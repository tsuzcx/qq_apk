package com.tencent.aelight.camera.aebase.fragment;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$3
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$3(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0).setText(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTipsTextData: textData=");
      localStringBuilder.append(this.a);
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite.3
 * JD-Core Version:    0.7.0.1
 */