package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import tes;
import tfa;
import tju;
import tlo;

public class RockDownloadPresenter$1
  extends RockDownloadListener
{
  public RockDownloadPresenter$1(tes paramtes, RockDownloadListenerWrapper paramRockDownloadListenerWrapper) {}
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = tfa.b();
    tlo.a("RockDownloader", "rockdownload onDownloadCancel");
    tfa.a();
    WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    boolean bool = true;
    tfa.a();
    tlo.d("RockDownloader", "onDownloadFail errorCode: " + paramInt + ",errorInfo:" + paramString + ",    " + paramRockDownloadInfo.toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = tfa.b();
    WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 3, 1, 0);
    tlo.d("RockDownloader", "Rock下载失败，QQ下载兜底！,eventType = " + i);
    Activity localActivity = tes.a(this.this$0);
    tes localtes = this.this$0;
    WSDownloadParams localWSDownloadParams = tes.a(this.this$0);
    if (i != 1) {}
    for (;;)
    {
      tfa.a(localActivity, localtes, localWSDownloadParams, bool, i);
      if (this.val$listenerWrapper == null) {
        break;
      }
      this.val$listenerWrapper.onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
      bool = false;
    }
    tlo.d("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    tlo.a("RockDownloader", "rockdownload onDownloadFinish");
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    tlo.a("RockDownloader", "rockdownload onDownloadProceedOn,process" + paramInt);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = tfa.b();
    tlo.b("RockDownloader", "rockdownload onDownloadStart,eventType = " + i);
    tfa.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = tfa.b();
    tlo.c("RockDownloader", "rockdownload onDownloadSuccess,eventType = " + i);
    tfa.a();
    tju.a(1);
    WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 2, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    tlo.c("RockDownloader", "rockdownload onDownloadSuccess,but preload need not call install. eventType = " + i);
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    tlo.c("RockDownloader", "rockdownload onDownloadWait");
    tfa.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = tfa.b();
    tlo.b("RockDownloader", "rockdownload onPermissionDeny");
    tfa.a();
    WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    tlo.b("RockDownloader", "rockdownload onPermissionPermit");
    tfa.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */