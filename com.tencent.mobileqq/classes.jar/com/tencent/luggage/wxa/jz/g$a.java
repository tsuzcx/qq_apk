package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;

class g$a
  extends a
{
  public com.tencent.luggage.wxa.jx.c a;
  public int b;
  public String c = "";
  public String d = "";
  public boolean e = false;
  private m f;
  
  public g$a(m paramm, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    this.f = paramm;
    this.a = paramc;
    this.b = paramInt;
  }
  
  public void c()
  {
    super.c();
    o.d("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    com.tencent.luggage.wxa.jx.c localc = this.a;
    if (localc == null)
    {
      o.b("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      return;
    }
    if (this.e)
    {
      localc.a(this.b, this.f.b("fail"));
      return;
    }
    localc.a(this.b, this.f.b("ok"));
  }
  
  public void d()
  {
    o.d("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    this.e = com.tencent.luggage.wxa.if.c.c(this.d);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.g.a
 * JD-Core Version:    0.7.0.1
 */