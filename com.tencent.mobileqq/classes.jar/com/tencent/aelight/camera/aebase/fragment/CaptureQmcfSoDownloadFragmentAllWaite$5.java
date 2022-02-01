package com.tencent.aelight.camera.aebase.fragment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragmentAllWaite$5
  implements Runnable
{
  CaptureQmcfSoDownloadFragmentAllWaite$5(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStatusChanged: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" error:");
      localStringBuilder.append(this.b);
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, localStringBuilder.toString());
    }
    if (!this.a)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131915837, 0).show();
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, -1);
      return;
    }
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, 101);
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.this$0, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragmentAllWaite.5
 * JD-Core Version:    0.7.0.1
 */