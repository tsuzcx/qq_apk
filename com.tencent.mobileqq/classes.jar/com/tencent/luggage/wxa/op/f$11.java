package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.e;

class f$11
  implements Runnable
{
  f$11(f paramf) {}
  
  public void run()
  {
    o.d(f.a(this.a), "transferTo, showTask run");
    if (f.j(this.a) == null) {
      return;
    }
    f.j(this.a).a(true);
    f.j(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.11
 * JD-Core Version:    0.7.0.1
 */