package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

class EngineResource<Z>
  implements Resource<Z>
{
  private final boolean a;
  private final boolean b;
  private EngineResource.ResourceListener c;
  private Key d;
  private int e;
  private boolean f;
  private final Resource<Z> g;
  
  EngineResource(Resource<Z> paramResource, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.g = ((Resource)Preconditions.a(paramResource));
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  Resource<Z> a()
  {
    return this.g;
  }
  
  void a(Key paramKey, EngineResource.ResourceListener paramResourceListener)
  {
    this.d = paramKey;
    this.c = paramResourceListener;
  }
  
  boolean b()
  {
    return this.a;
  }
  
  @NonNull
  public Class<Z> c()
  {
    return this.g.c();
  }
  
  @NonNull
  public Z d()
  {
    return this.g.d();
  }
  
  public int e()
  {
    return this.g.e();
  }
  
  public void f()
  {
    if (this.e <= 0)
    {
      if (!this.f)
      {
        this.f = true;
        if (this.b) {
          this.g.f();
        }
        return;
      }
      throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
    }
    throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
  }
  
  void g()
  {
    if (!this.f)
    {
      if (Looper.getMainLooper().equals(Looper.myLooper()))
      {
        this.e += 1;
        return;
      }
      throw new IllegalThreadStateException("Must call acquire on the main thread");
    }
    throw new IllegalStateException("Cannot acquire a recycled resource");
  }
  
  void h()
  {
    if (this.e > 0)
    {
      if (Looper.getMainLooper().equals(Looper.myLooper()))
      {
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
          this.c.a(this.d, this);
        }
        return;
      }
      throw new IllegalThreadStateException("Must call release on the main thread");
    }
    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineResource{isCacheable=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", listener=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", acquired=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isRecycled=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", resource=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.EngineResource
 * JD-Core Version:    0.7.0.1
 */