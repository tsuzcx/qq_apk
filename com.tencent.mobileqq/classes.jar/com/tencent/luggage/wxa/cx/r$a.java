package com.tencent.luggage.wxa.cx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.nl.a.a;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.h;
import java.util.concurrent.CountDownLatch;

class r$a
  extends com.tencent.luggage.wxa.nl.a
{
  r$a(r paramr, @NonNull com.tencent.luggage.wxa.nn.a parama, @Nullable a.a parama1)
  {
    super(parama, parama1);
  }
  
  private <Func extends com.tencent.luggage.wxa.rl.b<p, p>> boolean a(Func paramFunc)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    i locali = new i();
    h.a(new p(this.a.a)).b(paramFunc).a(com.tencent.luggage.wxa.rp.d.b, new r.a.2(this, locali, localCountDownLatch)).a(com.tencent.luggage.wxa.rp.d.b, new r.a.1(this, locali, localCountDownLatch));
    boolean bool = false;
    try
    {
      localCountDownLatch.await();
      if (!(locali.a instanceof com.tencent.luggage.wxa.cy.a))
      {
        if (!(locali.a instanceof com.tencent.luggage.wxa.cy.b))
        {
          if (!(locali.a instanceof p)) {
            bool = true;
          }
          return bool;
        }
        throw ((com.tencent.luggage.wxa.cy.b)locali.a);
      }
      throw ((com.tencent.luggage.wxa.cy.a)locali.a);
    }
    catch (InterruptedException paramFunc)
    {
      o.b("Luggage.Standalone.WxaLaunchPreconditionProcess", "checkBanDemoPermission with appId[%s] await failed e=%s", new Object[] { this.e, paramFunc });
    }
    return true;
  }
  
  private boolean c()
  {
    if (this.c == 2) {
      return a(new a(this.e));
    }
    if (this.c == 1)
    {
      if ((r.a(this.a).f != null) && (r.a(this.a).f.c == 1011)) {
        return false;
      }
      return a(new b(this.e));
    }
    return false;
  }
  
  protected boolean a(@NonNull s params)
  {
    return (super.a(params)) || (c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.a
 * JD-Core Version:    0.7.0.1
 */