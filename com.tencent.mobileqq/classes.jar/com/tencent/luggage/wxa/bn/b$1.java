package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;

class b$1
  implements e.a
{
  b$1(b paramb, h paramh, int paramInt) {}
  
  public void a(e.b paramb, boolean paramBoolean)
  {
    h localh = this.a;
    int i = this.b;
    b localb = this.c;
    if (paramBoolean) {
      paramb = "ok";
    } else {
      paramb = "fail";
    }
    localh.a(i, localb.b(paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.b.1
 * JD-Core Version:    0.7.0.1
 */