package com.tencent.luggage.wxa.fy;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.Future;

class d$2
  implements SurfaceTexture.OnFrameAvailableListener
{
  d$2(d paramd, Future paramFuture, Runnable paramRunnable, q paramq) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    o.d(this.d.a, "scheduleAfterTransferToTask, onFrameAvailable");
    this.a.cancel(true);
    this.b.run();
    this.c.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.d.2
 * JD-Core Version:    0.7.0.1
 */