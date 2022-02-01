package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.ExecuteDetails;
import com.eclipsesource.mmv8.V8Context;

class n$8
  implements Runnable
{
  n$8(n paramn, n.b paramb, String paramString) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    String str = null;
    if (localObject1 != null)
    {
      localObject1 = new n.c();
      n.c.a((n.c)localObject1);
      Object localObject2 = this.c.b().executeScript(this.b, (ExecuteDetails)localObject1);
      n.c.b((n.c)localObject1);
      n.b localb = this.a;
      if (localObject2 != null) {
        str = localObject2.toString();
      }
      localb.a(str, (n.c)localObject1);
      return;
    }
    this.c.b().executeVoidScript(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n.8
 * JD-Core Version:    0.7.0.1
 */