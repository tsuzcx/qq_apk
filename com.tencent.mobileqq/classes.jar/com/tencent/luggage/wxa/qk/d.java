package com.tencent.luggage.wxa.qk;

import com.tencent.luggage.wxa.qh.b.b;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.qz.o;

public class d
  extends a
{
  public boolean a = false;
  private com.tencent.luggage.wxa.ig.e b;
  private com.tencent.luggage.wxa.ql.b c;
  private com.tencent.luggage.wxa.qh.b d;
  private boolean e;
  private com.tencent.luggage.wxa.ig.c f;
  private boolean g;
  private b.b r = new d.2(this);
  
  private void a(com.tencent.luggage.wxa.ig.e parame, boolean paramBoolean)
  {
    if (this.c == null)
    {
      if ((!paramBoolean) && (com.tencent.luggage.wxa.hg.c.c(15)))
      {
        o.d("MicroMsg.Music.MusicPlayer", "use MMPlayer");
        this.c = new c();
      }
      else
      {
        o.d("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
        this.c = new b();
      }
      this.c.a(parame);
      this.c.a(new d.1(this));
    }
  }
  
  private void a(String paramString)
  {
    if (this.j != null) {
      this.j.a(this.b, paramString);
    }
  }
  
  private void b(com.tencent.luggage.wxa.ig.e parame, int paramInt)
  {
    if (parame == null)
    {
      o.b("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
      return;
    }
    int j = 0;
    o.d("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", new Object[] { Integer.valueOf(paramInt) });
    parame = this.c;
    int i = j;
    if (parame != null)
    {
      i = j;
      if ((parame instanceof c)) {
        i = ((c)parame).k();
      }
    }
    if (this.j != null) {
      this.j.a(this.b, paramInt, i);
    }
  }
  
  private void k()
  {
    if (i.h().a())
    {
      o.d("MicroMsg.Music.MusicPlayer", "startPlay");
      try
      {
        if (this.c != null) {
          this.c.e();
        }
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
      }
      this.g = true;
      this.e = false;
      return;
    }
    o.b("MicroMsg.Music.MusicPlayer", "request focus error");
  }
  
  public boolean B()
  {
    return this.g;
  }
  
  public void G()
  {
    o.d("MicroMsg.Music.MusicPlayer", "stopPlay");
    com.tencent.luggage.wxa.ql.b localb = this.c;
    if ((localb != null) && ((localb instanceof c))) {
      a(localb.h());
    }
    try
    {
      if (this.d != null)
      {
        this.d.c();
        this.d = null;
      }
      if (this.c != null)
      {
        this.c.f();
        this.c = null;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
    }
    i.h().b();
    this.g = false;
    this.a = false;
  }
  
  public int H()
  {
    com.tencent.luggage.wxa.ql.b localb = this.c;
    if (localb != null) {
      return localb.c();
    }
    return -1;
  }
  
  public int I()
  {
    com.tencent.luggage.wxa.ql.b localb = this.c;
    if (localb != null) {
      return localb.d();
    }
    return -1;
  }
  
  public void a()
  {
    this.a = true;
    o.d("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.c != null) && (this.c.a()))
      {
        this.c.g();
        f(this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
    }
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame)
  {
    super.a(parame);
    o.d("MicroMsg.Music.MusicPlayer", "init and start download");
    G();
    if (parame == null)
    {
      o.d("MicroMsg.Music.MusicPlayer", "music is null");
      return;
    }
    this.d = new com.tencent.luggage.wxa.qh.b(parame, com.tencent.luggage.wxa.qg.e.f(parame.c));
    this.d.a(this.r);
    if (this.j != null)
    {
      this.j.a(parame, false);
      o.d("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.j.a();
      this.j.a(this.d);
    }
    this.b = parame;
    a(parame, false);
    o.d("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { parame.i, parame.C });
    this.d.d();
    h();
  }
  
  public boolean b()
  {
    return (this.g) && (this.a);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(int paramInt)
  {
    o.d("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = I();
      int j = g();
      if ((i >= 0) && (paramInt <= i))
      {
        double d1 = j;
        Double.isNaN(d1);
        d1 /= 100.0D;
        double d2 = i;
        Double.isNaN(d2);
        int k = (int)(d1 * d2);
        i = paramInt;
        if (j != 100)
        {
          i = paramInt;
          if (paramInt > k)
          {
            i = k - 2000;
            o.d("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
          }
        }
        if ((this.c != null) && (i >= 0))
        {
          this.c.a(i);
          i(this.b);
          return true;
        }
      }
      else
      {
        o.b("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
        G();
        return false;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
    }
    return false;
  }
  
  public com.tencent.luggage.wxa.ig.c d()
  {
    int k = I();
    int m = H();
    int i;
    if (t()) {
      i = 1;
    } else if (f()) {
      i = 0;
    } else {
      i = 2;
    }
    o.d("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
    int j = g();
    if (k <= 0) {
      j = 0;
    }
    com.tencent.luggage.wxa.ig.c localc = this.f;
    if (localc != null) {
      localc.a(k, m, i, j);
    } else {
      this.f = new com.tencent.luggage.wxa.ig.c(k, m, i, j);
    }
    localc = this.f;
    localc.a = false;
    localc.b = i();
    return this.f;
  }
  
  protected void e()
  {
    this.j = ((com.tencent.luggage.wxa.qj.d)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qj.d.class));
    this.k = i.i();
  }
  
  public boolean f()
  {
    return (this.g) && ((this.e) || (this.h));
  }
  
  public int g()
  {
    com.tencent.luggage.wxa.qh.b localb = this.d;
    if (localb != null) {
      return localb.f();
    }
    return 0;
  }
  
  public void q()
  {
    this.a = false;
    o.d("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.c != null) && (this.c.a()))
      {
        this.c.g();
        this.e = true;
        f(this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
    }
  }
  
  public void r()
  {
    o.d("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    q();
    i.h().b();
  }
  
  public void s()
  {
    try
    {
      if ((this.c != null) && (!this.c.a()))
      {
        o.d("MicroMsg.Music.MusicPlayer", "resume");
        if (i.h().a())
        {
          this.c.e();
          e(this.b);
          return;
        }
        o.b("MicroMsg.Music.MusicPlayer", "request focus error");
        return;
      }
      o.d("MicroMsg.Music.MusicPlayer", "music is playing");
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
    }
  }
  
  public boolean t()
  {
    com.tencent.luggage.wxa.ql.b localb = this.c;
    if (localb != null) {}
    try
    {
      boolean bool = localb.a();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.d
 * JD-Core Version:    0.7.0.1
 */