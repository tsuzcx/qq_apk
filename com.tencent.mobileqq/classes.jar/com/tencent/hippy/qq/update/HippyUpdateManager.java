package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.hippy.qq.update.sign.MD5;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyUpdateManager
  extends DownloadListener
  implements Manager
{
  public static final int DEFAULT_MAX_FAILED_CNT = 2;
  public static final long DEFAULT_PRELOAD_HIPPY_INTERVAL = 600L;
  public static final long DEFAULT_UPDATE_HIPPY_INTERVAL = 120L;
  public static final String HIPPY_DOWNLOADER_BUSINESSCODE = "gamecenter_hippy";
  public static final String IPC_BUNDLE_KEY_BUNDLE_NAME = "bundle_name";
  public static final String IPC_BUNDLE_KEY_BUNDLE_VERSION = "bundle_version";
  public static final String KEY_DOWNLOAD_FAILED_URLS = "key_download_failed_urls";
  public static final String KEY_HIPPY_CONFIG = "key_hippy_config";
  public static final String KEY_LAST_PRELOAD_HIPPY_TIMESTAMP = "key_last_preload_hippy_timestamp";
  public static final String KEY_PREDOWNLOAD_HIPPY = "preDownloadHippyKey";
  public static final String KEY_PRELOAD_HIPPY_INTERVAL = "key_preload_hippy_interval";
  public static final String KEY_TAB_FILES = "key_tab_files";
  public static final String KEY_UNZIP_FAILED_URLS = "key_unzip_failed_urls";
  public static final String PREFIX = "hippyUpdateAction-";
  private static final int SERVER_STATUS_CODE_NO_UPDATE = 2;
  private static final int SERVER_STATUS_CODE_SUCCESS = 1;
  public static final String TAG = "hippyUpdateAction-" + HippyUpdateManager.class.getSimpleName();
  public static final int UPDATE_JS_BUNDLE_TYPE_PRELODAD = 1;
  public static final int UPDATE_JS_BUNDLE_TYPE_SINGLE = 2;
  private static int mCurRequestId = 0;
  private static volatile HippyUpdateManager sHippyUpdateManager;
  private Map<String, HippyUpdateManager.BundleInfo> mBundleInfos = new HashMap();
  private String mCurrentUin;
  private Map<String, Integer> mDownFailedUrls;
  private DownloaderInterface mDownloader;
  private DownloaderFactory mDownloaderFactory;
  private HippyUpdateManager.HippyConfig mHippyConfig;
  private HashMap<String, Long> mJsBundleLastUpdateTimes = new HashMap();
  private HashMap<String, ArrayList<HippyUpdateManager.IUpdateListener>> mJsBundleUpdateListeners = new HashMap();
  private long mLastPreloadTimeStamp = 0L;
  private List<WeakReference<HippyUpdateManager.IUpdateListener>> mListeners = new ArrayList();
  private long mPreloadInterval = 600L;
  private Map<String, HippyUpdateManager.TabFile> mTabFiles;
  private List<String> mUnzipFailedUrls;
  
  private HippyUpdateManager()
  {
    initData();
  }
  
  private boolean checkPreDownloadInterval()
  {
    boolean bool = true;
    this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
    if (NetConnInfoCenter.getServerTime() - this.mLastPreloadTimeStamp / 1000L < this.mPreloadInterval) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[checkPreloadInterval] ret=" + bool + ",mLastPreloadTimeStamploc = " + this.mLastPreloadTimeStamp / 1000L + ", interval = " + this.mPreloadInterval);
    }
    return bool;
  }
  
  private void doDownloadBundle(HippyUpdateManager.BundleInfo paramBundleInfo, int paramInt)
  {
    if ((paramBundleInfo == null) || (TextUtils.isEmpty(paramBundleInfo.downloadUrl)))
    {
      QLog.i(TAG, 1, "[doDownloadBundle] info or downloadUrl is null, return.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[doDownloadBundle] download bundle:" + paramBundleInfo.toString());
    }
    if ((this.mDownFailedUrls != null) && (this.mDownFailedUrls.containsKey(paramBundleInfo.downloadUrl)) && (((Integer)this.mDownFailedUrls.get(paramBundleInfo.downloadUrl)).intValue() > paramBundleInfo.maxFailedCnt))
    {
      QLog.e(TAG, 2, "[doDownloadBundle]currentFailedCnt:" + this.mDownFailedUrls.get(paramBundleInfo.downloadUrl) + ", url:" + paramBundleInfo.downloadUrl);
      notifyUpdateStatus(mCurRequestId, -5, paramBundleInfo.bundleName, paramInt);
      return;
    }
    if ((this.mUnzipFailedUrls != null) && (this.mUnzipFailedUrls.contains(paramBundleInfo.downloadUrl)))
    {
      QLog.e(TAG, 2, "[doDownloadBundle]ever uinzip failed:, url:" + paramBundleInfo.downloadUrl);
      notifyUpdateStatus(mCurRequestId, -6, paramBundleInfo.bundleName, paramInt);
      return;
    }
    if (UpdateSetting.getInstance().isModuleVersionFileExists(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion))
    {
      QLog.i(TAG, 2, "[doDownloadBundle]file exist:" + paramBundleInfo.bundleName + ",ver: " + paramBundleInfo.bundleVersion);
      notifyUpdateStatus(mCurRequestId, 1, paramBundleInfo.bundleName, paramInt);
      return;
    }
    Object localObject = HippyQQFileUtil.getZipFile(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
    localObject = new DownloadTask(paramBundleInfo.downloadUrl, (File)localObject);
    ((DownloadTask)localObject).p = true;
    ((DownloadTask)localObject).n = true;
    ((DownloadTask)localObject).f = "gamecenter_hippy";
    ((DownloadTask)localObject).b = 0;
    ((DownloadTask)localObject).q = true;
    ((DownloadTask)localObject).r = true;
    ((DownloadTask)localObject).jdField_a_of_type_JavaLangString = (paramBundleInfo.bundleName + paramBundleInfo.bundleVersion);
    Bundle localBundle = new Bundle();
    localBundle.putString("bundleName", paramBundleInfo.bundleName);
    localBundle.putInt("bundleVersion", paramBundleInfo.bundleVersion);
    localBundle.putString("bundleMd5", paramBundleInfo.bundleMd5);
    localBundle.putInt("source", paramInt);
    if (this.mDownloaderFactory == null) {
      this.mDownloaderFactory = new DownloaderFactory(CmGameUtil.a());
    }
    if (this.mDownloader == null) {
      this.mDownloader = this.mDownloaderFactory.a(5);
    }
    this.mDownloader.a((DownloadTask)localObject, this, localBundle);
  }
  
  private void downloadJsBundleImmediately(Intent paramIntent, HippyUpdateManager.BundleInfo paramBundleInfo)
  {
    int i = 0;
    localFile = HippyQQFileUtil.getZipFile(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
    Object localObject = new DownloadTask(paramBundleInfo.downloadUrl, localFile);
    ((DownloadTask)localObject).p = true;
    ((DownloadTask)localObject).n = true;
    ((DownloadTask)localObject).b = 2;
    ((DownloadTask)localObject).q = true;
    ((DownloadTask)localObject).r = true;
    if ((DownloaderFactory.a((DownloadTask)localObject, null) != 0) || (!localFile.exists()) || (localFile.length() <= 0L))
    {
      notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -4, null);
      return;
    }
    localObject = MD5.getFileMd5(localFile.getAbsolutePath());
    if ((localObject == null) || (!((String)localObject).equals(paramBundleInfo.bundleMd5))) {
      notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -3, null);
    }
    try
    {
      localObject = HippyQQFileUtil.getModuleFile(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion).getAbsolutePath();
      FileUtils.a(localFile.getAbsolutePath(), (String)localObject, false);
      if (UpdateSetting.getInstance().isModuleVersionFileExists(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion))
      {
        UpdateSetting.getInstance().setModuleVersion(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
        notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, 0, null);
        localObject = HippyQQFileUtil.getModuleFile(paramBundleInfo.bundleName, -1);
        if (paramIntent != null) {
          i = paramIntent.getIntExtra("curVersion", 0);
        }
        if (i > 0) {
          UpdateBase.cleanHistoryVersion((File)localObject, i);
        }
      }
      for (;;)
      {
        try
        {
          localFile.delete();
          return;
        }
        catch (Exception paramIntent)
        {
          QLog.e(TAG, 1, "delete file failed " + paramIntent.toString());
          return;
        }
        notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -1, null);
      }
      try
      {
        localFile.delete();
        throw paramIntent;
      }
      catch (Exception paramBundleInfo)
      {
        for (;;)
        {
          QLog.e(TAG, 1, "delete file failed " + paramBundleInfo.toString());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -1, "unZipFile file error:" + localThrowable);
      try
      {
        localFile.delete();
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "delete file failed " + paramIntent.toString());
        return;
      }
    }
    finally {}
  }
  
  public static HippyUpdateManager getInstance()
  {
    if (sHippyUpdateManager == null) {}
    try
    {
      if (sHippyUpdateManager == null) {
        sHippyUpdateManager = new HippyUpdateManager();
      }
      return sHippyUpdateManager;
    }
    finally {}
  }
  
  private void handleHippyConfig(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleHippyConfig] retCode:" + paramLong);
    }
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("source", -1);
      if ((paramLong != 0L) || (paramTrpcInovkeRsp == null)) {}
    }
    for (;;)
    {
      int j;
      String str;
      try
      {
        if (!paramTrpcInovkeRsp.data.has())
        {
          QLog.e(TAG, 1, "[handleHippyConfig] server ret error. return.");
          notifyUpdateStatus(mCurRequestId, -2, "", i);
          return;
        }
        paramIntent = new CommonMobileConfQueryRsp();
        paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        if (paramIntent.updatePreDownloadGap.has())
        {
          paramLong = paramIntent.updatePreDownloadGap.get();
          savePreloadHippyInterval(paramLong);
          if (!paramIntent.confList.has()) {
            break label445;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[handleHippyConfig] config size:" + paramIntent.confList.size());
          }
          paramIntent = paramIntent.confList.get().iterator();
          if (!paramIntent.hasNext()) {
            break label462;
          }
          paramTrpcInovkeRsp = (MobileConfRsp)paramIntent.next();
          j = paramTrpcInovkeRsp.ret.get();
          str = paramTrpcInovkeRsp.conf.get();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[handleHippyConfig] config:" + str);
          }
          if (j != 1) {
            break label397;
          }
          if (TextUtils.isEmpty(str)) {
            continue;
          }
        }
        switch (paramTrpcInovkeRsp.configType.get())
        {
        case 1: 
          handleHippyConfigResponse(j, str, paramString);
          continue;
          paramLong = 600L;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, paramIntent.toString());
        notifyUpdateStatus(mCurRequestId, -2, "", i);
        return;
      }
      continue;
      handlePreloadJsBundleResponse(j, str, i);
      continue;
      handleTabConfigResponse(j, str, paramString);
      continue;
      label397:
      QLog.i(TAG, 2, "[handleHippyConfig] no need update. ret = " + j + ", type = " + paramTrpcInovkeRsp.configType.get());
      continue;
      label445:
      QLog.i(TAG, 2, "[handleHippyConfig] confList is null. return");
      return;
      i = -1;
      break;
      label462:
      return;
    }
  }
  
  private void handleHippyConfigResponse(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 1) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        HippyUpdateManager.HippyConfig localHippyConfig = parseHippyConfigJson(paramString1);
        if (localHippyConfig != null)
        {
          BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).edit().putString(paramString2 + "key_hippy_config", paramString1).commit();
          this.mHippyConfig = localHippyConfig;
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e(TAG, 1, "handleHippyConfigResponse e:" + paramString1);
      }
    }
  }
  
  private void handlePreloadJsBundleResponse(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 1) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("bundleList");
        if (paramString != null)
        {
          this.mBundleInfos.clear();
          paramInt1 = 0;
          if (paramInt1 >= paramString.length()) {
            break;
          }
          JSONObject localJSONObject = paramString.getJSONObject(paramInt1);
          if (localJSONObject == null) {
            break label205;
          }
          HippyUpdateManager.BundleInfo localBundleInfo = new HippyUpdateManager.BundleInfo();
          localBundleInfo.bundleName = localJSONObject.optString("bundleName");
          localBundleInfo.bundleVersion = localJSONObject.optInt("bundleVersion");
          localBundleInfo.bundleMd5 = localJSONObject.optString("bundleMd5");
          localBundleInfo.downloadUrl = localJSONObject.optString("downloadUrl");
          localBundleInfo.maxFailedCnt = localJSONObject.optInt("maxFailedCnt", 2);
          this.mBundleInfos.put(localBundleInfo.bundleName, localBundleInfo);
          doDownloadBundle(localBundleInfo, paramInt2);
          break label205;
        }
        QLog.i(TAG, 2, "[doHandleHippyBundle] array is null.");
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e(TAG, 1, "handlePreloadJsBundleResponse e:" + paramString);
        return;
      }
      label205:
      paramInt1 += 1;
    }
  }
  
  private void handleTabConfigResponse(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 1) || (TextUtils.isEmpty(paramString1))) {}
    label202:
    do
    {
      do
      {
        return;
        for (;;)
        {
          try
          {
            paramString1 = parseTabJson(paramString1);
            if (this.mTabFiles == null) {
              this.mTabFiles = new HashMap();
            }
            if (paramString1 == null) {
              break;
            }
            localObject1 = paramString1.keySet().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label202;
            }
            localObject2 = (String)((Iterator)localObject1).next();
            if (this.mTabFiles.containsKey(localObject2))
            {
              if (!TextUtils.equals(((HippyUpdateManager.TabFile)this.mTabFiles.get(localObject2)).tabFileMd5, ((HippyUpdateManager.TabFile)paramString1.get(localObject2)).tabFileMd5)) {
                this.mTabFiles.put(localObject2, paramString1.get(localObject2));
              }
            }
            else {
              this.mTabFiles.put(localObject2, paramString1.get(localObject2));
            }
          }
          catch (Throwable paramString1)
          {
            QLog.e(TAG, 1, "handleTabConfigResponse e:" + paramString1);
            return;
          }
        }
      } while ((this.mTabFiles == null) || (this.mTabFiles.size() <= 0));
      paramString1 = new JSONObject();
      Object localObject1 = new JSONObject();
      Object localObject2 = this.mTabFiles.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tabFileMd5", ((HippyUpdateManager.TabFile)this.mTabFiles.get(str)).tabFileMd5);
        localJSONObject.put("tabFileJson", ((HippyUpdateManager.TabFile)this.mTabFiles.get(str)).tabFileJson);
        ((JSONObject)localObject1).put(str, localJSONObject);
      }
      paramString1.put("tabFileList", localObject1);
      BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).edit().putString(paramString2 + "key_tab_files", paramString1.toString()).commit();
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "[handleHippyConfig] tab json : " + paramString1.toString());
  }
  
  private void handleUpdateConfigResponse(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      notifyJsBundleUpdate(paramIntent, paramString1, -5, "ret " + paramInt);
      return;
    }
    paramString2 = parseBundleInfo(paramString2);
    Object localObject;
    if (paramString2 != null)
    {
      Iterator localIterator = paramString2.iterator();
      paramString2 = null;
      localObject = paramString2;
      if (!localIterator.hasNext()) {
        break label110;
      }
      localObject = (HippyUpdateManager.BundleInfo)localIterator.next();
      if (!paramString1.equals(((HippyUpdateManager.BundleInfo)localObject).bundleName)) {
        break label217;
      }
      paramString2 = (String)localObject;
    }
    label217:
    for (;;)
    {
      break;
      localObject = null;
      label110:
      if (localObject == null)
      {
        notifyJsBundleUpdate(paramIntent, paramString1, 1, null);
        return;
      }
      if (UpdateSetting.getInstance().isModuleVersionFileExists(((HippyUpdateManager.BundleInfo)localObject).bundleName, ((HippyUpdateManager.BundleInfo)localObject).bundleVersion))
      {
        UpdateSetting.getInstance().setModuleVersion(((HippyUpdateManager.BundleInfo)localObject).bundleName, ((HippyUpdateManager.BundleInfo)localObject).bundleVersion);
        notifyJsBundleUpdate(paramIntent, ((HippyUpdateManager.BundleInfo)localObject).bundleName, 101, "js bundle exists");
        return;
      }
      if (TextUtils.isEmpty(((HippyUpdateManager.BundleInfo)localObject).downloadUrl))
      {
        notifyJsBundleUpdate(paramIntent, paramString1, -5, "download url is empty");
        return;
      }
      ThreadManager.post(new HippyUpdateManager.3(this, (HippyUpdateManager.BundleInfo)localObject, paramIntent), 8, null, true);
      return;
    }
  }
  
  private void handleUpdateJsBundle(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp, String paramString)
  {
    if (paramIntent == null)
    {
      QLog.e(TAG, 1, "handleUpdateJsBundle request is null");
      return;
    }
    String str = paramIntent.getStringExtra("jsBundleName");
    if (TextUtils.isEmpty(str))
    {
      QLog.e(TAG, 1, "handleUpdateJsBundle bundleName is empty");
      return;
    }
    QLog.i(TAG, 1, "handleUpdateJsBundle retCode:" + paramLong);
    if ((paramLong != 0L) || (paramTrpcInovkeRsp == null) || (!paramTrpcInovkeRsp.data.has()))
    {
      notifyJsBundleUpdate(paramIntent, str, -5, "net error code:" + paramLong);
      return;
    }
    try
    {
      localObject = new CommonMobileConfQueryRsp();
      ((CommonMobileConfQueryRsp)localObject).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
      if (!((CommonMobileConfQueryRsp)localObject).confList.has())
      {
        notifyJsBundleUpdate(paramIntent, str, -5, "configRsp is empty");
        return;
      }
    }
    catch (Throwable paramTrpcInovkeRsp)
    {
      notifyJsBundleUpdate(paramIntent, str, -5, "handleUpdateJsBundle e:" + paramTrpcInovkeRsp);
      return;
    }
    int i = 0;
    Object localObject = ((CommonMobileConfQueryRsp)localObject).confList.get().iterator();
    label223:
    MobileConfRsp localMobileConfRsp;
    while (((Iterator)localObject).hasNext())
    {
      localMobileConfRsp = (MobileConfRsp)((Iterator)localObject).next();
      if ((localMobileConfRsp.ret.has()) && (localMobileConfRsp.configType.has())) {
        switch (localMobileConfRsp.configType.get())
        {
        case 2: 
          if (!localMobileConfRsp.conf.has()) {
            break label445;
          }
          paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
          handleUpdateConfigResponse(paramIntent, str, localMobileConfRsp.ret.get(), paramTrpcInovkeRsp);
          i = 1;
          break;
        case 1: 
          if (!localMobileConfRsp.conf.has()) {
            break label451;
          }
          paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
          handleHippyConfigResponse(localMobileConfRsp.ret.get(), paramTrpcInovkeRsp, paramString);
          break;
        case 3: 
          label321:
          label365:
          if (!localMobileConfRsp.conf.has()) {
            break label457;
          }
        }
      }
    }
    label442:
    label445:
    label451:
    label457:
    for (paramTrpcInovkeRsp = localMobileConfRsp.conf.get();; paramTrpcInovkeRsp = null)
    {
      handleTabConfigResponse(localMobileConfRsp.ret.get(), paramTrpcInovkeRsp, paramString);
      break label442;
      if (i != 0) {
        break;
      }
      notifyJsBundleUpdate(paramIntent, str, -5, "no update config");
      return;
      break label223;
      paramTrpcInovkeRsp = null;
      break label321;
      paramTrpcInovkeRsp = null;
      break label365;
    }
  }
  
  private void initData()
  {
    QLog.i(TAG, 1, "=====initData=====");
    this.mCurrentUin = CmGameUtil.a().getCurrentAccountUin();
    this.mHippyConfig = getHippyConfig();
    this.mPreloadInterval = getPreloadHippyInterval();
    this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
    this.mDownFailedUrls = getBundleFailedCnt();
    this.mUnzipFailedUrls = getBundleUnzipFailedUrls();
  }
  
  private boolean isToolProcess()
  {
    if (BaseApplicationImpl.sProcessId == 7) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i(TAG, 2, "[checkToolProcess] isToolProcess: " + bool);
      return bool;
    }
  }
  
  private void notifyJsBundleUpdate(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramIntent == null))
    {
      QLog.i(TAG, 1, "notifyJsBundleUpdate bundleName or request is null");
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis() - paramIntent.getLongExtra("requestStartTime", 0L);
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.i(TAG, 2, "notifyJsBundleUpdate bundleName:" + paramString1 + " retCode:" + paramInt + " retMsg:" + paramString2 + " cost:" + l);
    }
    ArrayList localArrayList;
    for (;;)
    {
      HippyUpdateManager.IUpdateListener localIUpdateListener;
      synchronized (this.mJsBundleUpdateListeners)
      {
        localArrayList = (ArrayList)this.mJsBundleUpdateListeners.get(paramString1);
        if (localArrayList == null) {
          break label203;
        }
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localIUpdateListener = (HippyUpdateManager.IUpdateListener)localIterator.next();
        if (paramInt == 0) {
          localIUpdateListener.onUpdateSuccess(0, paramString1);
        }
      }
      localIUpdateListener.onUpdateFailed(0, paramInt, paramString2, paramString1);
    }
    localArrayList.clear();
    label203:
    if (paramIntent.getBooleanExtra("isUseHttpRequest", false)) {}
    for (int i = 5;; i = 11)
    {
      HippyReporter.getInstance().reportCheckUpdate(paramString1, i, paramInt, paramString2, l);
      return;
    }
  }
  
  private ArrayList<HippyUpdateManager.BundleInfo> parseBundleInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i(TAG, 2, "[parseBundleInfo] json is empty.");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("bundleList");
      if (paramString == null)
      {
        QLog.i(TAG, 2, "[parseBundleInfo] array is null.");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.i(TAG, 2, "[parseBundleInfo] e:" + paramString);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length())
    {
      JSONObject localJSONObject = paramString.getJSONObject(i);
      if (localJSONObject != null)
      {
        HippyUpdateManager.BundleInfo localBundleInfo = new HippyUpdateManager.BundleInfo();
        localBundleInfo.bundleName = localJSONObject.optString("bundleName");
        localBundleInfo.bundleVersion = localJSONObject.optInt("bundleVersion");
        localBundleInfo.bundleMd5 = localJSONObject.optString("bundleMd5");
        localBundleInfo.downloadUrl = localJSONObject.optString("downloadUrl");
        localArrayList.add(localBundleInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void saveLastPreDownloadTime(long paramLong)
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).edit().putLong(str + "key_last_preload_hippy_timestamp", paramLong).commit();
  }
  
  private void savePreloadHippyInterval(long paramLong)
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).edit().putLong(str + "key_preload_hippy_interval", paramLong);
    this.mPreloadInterval = paramLong;
  }
  
  private void updateJsBundleByHttp(String paramString, int paramInt, Bundle paramBundle, HippyUpdateManager.IUpdateListener paramIUpdateListener)
  {
    new HippyQQUpdateManager().checkUpdate(paramString, new HippyUpdateManager.1(this, paramBundle, paramString));
  }
  
  private void updateJsBundleBySSO(String paramString, int paramInt1, Bundle paramBundle, int paramInt2, HippyUpdateManager.IUpdateListener paramIUpdateListener)
  {
    GameCenterUnissoHandler localGameCenterUnissoHandler = GameCenterUnissoHandler.a();
    if (localGameCenterUnissoHandler == null)
    {
      if (paramIUpdateListener != null)
      {
        removeJsBundleUpdateListener(paramString, paramIUpdateListener);
        paramIUpdateListener.onUpdateFailed(0, -5, "gcHandler is null", paramString);
      }
      QLog.e(TAG, 1, "updateJsBundle gcHandler is null.");
      return;
    }
    if (this.mJsBundleLastUpdateTimes.containsKey(paramString)) {}
    for (long l = ((Long)this.mJsBundleLastUpdateTimes.get(paramString)).longValue();; l = 0L)
    {
      localGameCenterUnissoHandler.a(paramInt2, paramString, paramInt1, l, paramBundle);
      return;
    }
  }
  
  public void addBundleFailedCnt(String paramString, int paramInt)
  {
    if (this.mDownFailedUrls == null) {
      this.mDownFailedUrls = new HashMap();
    }
    if (this.mDownFailedUrls.containsKey(paramString)) {}
    for (int i = ((Integer)this.mDownFailedUrls.get(paramString)).intValue();; i = 0)
    {
      this.mDownFailedUrls.put(paramString, Integer.valueOf(i + paramInt));
      paramString = new StringBuilder();
      Iterator localIterator = this.mDownFailedUrls.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.append(str + ">>>" + this.mDownFailedUrls.get(str) + "<<<");
      }
      BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).edit().putString("key_download_failed_urls", paramString.toString()).commit();
      return;
    }
  }
  
  public void addBundleUnzipFailedUrl(String paramString)
  {
    if (this.mUnzipFailedUrls == null) {
      this.mUnzipFailedUrls = new ArrayList();
    }
    if (this.mUnzipFailedUrls.contains(paramString)) {
      return;
    }
    this.mUnzipFailedUrls.add(paramString);
    paramString = new StringBuilder();
    Iterator localIterator = this.mUnzipFailedUrls.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.append(str + "<<<");
    }
    BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).edit().putString("key_unzip_failed_urls", paramString.toString()).commit();
  }
  
  public void addListener(HippyUpdateManager.IUpdateListener paramIUpdateListener)
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      HippyUpdateManager.IUpdateListener localIUpdateListener;
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label63;
          }
          localIUpdateListener = (HippyUpdateManager.IUpdateListener)((WeakReference)localIterator.next()).get();
          if (localIUpdateListener != null) {
            break;
          }
          localIterator.remove();
        }
      } while (localIUpdateListener != paramIUpdateListener);
    }
    finally {}
    for (;;)
    {
      return;
      label63:
      this.mListeners.add(new WeakReference(paramIUpdateListener));
    }
  }
  
  public void cancleDownloadTask(String paramString, int paramInt)
  {
    QLog.i(TAG, 1, "[stopDownloadTask] stop download task:" + paramString + ", version: " + paramInt);
    if (isToolProcess())
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("bundle_name", paramString);
      localBundle.putInt("bundle_version", paramInt);
      QIPCClientHelper.getInstance().callServer("module_hippy", "action_cancle_download_task", localBundle, null);
      return;
    }
    if ((this.mDownloader != null) && (this.mDownloader.a(paramString + paramInt) != null))
    {
      this.mDownloader.a(true, paramString + paramInt);
      return;
    }
    QLog.i(TAG, 1, "[stopDownloadTask] mDownloader is null.");
  }
  
  public boolean checkUpdateJsBundleInterval(String paramString)
  {
    if (!this.mJsBundleLastUpdateTimes.containsKey(paramString)) {
      return true;
    }
    long l1 = ((Long)this.mJsBundleLastUpdateTimes.get(paramString)).longValue();
    long l2 = NetConnInfoCenter.getServerTime();
    if ((l2 > l1) && (l2 - l1 > getHippyConfig().checkUpdateGap)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Map<String, Integer> getBundleFailedCnt()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getString("key_download_failed_urls", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("<<<");
      int i = 0;
      while (i < localObject.length)
      {
        String[] arrayOfString = localObject[i].split(">>>");
        if (arrayOfString.length == 2) {
          localHashMap.put(arrayOfString[0], Integer.valueOf(Integer.parseInt(arrayOfString[1])));
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getBundleFailedCnt] size:" + localHashMap.size());
    }
    return localHashMap;
  }
  
  public List<String> getBundleUnzipFailedUrls()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getString("key_unzip_failed_urls", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("<<<");
      while (i < localObject.length)
      {
        localArrayList.add(localObject[i]);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getBundleUnzipFailedUrls] size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public HippyUpdateManager.HippyConfig getHippyConfig()
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    if (!TextUtils.equals(str, this.mCurrentUin)) {
      initData();
    }
    for (;;)
    {
      if (this.mHippyConfig == null) {
        this.mHippyConfig = new HippyUpdateManager.HippyConfig();
      }
      return this.mHippyConfig;
      if (this.mHippyConfig == null)
      {
        str = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getString(str + "key_hippy_config", "");
        try
        {
          this.mHippyConfig = parseHippyConfigJson(str);
        }
        catch (Exception localException)
        {
          QLog.e(TAG, 1, localException.toString());
        }
      }
    }
  }
  
  public long getLastPreloadDownTimeStamp()
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    if (!TextUtils.equals(str, this.mCurrentUin)) {
      initData();
    }
    for (;;)
    {
      return this.mLastPreloadTimeStamp;
      this.mLastPreloadTimeStamp = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getLong(str + "key_last_preload_hippy_timestamp", 0L);
    }
  }
  
  public long getPreloadHippyInterval()
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    return BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getLong(str + "key_preload_hippy_interval", 600L);
  }
  
  public Map<String, HippyUpdateManager.TabFile> getTabFilesConfig()
  {
    Object localObject = CmGameUtil.a().getCurrentAccountUin();
    if (!TextUtils.equals((CharSequence)localObject, this.mCurrentUin)) {
      initData();
    }
    for (;;)
    {
      if (this.mTabFiles == null) {
        this.mTabFiles = new HashMap();
      }
      return this.mTabFiles;
      if (this.mTabFiles == null) {
        try
        {
          localObject = parseTabJson(BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getString((String)localObject + "key_tab_files", ""));
          if ((localObject != null) && (((Map)localObject).size() > 0)) {
            this.mTabFiles = ((Map)localObject);
          }
        }
        catch (Exception localException)
        {
          QLog.e(TAG, 1, localException.toString());
        }
      }
    }
  }
  
  public void handleResponse(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    int i = 0;
    String str = "";
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("source", 0);
      str = paramIntent.getStringExtra("uin");
    }
    if (!TextUtils.equals(str, CmGameUtil.a().getCurrentAccountUin()))
    {
      QLog.e(TAG, 1, "[handleResponse] current uin change. return.");
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
    case 2: 
      handleHippyConfig(paramIntent, paramLong, paramTrpcInovkeRsp, str);
      return;
    }
    handleUpdateJsBundle(paramIntent, paramLong, paramTrpcInovkeRsp, str);
  }
  
  public void notifyUpdateStatus(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[notifyUpdateStatus] requestId = " + paramInt1 + ", ret = " + paramInt2 + ", source = " + paramInt3);
    }
    paramString = (HippyUpdateManager.BundleInfo)this.mBundleInfos.get(paramString);
    JSONObject localJSONObject = new JSONObject();
    if (paramString != null) {}
    try
    {
      localJSONObject.put("maxFailedCnt", this.mDownFailedUrls.get(paramString.downloadUrl));
      switch (paramInt2)
      {
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, localException.toString());
        continue;
        paramInt1 = paramInt2;
      }
    }
    if ((1 != paramInt2) && (paramString != null))
    {
      if (paramInt2 == 0)
      {
        paramInt1 = (int)(l - this.mLastPreloadTimeStamp);
        HippyReporter.getInstance().reportPreDownloadOper(paramString.bundleName, paramString.bundleVersion, 12, paramInt1, localJSONObject, "");
      }
    }
    else {
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "download succ. task: " + paramDownloadTask.toString());
    }
    Object localObject = paramDownloadTask.a();
    String str1 = ((Bundle)localObject).getString("bundleName");
    int i = ((Bundle)localObject).getInt("bundleVersion");
    String str2 = ((Bundle)localObject).getString("bundleMd5");
    int j = ((Bundle)localObject).getInt("source");
    if (3 == paramDownloadTask.a())
    {
      localObject = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        String str3 = MD5.getFileMd5(((File)localObject).getAbsolutePath());
        if (!TextUtils.equals(str3, str2))
        {
          QLog.e(TAG, 1, "[onDone] check md5 failed. bundleMd5 = " + str2 + ", md5 = " + str3);
          notifyUpdateStatus(mCurRequestId, -3, str1, j);
          addBundleFailedCnt(paramDownloadTask.c, 1);
          return;
        }
        try
        {
          if (UpdateSetting.getInstance().isModuleVersionFileExists(str1, i))
          {
            QLog.i(TAG, 2, "[onDone]hippy file exist:" + str1 + ",ver: " + i);
            notifyUpdateStatus(mCurRequestId, 1, str1, j);
            try
            {
              ((File)localObject).delete();
              return;
            }
            catch (Exception paramDownloadTask)
            {
              QLog.e(TAG, 1, "delete file failed " + paramDownloadTask.toString());
              return;
            }
          }
          str2 = HippyQQFileUtil.getModuleFile(str1, i).getAbsolutePath();
          FileUtils.a(((File)localObject).getAbsolutePath(), str2, false);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "download succ");
          }
          notifyUpdateStatus(mCurRequestId, 0, str1, j);
          try
          {
            ((File)localObject).delete();
            return;
          }
          catch (Exception paramDownloadTask)
          {
            QLog.e(TAG, 1, "delete file failed " + paramDownloadTask.toString());
            return;
          }
          try
          {
            ((File)localObject).delete();
            throw paramDownloadTask;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e(TAG, 1, "delete file failed " + localException.toString());
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable = localThrowable;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unZipFile file error  error->" + localThrowable.getMessage());
          }
          addBundleUnzipFailedUrl(paramDownloadTask.c);
          notifyUpdateStatus(mCurRequestId, -1, str1, j);
          try
          {
            ((File)localObject).delete();
            return;
          }
          catch (Exception paramDownloadTask)
          {
            QLog.e(TAG, 1, "delete file failed " + paramDownloadTask.toString());
            return;
          }
        }
        finally {}
      }
      addBundleFailedCnt(paramDownloadTask.c, 1);
      notifyUpdateStatus(mCurRequestId, -7, localException, j);
      QLog.e(TAG, 1, "download file suc, but file not find");
      return;
    }
    QLog.e(TAG, 1, "download file failed.");
    addBundleFailedCnt(paramDownloadTask.c, 1);
    notifyUpdateStatus(mCurRequestId, -4, localException, j);
  }
  
  public HippyUpdateManager.HippyConfig parseHippyConfigJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i(TAG, 2, "[parseHippyConfigJson] str is empty");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      HippyUpdateManager.HippyConfig localHippyConfig = new HippyUpdateManager.HippyConfig();
      localHippyConfig.isPredrawHippy = paramString.optInt("isPredrawHippy", 0);
      localHippyConfig.isLoadHippyInToolProcess = paramString.optInt("isLoadHippyInToolProcess", 0);
      localHippyConfig.isPreloadHippy = paramString.optInt("isPreloadHippy", 0);
      localHippyConfig.checkUpdateGap = paramString.optLong("checkUpdateGap", 120L);
      return localHippyConfig;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, paramString.toString());
      throw paramString;
    }
  }
  
  public Map<String, HippyUpdateManager.TabFile> parseTabJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i(TAG, 2, "[parseTabJson] jsonStr is empty.");
      return null;
    }
    HashMap localHashMap;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("tabFileList");
        if (paramString == null) {
          break;
        }
        localHashMap = new HashMap();
        Iterator localIterator = paramString.keys();
        if (!localIterator.hasNext()) {
          return localHashMap;
        }
        String str = (String)localIterator.next();
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        JSONObject localJSONObject = paramString.optJSONObject(str);
        if (localJSONObject != null)
        {
          HippyUpdateManager.TabFile localTabFile = new HippyUpdateManager.TabFile();
          localTabFile.tabFileMd5 = localJSONObject.optString("tabFileMd5");
          localTabFile.tabFileJson = localJSONObject.optString("tabFileJson");
          localHashMap.put(str, localTabFile);
          continue;
        }
        QLog.i(TAG, 2, "[getTabFilesConfig] fileObj is empty");
      }
      catch (Exception paramString)
      {
        QLog.e(TAG, 2, paramString.toString());
        throw paramString;
      }
      continue;
      label168:
      QLog.i(TAG, 2, "[getTabFilesConfig] key is empty");
    }
    QLog.i(TAG, 2, "[getTabFilesConfig] filesObj is null.");
    return null;
    return localHashMap;
  }
  
  public void preDownloadHippyByController(int paramInt)
  {
    AppInterface localAppInterface = CmGameUtil.a();
    if (!(localAppInterface instanceof QQAppInterface))
    {
      QLog.e(TAG, 1, "[preDownloadHippyByController] cur process is not QQProcess, return.");
      return;
    }
    RunnableTask localRunnableTask = new RunnableTask((QQAppInterface)localAppInterface, "preDownloadHippyKey", new HippyUpdateManager.2(this, paramInt), 0L);
    boolean bool = ((PreDownloadController)localAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).requestPreDownload(10097, "sed", "preDownloadHippyKey", 2, "https://gamecenter.fake.url", BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/pddate/edu/gamecenter/", 3, 0, true, localRunnableTask);
    QLog.i(TAG, 1, "[preDownloadHippyByController] ret = " + bool);
  }
  
  public void predownloadHippy(int paramInt)
  {
    QLog.i(TAG, 1, "[predownloadHippy] source:" + paramInt);
    if ((paramInt == 1) && (QQGameConfigUtil.h())) {
      HippyQQLibraryManager.getInstance().preDownload();
    }
    if ((checkPreDownloadInterval()) || (paramInt == 2))
    {
      Map localMap = UpdateSetting.getInstance().getAllModuleVersion();
      GameCenterUnissoHandler localGameCenterUnissoHandler = GameCenterUnissoHandler.a();
      Bundle localBundle = new Bundle();
      localBundle.putInt("source", paramInt);
      localBundle.putInt("requestId", mCurRequestId);
      localBundle.putString("uin", this.mCurrentUin);
      localGameCenterUnissoHandler.a(paramInt, localMap, this.mLastPreloadTimeStamp, localBundle);
      this.mLastPreloadTimeStamp = NetConnInfoCenter.getServerTimeMillis();
      saveLastPreDownloadTime(this.mLastPreloadTimeStamp);
      return;
    }
    QLog.i(TAG, 1, "[preloadHippy] check preloadInterval failed, stop action.");
  }
  
  public void removeJsBundleUpdateListener(String paramString, HippyUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIUpdateListener == null)) {
      return;
    }
    synchronized (this.mJsBundleUpdateListeners)
    {
      paramString = (ArrayList)this.mJsBundleUpdateListeners.get(paramString);
      if (paramString != null) {
        paramString.remove(paramIUpdateListener);
      }
      return;
    }
  }
  
  public void removeListener(HippyUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if (paramIUpdateListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator;
      try
      {
        localIterator = this.mListeners.iterator();
        HippyUpdateManager.IUpdateListener localIUpdateListener;
        do
        {
          while (localIterator.hasNext())
          {
            localIUpdateListener = (HippyUpdateManager.IUpdateListener)((WeakReference)localIterator.next()).get();
            if (localIUpdateListener != null) {
              break label62;
            }
            localIterator.remove();
          }
        } while (localIUpdateListener != paramIUpdateListener);
      }
      finally {}
      label62:
      localIterator.remove();
    }
  }
  
  public void updateJsBundle(String paramString, boolean paramBoolean, int paramInt, HippyUpdateManager.IUpdateListener paramIUpdateListener)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return;
        if (AppNetConnInfo.isNetSupport()) {
          break;
        }
      } while (paramIUpdateListener == null);
      paramIUpdateListener.onUpdateFailed(0, -5, "Net unavailable", paramString);
      return;
      int j = UpdateSetting.getInstance().getModuleVersion(paramString);
      i = j;
      if (j < 0) {
        i = 0;
      }
      if ((checkUpdateJsBundleInterval(paramString)) || (i <= 0)) {
        break;
      }
    } while (paramIUpdateListener == null);
    paramIUpdateListener.onUpdateFailed(0, -5, "Check update interval", paramString);
    return;
    if (paramIUpdateListener != null) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.mJsBundleUpdateListeners)
      {
        ArrayList localArrayList = (ArrayList)this.mJsBundleUpdateListeners.get(paramString);
        localObject = localArrayList;
        if (localArrayList == null)
        {
          localObject = new ArrayList();
          this.mJsBundleUpdateListeners.put(paramString, localObject);
        }
        if (!((ArrayList)localObject).contains(paramIUpdateListener)) {
          ((ArrayList)localObject).add(paramIUpdateListener);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putInt("source", 4);
        ((Bundle)localObject).putBoolean("isUseHttpRequest", paramBoolean);
        ((Bundle)localObject).putString("jsBundleName", paramString);
        ((Bundle)localObject).putLong("requestStartTime", NetConnInfoCenter.getServerTimeMillis());
        ((Bundle)localObject).putInt("curVersion", i);
        ((Bundle)localObject).putString("uin", this.mCurrentUin);
        if (paramBoolean)
        {
          updateJsBundleByHttp(paramString, i, (Bundle)localObject, paramIUpdateListener);
          this.mJsBundleLastUpdateTimes.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return;
        }
      }
      updateJsBundleBySSO(paramString, i, (Bundle)localObject, paramInt, paramIUpdateListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager
 * JD-Core Version:    0.7.0.1
 */