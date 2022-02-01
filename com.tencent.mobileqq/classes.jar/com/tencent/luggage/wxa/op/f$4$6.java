package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.qz.o;

class f$4$6
  implements Runnable
{
  f$4$6(f.4 param4, boolean paramBoolean) {}
  
  public void run()
  {
    if (f.h(this.b.a, false))
    {
      if ((f.e(this.b.a) != null) && (f.d(this.b.a) != null))
      {
        d locald = f.e(this.b.a);
        c localc = f.d(this.b.a).h;
        e locale;
        if (this.a) {
          locale = e.c;
        } else {
          locale = e.d;
        }
        locald.a(localc, locale);
      }
      o.d(f.a(this.b.a), "processTransferFromOnPlay, clearPipVideoRelated");
      f.a(this.b.a, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.4.6
 * JD-Core Version:    0.7.0.1
 */