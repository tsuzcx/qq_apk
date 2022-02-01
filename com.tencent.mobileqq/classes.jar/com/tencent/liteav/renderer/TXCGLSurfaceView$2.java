package com.tencent.liteav.renderer;

import android.opengl.GLES20;

class TXCGLSurfaceView$2
  implements Runnable
{
  TXCGLSurfaceView$2(TXCGLSurfaceView paramTXCGLSurfaceView, int paramInt) {}
  
  public void run()
  {
    TXCGLSurfaceView.b(this.b, this.a);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */