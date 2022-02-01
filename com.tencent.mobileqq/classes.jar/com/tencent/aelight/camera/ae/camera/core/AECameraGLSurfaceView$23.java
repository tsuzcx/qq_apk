package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase;

class AECameraGLSurfaceView$23
  implements Runnable
{
  AECameraGLSurfaceView$23(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void run()
  {
    if (AECameraGLSurfaceView.access$000(this.this$0) != null) {
      AECameraGLSurfaceView.access$000(this.this$0).a(true, AECameraGLSurfaceView.access$1000(this.this$0), this.this$0);
    }
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.23
 * JD-Core Version:    0.7.0.1
 */