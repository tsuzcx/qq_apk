package com.tencent.luggage.wxa.be;

import android.graphics.Point;

class b$2
  implements Runnable
{
  b$2(b paramb, com.tencent.luggage.wxa.jx.c paramc, d paramd, com.tencent.luggage.wxa.kp.c paramc1) {}
  
  public void run()
  {
    if (this.d.a_ == null) {
      this.d.a_ = new c(this.a);
    }
    int i = this.b.f().x;
    int j = this.b.f().y;
    int k = this.d.a_.a(this.b, i, j);
    if (k < 0)
    {
      this.c.a(String.format("illegal state:%d", new Object[] { Integer.valueOf(k) }), -1, -1, -1);
      return;
    }
    this.c.a(null, k, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.b.2
 * JD-Core Version:    0.7.0.1
 */