package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jn.d;
import com.tencent.luggage.wxa.jt.b;
import rx.Observable;

public class b$c
  extends b<Void>
{
  private d a;
  private a b;
  
  public b$c(d paramd)
  {
    this.a = paramd;
    this.b = a.a();
  }
  
  public Observable<Void> a()
  {
    return this.b.a(this.a).compose(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.b.c
 * JD-Core Version:    0.7.0.1
 */