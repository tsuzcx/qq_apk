package com.tencent.mobileqq.armap;

class ARGLSurfaceView$6
  implements Runnable
{
  ARGLSurfaceView$6(ARGLSurfaceView paramARGLSurfaceView) {}
  
  public void run()
  {
    if (this.this$0.mEngineHandler != 0L)
    {
      ARGLSurfaceView localARGLSurfaceView = this.this$0;
      ARGLSurfaceView.access$200(localARGLSurfaceView, localARGLSurfaceView.mEngineHandler);
      this.this$0.mEngineHandler = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */