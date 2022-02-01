package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jn.d;
import rx.Observable;

public class a
{
  private static a a;
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public Observable<Void> a(d paramd)
  {
    return Observable.create(new a.2(this, paramd));
  }
  
  public Observable<com.tencent.luggage.wxa.jr.e> a(com.tencent.luggage.wxa.jn.e parame)
  {
    return Observable.create(new a.3(this, parame));
  }
  
  public Observable<com.tencent.luggage.wxa.jo.b> a(com.tencent.luggage.wxa.jr.b paramb)
  {
    return Observable.create(new a.1(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.a
 * JD-Core Version:    0.7.0.1
 */