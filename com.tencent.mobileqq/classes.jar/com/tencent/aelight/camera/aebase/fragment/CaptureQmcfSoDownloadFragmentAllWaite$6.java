package com.tencent.aelight.camera.aebase.fragment;

import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$6
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$6(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, int paramInt) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadProgress mGestureState=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragmentAllWaite.c(this.this$0));
      localStringBuilder.append(" mVideoState=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragmentAllWaite.f(this.this$0));
      localStringBuilder.append(",mFilterSoState=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragmentAllWaite.h(this.this$0));
      localStringBuilder.append(",mQmcfState=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragmentAllWaite.i(this.this$0));
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, localStringBuilder.toString());
    }
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite.6
 * JD-Core Version:    0.7.0.1
 */