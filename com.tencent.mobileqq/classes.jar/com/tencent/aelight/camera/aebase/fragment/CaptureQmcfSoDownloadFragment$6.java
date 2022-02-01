package com.tencent.aelight.camera.aebase.fragment;

import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$6
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$6(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, int paramInt) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragment.a(this.this$0, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadProgress mGestureState=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragment.c(this.this$0));
      localStringBuilder.append(" mVideoState=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragment.f(this.this$0));
      QLog.d("CaptureQmcfSoDownloadFragment", 2, localStringBuilder.toString());
    }
    CaptureQmcfSoDownloadFragment.a(this.this$0, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.6
 * JD-Core Version:    0.7.0.1
 */