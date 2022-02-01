package com.tencent.luggage.wxa.ed;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.pp.n;

class b$1
  implements Runnable
{
  b$1(b paramb, d paramd, c paramc, com.tencent.luggage.wxa.ou.d paramd1) {}
  
  public void run()
  {
    n.b(this.d.u());
    if (this.a == null) {
      b.a(this.d, this.b.D);
    }
    d locald1 = (d)b.b(this.d, this.b.D);
    this.b.a(this.c);
    if (locald1 == null)
    {
      locald1 = this.d.a(this.b);
      b.a(this.d, locald1);
      this.d.a(this.a, locald1, this.b);
    }
    else
    {
      d locald2 = this.a;
      if (locald2 == locald1)
      {
        this.d.b(null, locald1, this.b);
        this.d.c();
      }
      else
      {
        this.d.b(locald2, locald1, this.b);
      }
    }
    if (this.d.b(locald1))
    {
      if (locald1.ac() != null)
      {
        locald1.c(true);
        return;
      }
      locald1.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.b.1
 * JD-Core Version:    0.7.0.1
 */