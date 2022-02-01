package com.tencent.ad.tangram.preorder;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.downloader.AdDownloader;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;

final class b
{
  private static final String TAG = "AdAppPreOrderManagerForPreDownload";
  
  private static boolean canStartDownload(String paramString)
  {
    return AdAppPreOrderManager.INSTANCE.canStartDownload(paramString);
  }
  
  static void fetchAdInfo(WeakReference<Context> paramWeakReference, String paramString)
  {
    if (paramWeakReference != null) {}
    for (Object localObject = (Context)paramWeakReference.get(); !AdNet.isNetValid((Context)localObject); localObject = null) {
      return;
    }
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramString, 4);
    localObject = "https://fv.gdt.qq.com/msg?id=" + paramString;
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl((String)localObject);
    localParams.method = "GET";
    AdThreadManager.INSTANCE.post(new b.1(localParams, (String)localObject, paramString, paramWeakReference), 4);
  }
  
  public static boolean pauseDownload(AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    IAdDownloader localIAdDownloader = AdDownloader.getDownloader();
    if (localIAdDownloader == null) {
      return false;
    }
    localIAdDownloader.pauseDownload(paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name, paramAdAppPreOrderTask.content.ad_info.app_info.pkg_url);
    return true;
  }
  
  public static void runTask(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean)
  {
    if (paramAdAppPreOrderTask.status == 2) {
      fetchAdInfo(new WeakReference(paramContext), paramAdAppPreOrderTask.taskId);
    }
    do
    {
      do
      {
        return;
        if (paramAdAppPreOrderTask.status != 6) {
          break;
        }
      } while ((paramAdAppPreOrderTask.content != null) || (!paramBoolean));
      fetchAdInfo(new WeakReference(paramContext), paramAdAppPreOrderTask.taskId);
      return;
    } while ((paramAdAppPreOrderTask.status == 4) || (paramAdAppPreOrderTask.status == 7) || (paramAdAppPreOrderTask.status == 8));
    if (paramAdAppPreOrderTask.status == 5)
    {
      if (AdAppUtil.isInstalled(paramContext, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name))
      {
        AdAppPreOrderManager.INSTANCE.setTaskFinishedAndCommit(paramAdAppPreOrderTask.taskId, 19);
        return;
      }
      startDownload(paramAdAppPreOrderTask);
      return;
    }
    if ((paramAdAppPreOrderTask.status == 9) || (paramAdAppPreOrderTask.status == 11))
    {
      startDownload(paramAdAppPreOrderTask);
      return;
    }
    AdLog.i("AdAppPreOrderManagerForPreDownload", String.format("runTask error, taskId:%s status%d ", new Object[] { paramAdAppPreOrderTask.taskId, Integer.valueOf(paramAdAppPreOrderTask.status) }));
  }
  
  private static void startDownload(AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    if (paramAdAppPreOrderTask.isDownloadLaunched) {}
    while ((!canStartDownload(paramAdAppPreOrderTask.taskId)) || (!startDownloadInternal(paramAdAppPreOrderTask))) {
      return;
    }
    AdAppPreOrderManager localAdAppPreOrderManager = AdAppPreOrderManager.INSTANCE;
    localAdAppPreOrderManager.downloadingTaskCount += 1;
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramAdAppPreOrderTask.taskId, 7, true);
  }
  
  private static boolean startDownloadInternal(AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    IAdDownloader localIAdDownloader = AdDownloader.getDownloader();
    if (localIAdDownloader == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(AdDownloadConstants.PARAM_TASK_PACKNAME, paramAdAppPreOrderTask.content.ad_info.app_info.app_package_name);
    localBundle.putString(AdDownloadConstants.PARAM_SNG_APPID, paramAdAppPreOrderTask.content.ad_info.app_info.android_app_id);
    localBundle.putString(AdDownloadConstants.PARAM_URL, paramAdAppPreOrderTask.content.ad_info.app_info.pkg_url);
    localBundle.putString(AdDownloadConstants.PARAM_APPNAME, paramAdAppPreOrderTask.content.ad_info.app_info.app_name);
    localBundle.putInt(AdDownloadConstants.PARAM_ACTIONCODE, 2);
    localBundle.putInt(AdDownloadConstants.PARAM_WOWNLOAD_TYPE, 0);
    localBundle.putBoolean(AdDownloadConstants.PARAM_BLOCK_NOTIFY, true);
    localBundle.putInt(AdDownloadConstants.PARAM_SHOW_NOTIFICATION, 0);
    localBundle.putBoolean(AdDownloadConstants.PARAM_IS_APK, true);
    localBundle.putBoolean(AdDownloadConstants.PARAM_AUTO_INSTALL, false);
    localBundle.putBoolean(AdDownloadConstants.PARAM_SHOW_NETWORK_DIALOG, false);
    localBundle.putBoolean(AdDownloadConstants.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    localBundle.putString(AdDownloadConstants.PARAM_VIA, paramAdAppPreOrderTask.content.ad_info.report_info.trace_info.via);
    localBundle.putString(AdDownloadConstants.KEY, "biz_src_ads");
    localIAdDownloader.doDownloadAction(null, localBundle, "biz_src_ads", 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.b
 * JD-Core Version:    0.7.0.1
 */