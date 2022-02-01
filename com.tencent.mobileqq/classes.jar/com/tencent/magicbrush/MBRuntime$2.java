package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.gi.c.c;

class MBRuntime$2
  implements Runnable
{
  MBRuntime$2(MBRuntime paramMBRuntime, int paramInt, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    if (this.c.a == 0L) {
      return;
    }
    Object localObject = this.c;
    ((MBRuntime)localObject).nativeNotifyWindowDestroyed(((MBRuntime)localObject).a, this.a);
    localObject = this.b;
    if (localObject == null)
    {
      c.c.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not release. maybe released by other module", new Object[0]);
      return;
    }
    ((SurfaceTexture)localObject).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.2
 * JD-Core Version:    0.7.0.1
 */