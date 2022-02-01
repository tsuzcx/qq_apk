package com.tencent.luggage.wxa.od;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oe.e;
import com.tencent.luggage.wxa.oe.e.a;
import com.tencent.luggage.wxa.oh.a;
import com.tencent.luggage.wxa.oh.b;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private final Map<Integer, e> a = new HashMap();
  
  protected static c a(e.a parama, h paramh)
  {
    c localc = new c();
    localc.a(new a(parama, paramh));
    localc.a(new com.tencent.luggage.wxa.oh.c(parama, paramh));
    localc.a(new b(parama, paramh));
    return localc;
  }
  
  private void a(e parame)
  {
    this.a.put(Integer.valueOf(parame.c()), parame);
  }
  
  e a(int paramInt)
  {
    return (e)this.a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.od.c
 * JD-Core Version:    0.7.0.1
 */