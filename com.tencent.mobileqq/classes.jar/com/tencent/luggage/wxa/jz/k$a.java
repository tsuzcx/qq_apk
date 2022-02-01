package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.if.c.a;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.v.a;

final class k$a
  extends a
{
  public com.tencent.luggage.wxa.jx.c a;
  public int b;
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public String g;
  public v.a h;
  public String i = "";
  public String j = "";
  public long k;
  public long l;
  public boolean m = false;
  public String n;
  private m o;
  
  public k$a(m paramm, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    this.o = paramm;
    this.a = paramc;
    this.b = paramInt;
  }
  
  public void c()
  {
    super.c();
    com.tencent.luggage.wxa.jx.c localc = this.a;
    if (localc == null)
    {
      o.b("MicroMsg.Audio.JsApiOperateAudio", "server is null");
      return;
    }
    if (this.m)
    {
      int i1 = this.b;
      m localm = this.o;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      localStringBuilder.append(this.n);
      localc.a(i1, localm.b(localStringBuilder.toString()));
      return;
    }
    localc.a(this.b, this.o.b("ok"));
  }
  
  public void d()
  {
    o.d("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.e });
    this.m = false;
    Object localObject = this.e;
    if (((String)localObject).equalsIgnoreCase("play"))
    {
      com.tencent.luggage.wxa.if.b localb = com.tencent.luggage.wxa.if.c.k(this.d);
      localObject = localb;
      if (localb == null)
      {
        o.b("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
        localObject = com.tencent.luggage.wxa.nq.b.a(this.a, this.c, this.d, this.j, this.g, this.h, this.i);
      }
      if (localObject != null)
      {
        ((com.tencent.luggage.wxa.if.b)localObject).t = this.k;
        ((com.tencent.luggage.wxa.if.b)localObject).u = this.l;
      }
      if (c.a.a(this.d, (com.tencent.luggage.wxa.if.b)localObject))
      {
        o.d("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
      }
      else if (com.tencent.luggage.wxa.if.c.d(this.d))
      {
        this.m = true;
        this.n = "audio is playing, don't play again";
      }
      else
      {
        this.m = true;
        this.n = "play audio fail";
      }
    }
    else if (((String)localObject).equalsIgnoreCase("pause"))
    {
      if (c.a.a(this.d))
      {
        o.d("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
      }
      else
      {
        this.m = true;
        this.n = "pause audio fail";
      }
    }
    else if (((String)localObject).equalsIgnoreCase("seek"))
    {
      o.d("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.f) });
      int i1 = this.f;
      if (i1 < 0)
      {
        o.b("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(i1) });
        this.m = true;
        this.n = "currentTime is invalid";
      }
      else if (c.a.a(this.d, i1))
      {
        o.d("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
      }
      else
      {
        this.m = true;
        this.n = "seek audio fail";
      }
    }
    else if (((String)localObject).equalsIgnoreCase("stop"))
    {
      if (c.a.b(this.d))
      {
        o.d("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
      }
      else
      {
        this.m = true;
        this.n = "stop audio fail";
      }
    }
    else
    {
      o.b("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
      this.m = true;
      this.n = "operationType is invalid";
    }
    if (this.m) {
      o.b("MicroMsg.Audio.JsApiOperateAudio", this.n);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.k.a
 * JD-Core Version:    0.7.0.1
 */