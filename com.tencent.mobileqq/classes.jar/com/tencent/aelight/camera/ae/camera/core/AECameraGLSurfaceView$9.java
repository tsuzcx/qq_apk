package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.testpkg.SurfaceTextureForTest.ITestListener;

class AECameraGLSurfaceView$9
  implements SurfaceTextureForTest.ITestListener
{
  AECameraGLSurfaceView$9(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public void endRecord()
  {
    this.this$0.stopCaptureTestVideo();
  }
  
  public void startRecord()
  {
    this.this$0.startCaptureTestVideo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.9
 * JD-Core Version:    0.7.0.1
 */