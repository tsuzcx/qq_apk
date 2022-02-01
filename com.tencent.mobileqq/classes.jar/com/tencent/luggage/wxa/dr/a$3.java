package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.u;

class a$3
  implements Runnable
{
  a$3(a parama, i parami, LockStepNative.ILockStepListener paramILockStepListener, LockStepNative.ILockStepReportListener paramILockStepReportListener) {}
  
  public void run()
  {
    o.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ");
    if (this.d.a != null)
    {
      o.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding lockStepNative != null");
      return;
    }
    u localu = (u)this.a.a(u.class);
    if (localu == null)
    {
      o.b("Luggage.LockStepNativeInstallHelper", "createLockStepBinding v8Addon is null");
      return;
    }
    if (a.a(this.d)) {
      this.d.a = new LockStepNative(localu.k(), localu.j(), localu.i());
    } else {
      this.d.a = new LockStepNative(localu.k(), localu.j(), 0L);
    }
    o.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ret:%d", new Object[] { Integer.valueOf(this.d.a.setCallback(this.b, this.c)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a.3
 * JD-Core Version:    0.7.0.1
 */