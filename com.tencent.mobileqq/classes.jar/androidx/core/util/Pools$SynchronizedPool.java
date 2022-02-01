package androidx.core.util;

import androidx.annotation.NonNull;

public class Pools$SynchronizedPool<T>
  extends Pools.SimplePool<T>
{
  private final Object mLock = new Object();
  
  public Pools$SynchronizedPool(int paramInt)
  {
    super(paramInt);
  }
  
  public T acquire()
  {
    synchronized (this.mLock)
    {
      Object localObject2 = super.acquire();
      return localObject2;
    }
  }
  
  public boolean release(@NonNull T paramT)
  {
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramT);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.util.Pools.SynchronizedPool
 * JD-Core Version:    0.7.0.1
 */