package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class r$2$2
  implements Runnable
{
  r$2$2(r.2 param2, com.tencent.luggage.wxa.nl.a parama, com.tencent.luggage.wxa.ro.b paramb) {}
  
  public void run()
  {
    try
    {
      try
      {
        this.a.run();
        return;
      }
      catch (com.tencent.luggage.wxa.cy.b localb) {}catch (com.tencent.luggage.wxa.cy.a locala) {}
      this.b.a(locala);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (af.b(localIllegalStateException.getMessage()).contains("attempt to re-open an already-closed object"))
      {
        o.a("Luggage.Standalone.WxaLaunchPreconditionProcess", localIllegalStateException, "prepare initConfig with appId[%s]", new Object[] { r.a(this.c.a).b });
        this.b.a(localIllegalStateException);
        t.a.a(this.c.a.a, t.d.b, t.c.d, localIllegalStateException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.2.2
 * JD-Core Version:    0.7.0.1
 */