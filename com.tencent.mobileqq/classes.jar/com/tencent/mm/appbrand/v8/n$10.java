package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Context;
import com.tencent.luggage.wxa.qz.o;

class n$10
  implements Runnable
{
  n$10(n paramn, String paramString1, n.b paramb, int paramInt, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    o.e("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", new Object[] { this.a });
    if (this.b != null)
    {
      n.c localc = new n.c();
      localc.c = this.c;
      n.c.a(localc);
      Object localObject = this.g.b().executeScript(this.d, this.a, 0, this.e, this.f, this.c, localc);
      n.c.b(localc);
      n.b localb = this.b;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = localObject.toString();
      }
      localb.a((String)localObject, localc);
      return;
    }
    this.g.b().executeVoidScript(this.d, this.a, 0, this.e, this.f, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n.10
 * JD-Core Version:    0.7.0.1
 */