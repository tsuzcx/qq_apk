package com.tencent.liteav.basic.c;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class f$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  f$1(f paramf) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    f.a(this.a, 103, new f.1.1(this));
    paramSurfaceTexture.setOnFrameAvailableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.f.1
 * JD-Core Version:    0.7.0.1
 */