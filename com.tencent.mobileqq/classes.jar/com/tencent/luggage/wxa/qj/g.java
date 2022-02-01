package com.tencent.luggage.wxa.qj;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

public abstract class g
  implements c
{
  private com.tencent.luggage.wxa.qk.d a = new com.tencent.luggage.wxa.qk.d();
  private com.tencent.luggage.wxa.qk.e b = new com.tencent.luggage.wxa.qk.e();
  private com.tencent.luggage.wxa.qi.a c = new com.tencent.luggage.wxa.qi.a();
  private Runnable d = new g.1(this);
  
  public com.tencent.luggage.wxa.ql.d a()
  {
    com.tencent.luggage.wxa.ig.e locale = d();
    if (com.tencent.luggage.wxa.qq.c.a(locale)) {
      return this.c;
    }
    if ((locale != null) && (com.tencent.luggage.wxa.qq.c.a(locale.a))) {
      return this.b;
    }
    return this.a;
  }
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    t.b(this.d);
    t.a(this.d, paramInt);
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame)
  {
    if (com.tencent.luggage.wxa.qq.c.a(parame))
    {
      o.d("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      b();
      this.c.a(parame);
    }
    else if (com.tencent.luggage.wxa.qq.c.a(parame.a))
    {
      o.d("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
      b();
      this.b.a(parame);
    }
    else
    {
      o.d("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
      b();
      this.a.a(parame);
    }
    if (parame.a != 11) {
      e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.t()) {
      this.a.a(paramBoolean);
    }
    if (this.b.t()) {
      this.b.a(paramBoolean);
    }
    if (this.c.t()) {
      this.c.a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.a.t()) {
      this.a.G();
    }
    if (this.b.t()) {
      this.b.G();
    }
    if (this.c.t()) {
      this.c.G();
    }
  }
  
  public void b(com.tencent.luggage.wxa.ig.e parame)
  {
    if (this.a.t()) {
      this.a.l(parame);
    }
    if (this.b.t()) {
      this.b.l(parame);
    }
    if (this.c.t()) {
      this.c.l(parame);
    }
  }
  
  public void c()
  {
    this.a.G();
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qk.e)localObject).G();
    }
    localObject = this.c;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qi.a)localObject).G();
    }
    t.b(this.d);
  }
  
  public com.tencent.luggage.wxa.ig.e d()
  {
    return null;
  }
  
  public void e()
  {
    o.d("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    com.tencent.luggage.wxa.gz.e locale = new com.tencent.luggage.wxa.gz.e();
    locale.a.a = 10;
    locale.a.e = "preempted";
    locale.a.h = "not from app brand appid";
    locale.a.f = true;
    com.tencent.luggage.wxa.qy.a.a.a(locale, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qj.g
 * JD-Core Version:    0.7.0.1
 */