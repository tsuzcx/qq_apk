package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;

class AEBaseCameraUnit$2
  implements AECameraManager.CameraOpenCallback
{
  AEBaseCameraUnit$2(AEBaseCameraUnit paramAEBaseCameraUnit) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.h.onChangeCamera(paramInt);
      if (this.a.h()) {
        CameraHelper.a(paramInt);
      }
      this.a.g();
      this.a.A();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEBaseCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */