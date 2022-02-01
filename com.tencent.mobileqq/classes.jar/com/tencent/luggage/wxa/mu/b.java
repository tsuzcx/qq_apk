package com.tencent.luggage.wxa.mu;

import com.tencent.luggage.wxa.fx.a;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.page.u;

public class b
{
  public static int a(String paramString)
  {
    paramString = com.tencent.luggage.wxa.iu.c.i(paramString);
    if (paramString == c.d.g) {
      return 2;
    }
    if (paramString == c.d.b) {
      return 3;
    }
    if (paramString == c.d.a) {
      return 4;
    }
    if (paramString == c.d.h) {
      return 5;
    }
    if (paramString == c.d.e) {
      return 6;
    }
    if (paramString == c.d.f) {
      return 7;
    }
    if (paramString == c.d.d) {
      return 8;
    }
    return 1;
  }
  
  public static d a(a parama)
  {
    if ((parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return a(parama.g());
    }
    return null;
  }
  
  private static d a(com.tencent.luggage.wxa.jx.c paramc)
  {
    if ((paramc instanceof u)) {
      return ((u)paramc).q();
    }
    if ((paramc instanceof h)) {
      return ((h)paramc).q();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mu.b
 * JD-Core Version:    0.7.0.1
 */