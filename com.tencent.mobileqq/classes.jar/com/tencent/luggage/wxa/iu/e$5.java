package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.pp.n;

class e$5
  implements Runnable
{
  e$5(e parame, d paramd, h paramh) {}
  
  public void run()
  {
    n.b(this.c.u());
    if (this.a == null) {
      this.c.b(this.b.D);
    }
    d locald = this.c.a(this.b.D);
    if (locald == null)
    {
      locald = this.c.b(this.b);
      this.c.a(this.a, locald, this.b);
      return;
    }
    this.c.b(this.a, locald, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.5
 * JD-Core Version:    0.7.0.1
 */