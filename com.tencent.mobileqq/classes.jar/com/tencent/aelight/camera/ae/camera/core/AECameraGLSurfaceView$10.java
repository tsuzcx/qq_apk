package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;

class AECameraGLSurfaceView$10
  implements Runnable
{
  AECameraGLSurfaceView$10(AECameraGLSurfaceView paramAECameraGLSurfaceView, AEVideoCaptureResult paramAEVideoCaptureResult) {}
  
  public void run()
  {
    this.this$0.captureListener.onVideoCaptured(this.val$videoCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.10
 * JD-Core Version:    0.7.0.1
 */