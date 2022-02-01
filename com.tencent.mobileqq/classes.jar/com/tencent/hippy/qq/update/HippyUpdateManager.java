package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.update.patch.PatchUtil;
import com.tencent.hippy.qq.update.patch.PatchUtil.DiffResultCodes;
import com.tencent.hippy.qq.update.sign.MD5;
import com.tencent.hippy.qq.update.sso.BundleInfo;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class HippyUpdateManager
{
  public static final String PREFIX = "hippyUpdateAction-";
  public static final int SERVER_STATUS_CODE_NO_UPDATE = 2;
  public static final int SERVER_STATUS_CODE_SUCCESS = 1;
  public static final String TAG = "hippyUpdateAction-HippyUpdateManager";
  public static final int UPDATE_JS_BUNDLE_TYPE_PRELODAD = 1;
  public static final int UPDATE_JS_BUNDLE_TYPE_SINGLE = 2;
  private static final int UPDATE_TYPE_DIFF_PKG = 2;
  private static final int UPDATE_TYPE_FULL_PKG = 1;
  private static final int UPDATE_TYPE_FULL_PKG_AFTER_DIFF_ERR = 3;
  private static volatile HippyUpdateManager sHippyUpdateManager;
  private final HashMap<String, Long> mJsBundleLastUpdateTimes = new HashMap();
  private final HashMap<String, ArrayList<IUpdateListener>> mJsBundleUpdateListeners = new HashMap();
  
  private void downloadJsBundleImmediately(Intent paramIntent, BundleInfo paramBundleInfo, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = paramBundleInfo.diffPkgUrl;
    } else {
      localObject = paramBundleInfo.downloadUrl;
    }
    File localFile = paramBundleInfo.getDownloadFile(paramBoolean);
    Object localObject = new DownloadTask((String)localObject, localFile);
    ((DownloadTask)localObject).N = true;
    ((DownloadTask)localObject).J = true;
    ((DownloadTask)localObject).e = 2;
    ((DownloadTask)localObject).P = true;
    ((DownloadTask)localObject).Q = true;
    long l = System.currentTimeMillis();
    int i = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject, MobileQQ.sMobileQQ.waitAppRuntime(null));
    paramIntent.putExtra("downloadTime", System.currentTimeMillis() - l);
    if ((i == 0) && (localFile.exists()) && (localFile.length() > 0L))
    {
      if (!paramBundleInfo.checkMd5(MD5.getFileMd5(localFile.getAbsolutePath()), paramBoolean))
      {
        notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -3, null);
        return;
      }
      if (paramBoolean)
      {
        onDiffFileDownloaded(paramIntent, paramBundleInfo, localFile);
        return;
      }
      onFullJsBundleDownloaded(paramIntent, paramBundleInfo, localFile);
      return;
    }
    notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -4, null);
  }
  
  public static HippyUpdateManager getInstance()
  {
    if (sHippyUpdateManager == null) {
      try
      {
        if (sHippyUpdateManager == null) {
          sHippyUpdateManager = new HippyUpdateManager();
        }
      }
      finally {}
    }
    return sHippyUpdateManager;
  }
  
  private void handleUpdateConfigResponse(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    long l = paramIntent.getLongExtra("requestStartTime", 0L);
    paramIntent.putExtra("requestTime", NetConnInfoCenter.getServerTimeMillis() - l);
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("ret ");
      paramString2.append(paramInt);
      notifyJsBundleUpdate(paramIntent, paramString1, -5, paramString2.toString());
      return;
    }
    paramString2 = BundleInfo.parseBundleList(paramString2);
    if (paramString2 != null)
    {
      Iterator localIterator = paramString2.iterator();
      paramString2 = null;
      for (;;)
      {
        localObject = paramString2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (BundleInfo)localIterator.next();
        if (paramString1.equals(((BundleInfo)localObject).bundleName)) {
          paramString2 = (String)localObject;
        }
      }
    }
    Object localObject = null;
    if (localObject == null)
    {
      notifyJsBundleUpdate(paramIntent, paramString1, 1, null);
      return;
    }
    if (UpdateSetting.getInstance().isModuleVersionFileExists(((BundleInfo)localObject).bundleName, ((BundleInfo)localObject).bundleVersion))
    {
      UpdateSetting.getInstance().setModuleVersion(((BundleInfo)localObject).bundleName, ((BundleInfo)localObject).bundleVersion);
      notifyJsBundleUpdate(paramIntent, ((BundleInfo)localObject).bundleName, 101, "js bundle exists");
      return;
    }
    if (TextUtils.isEmpty(((BundleInfo)localObject).downloadUrl))
    {
      notifyJsBundleUpdate(paramIntent, paramString1, -5, "download url is empty");
      return;
    }
    paramIntent.putExtra("bundleSize", ((BundleInfo)localObject).bundleSize);
    paramIntent.putExtra("diffSize", ((BundleInfo)localObject).diffPkgSize);
    ThreadManager.post(new HippyUpdateManager.2(this, (BundleInfo)localObject, paramIntent), 8, null, true);
  }
  
  private void handleUpdateJsBundle(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp, String paramString)
  {
    if (paramIntent == null)
    {
      QLog.e("hippyUpdateAction-HippyUpdateManager", 1, "handleUpdateJsBundle request is null");
      return;
    }
    String str = paramIntent.getStringExtra("jsBundleName");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("hippyUpdateAction-HippyUpdateManager", 1, "handleUpdateJsBundle bundleName is empty");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleUpdateJsBundle retCode:");
    ((StringBuilder)localObject1).append(paramLong);
    QLog.i("hippyUpdateAction-HippyUpdateManager", 1, ((StringBuilder)localObject1).toString());
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.has())) {}
    for (;;)
    {
      try
      {
        localObject1 = new CommonMobileConfQueryRsp();
        ((CommonMobileConfQueryRsp)localObject1).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        if (!((CommonMobileConfQueryRsp)localObject1).confList.has())
        {
          notifyJsBundleUpdate(paramIntent, str, -5, "configRsp is empty");
          return;
        }
        i = 0;
        boolean bool = isCheckPreloadSuccess(paramIntent, ((CommonMobileConfQueryRsp)localObject1).confList.get());
        Iterator localIterator = ((CommonMobileConfQueryRsp)localObject1).confList.get().iterator();
        if (localIterator.hasNext())
        {
          MobileConfRsp localMobileConfRsp = (MobileConfRsp)localIterator.next();
          if ((!localMobileConfRsp.ret.has()) || (!localMobileConfRsp.configType.has())) {
            continue;
          }
          int j = localMobileConfRsp.configType.get();
          localObject1 = null;
          Object localObject2 = null;
          paramTrpcInovkeRsp = null;
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3) {
                continue;
              }
              if (localMobileConfRsp.conf.has()) {
                paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
              }
              HippyPredownloadManager.getInstance().handleTabConfigResponse(localMobileConfRsp.ret.get(), paramTrpcInovkeRsp, paramString);
              continue;
            }
            if (bool)
            {
              paramTrpcInovkeRsp = (TrpcProxy.TrpcInovkeRsp)localObject1;
              if (localMobileConfRsp.conf.has()) {
                paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
              }
              handleUpdateConfigResponse(paramIntent, str, localMobileConfRsp.ret.get(), paramTrpcInovkeRsp);
              break label525;
            }
            notifyJsBundleUpdate(paramIntent, str, 2, "preload not allowed");
            break label525;
          }
          paramTrpcInovkeRsp = localObject2;
          if (localMobileConfRsp.conf.has()) {
            paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
          }
          HippyPredownloadManager.getInstance().handleHippyConfigResponse(localMobileConfRsp.ret.get(), paramTrpcInovkeRsp, paramString);
          continue;
        }
        if (i == 0)
        {
          notifyJsBundleUpdate(paramIntent, str, -5, "no update config");
          return;
        }
      }
      catch (Throwable paramTrpcInovkeRsp)
      {
        paramString = new StringBuilder();
        paramString.append("handleUpdateJsBundle e:");
        paramString.append(paramTrpcInovkeRsp);
        notifyJsBundleUpdate(paramIntent, str, -5, paramString.toString());
      }
      return;
      paramTrpcInovkeRsp = new StringBuilder();
      paramTrpcInovkeRsp.append("net error code:");
      paramTrpcInovkeRsp.append(paramLong);
      notifyJsBundleUpdate(paramIntent, str, -5, paramTrpcInovkeRsp.toString());
      return;
      label525:
      int i = 1;
    }
  }
  
  private boolean isCheckPreloadSuccess(Intent paramIntent, List<MobileConfRsp> paramList)
  {
    boolean bool1 = false;
    if (!paramIntent.getBooleanExtra("isCheckPreload", false)) {
      return true;
    }
    Iterator localIterator = paramList.iterator();
    MobileConfRsp localMobileConfRsp;
    do
    {
      boolean bool2 = localIterator.hasNext();
      paramList = null;
      paramIntent = paramList;
      if (!bool2) {
        break;
      }
      localMobileConfRsp = (MobileConfRsp)localIterator.next();
    } while ((!localMobileConfRsp.configType.has()) || (localMobileConfRsp.configType.get() != 6));
    paramIntent = paramList;
    if (localMobileConfRsp.conf.has()) {
      paramIntent = localMobileConfRsp.conf.get();
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      try
      {
        int i = new JSONObject(paramIntent).optInt("needPreload");
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("isCheckPreloadSuccess needPreload:");
          paramIntent.append(i);
          QLog.i("hippyUpdateAction-HippyUpdateManager", 2, paramIntent.toString());
        }
        if (i == 1) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Throwable paramIntent)
      {
        paramList = new StringBuilder();
        paramList.append("isCheckPreloadSuccess e:");
        paramList.append(paramIntent);
        QLog.e("hippyUpdateAction-HippyUpdateManager", 1, paramList.toString());
      }
    }
    return true;
  }
  
  private void notifyJsBundleUpdate(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramIntent != null))
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - paramIntent.getLongExtra("requestStartTime", 0L);
      if ((QLog.isColorLevel()) || (paramInt != 0))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("notifyJsBundleUpdate bundleName:");
        ((StringBuilder)???).append(paramString1);
        ((StringBuilder)???).append(" retCode:");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(" retMsg:");
        ((StringBuilder)???).append(paramString2);
        ((StringBuilder)???).append(" cost:");
        ((StringBuilder)???).append(l);
        QLog.i("hippyUpdateAction-HippyUpdateManager", 2, ((StringBuilder)???).toString());
      }
      synchronized (this.mJsBundleUpdateListeners)
      {
        ArrayList localArrayList = (ArrayList)this.mJsBundleUpdateListeners.get(paramString1);
        if (localArrayList != null)
        {
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            IUpdateListener localIUpdateListener = (IUpdateListener)localIterator.next();
            if (paramInt == 0) {
              localIUpdateListener.onUpdateSuccess(0, paramString1);
            } else {
              localIUpdateListener.onUpdateFailed(0, paramInt, paramString2, paramString1);
            }
          }
          localArrayList.clear();
        }
        reportJsUpdateEvent(paramIntent, paramString1, paramInt, paramString2, l);
        return;
      }
    }
    QLog.i("hippyUpdateAction-HippyUpdateManager", 1, "notifyJsBundleUpdate bundleName or request is null");
  }
  
  private void onDiffFileDownloaded(Intent paramIntent, BundleInfo paramBundleInfo, File paramFile)
  {
    try
    {
      long l = System.currentTimeMillis();
      int i = paramIntent.getIntExtra("curVersion", -1);
      localObject = HippyQQFileUtil.getJsBundleZipFile(paramBundleInfo.bundleName, i);
      File localFile = HippyQQFileUtil.getJsBundleZipFile(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
      localObject = PatchUtil.patch(((File)localObject).getAbsolutePath(), localFile.getAbsolutePath(), paramFile.getAbsolutePath(), paramBundleInfo.diffQarFileMd5);
      paramIntent.putExtra("diffTime", System.currentTimeMillis() - l);
      if (localObject != PatchUtil.DiffResultCodes.SUCCESS)
      {
        onDiffPkgError(paramIntent, paramBundleInfo, paramFile, (PatchUtil.DiffResultCodes)localObject);
        return;
      }
      l = System.currentTimeMillis();
      boolean bool = HippyQQFileUtil.unzipModulePackage(localFile, paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
      paramIntent.putExtra("unzipTime", System.currentTimeMillis() - l);
      if (!bool)
      {
        onDiffPkgError(paramIntent, paramBundleInfo, paramFile, PatchUtil.DiffResultCodes.UNZIP_FULL_PKG_FAILED);
        return;
      }
      UpdateSetting.getInstance().setModuleVersion(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
      notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, 0, null);
      if (i > 0)
      {
        HippyQQFileUtil.cleanHistoryVersion(paramBundleInfo.bundleName, i);
        HippyQQFileUtil.cleanHistoryPkg(paramBundleInfo.bundleName, i);
      }
      paramFile.delete();
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("diff error:");
      ((StringBuilder)localObject).append(localThrowable);
      QLog.e("hippyUpdateAction-HippyUpdateManager", 1, ((StringBuilder)localObject).toString());
      onDiffPkgError(paramIntent, paramBundleInfo, paramFile, PatchUtil.DiffResultCodes.UNKNOWN);
    }
  }
  
  private void onDiffPkgError(Intent paramIntent, BundleInfo paramBundleInfo, File paramFile, PatchUtil.DiffResultCodes paramDiffResultCodes)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDiffPkgError errorCode:");
    localStringBuilder.append(paramDiffResultCodes.ordinal());
    QLog.e("hippyUpdateAction-HippyUpdateManager", 1, localStringBuilder.toString());
    paramIntent.putExtra("diffErrCode", paramDiffResultCodes.ordinal());
    paramFile.delete();
    downloadJsBundleImmediately(paramIntent, paramBundleInfo, false);
  }
  
  private void onFullJsBundleDownloaded(Intent paramIntent, BundleInfo paramBundleInfo, File paramFile)
  {
    try
    {
      long l = System.currentTimeMillis();
      boolean bool = HippyQQFileUtil.unzipModulePackage(paramFile, paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
      paramIntent.putExtra("unzipTime", System.currentTimeMillis() - l);
      if (bool)
      {
        UpdateSetting.getInstance().setModuleVersion(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
        notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, 0, null);
        int i = paramIntent.getIntExtra("curVersion", 0);
        if (i > 0)
        {
          HippyQQFileUtil.cleanHistoryVersion(paramBundleInfo.bundleName, i);
          HippyQQFileUtil.cleanHistoryPkg(paramBundleInfo.bundleName, i);
        }
      }
      else
      {
        notifyJsBundleUpdate(paramIntent, paramBundleInfo.bundleName, -1, null);
        return;
      }
    }
    catch (Throwable paramFile)
    {
      paramBundleInfo = paramBundleInfo.bundleName;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unZipFile file error:");
      localStringBuilder.append(paramFile);
      notifyJsBundleUpdate(paramIntent, paramBundleInfo, -1, localStringBuilder.toString());
    }
  }
  
  private void reportJsUpdateEvent(Intent paramIntent, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    long l1 = paramIntent.getLongExtra("downloadTime", 0L);
    long l2 = paramIntent.getLongExtra("unzipTime", 0L);
    long l3 = paramIntent.getLongExtra("requestTime", 0L);
    long l4 = paramIntent.getLongExtra("diffTime", 0L);
    long l5 = paramIntent.getLongExtra("diffErrCode", 0L);
    long l6 = paramIntent.getLongExtra("bundleSize", 0L);
    long l7 = paramIntent.getLongExtra("diffSize", 0L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("reportFrom", paramIntent.getStringExtra("reportFrom"));
    localHashMap.put("downloadTime", String.valueOf(l1));
    localHashMap.put("unzipTime", String.valueOf(l2));
    localHashMap.put("requestTime", String.valueOf(l3));
    localHashMap.put("diffTime", String.valueOf(l4));
    localHashMap.put("diffErrCode", String.valueOf(l5));
    localHashMap.put("bundleSize", String.valueOf(l6));
    localHashMap.put("diffSize", String.valueOf(l7));
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if (l4 > 0L) {
        if (l5 == 0L) {
          i = 2;
        } else {
          i = 3;
        }
      }
      localHashMap.put("updateResult", String.valueOf(i));
    }
    if (paramIntent.getBooleanExtra("isUseHttpRequest", false)) {
      i = 5;
    } else {
      i = 11;
    }
    HippyReporter.getInstance().reportCheckUpdate(paramString1, i, paramInt, paramString2, paramLong, localHashMap);
  }
  
  private void updateJsBundleByHttp(String paramString, int paramInt, Bundle paramBundle, IUpdateListener paramIUpdateListener)
  {
    new HippyQQUpdateManager().checkUpdate(paramString, new HippyUpdateManager.1(this, paramBundle, paramString));
  }
  
  private void updateJsBundleBySSO(String paramString, int paramInt1, Bundle paramBundle, int paramInt2, IUpdateListener paramIUpdateListener)
  {
    long l;
    if (this.mJsBundleLastUpdateTimes.containsKey(paramString)) {
      l = ((Long)this.mJsBundleLastUpdateTimes.get(paramString)).longValue();
    } else {
      l = 0L;
    }
    HippyUnissoHandler localHippyUnissoHandler = HippyUnissoHandler.getInstance();
    if (localHippyUnissoHandler != null)
    {
      localHippyUnissoHandler.requestHippyConfig(paramInt2, paramString, paramInt1, l, paramBundle);
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      if (paramIUpdateListener != null)
      {
        removeJsBundleUpdateListener(paramString, paramIUpdateListener);
        paramIUpdateListener.onUpdateFailed(0, -5, "gcHandler is null", paramString);
      }
      QLog.e("hippyUpdateAction-HippyUpdateManager", 1, "updateJsBundle gcHandler is null.");
    }
  }
  
  public boolean checkUpdateJsBundleInterval(String paramString)
  {
    return checkUpdateJsBundleInterval(paramString, HippyPredownloadManager.getInstance().getHippyConfig().checkUpdateGap);
  }
  
  public boolean checkUpdateJsBundleInterval(String paramString, long paramLong)
  {
    if (!this.mJsBundleLastUpdateTimes.containsKey(paramString)) {
      return true;
    }
    long l1 = ((Long)this.mJsBundleLastUpdateTimes.get(paramString)).longValue();
    long l2 = NetConnInfoCenter.getServerTime();
    return (l2 > l1) && (l2 - l1 > paramLong);
  }
  
  public void handleAllResponses(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    int i = 0;
    String str;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("source", 0);
      str = paramIntent.getStringExtra("uin");
    }
    else
    {
      str = "";
    }
    if (!TextUtils.equals(str, HippyAccessHelper.getCurrentUin()))
    {
      QLog.e("hippyUpdateAction-HippyUpdateManager", 1, "[handleResponse] current uin change. return.");
      return;
    }
    if ((i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4)) {
        return;
      }
      handleUpdateJsBundle(paramIntent, paramLong, paramTrpcInovkeRsp, str);
      return;
    }
    HippyPredownloadManager.getInstance().handleAllConfigResponses(paramIntent, paramLong, paramTrpcInovkeRsp, str);
  }
  
  public void removeJsBundleUpdateListener(String paramString, IUpdateListener paramIUpdateListener)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIUpdateListener == null) {
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
  }
  
  public void updateJsBundle(String paramString, boolean paramBoolean, int paramInt, Bundle paramBundle, IUpdateListener paramIUpdateListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      if (paramIUpdateListener != null) {
        paramIUpdateListener.onUpdateFailed(0, -5, "Net unavailable", paramString);
      }
      return;
    }
    int i = UpdateSetting.getInstance().getModuleVersion(paramString);
    if (i < 0) {
      i = 0;
    }
    boolean bool1;
    int j;
    boolean bool2;
    if (paramBundle != null)
    {
      bool1 = paramBundle.getBoolean("isCheckPreload");
      j = paramBundle.getInt("preloadSceneType");
      bool2 = paramBundle.getBoolean("isSkipInterval");
      paramBundle = paramBundle.getString("reportFrom");
    }
    else
    {
      paramBundle = null;
      bool1 = false;
      j = 0;
      bool2 = false;
    }
    if ((!bool1) && (!bool2) && (i > 0) && (!checkUpdateJsBundleInterval(paramString)))
    {
      if (paramIUpdateListener != null) {
        paramIUpdateListener.onUpdateFailed(0, -5, "Check update interval", paramString);
      }
      return;
    }
    if (paramIUpdateListener != null) {
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
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("source", 4);
    ((Bundle)localObject).putBoolean("isUseHttpRequest", paramBoolean);
    ((Bundle)localObject).putBoolean("isCheckPreload", bool1);
    ((Bundle)localObject).putInt("preloadSceneType", j);
    ((Bundle)localObject).putString("jsBundleName", paramString);
    ((Bundle)localObject).putLong("requestStartTime", NetConnInfoCenter.getServerTimeMillis());
    ((Bundle)localObject).putInt("curVersion", i);
    ((Bundle)localObject).putString("uin", HippyAccessHelper.getCurrentUin());
    ((Bundle)localObject).putString("reportFrom", paramBundle);
    if (paramBoolean) {
      updateJsBundleByHttp(paramString, i, (Bundle)localObject, paramIUpdateListener);
    } else {
      updateJsBundleBySSO(paramString, i, (Bundle)localObject, paramInt, paramIUpdateListener);
    }
    this.mJsBundleLastUpdateTimes.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager
 * JD-Core Version:    0.7.0.1
 */