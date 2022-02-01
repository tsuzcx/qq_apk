package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.data.RockDownloadInfo;
import mqq.util.WeakReference;
import ugz;
import unx;
import uqf;

class RockDownloadPresenter$1
  extends RockDownloadPresenter.MyRockDownloadListener
{
  RockDownloadPresenter$1(RockDownloadPresenter paramRockDownloadPresenter1, RockDownloadPresenter paramRockDownloadPresenter2, WeakReference paramWeakReference, Activity paramActivity)
  {
    super(paramRockDownloadPresenter2);
  }
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = ugz.b();
    uqf.a("RockDownloader", "rockdownload onDownloadCancel");
    ugz.a();
    WSPublicAccReport.getInstance().reportDownload(ugz.a(), i, 3, 1, 0);
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    boolean bool = true;
    ugz.a();
    uqf.d("RockDownloader", "onDownloadFail errorCode: " + paramInt + ",errorInfo:" + paramString + ",    " + paramRockDownloadInfo.toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = ugz.b();
    WSPublicAccReport.getInstance().reportDownload(ugz.a(), i, 3, 1, 0);
    uqf.d("RockDownloader", "Rock下载失败，QQ下载兜底！,eventType = " + i);
    Object localObject = this.val$activity;
    RockDownloadPresenter localRockDownloadPresenter = this.this$0;
    WSDownloadParams localWSDownloadParams = RockDownloadPresenter.a(this.this$0);
    if (i != 1) {}
    for (;;)
    {
      ugz.a((Activity)localObject, localRockDownloadPresenter, localWSDownloadParams, bool, i);
      localObject = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
      if (localObject == null) {
        break;
      }
      ((RockDownloadListenerWrapper)localObject).onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
      bool = false;
    }
    uqf.d("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    uqf.a("RockDownloader", "rockdownload onDownloadFinish");
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    uqf.a("RockDownloader", "rockdownload onDownloadProceedOn,process" + paramInt);
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = ugz.b();
    uqf.b("RockDownloader", "rockdownload onDownloadStart,eventType = " + i);
    ugz.b();
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = ugz.b();
    uqf.c("RockDownloader", "rockdownload onDownloadSuccess,eventType = " + i);
    ugz.a();
    unx.a(1);
    WSPublicAccReport.getInstance().reportDownload(ugz.a(), i, 2, 1, 0);
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    uqf.c("RockDownloader", "rockdownload onDownloadSuccess,but preload need not call install. eventType = " + i);
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    uqf.c("RockDownloader", "rockdownload onDownloadWait");
    ugz.b();
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = ugz.b();
    uqf.b("RockDownloader", "rockdownload onPermissionDeny");
    ugz.a();
    WSPublicAccReport.getInstance().reportDownload(ugz.a(), i, 3, 1, 0);
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    uqf.b("RockDownloader", "rockdownload onPermissionPermit");
    ugz.b();
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */