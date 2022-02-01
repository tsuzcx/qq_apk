package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;

class AECameraGLSurfaceView$9
  implements Runnable
{
  AECameraGLSurfaceView$9(AECameraGLSurfaceView paramAECameraGLSurfaceView, AEVideoCaptureResult paramAEVideoCaptureResult) {}
  
  public void run()
  {
    this.this$0.captureListener.onVideoCaptured(this.val$videoCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.9
 * JD-Core Version:    0.7.0.1
 */