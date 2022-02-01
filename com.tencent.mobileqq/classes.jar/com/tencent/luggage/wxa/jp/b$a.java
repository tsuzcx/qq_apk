package com.tencent.luggage.wxa.jp;

import rx.Observable;

public class b$a
  extends com.tencent.luggage.wxa.jt.b<com.tencent.luggage.wxa.jo.b>
{
  private com.tencent.luggage.wxa.jr.b a;
  private a b;
  
  public b$a(com.tencent.luggage.wxa.jr.b paramb)
  {
    this.a = paramb;
    this.b = a.a();
  }
  
  public Observable<com.tencent.luggage.wxa.jo.b> a()
  {
    return this.b.a(this.a).compose(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.b.a
 * JD-Core Version:    0.7.0.1
 */