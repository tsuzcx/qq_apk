package com.tencent.magicbrush;

import android.view.Surface;
import com.tencent.luggage.wxa.gi.c.c;

class MBRuntime$15
  implements Runnable
{
  MBRuntime$15(MBRuntime paramMBRuntime, Surface paramSurface, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (this.a == null)
    {
      c.c.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
      return;
    }
    MBRuntime localMBRuntime = this.e;
    localMBRuntime.nativeNotifyWindowChangedForSurface(localMBRuntime.a, this.b, this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.15
 * JD-Core Version:    0.7.0.1
 */