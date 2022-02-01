package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.nz.p.a;
import com.tencent.luggage.wxa.nz.p.c;
import com.tencent.luggage.wxa.qz.o;

class f$a$1
  implements p.a
{
  f$a$1(f.a parama) {}
  
  public void a(p.c paramc)
  {
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
    a.a(this.a.a, paramc);
  }
  
  public void a(p.c paramc, int paramInt)
  {
    o.d("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
    a.c(this.a.a, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.f.a.1
 * JD-Core Version:    0.7.0.1
 */