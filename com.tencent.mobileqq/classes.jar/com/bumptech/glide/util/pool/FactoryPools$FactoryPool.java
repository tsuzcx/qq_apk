package com.bumptech.glide.util.pool;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.util.Log;

final class FactoryPools$FactoryPool<T>
  implements Pools.Pool<T>
{
  private final FactoryPools.Factory<T> a;
  private final FactoryPools.Resetter<T> b;
  private final Pools.Pool<T> c;
  
  FactoryPools$FactoryPool(@NonNull Pools.Pool<T> paramPool, @NonNull FactoryPools.Factory<T> paramFactory, @NonNull FactoryPools.Resetter<T> paramResetter)
  {
    this.c = paramPool;
    this.a = paramFactory;
    this.b = paramResetter;
  }
  
  public T acquire()
  {
    Object localObject2 = this.c.acquire();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.a.b();
      localObject1 = localObject2;
      if (Log.isLoggable("FactoryPools", 2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Created new ");
        ((StringBuilder)localObject1).append(localObject2.getClass());
        Log.v("FactoryPools", ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if ((localObject1 instanceof FactoryPools.Poolable)) {
      ((FactoryPools.Poolable)localObject1).E_().a(false);
    }
    return localObject1;
  }
  
  public boolean release(@NonNull T paramT)
  {
    if ((paramT instanceof FactoryPools.Poolable)) {
      ((FactoryPools.Poolable)paramT).E_().a(true);
    }
    this.b.a(paramT);
    return this.c.release(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.pool.FactoryPools.FactoryPool
 * JD-Core Version:    0.7.0.1
 */