package com.tencent.luggage.wxa.kv;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.o;

class d$2
  extends c.c
{
  d$2(d paramd, com.tencent.luggage.wxa.jx.c paramc) {}
  
  public void c()
  {
    o.d("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
    com.tencent.luggage.wxa.iu.c.b(this.a.getAppId(), this);
    a.a locala = a.a(this.a.getAppId());
    if (locala != null)
    {
      locala.c();
      a.b(this.a.getAppId());
    }
    d.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.d.2
 * JD-Core Version:    0.7.0.1
 */