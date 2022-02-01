package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.gz.b.a;
import com.tencent.luggage.wxa.if.d;
import com.tencent.luggage.wxa.qz.o;

public final class a
{
  public static boolean a(com.tencent.luggage.wxa.gz.b paramb)
  {
    if (paramb.b.a != 6) {
      o.e("MicroMsg.Audio.AudioActionListener", "callback, action:%d", new Object[] { Integer.valueOf(paramb.b.a) });
    }
    Object localObject;
    switch (paramb.b.a)
    {
    default: 
      return true;
    case 20: 
      paramb.c.d = g.a().c();
      return true;
    case 19: 
      bool = g.a().a(paramb.b.g);
      paramb.c.a = bool;
      return bool;
    case 18: 
      bool = g.a().a(paramb.b.e);
      paramb.c.a = bool;
      return bool;
    case 17: 
      bool = g.a().g(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 16: 
      localObject = g.a().l(paramb.b.b);
      paramb.b.e = ((com.tencent.luggage.wxa.if.b)localObject);
      return true;
    case 15: 
      g.a().q(paramb.b.f);
      return true;
    case 14: 
      bool = g.a().c(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 13: 
      bool = g.a().h(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 12: 
      g.a().m(paramb.b.c);
      return true;
    case 11: 
      int i = g.a().k(paramb.b.c);
      paramb.c.b = i;
      return true;
    case 10: 
      localObject = g.a().a(paramb.b.c, paramb.b.b);
      paramb.b.b = ((String)localObject);
      return true;
    case 9: 
      g.a().n(paramb.b.c);
      return true;
    case 8: 
      bool = g.a().e(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 7: 
      bool = g.a().f(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 6: 
      localObject = g.a().j(paramb.b.b);
      paramb.c.c = ((d)localObject);
      return true;
    case 5: 
      bool = g.a().d(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 4: 
      bool = g.a().a(paramb.b.b, paramb.b.d);
      paramb.c.a = bool;
      return bool;
    case 3: 
      bool = g.a().b(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 2: 
      bool = g.a().a(paramb.b.b);
      paramb.c.a = bool;
      return bool;
    case 1: 
      bool = g.a().a(paramb.b.b, paramb.b.e);
      paramb.c.a = bool;
      return bool;
    }
    boolean bool = g.a().b(paramb.b.e);
    paramb.c.a = bool;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.a
 * JD-Core Version:    0.7.0.1
 */