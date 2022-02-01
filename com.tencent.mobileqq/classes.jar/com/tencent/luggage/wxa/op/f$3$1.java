package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.qz.o;

class f$3$1
  implements Runnable
{
  f$3$1(f.3 param3) {}
  
  public void run()
  {
    if (f.h(this.a.a, false))
    {
      if ((f.e(this.a.a) != null) && (f.d(this.a.a) != null)) {
        f.e(this.a.a).a(f.d(this.a.a).h, e.d);
      }
      o.d(f.a(this.a.a), "onPageSwitchEnd, clearPipVideoRelated");
      f.a(this.a.a, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.3.1
 * JD-Core Version:    0.7.0.1
 */