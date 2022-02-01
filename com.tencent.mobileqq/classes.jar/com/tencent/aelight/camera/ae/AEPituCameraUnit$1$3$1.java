package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$1$3$1
  implements AECameraManager.CameraOpenCallback
{
  AEPituCameraUnit$1$3$1(AEPituCameraUnit.1.3 param3) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    AEQLog.b(this.a.a.a.a, "onRetryOpenCamera post| tryStartPreview.");
    this.a.a.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.1.3.1
 * JD-Core Version:    0.7.0.1
 */