package com.tencent.luggage.wxa.qk;

import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.ql.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

class d$1
  implements f
{
  private long b;
  
  d$1(d paramd) {}
  
  public void a(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
    this.a.d(parame);
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame, int paramInt)
  {
    com.tencent.luggage.wxa.ig.e locale = i.f().d();
    if (locale == null) {
      return;
    }
    if ((locale.a(parame)) && (d.a(this.a) != null) && (d.a(this.a).a()))
    {
      paramInt = d.a(this.a).c();
      int i = d.a(this.a).d();
      if ((paramInt > 0) && (i > 0))
      {
        float f = paramInt / i;
        if (d.b(this.a) != null)
        {
          d.b(this.a).a(f);
          if ((d.b(this.a) != null) && (d.b(this.a).b()) && (!d.b(this.a).b(f)))
          {
            o.d("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
            this.a.G();
          }
        }
        this.a.a(paramInt, i);
      }
    }
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame, boolean paramBoolean)
  {
    o.d("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
    com.tencent.luggage.wxa.ig.e locale = i.f().d();
    if (locale == null) {
      return;
    }
    if (locale.a(parame)) {
      this.a.G();
    }
    parame = this.a;
    parame.g(d.c(parame));
    if (paramBoolean)
    {
      parame = this.a;
      parame.k(d.c(parame));
    }
  }
  
  public void b(com.tencent.luggage.wxa.ig.e parame, boolean paramBoolean)
  {
    com.tencent.luggage.wxa.ig.e locale = i.f().d();
    if (locale == null) {
      return;
    }
    o.d("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      d.a(this.a, parame, 20);
    } else {
      d.a(this.a, parame, 21);
    }
    if (locale.a(parame))
    {
      o.d("MicroMsg.Music.MusicPlayer", "stop");
      this.a.G();
      if (paramBoolean)
      {
        o.d("MicroMsg.Music.MusicPlayer", "retry system media player again");
        d.a(this.a, locale, true);
        d.a(this.a, new com.tencent.luggage.wxa.qh.b(parame, com.tencent.luggage.wxa.qg.e.f(parame.c)));
        d.b(this.a).a(d.d(this.a));
        d.b(this.a).d();
        if (this.a.j != null) {
          this.a.j.a(d.b(this.a));
        }
      }
      else
      {
        t.a(new d.1.1(this));
        parame = this.a;
        parame.g(d.c(parame));
      }
    }
    else
    {
      o.d("MicroMsg.Music.MusicPlayer", "send stop event");
      parame = this.a;
      parame.g(d.c(parame));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.d.1
 * JD-Core Version:    0.7.0.1
 */