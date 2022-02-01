package com.tencent.luggage.wxa.fy;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.luggage.wxa.qz.o;

class d$4
  implements SurfaceTexture.OnFrameAvailableListener
{
  d$4(d paramd, Runnable paramRunnable, q paramq) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    o.d(this.c.a, "scheduleAfterTransferFromTask, onFrameAvailable");
    this.a.run();
    this.b.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.d.4
 * JD-Core Version:    0.7.0.1
 */