package com.tencent.aelight.camera.ae.flashshow;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture.CameraSwitchGestureListener;

class AEFlashShowCameraUnit$4
  implements CameraSwitchGesture.CameraSwitchGestureListener
{
  AEFlashShowCameraUnit$4(AEFlashShowCameraUnit paramAEFlashShowCameraUnit) {}
  
  public void a()
  {
    if (AEFlashShowCameraUnit.e(this.a))
    {
      AEQLog.b(AEFlashShowCameraUnit.f(this.a), "cut down status can not toggle camera");
      return;
    }
    this.a.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */