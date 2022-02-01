package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.pd.r;
import com.tencent.luggage.wxa.qz.o;

class f$13
  implements Runnable
{
  f$13(f paramf) {}
  
  public void run()
  {
    o.d(f.a(this.a), "transferTo, run pendingCancelableShowTask");
    if (f.m(this.a) == null)
    {
      o.d(f.a(this.a), "transferTo, pendingCancelableShowTask is null");
      return;
    }
    f.m(this.a).b();
    if (!f.m(this.a).a())
    {
      Runnable localRunnable = f.m(this.a).e();
      if (localRunnable != null)
      {
        o.d(f.a(this.a), "transferTo, run extraTask");
        localRunnable.run();
      }
    }
    f.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.13
 * JD-Core Version:    0.7.0.1
 */