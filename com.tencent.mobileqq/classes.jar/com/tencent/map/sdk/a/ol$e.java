package com.tencent.map.sdk.a;

import java.util.concurrent.Callable;

public abstract class ol$e<T>
  implements Runnable, Callable<T>
{
  private ol.a<T> a;
  
  public final void run()
  {
    try
    {
      Object localObject = call();
      if (this.a != null) {
        this.a.a(localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.e
 * JD-Core Version:    0.7.0.1
 */