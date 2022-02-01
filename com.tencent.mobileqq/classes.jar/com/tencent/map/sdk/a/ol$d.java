package com.tencent.map.sdk.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class ol$d<T>
  implements ol.c<T>
{
  T a;
  
  public ol$d(T paramT)
  {
    this.a = paramT;
  }
  
  public final Future<T> a(ol.e<T> parame)
  {
    return ol.b().submit(parame, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.d
 * JD-Core Version:    0.7.0.1
 */