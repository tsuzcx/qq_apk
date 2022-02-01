package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.lz.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;

final class f$1
  implements e.a<Object>
{
  f$1(String paramString, d paramd) {}
  
  public void a(Object paramObject)
  {
    o.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "async update FAILED, appId[%s] exception[%s]", new Object[] { this.a, paramObject });
    f.a(this.b, a.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.f.1
 * JD-Core Version:    0.7.0.1
 */