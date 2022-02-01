package com.tencent.aelight.camera.aebase.fragment;

import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$2
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$2(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0))
    {
      CaptureQmcfSoDownloadFragmentAllWaite.d(this.this$0).setProgress((CaptureQmcfSoDownloadFragmentAllWaite.b(this.this$0) + CaptureQmcfSoDownloadFragmentAllWaite.c(this.this$0)) / 2);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" setProgress=");
        localStringBuilder.append((CaptureQmcfSoDownloadFragmentAllWaite.b(this.this$0) + CaptureQmcfSoDownloadFragmentAllWaite.c(this.this$0)) / 2);
        QLog.d("CaptureSoDownloadFragmentAllWaite", 2, localStringBuilder.toString());
      }
      CaptureQmcfSoDownloadFragmentAllWaite.e(this.this$0);
      return;
    }
    CaptureQmcfSoDownloadFragmentAllWaite.d(this.this$0).setProgress(CaptureQmcfSoDownloadFragmentAllWaite.b(this.this$0));
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" setProgress=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragmentAllWaite.f(this.this$0));
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite.2
 * JD-Core Version:    0.7.0.1
 */