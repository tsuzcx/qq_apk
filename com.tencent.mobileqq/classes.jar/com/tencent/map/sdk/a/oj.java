package com.tencent.map.sdk.a;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public abstract class oj<D extends nz>
  implements ny<D>, oh<D>
{
  private ReentrantReadWriteLock a = new ReentrantReadWriteLock();
  
  public final D b(String paramString, Class<D> paramClass)
  {
    try
    {
      this.a.readLock().lock();
      paramString = a(paramString, paramClass);
      return paramString;
    }
    finally
    {
      this.a.readLock().unlock();
    }
  }
  
  public final void b(String paramString, D paramD)
  {
    try
    {
      this.a.writeLock().lock();
      a(paramString, paramD);
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public final void e()
  {
    try
    {
      this.a.writeLock().lock();
      a();
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public final oh<D> f()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oj
 * JD-Core Version:    0.7.0.1
 */