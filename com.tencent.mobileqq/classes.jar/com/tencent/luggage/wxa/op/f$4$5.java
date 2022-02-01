package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.lp.i;
import com.tencent.luggage.wxa.qz.o;

class f$4$5
  implements Runnable
{
  f$4$5(f.4 param4) {}
  
  public void run()
  {
    o.d(f.a(this.a.a), "onPlayEnd, onPlayEndWorkaround");
    if ((f.l(this.a.a) != null) && (f.k(this.a.a) != null)) {
      f.l(this.a.a).b(f.k(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.4.5
 * JD-Core Version:    0.7.0.1
 */