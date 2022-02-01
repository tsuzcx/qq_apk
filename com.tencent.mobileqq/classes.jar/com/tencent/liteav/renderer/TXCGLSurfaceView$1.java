package com.tencent.liteav.renderer;

class TXCGLSurfaceView$1
  implements Runnable
{
  TXCGLSurfaceView$1(TXCGLSurfaceView paramTXCGLSurfaceView, int paramInt) {}
  
  public void run()
  {
    TXCGLSurfaceView.a(this.b, this.a);
    if (TXCGLSurfaceView.a(this.b) <= 0) {
      TXCGLSurfaceView.a(this.b, 1);
    } else if (TXCGLSurfaceView.a(this.b) > 60) {
      TXCGLSurfaceView.a(this.b, 60);
    }
    TXCGLSurfaceView.a(this.b, 0L);
    TXCGLSurfaceView.b(this.b, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */