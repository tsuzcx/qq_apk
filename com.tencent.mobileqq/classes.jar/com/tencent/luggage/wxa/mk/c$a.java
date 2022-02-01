package com.tencent.luggage.wxa.mk;

import com.tencent.luggage.wxa.h.f;

class c$a
  implements f.b
{
  private c$a(c paramc) {}
  
  public void a()
  {
    synchronized (this.a)
    {
      if (c.d(this.a)) {
        return;
      }
      if (c.b(this.a))
      {
        int i = c.c(this.a).a();
        if (i != 1) {
          if ((i != 2) && (i != 3))
          {
            if (i != 4) {
              break label113;
            }
          }
          else
          {
            i = c.e(this.a);
            if (i == c.f(this.a)) {
              break label113;
            }
            c.a(this.a, i);
            c.b(this.a, i);
            break label113;
          }
        }
        c.a(this.a, false);
      }
      label113:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.c.a
 * JD-Core Version:    0.7.0.1
 */