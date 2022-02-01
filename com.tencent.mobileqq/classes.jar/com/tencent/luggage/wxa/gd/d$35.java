package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.ge.b;
import com.tencent.luggage.wxa.ge.c.a;
import com.tencent.luggage.wxa.ge.e;
import com.tencent.luggage.wxa.ma.k;
import com.tencent.luggage.wxa.qz.o;

class d$35
  implements c.a
{
  d$35(d paramd) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    o.c(d.b(this.a), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (d.c(this.a)) {
      d.d(this.a).a(paramString, paramInt1, paramInt2);
    }
    if (d.e(this.a) != null) {
      d.e(this.a).a(d.f(this.a), d.g(this.a), paramInt1, paramInt2, paramString);
    }
    if (d.h(this.a) != null) {
      if (k.a(d.g(this.a)))
      {
        if (paramInt1 == -1024)
        {
          d.h(this.a).a(-paramInt2, 1L, false);
          d.h(this.a).a(0L, 1L, false);
        }
        else
        {
          d.h(this.a).a(41L, 1L, false);
        }
      }
      else {
        d.h(this.a).a(42L, 1L, false);
      }
    }
    d.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.35
 * JD-Core Version:    0.7.0.1
 */