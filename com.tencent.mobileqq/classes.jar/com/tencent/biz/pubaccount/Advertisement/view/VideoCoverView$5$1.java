package com.tencent.biz.pubaccount.Advertisement.view;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

class VideoCoverView$5$1
  implements TVK_SDKMgr.InstallListener
{
  VideoCoverView$5$1(VideoCoverView.5 param5) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("installSDK onInstalledFailed arg0=");
    localStringBuilder.append(paramInt);
    QLog.i("VideoCoverView", 1, localStringBuilder.toString());
    this.a.this$0.d = false;
  }
  
  public void onInstalledSuccessed()
  {
    QLog.i("VideoCoverView", 1, "installSDK onInstalledSuccessed");
    this.a.this$0.d = true;
    ThreadManager.getUIHandler().post(new VideoCoverView.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.5.1
 * JD-Core Version:    0.7.0.1
 */