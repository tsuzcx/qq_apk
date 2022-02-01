package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;

class o$1
  extends c.c
{
  o$1(o paramo, com.tencent.luggage.wxa.jx.c paramc) {}
  
  public void a(c.d paramd)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "onPause");
    if (o.a(this.b)) {
      o.b(this.b);
    }
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "onResume");
    if (o.c()) {
      o.c(this.b);
    }
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
    if (o.a(this.b)) {
      o.b(this.b);
    }
    com.tencent.luggage.wxa.iu.c.b(this.a.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.o.1
 * JD-Core Version:    0.7.0.1
 */