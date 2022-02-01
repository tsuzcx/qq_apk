package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z>
  implements Resource<Z>, FactoryPools.Poolable
{
  private static final Pools.Pool<LockedResource<?>> a = FactoryPools.b(20, new LockedResource.1());
  private final StateVerifier b = StateVerifier.a();
  private Resource<Z> c;
  private boolean d;
  private boolean e;
  
  @NonNull
  static <Z> LockedResource<Z> a(Resource<Z> paramResource)
  {
    LockedResource localLockedResource = (LockedResource)Preconditions.a((LockedResource)a.acquire());
    localLockedResource.b(paramResource);
    return localLockedResource;
  }
  
  private void b()
  {
    this.c = null;
    a.release(this);
  }
  
  private void b(Resource<Z> paramResource)
  {
    this.e = false;
    this.d = true;
    this.c = paramResource;
  }
  
  @NonNull
  public StateVerifier E_()
  {
    return this.b;
  }
  
  void a()
  {
    try
    {
      this.b.b();
      if (this.d)
      {
        this.d = false;
        if (this.e) {
          f();
        }
        return;
      }
      throw new IllegalStateException("Already unlocked");
    }
    finally {}
  }
  
  @NonNull
  public Class<Z> c()
  {
    return this.c.c();
  }
  
  @NonNull
  public Z d()
  {
    return this.c.d();
  }
  
  public int e()
  {
    return this.c.e();
  }
  
  public void f()
  {
    try
    {
      this.b.b();
      this.e = true;
      if (!this.d)
      {
        this.c.f();
        b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.LockedResource
 * JD-Core Version:    0.7.0.1
 */