package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.gi.c.c;

class MBRuntime$10
  implements Runnable
{
  MBRuntime$10(MBRuntime paramMBRuntime, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a == null)
    {
      c.c.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowAvailable. maybe released by other module", new Object[0]);
      return;
    }
    MBRuntime localMBRuntime = this.f;
    localMBRuntime.nativeNotifyWindowAvailable(localMBRuntime.a, this.b, this.a, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.10
 * JD-Core Version:    0.7.0.1
 */