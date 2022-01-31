package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import rxm;
import rxu;
import rzw;
import sai;

public class RockDownloadPresenter$1
  extends RockDownloadListener
{
  public RockDownloadPresenter$1(rxm paramrxm, RockDownloadListenerWrapper paramRockDownloadListenerWrapper) {}
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = rxu.b();
    sai.a("RockDownloader", "rockdownload onDownloadCancel");
    rxu.a();
    WSPublicAccReport.getInstance().reportDownload(rxu.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    boolean bool = true;
    rxu.a();
    sai.d("RockDownloader", "onDownloadFail errorCode: " + paramInt + ",errorInfo:" + paramString + ",    " + paramRockDownloadInfo.toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = rxu.b();
    WSPublicAccReport.getInstance().reportDownload(rxu.a(), i, 3, 1, 0);
    sai.d("RockDownloader", "Rock下载失败，QQ下载兜底！,eventType = " + i);
    Activity localActivity = rxm.a(this.this$0);
    rxm localrxm = this.this$0;
    WSDownloadParams localWSDownloadParams = rxm.a(this.this$0);
    if (i != 1) {}
    for (;;)
    {
      rxu.a(localActivity, localrxm, localWSDownloadParams, bool, i);
      if (this.val$listenerWrapper == null) {
        break;
      }
      this.val$listenerWrapper.onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
      bool = false;
    }
    sai.d("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    sai.a("RockDownloader", "rockdownload onDownloadFinish");
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    sai.a("RockDownloader", "rockdownload onDownloadProceedOn,process" + paramInt);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = rxu.b();
    sai.b("RockDownloader", "rockdownload onDownloadStart,eventType = " + i);
    rxu.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = rxu.b();
    sai.c("RockDownloader", "rockdownload onDownloadSuccess,eventType = " + i);
    rxu.a();
    rzw.a(1);
    WSPublicAccReport.getInstance().reportDownload(rxu.a(), i, 2, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    sai.c("RockDownloader", "rockdownload onDownloadSuccess,but preload need not call install. eventType = " + i);
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    sai.c("RockDownloader", "rockdownload onDownloadWait");
    rxu.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = rxu.b();
    sai.b("RockDownloader", "rockdownload onPermissionDeny");
    rxu.a();
    WSPublicAccReport.getInstance().reportDownload(rxu.a(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    sai.b("RockDownloader", "rockdownload onPermissionPermit");
    rxu.b();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */