package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$20
  implements Runnable
{
  ARScanEntryView$20(ARScanEntryView paramARScanEntryView, ARTarget paramARTarget) {}
  
  public void run()
  {
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.g(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if (((!ARVideoRecordUIControllerImpl.a().a()) || (ARVideoRecordUIControllerImpl.a().b())) && (!this.a.a.a()) && (!this.a.a.b()))
    {
      ARVideoRecordUIControllerImpl.a().b();
      ARVideoRecordUIControllerImpl.a().d();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
      return;
    }
    if (this.a.a.a())
    {
      ARVideoRecordUIControllerImpl.a().c();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.20
 * JD-Core Version:    0.7.0.1
 */