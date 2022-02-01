package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;

class AEPituCameraUnit$47
  implements AECameraManager.CameraOpenCallback
{
  AEPituCameraUnit$47(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.h()) {
        CameraHelper.a(paramInt);
      }
      if (this.a.A)
      {
        this.a.A();
        return;
      }
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.47
 * JD-Core Version:    0.7.0.1
 */