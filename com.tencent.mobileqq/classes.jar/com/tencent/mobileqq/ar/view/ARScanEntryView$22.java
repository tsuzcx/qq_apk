package com.tencent.mobileqq.ar.view;

import apdk;
import apfk;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$22
  implements Runnable
{
  ARScanEntryView$22(ARScanEntryView paramARScanEntryView, apfk paramapfk) {}
  
  public void run()
  {
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.g(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if (((!apdk.a().a()) || (apdk.a().b())) && (!this.a.a.a()) && (!this.a.a.b()))
    {
      apdk.a().b();
      apdk.a().d();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
      return;
    }
    if (this.a.a.a())
    {
      apdk.a().c();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.22
 * JD-Core Version:    0.7.0.1
 */