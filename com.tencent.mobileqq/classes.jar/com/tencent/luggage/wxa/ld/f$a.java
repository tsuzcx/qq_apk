package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.p;
import com.tencent.luggage.wxa.nz.p.b;
import com.tencent.luggage.wxa.nz.p.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicInteger;

class f$a
  implements p.b
{
  c a;
  AtomicInteger b = new AtomicInteger();
  AtomicInteger c = new AtomicInteger();
  
  f$a(f paramf, c paramc)
  {
    this.a = paramc;
  }
  
  void a(int paramInt)
  {
    this.b.set(paramInt);
  }
  
  public void a(p.c paramc)
  {
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
    p.a.a(paramc, new f.a.1(this));
  }
  
  public void a(String paramString)
  {
    this.a.a(this.b.get(), this.d.b("ok"));
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.a(this.b.get(), this.d.b("fail"));
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
  }
  
  void b(int paramInt)
  {
    this.c.set(paramInt);
  }
  
  public void b(p.c paramc)
  {
    a.b(this.a, paramc);
  }
  
  public void b(String paramString)
  {
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
    this.a.a(this.c.get(), this.d.b("ok"));
    a.a(this.a);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.a.a(this.c.get(), this.d.b("fail"));
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.f.a
 * JD-Core Version:    0.7.0.1
 */