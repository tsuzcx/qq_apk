package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.qz.o;

class g$1
  extends c.c
{
  g$1(g paramg, e parame, String paramString) {}
  
  public void a(c.d paramd)
  {
    o.d("MicroMsg.JsApiOperateRecorder", "onPause");
    this.a.d();
  }
  
  public void b()
  {
    o.d("MicroMsg.JsApiOperateRecorder", "onResume");
    this.a.e();
  }
  
  public void c()
  {
    o.d("MicroMsg.JsApiOperateRecorder", "onDestroy");
    c.b(this.b, g.a(this.c));
    g.a(this.c, null);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.g.1
 * JD-Core Version:    0.7.0.1
 */