package com.tencent.liteav.basic.opengl;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class h$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  h$1(h paramh) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    h.a(this.a, 103, new h.1.1(this));
    paramSurfaceTexture.setOnFrameAvailableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.h.1
 * JD-Core Version:    0.7.0.1
 */