package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.TabFile;
import com.tencent.hippy.qq.update.config.TabPreloadConfigManager;
import com.tencent.hippy.qq.update.sso.BundleInfo;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
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
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyPredownloadManager
  extends DownloadListener
{
  public static final int DEFAULT_MAX_FAILED_CNT = 2;
  public static final long DEFAULT_PRELOAD_HIPPY_INTERVAL = 600L;
  public static final long DEFAULT_UPDATE_HIPPY_INTERVAL = 120L;
  public static final String GAME_CENTER_SHARED_PREFERECE_NAME = "game_center_sp";
  public static final String HIPPY_DOWNLOADER_BUSINESSCODE = "gamecenter_hippy";
  public static final String KEY_DOWNLOAD_FAILED_URLS = "key_download_failed_urls";
  public static final String KEY_HIPPY_CONFIG = "key_hippy_config";
  public static final String KEY_LAST_PRELOAD_HIPPY_TIMESTAMP = "key_last_preload_hippy_timestamp";
  public static final String KEY_PREDOWNLOAD_HIPPY = "preDownloadHippyKey";
  public static final String KEY_PRELOAD_HIPPY_INTERVAL = "key_preload_hippy_interval";
  public static final String KEY_TAB_FILES = "key_tab_files";
  public static final String KEY_UNZIP_FAILED_URLS = "key_unzip_failed_urls";
  public static final String PREFIX = "hippyUpdateAction-";
  public static final String TAG = "hippyUpdateAction-PreDownload";
  private static int mCurRequestId;
  private static volatile HippyPredownloadManager sHippyPredownloadManager;
  private final Map<String, BundleInfo> mBundleInfos = new HashMap();
  private String mCurrentUin;
  private Map<String, Integer> mDownFailedUrls;
  private DownloaderInterface mDownloader;
  private HippyConfig mHippyConfig;
  private long mLastPreloadTimeStamp = 0L;
  private final List<WeakReference<IUpdateListener>> mListeners = new ArrayList();
  private long mPreloadInterval = 600L;
  private Map<String, TabFile> mTabFiles;
  TabPreloadConfigManager mTabPreloadConfigManager;
  private List<String> mUnzipFailedUrls;
  
  private HippyPredownloadManager()
  {
    initData();
  }
  
  private boolean checkPreDownloadInterval()
  {
    this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
    boolean bool;
    if (NetConnInfoCenter.getServerTime() - this.mLastPreloadTimeStamp / 1000L < this.mPreloadInterval) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkPreloadInterval] ret=");
      localStringBuilder.append(bool);
      localStringBuilder.append(",mLastPreloadTimeStamploc = ");
      localStringBuilder.append(this.mLastPreloadTimeStamp / 1000L);
      localStringBuilder.append(", interval = ");
      localStringBuilder.append(this.mPreloadInterval);
      QLog.d("hippyUpdateAction-PreDownload", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void doDownloadBundle(BundleInfo paramBundleInfo, int paramInt)
  {
    if ((paramBundleInfo != null) && (!TextUtils.isEmpty(paramBundleInfo.downloadUrl)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[doDownloadBundle] download bundle:");
        ((StringBuilder)localObject1).append(paramBundleInfo.toString());
        QLog.d("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.mDownFailedUrls;
      if ((localObject1 != null) && (((Map)localObject1).containsKey(paramBundleInfo.downloadUrl)) && (((Integer)this.mDownFailedUrls.get(paramBundleInfo.downloadUrl)).intValue() > paramBundleInfo.maxPreDownloadFailedCnt))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[doDownloadBundle]currentFailedCnt:");
        ((StringBuilder)localObject1).append(this.mDownFailedUrls.get(paramBundleInfo.downloadUrl));
        ((StringBuilder)localObject1).append(", url:");
        ((StringBuilder)localObject1).append(paramBundleInfo.downloadUrl);
        QLog.e("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject1).toString());
        notifyUpdateStatus(mCurRequestId, -5, paramBundleInfo.bundleName, paramInt);
        return;
      }
      localObject1 = this.mUnzipFailedUrls;
      if ((localObject1 != null) && (((List)localObject1).contains(paramBundleInfo.downloadUrl)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[doDownloadBundle]ever uinzip failed:, url:");
        ((StringBuilder)localObject1).append(paramBundleInfo.downloadUrl);
        QLog.e("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject1).toString());
        notifyUpdateStatus(mCurRequestId, -6, paramBundleInfo.bundleName, paramInt);
        return;
      }
      if (UpdateSetting.getInstance().isModuleVersionFileExists(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[doDownloadBundle]file exist:");
        ((StringBuilder)localObject1).append(paramBundleInfo.bundleName);
        ((StringBuilder)localObject1).append(",ver: ");
        ((StringBuilder)localObject1).append(paramBundleInfo.bundleVersion);
        QLog.i("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject1).toString());
        notifyUpdateStatus(mCurRequestId, 1, paramBundleInfo.bundleName, paramInt);
        return;
      }
      localObject1 = HippyQQFileUtil.getJsBundleZipFile(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
      localObject1 = new DownloadTask(paramBundleInfo.downloadUrl, (File)localObject1);
      ((DownloadTask)localObject1).N = true;
      ((DownloadTask)localObject1).J = true;
      ((DownloadTask)localObject1).L = "gamecenter_hippy";
      ((DownloadTask)localObject1).e = 0;
      ((DownloadTask)localObject1).P = true;
      ((DownloadTask)localObject1).Q = true;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundleInfo.bundleName);
      ((StringBuilder)localObject2).append(paramBundleInfo.bundleVersion);
      ((DownloadTask)localObject1).b = ((StringBuilder)localObject2).toString();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("bundleName", paramBundleInfo.bundleName);
      ((Bundle)localObject2).putInt("bundleVersion", paramBundleInfo.bundleVersion);
      ((Bundle)localObject2).putString("bundleMd5", paramBundleInfo.bundleMd5);
      ((Bundle)localObject2).putInt("source", paramInt);
      if (this.mDownloader == null) {
        this.mDownloader = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
      }
      this.mDownloader.startDownload((DownloadTask)localObject1, this, (Bundle)localObject2);
      return;
    }
    QLog.i("hippyUpdateAction-PreDownload", 1, "[doDownloadBundle] info or downloadUrl is null, return.");
  }
  
  public static HippyPredownloadManager getInstance()
  {
    if (sHippyPredownloadManager == null) {
      try
      {
        if (sHippyPredownloadManager == null) {
          sHippyPredownloadManager = new HippyPredownloadManager();
        }
      }
      finally {}
    }
    return sHippyPredownloadManager;
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    return MobileQQ.getContext().getSharedPreferences("game_center_sp", 4);
  }
  
  private void handlePreloadJsBundleResponse(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 1) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
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
          if (paramInt1 < paramString.length())
          {
            localObject = BundleInfo.fromJson(paramString.getJSONObject(paramInt1));
            if (localObject == null) {
              break label141;
            }
            this.mBundleInfos.put(((BundleInfo)localObject).bundleName, localObject);
            doDownloadBundle((BundleInfo)localObject, paramInt2);
            break label141;
          }
        }
        else
        {
          QLog.i("hippyUpdateAction-PreDownload", 2, "[doHandleHippyBundle] array is null.");
          return;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePreloadJsBundleResponse e:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("hippyUpdateAction-PreDownload", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label141:
      paramInt1 += 1;
    }
  }
  
  private void initData()
  {
    QLog.i("hippyUpdateAction-PreDownload", 1, "=====initData=====");
    this.mCurrentUin = HippyAccessHelper.getCurrentUin();
    this.mHippyConfig = getHippyConfig();
    this.mPreloadInterval = getPreloadHippyInterval();
    this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
    this.mDownFailedUrls = getBundleFailedCnt();
    this.mUnzipFailedUrls = getBundleUnzipFailedUrls();
    this.mTabPreloadConfigManager = new TabPreloadConfigManager(this.mCurrentUin);
  }
  
  private boolean isToolProcess()
  {
    boolean bool;
    if (MobileQQ.sProcessId == 7) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkToolProcess] isToolProcess: ");
    localStringBuilder.append(bool);
    QLog.i("hippyUpdateAction-PreDownload", 2, localStringBuilder.toString());
    return bool;
  }
  
  private void saveLastPreDownloadTime(long paramLong)
  {
    String str = HippyAccessHelper.getCurrentUin();
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("key_last_preload_hippy_timestamp");
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  private void savePreloadHippyInterval(long paramLong)
  {
    String str = HippyAccessHelper.getCurrentUin();
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("key_preload_hippy_interval");
    localEditor.putLong(localStringBuilder.toString(), paramLong);
    this.mPreloadInterval = paramLong;
  }
  
  public void addBundleFailedCnt(String paramString, int paramInt)
  {
    if (this.mDownFailedUrls == null) {
      this.mDownFailedUrls = new HashMap();
    }
    int i;
    if (this.mDownFailedUrls.containsKey(paramString)) {
      i = ((Integer)this.mDownFailedUrls.get(paramString)).intValue();
    } else {
      i = 0;
    }
    this.mDownFailedUrls.put(paramString, Integer.valueOf(paramInt + i));
    paramString = new StringBuilder();
    Iterator localIterator = this.mDownFailedUrls.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(">>>");
      localStringBuilder.append(this.mDownFailedUrls.get(str));
      localStringBuilder.append("<<<");
      paramString.append(localStringBuilder.toString());
    }
    getSharedPreferences().edit().putString("key_download_failed_urls", paramString.toString()).commit();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("<<<");
      paramString.append(localStringBuilder.toString());
    }
    getSharedPreferences().edit().putString("key_unzip_failed_urls", paramString.toString()).commit();
  }
  
  public void addListener(IUpdateListener paramIUpdateListener)
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        IUpdateListener localIUpdateListener = (IUpdateListener)((WeakReference)localIterator.next()).get();
        if (localIUpdateListener == null) {
          localIterator.remove();
        } else if (localIUpdateListener == paramIUpdateListener) {
          return;
        }
      }
      this.mListeners.add(new WeakReference(paramIUpdateListener));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIUpdateListener;
    }
  }
  
  public void cancelDownloadTask(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[stopDownloadTask] stop download task:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", version: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("hippyUpdateAction-PreDownload", 1, ((StringBuilder)localObject).toString());
    if (isToolProcess())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("bundle_name", paramString);
      ((Bundle)localObject).putInt("bundle_version", paramInt);
      QIPCClientHelper.getInstance().callServer("module_hippy", "action_cancle_download_task", (Bundle)localObject, null);
      return;
    }
    localObject = this.mDownloader;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramInt);
      if (((DownloaderInterface)localObject).getTask(localStringBuilder.toString()) != null)
      {
        localObject = this.mDownloader;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramInt);
        ((DownloaderInterface)localObject).cancelTask(true, localStringBuilder.toString());
        return;
      }
    }
    QLog.i("hippyUpdateAction-PreDownload", 1, "[stopDownloadTask] mDownloader is null.");
  }
  
  public Map<String, Integer> getBundleFailedCnt()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = getSharedPreferences().getString("key_download_failed_urls", "");
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getBundleFailedCnt] size:");
      ((StringBuilder)localObject).append(localHashMap.size());
      QLog.d("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject).toString());
    }
    return localHashMap;
  }
  
  public List<String> getBundleUnzipFailedUrls()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getSharedPreferences().getString("key_unzip_failed_urls", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("<<<");
      int i = 0;
      while (i < localObject.length)
      {
        localArrayList.add(localObject[i]);
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getBundleUnzipFailedUrls] size:");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public HippyConfig getHippyConfig()
  {
    String str = HippyAccessHelper.getCurrentUin();
    if (!TextUtils.equals(str, this.mCurrentUin))
    {
      initData();
    }
    else if (this.mHippyConfig == null)
    {
      SharedPreferences localSharedPreferences = getSharedPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("key_hippy_config");
      str = localSharedPreferences.getString(localStringBuilder.toString(), "");
      try
      {
        this.mHippyConfig = parseHippyConfigJson(str);
      }
      catch (Exception localException)
      {
        QLog.e("hippyUpdateAction-PreDownload", 1, localException.toString());
      }
    }
    if (this.mHippyConfig == null) {
      this.mHippyConfig = new HippyConfig();
    }
    return this.mHippyConfig;
  }
  
  public long getLastPreloadDownTimeStamp()
  {
    String str = HippyAccessHelper.getCurrentUin();
    if (!TextUtils.equals(str, this.mCurrentUin))
    {
      initData();
    }
    else
    {
      SharedPreferences localSharedPreferences = getSharedPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("key_last_preload_hippy_timestamp");
      this.mLastPreloadTimeStamp = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    }
    return this.mLastPreloadTimeStamp;
  }
  
  public long getPreloadHippyInterval()
  {
    String str = HippyAccessHelper.getCurrentUin();
    SharedPreferences localSharedPreferences = getSharedPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("key_preload_hippy_interval");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 600L);
  }
  
  public Map<String, TabFile> getTabFilesConfig()
  {
    Object localObject = HippyAccessHelper.getCurrentUin();
    if (!TextUtils.equals((CharSequence)localObject, this.mCurrentUin)) {
      initData();
    } else if (this.mTabFiles == null) {
      try
      {
        SharedPreferences localSharedPreferences = getSharedPreferences();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("key_tab_files");
        localObject = parseTabJson(localSharedPreferences.getString(localStringBuilder.toString(), ""));
        if ((localObject != null) && (((Map)localObject).size() > 0)) {
          this.mTabFiles = ((Map)localObject);
        }
      }
      catch (Exception localException)
      {
        QLog.e("hippyUpdateAction-PreDownload", 1, localException.toString());
      }
    }
    if (this.mTabFiles == null) {
      this.mTabFiles = new HashMap();
    }
    return this.mTabFiles;
  }
  
  public TabPreloadConfigManager getTabPreloadConfigManager()
  {
    if (!TextUtils.equals(HippyAccessHelper.getCurrentUin(), this.mCurrentUin)) {
      initData();
    }
    if (this.mTabPreloadConfigManager == null) {
      this.mTabPreloadConfigManager = new TabPreloadConfigManager(this.mCurrentUin);
    }
    this.mTabPreloadConfigManager.initData();
    return this.mTabPreloadConfigManager;
  }
  
  public void handleAllConfigResponses(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleHippyConfig] retCode:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject).toString());
    }
    int i = -1;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("source", -1);
    }
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null)) {}
    for (;;)
    {
      try
      {
        if (paramTrpcInovkeRsp.data.has())
        {
          paramIntent = new CommonMobileConfQueryRsp();
          paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
          if (!paramIntent.updatePreDownloadGap.has()) {
            break label520;
          }
          paramLong = paramIntent.updatePreDownloadGap.get();
          savePreloadHippyInterval(paramLong);
          if (paramIntent.confList.has())
          {
            if (QLog.isColorLevel())
            {
              paramTrpcInovkeRsp = new StringBuilder();
              paramTrpcInovkeRsp.append("[handleHippyConfig] config size:");
              paramTrpcInovkeRsp.append(paramIntent.confList.size());
              QLog.d("hippyUpdateAction-PreDownload", 2, paramTrpcInovkeRsp.toString());
            }
            paramIntent = paramIntent.confList.get().iterator();
            if (paramIntent.hasNext())
            {
              paramTrpcInovkeRsp = (MobileConfRsp)paramIntent.next();
              int j = paramTrpcInovkeRsp.ret.get();
              localObject = paramTrpcInovkeRsp.conf.get();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[handleHippyConfig] config:");
                localStringBuilder.append((String)localObject);
                QLog.d("hippyUpdateAction-PreDownload", 2, localStringBuilder.toString());
              }
              if (j == 1)
              {
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  continue;
                }
                int k = paramTrpcInovkeRsp.configType.get();
                if (k != 1)
                {
                  if (k != 2)
                  {
                    if (k != 3)
                    {
                      if (k != 5) {
                        continue;
                      }
                      getTabPreloadConfigManager().handleTabPreloadResponse(j, (String)localObject, paramString);
                      continue;
                    }
                    handleTabConfigResponse(j, (String)localObject, paramString);
                    continue;
                  }
                  handlePreloadJsBundleResponse(j, (String)localObject, i);
                  continue;
                }
                handleHippyConfigResponse(j, (String)localObject, paramString);
                continue;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[handleHippyConfig] no need update. ret = ");
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append(", type = ");
              ((StringBuilder)localObject).append(paramTrpcInovkeRsp.configType.get());
              QLog.i("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject).toString());
              continue;
            }
          }
          else
          {
            QLog.i("hippyUpdateAction-PreDownload", 2, "[handleHippyConfig] confList is null. return");
          }
        }
        else
        {
          QLog.e("hippyUpdateAction-PreDownload", 1, "[handleHippyConfig] server ret error. return.");
          notifyUpdateStatus(mCurRequestId, -2, "", i);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("hippyUpdateAction-PreDownload", 1, paramIntent.toString());
        notifyUpdateStatus(mCurRequestId, -2, "", i);
      }
      return;
      label520:
      paramLong = 600L;
    }
  }
  
  public void handleHippyConfigResponse(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      try
      {
        HippyConfig localHippyConfig = parseHippyConfigJson(paramString1);
        if (localHippyConfig != null)
        {
          SharedPreferences.Editor localEditor = getSharedPreferences().edit();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("key_hippy_config");
          localEditor.putString(localStringBuilder.toString(), paramString1).commit();
          this.mHippyConfig = localHippyConfig;
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleHippyConfigResponse e:");
        paramString2.append(paramString1);
        QLog.e("hippyUpdateAction-PreDownload", 1, paramString2.toString());
      }
    }
  }
  
  public void handleTabConfigResponse(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      try
      {
        paramString1 = parseTabJson(paramString1);
        if (this.mTabFiles == null) {
          this.mTabFiles = new HashMap();
        }
        if (paramString1 != null)
        {
          Object localObject1 = paramString1.keySet().iterator();
          Object localObject2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (this.mTabFiles.containsKey(localObject2))
            {
              if (!TextUtils.equals(((TabFile)this.mTabFiles.get(localObject2)).tabFileMd5, ((TabFile)paramString1.get(localObject2)).tabFileMd5)) {
                this.mTabFiles.put(localObject2, paramString1.get(localObject2));
              }
            }
            else {
              this.mTabFiles.put(localObject2, paramString1.get(localObject2));
            }
          }
          if ((this.mTabFiles != null) && (this.mTabFiles.size() > 0))
          {
            paramString1 = new JSONObject();
            localObject1 = new JSONObject();
            localObject2 = this.mTabFiles.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("tabFileMd5", ((TabFile)this.mTabFiles.get(str)).tabFileMd5);
              localJSONObject.put("tabFileJson", ((TabFile)this.mTabFiles.get(str)).tabFileJson);
              ((JSONObject)localObject1).put(str, localJSONObject);
            }
            paramString1.put("tabFileList", localObject1);
            localObject1 = getSharedPreferences().edit();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append("key_tab_files");
            ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramString1.toString()).commit();
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("[handleHippyConfig] tab json : ");
              paramString2.append(paramString1.toString());
              QLog.d("hippyUpdateAction-PreDownload", 2, paramString2.toString());
              return;
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleTabConfigResponse e:");
        paramString2.append(paramString1);
        QLog.e("hippyUpdateAction-PreDownload", 1, paramString2.toString());
      }
    }
  }
  
  public void notifyUpdateStatus(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyUpdateStatus] requestId = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ret = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", source = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("hippyUpdateAction-PreDownload", 2, ((StringBuilder)localObject).toString());
    }
    paramString = (BundleInfo)this.mBundleInfos.get(paramString);
    Object localObject = new JSONObject();
    if (paramString != null) {
      try
      {
        if (this.mDownFailedUrls != null) {
          ((JSONObject)localObject).put("maxFailedCnt", this.mDownFailedUrls.get(paramString.downloadUrl));
        }
      }
      catch (Exception localException)
      {
        QLog.e("hippyUpdateAction-PreDownload", 1, localException.toString());
        break label204;
      }
    }
    switch (paramInt2)
    {
    }
    label204:
    if ((1 != paramInt2) && (paramString != null))
    {
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = (int)(l - this.mLastPreloadTimeStamp);
      }
      HippyReporter.getInstance().reportPreDownloadOper(paramString.bundleName, paramString.bundleVersion, 12, paramInt1, (JSONObject)localObject, "");
    }
  }
  
  /* Error */
  public void onDone(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 713	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   5: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +42 -> 50
    //   11: new 115	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   18: astore 6
    //   20: aload 6
    //   22: ldc_w 715
    //   25: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 6
    //   31: aload_1
    //   32: invokevirtual 716	com/tencent/mobileqq/vip/DownloadTask:toString	()Ljava/lang/String;
    //   35: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 48
    //   41: iconst_2
    //   42: aload 6
    //   44: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 719	com/tencent/mobileqq/vip/DownloadTask:b	()Landroid/os/Bundle;
    //   54: astore 7
    //   56: aload 7
    //   58: ldc_w 265
    //   61: invokevirtual 722	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 6
    //   66: aload 7
    //   68: ldc_w 270
    //   71: invokevirtual 725	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   74: istore_2
    //   75: aload 7
    //   77: ldc_w 276
    //   80: invokevirtual 722	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 8
    //   85: aload 7
    //   87: ldc_w 280
    //   90: invokevirtual 725	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   93: istore_3
    //   94: iconst_3
    //   95: aload_1
    //   96: invokevirtual 727	com/tencent/mobileqq/vip/DownloadTask:e	()I
    //   99: if_icmpne +552 -> 651
    //   102: aload_1
    //   103: getfield 730	com/tencent/mobileqq/vip/DownloadTask:g	Ljava/util/Map;
    //   106: aload_1
    //   107: getfield 733	com/tencent/mobileqq/vip/DownloadTask:h	Ljava/lang/String;
    //   110: invokeinterface 170 2 0
    //   115: checkcast 735	java/io/File
    //   118: astore 7
    //   120: aload 7
    //   122: ifnull +498 -> 620
    //   125: aload 7
    //   127: invokevirtual 738	java/io/File:exists	()Z
    //   130: ifeq +490 -> 620
    //   133: aload 7
    //   135: invokevirtual 741	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   138: invokestatic 746	com/tencent/hippy/qq/update/sign/MD5:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 9
    //   143: aload 9
    //   145: aload 8
    //   147: invokestatic 538	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   150: ifne +79 -> 229
    //   153: new 115	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   160: astore 7
    //   162: aload 7
    //   164: ldc_w 748
    //   167: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 7
    //   173: aload 8
    //   175: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 7
    //   181: ldc_w 750
    //   184: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 7
    //   190: aload 9
    //   192: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc 48
    //   198: iconst_1
    //   199: aload 7
    //   201: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: getstatic 191	com/tencent/hippy/qq/update/HippyPredownloadManager:mCurRequestId	I
    //   211: bipush 253
    //   213: aload 6
    //   215: iload_3
    //   216: invokevirtual 198	com/tencent/hippy/qq/update/HippyPredownloadManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   219: aload_0
    //   220: aload_1
    //   221: getfield 733	com/tencent/mobileqq/vip/DownloadTask:h	Ljava/lang/String;
    //   224: iconst_1
    //   225: invokevirtual 752	com/tencent/hippy/qq/update/HippyPredownloadManager:addBundleFailedCnt	(Ljava/lang/String;I)V
    //   228: return
    //   229: invokestatic 213	com/tencent/hippy/qq/update/UpdateSetting:getInstance	()Lcom/tencent/hippy/qq/update/UpdateSetting;
    //   232: aload 6
    //   234: iload_2
    //   235: invokevirtual 220	com/tencent/hippy/qq/update/UpdateSetting:isModuleVersionFileExists	(Ljava/lang/String;I)Z
    //   238: ifeq +114 -> 352
    //   241: new 115	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   248: astore 8
    //   250: aload 8
    //   252: ldc_w 754
    //   255: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 8
    //   261: aload 6
    //   263: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 8
    //   269: ldc 224
    //   271: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 8
    //   277: iload_2
    //   278: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc 48
    //   284: iconst_2
    //   285: aload 8
    //   287: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_0
    //   294: getstatic 191	com/tencent/hippy/qq/update/HippyPredownloadManager:mCurRequestId	I
    //   297: iconst_1
    //   298: aload 6
    //   300: iload_3
    //   301: invokevirtual 198	com/tencent/hippy/qq/update/HippyPredownloadManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   304: aload 7
    //   306: invokevirtual 757	java/io/File:delete	()Z
    //   309: pop
    //   310: return
    //   311: astore_1
    //   312: new 115	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   319: astore 6
    //   321: aload 6
    //   323: ldc_w 759
    //   326: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 6
    //   332: aload_1
    //   333: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   336: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: ldc 48
    //   342: iconst_1
    //   343: aload 6
    //   345: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: return
    //   352: aload 7
    //   354: aload 6
    //   356: iload_2
    //   357: invokestatic 763	com/tencent/hippy/qq/update/HippyQQFileUtil:unzipModulePackage	(Ljava/io/File;Ljava/lang/String;I)Z
    //   360: istore 5
    //   362: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +40 -> 405
    //   368: new 115	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   375: astore 8
    //   377: aload 8
    //   379: ldc_w 765
    //   382: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 8
    //   388: iload 5
    //   390: invokevirtual 125	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: ldc 48
    //   396: iconst_2
    //   397: aload 8
    //   399: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: getstatic 191	com/tencent/hippy/qq/update/HippyPredownloadManager:mCurRequestId	I
    //   408: istore 4
    //   410: iload 5
    //   412: ifeq +270 -> 682
    //   415: iconst_0
    //   416: istore_2
    //   417: goto +3 -> 420
    //   420: aload_0
    //   421: iload 4
    //   423: iload_2
    //   424: aload 6
    //   426: iload_3
    //   427: invokevirtual 198	com/tencent/hippy/qq/update/HippyPredownloadManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   430: aload 7
    //   432: invokevirtual 757	java/io/File:delete	()Z
    //   435: pop
    //   436: return
    //   437: astore 6
    //   439: new 115	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   446: astore_1
    //   447: goto +91 -> 538
    //   450: astore_1
    //   451: goto +116 -> 567
    //   454: astore 8
    //   456: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +43 -> 502
    //   462: new 115	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   469: astore 9
    //   471: aload 9
    //   473: ldc_w 767
    //   476: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 9
    //   482: aload 8
    //   484: invokevirtual 770	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   487: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: ldc 48
    //   493: iconst_2
    //   494: aload 9
    //   496: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload_0
    //   503: aload_1
    //   504: getfield 733	com/tencent/mobileqq/vip/DownloadTask:h	Ljava/lang/String;
    //   507: invokevirtual 772	com/tencent/hippy/qq/update/HippyPredownloadManager:addBundleUnzipFailedUrl	(Ljava/lang/String;)V
    //   510: aload_0
    //   511: getstatic 191	com/tencent/hippy/qq/update/HippyPredownloadManager:mCurRequestId	I
    //   514: iconst_m1
    //   515: aload 6
    //   517: iload_3
    //   518: invokevirtual 198	com/tencent/hippy/qq/update/HippyPredownloadManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   521: aload 7
    //   523: invokevirtual 757	java/io/File:delete	()Z
    //   526: pop
    //   527: return
    //   528: astore 6
    //   530: new 115	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   537: astore_1
    //   538: aload_1
    //   539: ldc_w 759
    //   542: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_1
    //   547: aload 6
    //   549: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   552: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: ldc 48
    //   558: iconst_1
    //   559: aload_1
    //   560: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: return
    //   567: aload 7
    //   569: invokevirtual 757	java/io/File:delete	()Z
    //   572: pop
    //   573: goto +45 -> 618
    //   576: astore 6
    //   578: new 115	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   585: astore 7
    //   587: aload 7
    //   589: ldc_w 759
    //   592: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 7
    //   598: aload 6
    //   600: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   603: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: ldc 48
    //   609: iconst_1
    //   610: aload 7
    //   612: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_1
    //   619: athrow
    //   620: aload_0
    //   621: aload_1
    //   622: getfield 733	com/tencent/mobileqq/vip/DownloadTask:h	Ljava/lang/String;
    //   625: iconst_1
    //   626: invokevirtual 752	com/tencent/hippy/qq/update/HippyPredownloadManager:addBundleFailedCnt	(Ljava/lang/String;I)V
    //   629: aload_0
    //   630: getstatic 191	com/tencent/hippy/qq/update/HippyPredownloadManager:mCurRequestId	I
    //   633: bipush 249
    //   635: aload 6
    //   637: iload_3
    //   638: invokevirtual 198	com/tencent/hippy/qq/update/HippyPredownloadManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   641: ldc 48
    //   643: iconst_1
    //   644: ldc_w 774
    //   647: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: return
    //   651: ldc 48
    //   653: iconst_1
    //   654: ldc_w 776
    //   657: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aload_0
    //   661: aload_1
    //   662: getfield 733	com/tencent/mobileqq/vip/DownloadTask:h	Ljava/lang/String;
    //   665: iconst_1
    //   666: invokevirtual 752	com/tencent/hippy/qq/update/HippyPredownloadManager:addBundleFailedCnt	(Ljava/lang/String;I)V
    //   669: aload_0
    //   670: getstatic 191	com/tencent/hippy/qq/update/HippyPredownloadManager:mCurRequestId	I
    //   673: bipush 252
    //   675: aload 6
    //   677: iload_3
    //   678: invokevirtual 198	com/tencent/hippy/qq/update/HippyPredownloadManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   681: return
    //   682: iconst_m1
    //   683: istore_2
    //   684: goto -264 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	HippyPredownloadManager
    //   0	687	1	paramDownloadTask	DownloadTask
    //   74	610	2	i	int
    //   93	585	3	j	int
    //   408	14	4	k	int
    //   360	51	5	bool	boolean
    //   18	407	6	localObject1	Object
    //   437	79	6	localException1	Exception
    //   528	20	6	localException2	Exception
    //   576	100	6	localException3	Exception
    //   54	557	7	localObject2	Object
    //   83	315	8	localObject3	Object
    //   454	29	8	localThrowable	Throwable
    //   141	354	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   304	310	311	java/lang/Exception
    //   430	436	437	java/lang/Exception
    //   229	304	450	finally
    //   352	405	450	finally
    //   405	410	450	finally
    //   420	430	450	finally
    //   456	502	450	finally
    //   502	521	450	finally
    //   229	304	454	java/lang/Throwable
    //   352	405	454	java/lang/Throwable
    //   405	410	454	java/lang/Throwable
    //   420	430	454	java/lang/Throwable
    //   521	527	528	java/lang/Exception
    //   567	573	576	java/lang/Exception
  }
  
  public HippyConfig parseHippyConfigJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("hippyUpdateAction-PreDownload", 2, "[parseHippyConfigJson] str is empty");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      HippyConfig localHippyConfig = new HippyConfig();
      localHippyConfig.isGameCenterPredrawHippy = paramString.optInt("isPredrawHippy", 0);
      localHippyConfig.isGameCenterLoadHippyInToolProcess = paramString.optInt("isLoadHippyInToolProcess", 0);
      localHippyConfig.isGameCenterPreloadHippy = paramString.optInt("isPreloadHippy", 0);
      localHippyConfig.checkUpdateGap = paramString.optLong("checkUpdateGap", 120L);
      return localHippyConfig;
    }
    catch (Exception paramString)
    {
      QLog.e("hippyUpdateAction-PreDownload", 1, paramString.toString());
      throw paramString;
    }
  }
  
  public Map<String, TabFile> parseTabJson(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    HashMap localHashMap = null;
    if (bool)
    {
      QLog.i("hippyUpdateAction-PreDownload", 2, "[parseTabJson] jsonStr is empty.");
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString).optJSONObject("tabFileList");
      if (localJSONObject1 != null)
      {
        localHashMap = new HashMap();
        Iterator localIterator = localJSONObject1.keys();
        for (;;)
        {
          paramString = localHashMap;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          if (!TextUtils.isEmpty(paramString))
          {
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(paramString);
            if (localJSONObject2 != null)
            {
              TabFile localTabFile = new TabFile();
              localTabFile.tabFileMd5 = localJSONObject2.optString("tabFileMd5");
              localTabFile.tabFileJson = localJSONObject2.optString("tabFileJson");
              localHashMap.put(paramString, localTabFile);
            }
            else
            {
              QLog.i("hippyUpdateAction-PreDownload", 2, "[getTabFilesConfig] fileObj is empty");
            }
          }
          else
          {
            QLog.i("hippyUpdateAction-PreDownload", 2, "[getTabFilesConfig] key is empty");
          }
        }
      }
      QLog.i("hippyUpdateAction-PreDownload", 2, "[getTabFilesConfig] filesObj is null.");
      paramString = localHashMap;
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("hippyUpdateAction-PreDownload", 2, paramString.toString());
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void preDownloadHippyByController(int paramInt1, int paramInt2)
  {
    Object localObject2 = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    if (!(localObject2 instanceof BaseQQAppInterface))
    {
      QLog.e("hippyUpdateAction-PreDownload", 1, "[preDownloadHippyByController] cur process is not QQProcess, return.");
      return;
    }
    Object localObject1 = new RunnableTask((BaseQQAppInterface)localObject2, "preDownloadHippyKey", new HippyPredownloadManager.1(this, paramInt1), 0L);
    localObject2 = (IPreDownloadController)((AppInterface)localObject2).getRuntimeService(IPreDownloadController.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    localStringBuilder.append(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/pddate/edu/gamecenter/");
    boolean bool = ((IPreDownloadController)localObject2).requestPreDownload(paramInt2, "sed", "preDownloadHippyKey", 2, "https://gamecenter.fake.url", localStringBuilder.toString(), 3, 0, true, (AbsPreDownloadTask)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[preDownloadHippyByController] ret = ");
    ((StringBuilder)localObject1).append(bool);
    QLog.i("hippyUpdateAction-PreDownload", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void predownloadHippy(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[predownloadHippy] source:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("hippyUpdateAction-PreDownload", 1, ((StringBuilder)localObject).toString());
    if ((paramInt == 1) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySoDownload())) {
      HippyQQLibraryManager.getInstance().downloadSo();
    }
    if ((!checkPreDownloadInterval()) && (paramInt != 2))
    {
      QLog.i("hippyUpdateAction-PreDownload", 1, "[preloadHippy] check preloadInterval failed, stop action.");
      return;
    }
    localObject = UpdateSetting.getInstance().getAllModuleVersion();
    Bundle localBundle = new Bundle();
    localBundle.putInt("source", paramInt);
    localBundle.putInt("requestId", mCurRequestId);
    localBundle.putString("uin", this.mCurrentUin);
    HippyUnissoHandler localHippyUnissoHandler = HippyUnissoHandler.getInstance();
    if (localHippyUnissoHandler != null)
    {
      localHippyUnissoHandler.requestPreDownloadConfig(paramInt, (Map)localObject, this.mLastPreloadTimeStamp, localBundle);
      this.mLastPreloadTimeStamp = NetConnInfoCenter.getServerTimeMillis();
      saveLastPreDownloadTime(this.mLastPreloadTimeStamp);
      return;
    }
    QLog.i("hippyUpdateAction-PreDownload", 1, "[preloadHippy] hippyHandler is null.");
  }
  
  public void removeListener(IUpdateListener paramIUpdateListener)
  {
    if (paramIUpdateListener == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        IUpdateListener localIUpdateListener = (IUpdateListener)((WeakReference)localIterator.next()).get();
        if (localIUpdateListener == null)
        {
          localIterator.remove();
        }
        else if (localIUpdateListener == paramIUpdateListener)
        {
          localIterator.remove();
          return;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIUpdateListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyPredownloadManager
 * JD-Core Version:    0.7.0.1
 */