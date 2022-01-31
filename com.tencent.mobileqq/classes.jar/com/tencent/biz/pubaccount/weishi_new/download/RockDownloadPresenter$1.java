package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import skf;
import skn;
import smp;
import snb;

public class RockDownloadPresenter$1
  extends RockDownloadListener
{
  public RockDownloadPresenter$1(skf paramskf, RockDownloadListenerWrapper paramRockDownloadListenerWrapper) {}
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skn.b();
    snb.a("RockDownloader", "rockdownload onDownloadCancel");
    skn.a();
    WSPublicAccReport.getInstance().reportDownload(skn.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    boolean bool = true;
    skn.a();
    snb.d("RockDownloader", "onDownloadFail errorCode: " + paramInt + ",errorInfo:" + paramString + ",    " + paramRockDownloadInfo.toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = skn.b();
    WSPublicAccReport.getInstance().reportDownload(skn.a(), i, 3, 1, 0);
    snb.d("RockDownloader", "Rock下载失败，QQ下载兜底！,eventType = " + i);
    Activity localActivity = skf.a(this.this$0);
    skf localskf = this.this$0;
    WSDownloadParams localWSDownloadParams = skf.a(this.this$0);
    if (i != 1) {}
    for (;;)
    {
      skn.a(localActivity, localskf, localWSDownloadParams, bool, i);
      if (this.val$listenerWrapper == null) {
        break;
      }
      this.val$listenerWrapper.onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
      bool = false;
    }
    snb.d("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    snb.a("RockDownloader", "rockdownload onDownloadFinish");
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    snb.a("RockDownloader", "rockdownload onDownloadProceedOn,process" + paramInt);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skn.b();
    snb.b("RockDownloader", "rockdownload onDownloadStart,eventType = " + i);
    skn.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skn.b();
    snb.c("RockDownloader", "rockdownload onDownloadSuccess,eventType = " + i);
    skn.a();
    smp.a(1);
    WSPublicAccReport.getInstance().reportDownload(skn.a(), i, 2, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    snb.c("RockDownloader", "rockdownload onDownloadSuccess,but preload need not call install. eventType = " + i);
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    snb.c("RockDownloader", "rockdownload onDownloadWait");
    skn.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = skn.b();
    snb.b("RockDownloader", "rockdownload onPermissionDeny");
    skn.a();
    WSPublicAccReport.getInstance().reportDownload(skn.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    snb.b("RockDownloader", "rockdownload onPermissionPermit");
    skn.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */