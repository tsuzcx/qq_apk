package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jt.b;
import rx.Observable;

public class b$b
  extends b<com.tencent.luggage.wxa.jr.e>
{
  private com.tencent.luggage.wxa.jn.e a;
  private a b;
  
  public b$b(com.tencent.luggage.wxa.jn.e parame)
  {
    this.a = parame;
    this.b = a.a();
  }
  
  public Observable<com.tencent.luggage.wxa.jr.e> a()
  {
    return this.b.a(this.a).compose(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.b.b
 * JD-Core Version:    0.7.0.1
 */