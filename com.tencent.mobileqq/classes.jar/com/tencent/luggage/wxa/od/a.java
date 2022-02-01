package com.tencent.luggage.wxa.od;

import com.tencent.luggage.wxa.og.b;
import com.tencent.luggage.wxa.og.c;
import com.tencent.luggage.wxa.og.d;
import com.tencent.luggage.wxa.og.e;
import com.tencent.luggage.wxa.og.f;
import com.tencent.luggage.wxa.og.g;
import com.tencent.luggage.wxa.og.h;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, com.tencent.luggage.wxa.oe.a> a = new HashMap();
  
  static
  {
    a(new com.tencent.luggage.wxa.og.a());
    a(new d());
    a(new f());
    a(new h());
    a(new g());
    a(new c());
    a(new b());
    a(new e());
  }
  
  public static com.tencent.luggage.wxa.oe.a a(int paramInt)
  {
    return (com.tencent.luggage.wxa.oe.a)a.get(Integer.valueOf(paramInt));
  }
  
  private static void a(com.tencent.luggage.wxa.oe.a parama)
  {
    a.put(Integer.valueOf(parama.a()), parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.od.a
 * JD-Core Version:    0.7.0.1
 */