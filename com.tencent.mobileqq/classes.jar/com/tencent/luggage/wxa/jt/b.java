package com.tencent.luggage.wxa.jt;

import rx.Observable.Transformer;

public abstract class b<T>
{
  private final Observable.Transformer<T, T> a = new b.1(this);
  
  public Observable.Transformer<T, T> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jt.b
 * JD-Core Version:    0.7.0.1
 */