package com.tencent.luggage.wxa.gq;

import com.tencent.luggage.wxa.gp.i;
import com.tencent.luggage.wxa.gu.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  extends e
{
  private a s;
  private Object t = new Object();
  
  public f(com.tencent.luggage.wxa.gt.d paramd, com.tencent.luggage.wxa.gv.c paramc)
  {
    super(paramd, paramc);
  }
  
  private void E()
  {
    do
    {
      boolean bool = this.j.get();
      o();
      if (this.k.get()) {
        break;
      }
      if (bool)
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
        this.s.c();
      }
    } while ((!this.k.get()) && (this.j.get()));
  }
  
  public void A()
  {
    super.A();
    C();
  }
  
  protected void B()
  {
    synchronized (this.t)
    {
      if (this.s != null) {
        this.s.g();
      }
      return;
    }
  }
  
  protected void C()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
    synchronized (this.t)
    {
      if (this.s != null)
      {
        this.s.e();
        this.s = null;
      }
      return;
    }
  }
  
  protected void D()
  {
    a locala = this.s;
    if (locala != null)
    {
      locala.b();
      if ((this.s instanceof com.tencent.luggage.wxa.gu.b)) {
        E();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    synchronized (this.t)
    {
      if (this.s != null) {
        this.s.a(paramFloat1, paramFloat2);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    synchronized (this.t)
    {
      if (this.s != null) {
        this.s.a(paramInt);
      }
      return;
    }
  }
  
  protected void a(com.tencent.luggage.wxa.gm.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    b(paramd, paramByteBuffer, paramInt);
  }
  
  protected void a(byte[] paramArrayOfByte)
  {
    if (this.h.get()) {
      return;
    }
    if (this.s == null)
    {
      localObject = n();
      if ((((com.tencent.luggage.wxa.gm.d)localObject).e()) && (((com.tencent.luggage.wxa.gm.d)localObject).d() <= 2000L)) {
        this.s = new com.tencent.luggage.wxa.gu.b(this.o, this.p, (com.tencent.luggage.wxa.gm.d)localObject, this);
      } else {
        this.s = new com.tencent.luggage.wxa.gu.c(this.o, this.p, (com.tencent.luggage.wxa.gm.d)localObject, this);
      }
      this.s.a(this.c.m);
      this.s.a((float)this.c.l, (float)this.c.l);
    }
    Object localObject = this.s;
    if (localObject != null) {
      ((a)localObject).a(paramArrayOfByte);
    }
  }
  
  protected void b(com.tencent.luggage.wxa.gm.d paramd)
  {
    if (this.e != null) {
      this.e.b();
    }
    c(paramd);
    paramd.f();
  }
  
  protected void b(com.tencent.luggage.wxa.gm.e parame)
  {
    if (n().g())
    {
      this.o = 44100;
      this.p = 2;
    }
    else
    {
      this.o = parame.b;
      this.p = parame.c;
    }
    a(parame.f);
    if (parame.b()) {
      com.tencent.luggage.wxa.gn.d.a().a(parame);
    }
  }
  
  public void d()
  {
    super.d();
    synchronized (this.t)
    {
      if (this.s != null) {
        this.s.d();
      }
      return;
    }
  }
  
  public void e()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    d(5);
    this.k.set(true);
    this.m.set(false);
    p();
  }
  
  public void h() {}
  
  protected void u()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.u();
    B();
  }
  
  protected void v()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.v();
    D();
  }
  
  public long z()
  {
    synchronized (this.t)
    {
      if (this.s != null)
      {
        long l = this.s.h();
        return l;
      }
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.f
 * JD-Core Version:    0.7.0.1
 */