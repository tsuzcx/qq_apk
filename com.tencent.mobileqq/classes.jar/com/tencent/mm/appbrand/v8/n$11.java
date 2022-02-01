package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Context;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;

class n$11
  implements Runnable
{
  n$11(n paramn, String paramString1, n.b paramb, ArrayList paramArrayList, String paramString2, String paramString3) {}
  
  public void run()
  {
    o.e("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", new Object[] { this.a });
    if (this.b != null)
    {
      n.c localc = new n.c();
      n.c.a(localc);
      String str = null;
      try
      {
        Object localObject2 = this.f.b().executeWxaScript(this.c, this.a, 0, this.d, this.e, 0, localc);
        n.c.b(localc);
        n.b localb = this.b;
        if (localObject2 != null) {
          str = localObject2.toString();
        }
        localb.a(str, localc);
        return;
      }
      finally
      {
        n.c.b(localc);
        this.b.a(null, localc);
      }
    }
    this.f.b().executeWxaScript(this.c, this.a, 0, this.d, this.e, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n.11
 * JD-Core Version:    0.7.0.1
 */