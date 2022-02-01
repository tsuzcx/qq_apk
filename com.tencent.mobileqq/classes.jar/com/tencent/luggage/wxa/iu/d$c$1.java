package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;

class d$c$1
  implements Runnable
{
  d$c$1(d.c paramc) {}
  
  public void run()
  {
    if (!d.c.a(this.a))
    {
      d.a(this.a.a, null);
      d.c(this.a.a);
      return;
    }
    o.b("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), this.a.a.aa() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.c.1
 * JD-Core Version:    0.7.0.1
 */