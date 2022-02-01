package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.data.RockDownloadInfo;
import mqq.util.WeakReference;

class RockDownloadPresenter$1
  extends RockDownloadPresenter.MyRockDownloadListener
{
  RockDownloadPresenter$1(RockDownloadPresenter paramRockDownloadPresenter1, RockDownloadPresenter paramRockDownloadPresenter2, WeakReference paramWeakReference, Activity paramActivity)
  {
    super(paramRockDownloadPresenter2);
  }
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = WeishiDownloadUtil.e();
    WSLog.a("RockDownloader", "rockdownload onDownloadCancel");
    WeishiDownloadUtil.h();
    WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), i, 3, 1, 0, RockDownloadPresenter.a(this.this$0));
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    WeishiDownloadUtil.h();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadFail errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",errorInfo:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",    ");
    ((StringBuilder)localObject).append(paramRockDownloadInfo.toString());
    WSLog.d("RockDownloader", ((StringBuilder)localObject).toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = WeishiDownloadUtil.e();
    WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), i, 3, 1, 0, RockDownloadPresenter.a(this.this$0));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Rock下载失败，QQ下载兜底！,eventType = ");
    ((StringBuilder)localObject).append(i);
    WSLog.d("RockDownloader", ((StringBuilder)localObject).toString());
    localObject = this.val$activity;
    RockDownloadPresenter localRockDownloadPresenter = this.this$0;
    WSDownloadParams localWSDownloadParams = RockDownloadPresenter.b(localRockDownloadPresenter);
    boolean bool = true;
    if (i == 1) {
      bool = false;
    }
    WeishiDownloadUtil.a((Activity)localObject, localRockDownloadPresenter, localWSDownloadParams, bool, i);
    localObject = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localObject != null)
    {
      ((RockDownloadListenerWrapper)localObject).onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
    }
    WSLog.d("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    WSLog.a("RockDownloader", "rockdownload onDownloadFinish");
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rockdownload onDownloadProceedOn,process");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.a("RockDownloader", ((StringBuilder)localObject).toString());
    localObject = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localObject != null) {
      ((RockDownloadListenerWrapper)localObject).onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = WeishiDownloadUtil.e();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rockdownload onDownloadStart,eventType = ");
    ((StringBuilder)localObject).append(i);
    WSLog.b("RockDownloader", ((StringBuilder)localObject).toString());
    WeishiDownloadUtil.i();
    localObject = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localObject != null) {
      ((RockDownloadListenerWrapper)localObject).onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = WeishiDownloadUtil.e();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rockdownload onDownloadSuccess,eventType = ");
    ((StringBuilder)localObject).append(i);
    WSLog.c("RockDownloader", ((StringBuilder)localObject).toString());
    WeishiDownloadUtil.h();
    WSReportDc00898.a(1);
    WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), i, 2, 1, 0, RockDownloadPresenter.a(this.this$0));
    localObject = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localObject != null) {
      ((RockDownloadListenerWrapper)localObject).onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    paramRockDownloadInfo = new StringBuilder();
    paramRockDownloadInfo.append("rockdownload onDownloadSuccess,but preload need not call install. eventType = ");
    paramRockDownloadInfo.append(i);
    WSLog.c("RockDownloader", paramRockDownloadInfo.toString());
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    WSLog.c("RockDownloader", "rockdownload onDownloadWait");
    WeishiDownloadUtil.i();
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = WeishiDownloadUtil.e();
    WSLog.b("RockDownloader", "rockdownload onPermissionDeny");
    WeishiDownloadUtil.h();
    WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), i, 3, 1, 0, RockDownloadPresenter.a(this.this$0));
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    WSLog.b("RockDownloader", "rockdownload onPermissionPermit");
    WeishiDownloadUtil.i();
    RockDownloadListenerWrapper localRockDownloadListenerWrapper = (RockDownloadListenerWrapper)this.val$listenerWrapperWeakReference.get();
    if (localRockDownloadListenerWrapper != null) {
      localRockDownloadListenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */