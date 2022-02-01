package com.bumptech.glide.util.pool;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import java.util.List;

public final class FactoryPools
{
  private static final FactoryPools.Resetter<Object> a = new FactoryPools.1();
  
  @NonNull
  public static <T> Pools.Pool<List<T>> a()
  {
    return a(20);
  }
  
  @NonNull
  public static <T> Pools.Pool<List<T>> a(int paramInt)
  {
    return a(new Pools.SynchronizedPool(paramInt), new FactoryPools.2(), new FactoryPools.3());
  }
  
  @NonNull
  public static <T extends FactoryPools.Poolable> Pools.Pool<T> a(int paramInt, @NonNull FactoryPools.Factory<T> paramFactory)
  {
    return a(new Pools.SimplePool(paramInt), paramFactory);
  }
  
  @NonNull
  private static <T extends FactoryPools.Poolable> Pools.Pool<T> a(@NonNull Pools.Pool<T> paramPool, @NonNull FactoryPools.Factory<T> paramFactory)
  {
    return a(paramPool, paramFactory, b());
  }
  
  @NonNull
  private static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> paramPool, @NonNull FactoryPools.Factory<T> paramFactory, @NonNull FactoryPools.Resetter<T> paramResetter)
  {
    return new FactoryPools.FactoryPool(paramPool, paramFactory, paramResetter);
  }
  
  @NonNull
  public static <T extends FactoryPools.Poolable> Pools.Pool<T> b(int paramInt, @NonNull FactoryPools.Factory<T> paramFactory)
  {
    return a(new Pools.SynchronizedPool(paramInt), paramFactory);
  }
  
  @NonNull
  private static <T> FactoryPools.Resetter<T> b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.pool.FactoryPools
 * JD-Core Version:    0.7.0.1
 */