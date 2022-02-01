package com.tencent.luggage.wxa.bw;

import androidx.core.util.Pools.Pool;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b<T>
  implements Pools.Pool<T>
{
  private ConcurrentLinkedQueue<T> a = new ConcurrentLinkedQueue();
  
  public T acquire()
  {
    Object localObject2 = this.a.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b();
    }
    return localObject1;
  }
  
  protected abstract T b();
  
  public void c()
  {
    this.a.clear();
  }
  
  public boolean release(T paramT)
  {
    return this.a.offer(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bw.b
 * JD-Core Version:    0.7.0.1
 */