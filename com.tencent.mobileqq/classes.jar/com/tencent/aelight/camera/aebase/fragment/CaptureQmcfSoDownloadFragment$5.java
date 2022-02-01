package com.tencent.aelight.camera.aebase.fragment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CaptureQmcfSoDownloadFragment$5
  implements Runnable
{
  CaptureQmcfSoDownloadFragment$5(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStatusChanged: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" error:");
      localStringBuilder.append(this.b);
      QLog.d("CaptureQmcfSoDownloadFragment", 2, localStringBuilder.toString());
    }
    if (!this.a)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131915837, 0).show();
      CaptureQmcfSoDownloadFragment.a(this.this$0, -1);
      return;
    }
    CaptureQmcfSoDownloadFragment.a(this.this$0, 101);
    CaptureQmcfSoDownloadFragment.a(this.this$0, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.5
 * JD-Core Version:    0.7.0.1
 */