package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;

class TXCGLSurfaceView$4
  implements Runnable
{
  TXCGLSurfaceView$4(TXCGLSurfaceView paramTXCGLSurfaceView) {}
  
  public void run()
  {
    try
    {
      TXCLog.i("TXCGLSurfaceView", "background capture exit background");
      this.a.c = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */