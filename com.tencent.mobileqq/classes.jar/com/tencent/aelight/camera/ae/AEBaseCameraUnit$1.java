package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;

class AEBaseCameraUnit$1
  implements AECameraManager.CameraOpenCallback
{
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a.onChangeCamera(paramInt);
      if (this.a.a()) {
        CameraHelper.a(paramInt);
      }
      this.a.c();
      this.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEBaseCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */