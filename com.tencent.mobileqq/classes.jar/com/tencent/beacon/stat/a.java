package com.tencent.beacon.stat;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a<T>
{
  private Lock a = new ReentrantLock();
  private Condition b = this.a.newCondition();
  private volatile T c;
  
  public final T a()
  {
    this.a.lock();
    try
    {
      while (this.c == null) {
        this.b.await();
      }
      localObject2 = this.c;
    }
    finally
    {
      this.a.unlock();
    }
    Object localObject2;
    this.a.unlock();
    return localObject2;
  }
  
  public final void a(T paramT)
  {
    this.a.lock();
    try
    {
      this.c = paramT;
      if (paramT != null) {
        this.b.signal();
      }
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public final T b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.a
 * JD-Core Version:    0.7.0.1
 */