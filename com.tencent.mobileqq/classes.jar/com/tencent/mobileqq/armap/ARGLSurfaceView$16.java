package com.tencent.mobileqq.armap;

class ARGLSurfaceView$16
  implements Runnable
{
  ARGLSurfaceView$16(ARGLSurfaceView paramARGLSurfaceView, float paramFloat) {}
  
  public void run()
  {
    ARGLSurfaceView localARGLSurfaceView = this.this$0;
    localARGLSurfaceView.native_updateAzimuth(localARGLSurfaceView.mEngineHandler, this.val$azimuth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.16
 * JD-Core Version:    0.7.0.1
 */