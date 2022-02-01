package com.tencent.aelight.camera.ae.camera.core;

import android.graphics.PointF;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

class AECameraGLSurfaceView$40
  implements Runnable
{
  AECameraGLSurfaceView$40(AECameraGLSurfaceView paramAECameraGLSurfaceView, AEFilterProcessTex paramAEFilterProcessTex, float paramFloat1, float paramFloat2, int paramInt) {}
  
  public void run()
  {
    this.val$aeFilterProcessTex.a(new PointF(this.val$x, this.val$y), this.val$screenWidth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.40
 * JD-Core Version:    0.7.0.1
 */