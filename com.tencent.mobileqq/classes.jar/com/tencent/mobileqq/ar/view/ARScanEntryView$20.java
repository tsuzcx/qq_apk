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
    ARScanEntryView.m(this.this$0);
    ARScanEntryView.n(this.this$0);
    ARScanEntryView.t(this.this$0);
    ARScanEntryView.c(this.this$0, false);
    if (((!ARVideoRecordUIControllerImpl.a().g()) || (ARVideoRecordUIControllerImpl.a().h())) && (!this.a.a.a()) && (!this.a.a.b()))
    {
      ARVideoRecordUIControllerImpl.a().d();
      ARVideoRecordUIControllerImpl.a().f();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
      return;
    }
    if (this.a.a.a())
    {
      ARVideoRecordUIControllerImpl.a().e();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.20
 * JD-Core Version:    0.7.0.1
 */