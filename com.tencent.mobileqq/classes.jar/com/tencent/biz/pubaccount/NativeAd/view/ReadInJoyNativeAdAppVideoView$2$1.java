package com.tencent.biz.pubaccount.NativeAd.view;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ReadInJoyNativeAdAppVideoView$2$1
  implements TVK_SDKMgr.InstallListener
{
  ReadInJoyNativeAdAppVideoView$2$1(ReadInJoyNativeAdAppVideoView.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "install sdk failed");
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "install sdk success");
    }
    ReadInJoyNativeAdAppVideoView.a(this.a.this$0).post(new ReadInJoyNativeAdAppVideoView.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.2.1
 * JD-Core Version:    0.7.0.1
 */