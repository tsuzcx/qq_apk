package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

class AECameraGLSurfaceView$24
  implements Runnable
{
  AECameraGLSurfaceView$24(AECameraGLSurfaceView paramAECameraGLSurfaceView, int paramInt) {}
  
  public void run()
  {
    AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0);
    if (localAEFilterProcessTex != null) {
      localAEFilterProcessTex.a(this.val$level);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.24
 * JD-Core Version:    0.7.0.1
 */