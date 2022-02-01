package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rm.a;

class d$c
  implements d.a, a
{
  private final String b = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
  private volatile boolean c;
  
  private d$c(d paramd)
  {
    o.d("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", new Object[] { this.a.aa(), Integer.valueOf(hashCode()) });
    this.a.a(this);
    this.c = false;
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public void u_()
  {
    if (!this.c)
    {
      d.c.1 local1 = new d.c.1(this);
      this.a.d(local1);
      return;
    }
    o.b("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", new Object[] { Integer.valueOf(hashCode()), this.a.aa() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.c
 * JD-Core Version:    0.7.0.1
 */