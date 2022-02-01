package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class a$b$2
  implements SurfaceTexture.OnFrameAvailableListener
{
  a$b$2(a.b paramb) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.a.n.a(104, new a.b.2.1(this));
    paramSurfaceTexture.setOnFrameAvailableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.b.2
 * JD-Core Version:    0.7.0.1
 */