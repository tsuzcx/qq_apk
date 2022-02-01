package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.lp.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.e;

class f$10
  implements Runnable
{
  f$10(f paramf) {}
  
  public void run()
  {
    o.d(f.a(this.a), "transferFrom, dismissTask run");
    f.a(this.a, null);
    if ((f.j(this.a) != null) && (f.k(this.a) != null))
    {
      if (f.l(this.a) == null) {
        return;
      }
      f.j(this.a).b(f.k(this.a));
      f.l(this.a).a(f.k(this.a));
      f.j(this.a).setVisibility(4);
      f.a(this.a, null);
      f.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.10
 * JD-Core Version:    0.7.0.1
 */