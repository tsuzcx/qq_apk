package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;

class g$2
  implements e.a
{
  g$2(g paramg) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof Throwable))
    {
      o.a("Luggage.ShareWithSnapshot", (Throwable)paramObject, "save screenshot bitmap interrupted", new Object[0]);
      return;
    }
    o.b("Luggage.ShareWithSnapshot", "save screenshot bitmap interrupted %s", new Object[] { paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.g.2
 * JD-Core Version:    0.7.0.1
 */