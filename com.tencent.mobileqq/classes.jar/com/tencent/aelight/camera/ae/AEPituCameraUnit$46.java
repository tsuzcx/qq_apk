package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;

class AEPituCameraUnit$46
  implements AECameraManager.CameraOpenCallback
{
  AEPituCameraUnit$46(AEPituCameraUnit paramAEPituCameraUnit, AECameraManager.CameraOpenCallback paramCameraOpenCallback) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.h.onChangeCamera(paramInt);
      if (this.b.h()) {
        CameraHelper.a(paramInt);
      }
      this.b.g();
      this.b.A();
    }
    this.a.onOpenResult(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.46
 * JD-Core Version:    0.7.0.1
 */