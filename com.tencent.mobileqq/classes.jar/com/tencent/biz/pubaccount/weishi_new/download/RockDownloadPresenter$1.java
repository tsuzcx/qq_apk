package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import ski;
import skq;
import sms;
import sne;

public class RockDownloadPresenter$1
  extends RockDownloadListener
{
  public RockDownloadPresenter$1(ski paramski, RockDownloadListenerWrapper paramRockDownloadListenerWrapper) {}
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skq.b();
    sne.a("RockDownloader", "rockdownload onDownloadCancel");
    skq.a();
    WSPublicAccReport.getInstance().reportDownload(skq.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    boolean bool = true;
    skq.a();
    sne.d("RockDownloader", "onDownloadFail errorCode: " + paramInt + ",errorInfo:" + paramString + ",    " + paramRockDownloadInfo.toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = skq.b();
    WSPublicAccReport.getInstance().reportDownload(skq.a(), i, 3, 1, 0);
    sne.d("RockDownloader", "Rock下载失败，QQ下载兜底！,eventType = " + i);
    Activity localActivity = ski.a(this.this$0);
    ski localski = this.this$0;
    WSDownloadParams localWSDownloadParams = ski.a(this.this$0);
    if (i != 1) {}
    for (;;)
    {
      skq.a(localActivity, localski, localWSDownloadParams, bool, i);
      if (this.val$listenerWrapper == null) {
        break;
      }
      this.val$listenerWrapper.onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
      bool = false;
    }
    sne.d("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    sne.a("RockDownloader", "rockdownload onDownloadFinish");
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    sne.a("RockDownloader", "rockdownload onDownloadProceedOn,process" + paramInt);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skq.b();
    sne.b("RockDownloader", "rockdownload onDownloadStart,eventType = " + i);
    skq.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skq.b();
    sne.c("RockDownloader", "rockdownload onDownloadSuccess,eventType = " + i);
    skq.a();
    sms.a(1);
    WSPublicAccReport.getInstance().reportDownload(skq.a(), i, 2, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    sne.c("RockDownloader", "rockdownload onDownloadSuccess,but preload need not call install. eventType = " + i);
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    sne.c("RockDownloader", "rockdownload onDownloadWait");
    skq.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skq.b();
    sne.b("RockDownloader", "rockdownload onPermissionDeny");
    skq.a();
    WSPublicAccReport.getInstance().reportDownload(skq.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    sne.b("RockDownloader", "rockdownload onPermissionPermit");
    skq.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */