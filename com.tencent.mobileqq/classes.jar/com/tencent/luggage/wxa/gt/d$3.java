package com.tencent.luggage.wxa.gt;

import com.tencent.luggage.wxa.gq.p;
import com.tencent.luggage.wxa.gz.c;
import com.tencent.luggage.wxa.gz.c.a;
import java.util.HashMap;

class d$3
  implements p
{
  d$3(d paramd) {}
  
  private boolean a(int paramInt)
  {
    return (paramInt == 12) || (paramInt == 11) || (paramInt == 10) || (paramInt == 6);
  }
  
  public void a(c paramc)
  {
    int i = paramc.a.a;
    boolean bool = a(i);
    Boolean localBoolean = Boolean.valueOf(false);
    if (!bool) {
      if (d.j(this.a).containsKey(paramc.a.c))
      {
        ??? = (e)d.j(this.a).get(paramc.a.c);
        if (??? != null) {
          if (((e)???).a(new Integer[] { Integer.valueOf(i) }))
          {
            com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
            return;
          }
        }
        if (??? != null)
        {
          ((e)???).a(Integer.valueOf(i));
          d.j(this.a).put(paramc.a.c, ???);
        }
      }
      else
      {
        synchronized (d.k(this.a))
        {
          e locale = new e(Integer.valueOf(i));
          d.j(this.a).put(paramc.a.c, locale);
        }
      }
    }
    if (d.l(this.a) == null) {
      return;
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramc.a.c, paramc.a.d });
    if (i == 9)
    {
      d.l(this.a).a(paramc);
      return;
    }
    if (i == 7)
    {
      d.l(this.a).b(paramc);
      return;
    }
    if (i == 0)
    {
      d.l(this.a).c(paramc);
      return;
    }
    if (i == 1)
    {
      d.l(this.a).c(paramc);
      return;
    }
    if (i == 2)
    {
      d.l(this.a).d(paramc);
      return;
    }
    if (i == 3)
    {
      d.m(this.a).put(paramc.a.c, localBoolean);
      d.l(this.a).e(paramc);
      return;
    }
    if (i == 5)
    {
      d.m(this.a).put(paramc.a.c, localBoolean);
      d.l(this.a).f(paramc);
      return;
    }
    if (i == 4)
    {
      d.m(this.a).put(paramc.a.c, localBoolean);
      d.l(this.a).i(paramc);
      return;
    }
    if (i == 10)
    {
      d.l(this.a).g(paramc);
      return;
    }
    if (i == 6)
    {
      d.l(this.a).h(paramc);
      return;
    }
    if (i == 11)
    {
      d.l(this.a).j(paramc);
      return;
    }
    if (i == 12)
    {
      d.l(this.a).k(paramc);
      return;
    }
    if (i == 13) {
      d.l(this.a).l(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gt.d.3
 * JD-Core Version:    0.7.0.1
 */