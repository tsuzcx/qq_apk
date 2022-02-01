package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import java.util.LinkedList;

class o$5
  implements Runnable
{
  o$5(o paramo, int paramInt) {}
  
  public void run()
  {
    if (o.e(this.b) <= 1)
    {
      c.a(o.f(this.b), c.d.b);
      o.d(this.b).y();
      return;
    }
    synchronized (o.g(this.b))
    {
      int j = this.a;
      int i = j;
      if (j < 1) {
        i = 1;
      }
      j = i;
      if (i >= o.c(this.b).size()) {
        j = o.c(this.b).size() - 1;
      }
      m localm1 = (m)o.c(this.b).getFirst();
      m localm2 = (m)o.c(this.b).get(j);
      ??? = this.b.a(localm1, localm2);
      o.a(this.b, localm1, localm2);
      o.a(this.b, localm2, localm1, bg.c, (o.h)???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.5
 * JD-Core Version:    0.7.0.1
 */