package com.tencent.mobileqq.armap;

class ARGLSurfaceView$15
  implements Runnable
{
  ARGLSurfaceView$15(ARGLSurfaceView paramARGLSurfaceView, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    this.this$0.native_updateSensor(this.this$0.mEngineHandler, this.val$azimuth, this.val$pitch, this.val$roll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.15
 * JD-Core Version:    0.7.0.1
 */