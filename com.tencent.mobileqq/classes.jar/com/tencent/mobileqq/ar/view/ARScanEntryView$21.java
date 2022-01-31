package com.tencent.mobileqq.ar.view;

import amup;
import amwo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$21
  implements Runnable
{
  ARScanEntryView$21(ARScanEntryView paramARScanEntryView, amwo paramamwo) {}
  
  public void run()
  {
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.g(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if (((!amup.a().a()) || (amup.a().b())) && (!this.a.a.a()) && (!this.a.a.b()))
    {
      amup.a().b();
      amup.a().d();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
      return;
    }
    if (this.a.a.a())
    {
      amup.a().c();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.21
 * JD-Core Version:    0.7.0.1
 */