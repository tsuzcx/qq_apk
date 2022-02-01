package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderProxy;
import com.tencent.mobileqq.data.RockDownloadInfo;
import mqq.util.WeakReference;

public class RockDownloadPresenter
{
  private WSDownloadParams a;
  private RockDownloadListener b;
  
  private RockDownloadListener a(Activity paramActivity, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if (this.b == null) {
      this.b = new RockDownloadPresenter.1(this, this, new WeakReference(paramRockDownloadListenerWrapper), paramActivity);
    }
    return this.b;
  }
  
  public static String a()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  private int c()
  {
    WSDownloadParams localWSDownloadParams = this.a;
    if (localWSDownloadParams != null) {
      return localWSDownloadParams.mScene;
    }
    return 1;
  }
  
  public void a(Activity paramActivity, RockDownloadInfo paramRockDownloadInfo, int paramInt, WSDownloadParams paramWSDownloadParams, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if ((paramActivity != null) && (paramInt == 3)) {
      WSDownloadAppDialog.a(paramActivity);
    }
    if (WeishiDownloadUtil.g())
    {
      WSLog.d("RockDownloader", "已有正在下载的任务，不响应");
      return;
    }
    WSDownloadParams localWSDownloadParams = paramWSDownloadParams;
    if (paramWSDownloadParams == null) {
      localWSDownloadParams = new WSDownloadParams();
    }
    this.a = localWSDownloadParams;
    WSReportDc00898.a(localWSDownloadParams, 1);
    WSPublicAccReport.getInstance().reportDownload(localWSDownloadParams.mEventId, paramInt, 1, 1, 0, localWSDownloadParams.mScene);
    if (paramInt == 1)
    {
      RockDownloaderProxy.a(paramRockDownloadInfo, a(paramActivity, paramRockDownloadListenerWrapper));
      paramActivity = new StringBuilder();
      paramActivity.append("执行预下载Rock下载 ");
      paramActivity.append(paramRockDownloadInfo.toString());
      WSLog.d("RockDownloader", paramActivity.toString());
      return;
    }
    WeishiUtils.e(localWSDownloadParams.mScheme);
    RockDownloaderProxy.a(paramRockDownloadInfo, a(paramActivity, paramRockDownloadListenerWrapper));
    paramActivity = new StringBuilder();
    paramActivity.append("执行可call起安装Rock下载 ");
    paramActivity.append(paramRockDownloadInfo.toString());
    WSLog.d("RockDownloader", paramActivity.toString());
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo)
  {
    boolean bool = RockDownloaderProxy.b(paramRockDownloadInfo);
    if (bool)
    {
      WSLog.b("RockDownloader", "rockdownload deleteSuccess");
      return bool;
    }
    if (paramRockDownloadInfo.realVersionCode == 333)
    {
      WSLog.b("RockDownloader", "rockdownload 模拟 deleteFail");
      return bool;
    }
    WSLog.b("RockDownloader", "rockdownload deleteFail");
    return bool;
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    boolean bool = RockDownloaderProxy.c(paramRockDownloadInfo);
    int i = WeishiDownloadUtil.e();
    if (bool)
    {
      paramRockDownloadInfo = new StringBuilder();
      paramRockDownloadInfo.append("rockdownload installSuccess,eventType = ");
      paramRockDownloadInfo.append(i);
      WSLog.d("RockDownloader", paramRockDownloadInfo.toString());
      WSReportDc00898.a(paramInt, 1);
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), i, 2, 1, 1, c());
      return bool;
    }
    paramRockDownloadInfo = new StringBuilder();
    paramRockDownloadInfo.append("rockdownload installFail,eventType = ");
    paramRockDownloadInfo.append(i);
    WSLog.d("RockDownloader", paramRockDownloadInfo.toString());
    return bool;
  }
  
  public RockDownloadInfo b()
  {
    int i = WSGlobalConfig.a().m();
    String str2 = WSGlobalConfig.a().k();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a();
    }
    return new RockDownloadInfo("biz_src_jc_gzh_weishi", "weishi_gzh", "com.tencent.weishi", str1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter
 * JD-Core Version:    0.7.0.1
 */