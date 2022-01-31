package com.tencent.mobileqq.armap;

class ARGLSurfaceView$6
  implements Runnable
{
  ARGLSurfaceView$6(ARGLSurfaceView paramARGLSurfaceView) {}
  
  public void run()
  {
    if (this.this$0.mEngineHandler != 0L)
    {
      ARGLSurfaceView.access$200(this.this$0, this.this$0.mEngineHandler);
      this.this$0.mEngineHandler = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */