package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.qz.o;

class e$1
  extends c.c
{
  e$1(e parame, c paramc, String paramString) {}
  
  public void a(c.d paramd)
  {
    o.d("MicroMsg.JsApiStartPlayVoice", "onPause");
    this.a.a();
  }
  
  public void b()
  {
    o.d("MicroMsg.JsApiStartPlayVoice", "onResume");
    this.a.b();
  }
  
  public void c()
  {
    o.d("MicroMsg.JsApiStartPlayVoice", "onDestroy");
    com.tencent.luggage.wxa.iu.c.b(this.b, e.a(this.c));
    e.a(this.c, null);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.e.1
 * JD-Core Version:    0.7.0.1
 */