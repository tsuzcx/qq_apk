package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.testpkg.IProxyForTestCap;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator.CameraFocusParams;

class AECameraManager$8
  implements Runnable
{
  AECameraManager$8(AECameraManager paramAECameraManager, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (AECameraManager.access$1000(this.this$0) == null) {
      return;
    }
    FocusOperator.CameraFocusParams localCameraFocusParams = new FocusOperator.CameraFocusParams();
    localCameraFocusParams.a = this.val$x;
    localCameraFocusParams.b = this.val$y;
    localCameraFocusParams.c = this.val$surfaceWidth;
    localCameraFocusParams.d = this.val$surfaceHeight;
    localCameraFocusParams.e = CaptureUtil.c(AECameraManager.access$900(this.this$0));
    AECameraManager.access$700(this.this$0).a(AECameraManager.access$1100(this.this$0), new AECameraManager.8.1(this), localCameraFocusParams.e, localCameraFocusParams.c, localCameraFocusParams.d, localCameraFocusParams.a, localCameraFocusParams.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */