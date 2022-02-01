package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.qz.o;

class h$1
  extends c.c
{
  h$1(h paramh, e parame, String paramString) {}
  
  public void a(c.d paramd)
  {
    o.d("MicroMsg.JsApiStartRecordVoice", "onPause");
    this.a.d();
  }
  
  public void b()
  {
    o.d("MicroMsg.JsApiStartRecordVoice", "onResume");
    this.a.e();
  }
  
  public void c()
  {
    o.d("MicroMsg.JsApiStartRecordVoice", "onDestroy");
    c.b(this.b, h.a(this.c));
    h.a(this.c, null);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.h.1
 * JD-Core Version:    0.7.0.1
 */