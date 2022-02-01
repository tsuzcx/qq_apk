package com.tencent.luggage.wxa.jt;

import rx.Observable;
import rx.Observable.Transformer;
import rx.schedulers.Schedulers;

class b$1
  implements Observable.Transformer<T, T>
{
  b$1(b paramb) {}
  
  public Observable<T> a(Observable<T> paramObservable)
  {
    return paramObservable.subscribeOn(Schedulers.io()).observeOn(a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jt.b.1
 * JD-Core Version:    0.7.0.1
 */