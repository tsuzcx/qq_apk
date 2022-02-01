package com.tencent.luggage.wxa.qi;

import android.os.Handler;
import com.tencent.luggage.wxa.h.w;
import com.tencent.luggage.wxa.qz.o;

public class a$c
  implements a.b
{
  public a$c(a parama) {}
  
  public void a(a parama)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
    if (a.d(this.a) != null)
    {
      parama = this.a;
      parama.c(a.d(parama));
    }
    if (a.e(this.a) > 0)
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.e(this.a)) });
      parama = this.a;
      parama.c(a.e(parama));
    }
    if ((a.e(this.a) == 0) && (!a.a(this.a).b()))
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
      a.a(this.a).a(true);
    }
  }
  
  public void a(a parama, int paramInt)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(a parama, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (a.d(this.a) != null)
    {
      parama = this.a;
      parama.a(a.d(parama), paramInt1, paramInt2);
    }
    if (a.a(this.a) != null)
    {
      a.a(this.a).a(false);
      a.a(this.a).d();
    }
    a.b(this.a, false);
    this.a.f.removeMessages(100);
    a.h(this.a);
    if (a.i(this.a) == 1)
    {
      parama = this.a;
      a.a(parama, a.d(parama), paramInt1, paramInt2);
    }
  }
  
  public void b(a parama)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onStart");
    if (a.d(this.a) != null)
    {
      parama = this.a;
      parama.d(a.d(parama));
    }
  }
  
  public void c(a parama)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onPause");
    if ((a.d(this.a) != null) && (!a.a(this.a).b()))
    {
      parama = this.a;
      parama.f(a.d(parama));
    }
  }
  
  public void d(a parama)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onStop");
    if (a.d(this.a) != null)
    {
      parama = this.a;
      parama.g(a.d(parama));
    }
  }
  
  public void e(a parama)
  {
    if (a.f(this.a))
    {
      a.a(this.a, true);
      return;
    }
    a.g(this.a);
  }
  
  public void f(a parama)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onComplete");
    if (a.d(this.a) != null)
    {
      parama = this.a;
      parama.k(a.d(parama));
    }
    a.b(this.a, false);
    this.a.f.removeMessages(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a.c
 * JD-Core Version:    0.7.0.1
 */