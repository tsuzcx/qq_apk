package com.tencent.luggage.wxa.gq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.gm.e;
import com.tencent.luggage.wxa.gp.i;
import com.tencent.luggage.wxa.gt.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c
  implements n, com.tencent.luggage.wxa.gt.f
{
  protected volatile com.tencent.luggage.wxa.gt.d a;
  protected volatile com.tencent.luggage.wxa.gv.c b;
  protected volatile com.tencent.luggage.wxa.if.b c;
  protected volatile String d;
  protected i e;
  protected int f = 0;
  protected volatile String g;
  protected AtomicBoolean h = new AtomicBoolean(false);
  protected AtomicInteger i = new AtomicInteger(0);
  protected AtomicBoolean j = new AtomicBoolean(false);
  protected AtomicBoolean k = new AtomicBoolean(false);
  protected AtomicBoolean l = new AtomicBoolean(false);
  protected AtomicBoolean m = new AtomicBoolean(false);
  protected AtomicBoolean n = new AtomicBoolean(false);
  protected int o = 0;
  protected int p = 0;
  protected int q;
  protected Object r = new Object();
  private volatile String s;
  
  protected c(com.tencent.luggage.wxa.gt.d paramd, com.tencent.luggage.wxa.gv.c paramc)
  {
    this.a = paramd;
    this.b = paramc;
    this.c = this.b.a();
    this.d = this.c.a;
    this.g = this.c.c;
    this.q = this.c.d;
    this.s = this.c.b;
  }
  
  public void a()
  {
    this.q = this.b.a().e;
    this.j.set(false);
    this.k.set(false);
    if (this.b != null) {
      this.b.b();
    }
    d(1);
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt)
  {
    int i1 = this.q;
    this.q = paramInt;
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) });
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.i.set(paramInt1);
    int i1 = 13;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if (paramInt1 == 3)
      {
        paramInt1 = 9;
        break label172;
      }
      if (paramInt1 == 2)
      {
        paramInt1 = 7;
        break label172;
      }
      if (paramInt1 == 4)
      {
        paramInt1 = 0;
        break label172;
      }
      if (paramInt1 == 5)
      {
        paramInt1 = 2;
        break label172;
      }
      if (paramInt1 == 6)
      {
        paramInt1 = 3;
        break label172;
      }
      if (paramInt1 == 7)
      {
        paramInt1 = 5;
        break label172;
      }
      if (paramInt1 == 9)
      {
        paramInt1 = 4;
        break label172;
      }
      if (paramInt1 == 11)
      {
        paramInt1 = 6;
        break label172;
      }
      if (paramInt1 == 12)
      {
        paramInt1 = 10;
        break label172;
      }
      if (paramInt1 == 13)
      {
        paramInt1 = 11;
        break label172;
      }
      if (paramInt1 == 14)
      {
        paramInt1 = 12;
        break label172;
      }
      if (paramInt1 == 15)
      {
        paramInt1 = i1;
        break label172;
      }
    }
    paramInt1 = -1;
    label172:
    String str = x();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    com.tencent.luggage.wxa.gt.d locald = this.a;
    if (paramInt1 == -1) {
      return;
    }
    if ((locald != null) && (paramInt1 == 4))
    {
      locald.a(paramInt1, str, paramInt2, paramString);
      return;
    }
    if (locald != null) {
      locald.a(paramInt1, str, y());
    }
  }
  
  protected void a(com.tencent.luggage.wxa.gm.d paramd)
  {
    if (this.e == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    u();
    e locale;
    do
    {
      if (j()) {
        break;
      }
      o();
      locale = this.e.a(3536);
      if ((paramd.c() > 0) && (locale == null))
      {
        paramd.f();
        break;
      }
      if ((paramd.c() == 0) && (locale == null))
      {
        paramd.a();
        break;
      }
      if (locale == null) {
        break;
      }
      if (!paramd.e()) {
        paramd.a(locale);
      }
      a(locale);
    } while (locale != null);
    v();
  }
  
  protected void a(e parame)
  {
    if (this.h.get()) {
      return;
    }
    if (parame == null) {
      return;
    }
    if ((parame.e > 0L) && (this.q > 0) && (parame.e < this.q)) {
      return;
    }
    if ((this.a != null) && (this.a.b() != null) && (parame != null))
    {
      parame.a = x();
      b(parame);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.k.set(true);
    d(9);
    com.tencent.luggage.wxa.gm.d locald = n();
    if ((locald != null) && (!locald.e())) {
      locald.a();
    }
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.h.set(true);
    d(10);
  }
  
  protected void b(int paramInt)
  {
    if (paramInt < 50)
    {
      this.l.set(false);
      return;
    }
    ??? = n();
    w();
    if ((??? != null) && (((com.tencent.luggage.wxa.gm.d)???).e()))
    {
      this.l.set(true);
      try
      {
        synchronized (this.r)
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", new Object[] { Integer.valueOf(paramInt) });
          this.r.wait();
        }
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", localException, "lockWriteBuffer", new Object[0]);
        return;
      }
      throw localException;
    }
    this.l.set(false);
  }
  
  protected void b(e parame)
  {
    if (this.b.a().z)
    {
      if (!this.n.get())
      {
        this.n.set(true);
        d(14);
      }
      b(this.a.b().a(x(), parame, this));
    }
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "resume");
    d(4);
    synchronized (this.r)
    {
      if (i())
      {
        this.j.set(false);
        try
        {
          this.r.notify();
        }
        catch (Exception localException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", localException, "resume", new Object[0]);
        }
      }
      return;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt >= 20) {
      return;
    }
    if (!this.l.get()) {
      return;
    }
    if (!i())
    {
      if (j()) {
        return;
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
      p();
    }
  }
  
  public void d()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "pause");
    d(5);
    this.j.set(true);
    this.m.set(false);
  }
  
  protected void d(int paramInt)
  {
    a(paramInt, 0, "");
  }
  
  public void e()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    d();
  }
  
  public void e(int paramInt)
  {
    com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.f = paramInt;
    this.k.set(true);
    a(9, paramInt, "");
  }
  
  public void f()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "stop");
    a(0.0F, 0.0F);
    d(6);
    this.k.set(true);
    this.j.set(false);
    p();
    this.m.set(false);
    this.n.set(false);
  }
  
  public void g()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(n().d()) });
    h();
    A();
    if (this.b != null)
    {
      this.b.a().d = 0;
      this.b.c();
    }
    this.h.set(false);
    this.k.set(true);
    this.j.set(false);
    this.l.set(false);
    this.a = null;
  }
  
  public void h()
  {
    this.a.b().i(x());
  }
  
  public boolean i()
  {
    return this.j.get();
  }
  
  public boolean j()
  {
    return this.k.get();
  }
  
  public boolean k()
  {
    return this.i.get() == 4;
  }
  
  public boolean l()
  {
    return this.i.get() == 9;
  }
  
  public boolean m()
  {
    return this.a.b().j(x());
  }
  
  public com.tencent.luggage.wxa.gm.d n()
  {
    return com.tencent.luggage.wxa.gn.f.c().a(this.g);
  }
  
  protected void o()
  {
    synchronized (this.r)
    {
      while (!j())
      {
        boolean bool = i();
        if (!bool) {
          break;
        }
        try
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
          this.r.wait();
        }
        catch (Exception localException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", localException, "waitDecode", new Object[0]);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void p()
  {
    try
    {
      synchronized (this.r)
      {
        this.r.notify();
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", localException, "notifyDecode", new Object[0]);
      return;
    }
  }
  
  public void q()
  {
    if (this.a.j() != null) {
      this.a.j().a(w().i);
    }
    this.g = w().c;
    if (TextUtils.isEmpty(this.g))
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.f = 712;
      e(this.f);
      return;
    }
    Object localObject = w();
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.g, Boolean.valueOf(((com.tencent.luggage.wxa.if.b)localObject).h) });
    if (this.h.get())
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.luggage.wxa.if.b)localObject).B)
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.luggage.wxa.gn.f.c().c(this.g)) {
          r();
        } else {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "preload end");
        d(15);
        return;
      }
      if (!k()) {
        d(3);
      }
      if (!com.tencent.luggage.wxa.gn.f.c().c(this.g)) {
        r();
      } else {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
      this.h.set(false);
      com.tencent.luggage.wxa.gm.d locald = n();
      if (j())
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (locald.e()) {
          d(2);
        }
        return;
      }
      if (l())
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((!k()) && (!((com.tencent.luggage.wxa.if.b)localObject).g))
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "not to play");
        d(2);
        return;
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "to play");
      d(2);
    }
    d(4);
    int i1;
    label415:
    do
    {
      if (!com.tencent.luggage.wxa.gn.f.c().c(this.g)) {
        r();
      } else {
        s();
      }
      if ((((com.tencent.luggage.wxa.if.b)localObject).h) && (!j())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { x() });
      }
      try
      {
        Thread.sleep(20L);
      }
      catch (Exception localException)
      {
        break label415;
      }
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
      this.q = 0;
    } while (i1 != 0);
    if ((!j()) && (!l()))
    {
      if (!m())
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
        this.a.b().a(x(), true);
      }
      else
      {
        d(7);
        this.a.b().g(x());
      }
    }
    else
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
      localObject = w().c;
      if (this.b.equals(localObject))
      {
        this.a.b().g(x());
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
      }
      else
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
      }
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "task end");
  }
  
  protected abstract void r();
  
  protected void s()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.luggage.wxa.gm.d locald = n();
    if (locald == null) {
      return;
    }
    u();
    int i2 = locald.c();
    int i1 = 0;
    while ((i1 < i2) && (!j()))
    {
      o();
      e locale = locald.a(i1);
      if (locale != null) {
        a(locale);
      }
      i1 += 1;
    }
    v();
  }
  
  public void t()
  {
    if ((!this.m.get()) && (!this.k.get()))
    {
      this.m.set(true);
      d(13);
    }
  }
  
  protected void u() {}
  
  protected void v() {}
  
  public com.tencent.luggage.wxa.if.b w()
  {
    if (this.b != null) {
      return this.b.a();
    }
    return this.c;
  }
  
  public String x()
  {
    com.tencent.luggage.wxa.if.b localb = w();
    if (localb == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.d;
    }
    return localb.a;
  }
  
  public String y()
  {
    return this.s;
  }
  
  public long z()
  {
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.c
 * JD-Core Version:    0.7.0.1
 */