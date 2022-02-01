package com.tencent.aelight.camera.aebase.fragment;

import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$2
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$2(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (CaptureQmcfSoDownloadFragment.a(this.this$0))
    {
      CaptureQmcfSoDownloadFragment.d(this.this$0).setProgress((CaptureQmcfSoDownloadFragment.b(this.this$0) + CaptureQmcfSoDownloadFragment.c(this.this$0)) / 2);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" setProgress=");
        localStringBuilder.append((CaptureQmcfSoDownloadFragment.b(this.this$0) + CaptureQmcfSoDownloadFragment.c(this.this$0)) / 2);
        QLog.d("CaptureQmcfSoDownloadFragment", 2, localStringBuilder.toString());
      }
      CaptureQmcfSoDownloadFragment.e(this.this$0);
      return;
    }
    CaptureQmcfSoDownloadFragment.d(this.this$0).setProgress(CaptureQmcfSoDownloadFragment.b(this.this$0));
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" setProgress=");
      localStringBuilder.append(CaptureQmcfSoDownloadFragment.f(this.this$0));
      QLog.d("CaptureQmcfSoDownloadFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.2
 * JD-Core Version:    0.7.0.1
 */