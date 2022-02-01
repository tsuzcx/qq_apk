package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.ExecuteDetails;
import com.eclipsesource.mmv8.V8Context;
import com.tencent.luggage.wxa.qz.o;

class n$9
  implements Runnable
{
  n$9(n paramn, String paramString1, n.b paramb, String paramString2) {}
  
  public void run()
  {
    o.e("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", new Object[] { this.a });
    Object localObject1 = this.b;
    String str = null;
    if (localObject1 != null)
    {
      localObject1 = new n.c();
      n.c.a((n.c)localObject1);
      Object localObject2 = this.d.b().executeScript(this.c, this.a, 0, (ExecuteDetails)localObject1);
      n.c.b((n.c)localObject1);
      n.b localb = this.b;
      if (localObject2 != null) {
        str = localObject2.toString();
      }
      localb.a(str, (n.c)localObject1);
      return;
    }
    this.d.b().executeVoidScript(this.c, this.a, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n.9
 * JD-Core Version:    0.7.0.1
 */