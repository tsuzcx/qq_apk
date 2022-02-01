package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.lx.f;
import com.tencent.luggage.wxa.lx.f.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import java.lang.ref.WeakReference;

public class a
{
  protected LockStepNative a;
  private String b = null;
  private boolean c = true;
  private final a.a d = new a.a(this, new a.5(this));
  
  public static int a()
  {
    try
    {
      f.c localc1 = f.a(r.a());
      o.d("Luggage.LockStepNativeInstallHelper", "networkType = %s", new Object[] { localc1.h });
      o.d("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(x.d(r.a())) });
      if (localc1 == f.c.a) {
        return -1;
      }
      if (localc1 == f.c.b) {
        return 2;
      }
      if (localc1 == f.c.c) {
        return 3;
      }
      if (localc1 == f.c.d) {
        return 4;
      }
      if (localc1 == f.c.e) {
        return 5;
      }
      f.c localc2 = f.c.f;
      if (localc1 == localc2) {
        return 1;
      }
      return 0;
    }
    catch (Exception localException)
    {
      o.a("Luggage.LockStepNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
    }
    return -1;
  }
  
  public void a(i parami)
  {
    o.d("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
    if (parami == null)
    {
      o.b("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
      return;
    }
    ((m)parami.a(m.class)).a(this.d);
  }
  
  public void a(i parami, c paramc)
  {
    o.d("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
    if (parami == null)
    {
      o.b("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
      return;
    }
    parami = (q)parami.a(q.class);
    if (parami == null)
    {
      o.b("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      return;
    }
    parami.a(new a.4(this, paramc));
  }
  
  public void a(i parami, c paramc, int paramInt)
  {
    o.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (parami == null)
    {
      o.b("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
      return;
    }
    this.b = String.valueOf(paramInt);
    com.tencent.luggage.wxa.hi.a.a();
    q localq = (q)parami.a(q.class);
    if (localq == null)
    {
      o.b("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      return;
    }
    paramc = (b)paramc.a(b.class);
    if (paramc != null)
    {
      this.c = paramc.a();
      o.d("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.c) });
    }
    localq.a(new a.3(this, parami, new a.1(this, new WeakReference(localq)), new a.2(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a
 * JD-Core Version:    0.7.0.1
 */