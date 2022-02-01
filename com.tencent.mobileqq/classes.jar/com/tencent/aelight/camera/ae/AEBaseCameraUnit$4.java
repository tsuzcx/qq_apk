package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;

class AEBaseCameraUnit$4
  implements CameraProxy.PictureCallback
{
  AEBaseCameraUnit$4(AEBaseCameraUnit paramAEBaseCameraUnit) {}
  
  public void a(String paramString)
  {
    paramString = new AEPhotoCaptureResult(1, 0, paramString, null, this.a.a.getEffectOrientation());
    this.a.onPhotoCaptured(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEBaseCameraUnit.4
 * JD-Core Version:    0.7.0.1
 */