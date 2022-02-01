package com.tencent.luggage.wxa.la;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.ro.e.a;

class h$1
  implements e.a
{
  h$1(h paramh, c.c paramc, d paramd, i parami) {}
  
  public void a(Object paramObject)
  {
    if (this.a != null)
    {
      if ((paramObject instanceof Exception)) {
        paramObject = ((Exception)paramObject).getMessage();
      } else if (paramObject == null) {
        paramObject = "internal error";
      } else {
        paramObject = paramObject.toString();
      }
      this.a.a(false, paramObject);
    }
    this.b.d(new h.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.h.1
 * JD-Core Version:    0.7.0.1
 */