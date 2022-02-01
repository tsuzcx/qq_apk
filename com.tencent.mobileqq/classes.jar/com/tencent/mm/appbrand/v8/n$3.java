package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Context;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.LinkedList;

class n$3
  implements Runnable
{
  n$3(n paramn) {}
  
  public void run()
  {
    o.d("MicroMsg.J2V8.V8ContextEngine", "destroy");
    Object localObject = n.a(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((p)((Iterator)localObject).next()).a();
    }
    n.a(this.a).clear();
    localObject = this.a.b();
    if (localObject != null) {
      try
      {
        ((V8Context)localObject).release();
        return;
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n.3
 * JD-Core Version:    0.7.0.1
 */