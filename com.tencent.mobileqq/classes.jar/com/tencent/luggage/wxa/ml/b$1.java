package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.ma.e.c;
import com.tencent.luggage.wxa.qz.v.a;

class b$1
  implements v.a
{
  b$1(b paramb) {}
  
  public boolean p_()
  {
    if (!this.a.b()) {
      return false;
    }
    if (this.a.o)
    {
      if (this.a.p != null) {
        this.a.p.d(this.a.getSessionId(), this.a.getMediaId());
      }
      this.a.o = false;
    }
    b localb = this.a;
    localb.b(localb.getCurrPosSec());
    localb = this.a;
    b.a(localb, localb.b());
    if (this.a.E()) {
      return this.a.D();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.b.1
 * JD-Core Version:    0.7.0.1
 */