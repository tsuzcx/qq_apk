package com.tencent.liteav.basic.util;

import java.lang.ref.WeakReference;

public class a<T>
{
  private final ThreadLocal<T> a = new ThreadLocal();
  private final a.a<T> b;
  private WeakReference<T> c = new WeakReference(null);
  
  public a(a.a<T> parama)
  {
    this.b = parama;
  }
  
  private T b()
  {
    Object localObject1 = this.c.get();
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.c.get();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.b.a();
          this.c = new WeakReference(localObject1);
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
  
  public T a()
  {
    Object localObject2 = this.a.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = b();
      this.a.set(localObject1);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.a
 * JD-Core Version:    0.7.0.1
 */