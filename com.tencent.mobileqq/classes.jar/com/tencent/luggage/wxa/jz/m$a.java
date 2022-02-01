package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class m$a
  extends a
{
  public com.tencent.luggage.wxa.jx.c a;
  public String b = "";
  public String c;
  public int d;
  private String e;
  private com.tencent.luggage.wxa.qy.c f = new m.a.1(this);
  
  public m$a(com.tencent.luggage.wxa.jx.c paramc)
  {
    this.a = paramc;
  }
  
  public void c()
  {
    if (this.a == null)
    {
      o.b("MicroMsg.Audio.JsApiSetAudioState", "server is null");
      return;
    }
    o.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.d), this.c });
    if (af.c(this.c))
    {
      o.b("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
      return;
    }
    new m.b().b(this.a).b(this.c).a(c.a.a(this.b).a(this.e));
  }
  
  public void d()
  {
    o.e("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
    com.tencent.luggage.wxa.nq.a.d(this.b);
    com.tencent.luggage.wxa.nq.a.a(this.b, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.m.a
 * JD-Core Version:    0.7.0.1
 */