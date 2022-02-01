package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.game.liblockstep.LockStepNative;

class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, String paramString, long paramLong) {}
  
  public void run()
  {
    o.e("Luggage.LockStepNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,locksteplogicId:%d", new Object[] { this.a, Long.valueOf(this.b) });
    this.c.b.a.updateNativeInterface(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a.1.1
 * JD-Core Version:    0.7.0.1
 */