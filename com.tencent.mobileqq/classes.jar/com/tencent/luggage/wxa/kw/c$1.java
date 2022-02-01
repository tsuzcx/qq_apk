package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pp.o;

class c$1
  implements Runnable
{
  c$1(c paramc, com.tencent.luggage.wxa.jx.c paramc1, Integer paramInteger, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    String str;
    if (o.a(c.a(this.d, this.a), this.b)) {
      str = "ok";
    } else {
      str = "fail:input not exists";
    }
    this.a.a(this.c, this.d.b(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.c.1
 * JD-Core Version:    0.7.0.1
 */