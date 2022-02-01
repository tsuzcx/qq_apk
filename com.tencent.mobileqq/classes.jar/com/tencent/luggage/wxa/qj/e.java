package com.tencent.luggage.wxa.qj;

import com.tencent.luggage.wxa.gz.d.a;
import com.tencent.luggage.wxa.qn.b;
import com.tencent.luggage.wxa.qy.c;
import com.tencent.luggage.wxa.qz.o;

public class e
  extends c<com.tencent.luggage.wxa.gz.d>
{
  public boolean a(com.tencent.luggage.wxa.gz.d paramd)
  {
    if (!i.g())
    {
      o.b("MicroMsg.Music.MusicActionListener", "don't anything, must init MusicPlayerManager first with MusicLogic before!");
      return false;
    }
    int i = paramd.a.a;
    if (i != 13)
    {
      if (i != 16)
      {
        switch (i)
        {
        default: 
          return false;
        case 11: 
          i.f().a(600000);
          return false;
        case 10: 
          paramd.b.b = i.f().a().b();
          return false;
        case 9: 
          paramd.b.b = i.f().a().B();
          return false;
        case 8: 
          paramd.b.c = i.f().a().d();
          return false;
        case 7: 
          paramd.b.b = i.f().a().c(paramd.a.f);
          return false;
        case 6: 
          i.f().c(paramd.a.b);
          return false;
        case 5: 
          i.f().a(paramd.a.c, paramd.a.e);
          return false;
        case 4: 
          i.f().a(paramd.a.c, paramd.a.d);
          return false;
        case 3: 
          i.f().d(paramd.a.b);
          return false;
        case 2: 
          i.f().a().s();
          return false;
        case 1: 
          i.f().a().r();
          return false;
        case 0: 
          i.f().e(paramd.a.b);
          return false;
        case -1: 
          i.f().c();
          return false;
        case -2: 
          paramd.b.a = i.f().d();
          return false;
        }
        paramd.b.b = i.f().a().t();
        return false;
      }
      i.f().b(paramd.a.b);
      return false;
    }
    d locald = (d)b.a(d.class);
    if (locald != null) {
      locald.a(paramd.a.g);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qj.e
 * JD-Core Version:    0.7.0.1
 */