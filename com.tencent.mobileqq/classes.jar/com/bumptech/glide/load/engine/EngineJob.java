package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EngineJob<R>
  implements DecodeJob.Callback<R>, FactoryPools.Poolable
{
  private static final EngineJob.EngineResourceFactory a = new EngineJob.EngineResourceFactory();
  private static final Handler b = new Handler(Looper.getMainLooper(), new EngineJob.MainThreadCallback());
  private final List<ResourceCallback> c = new ArrayList(2);
  private final StateVerifier d = StateVerifier.a();
  private final Pools.Pool<EngineJob<?>> e;
  private final EngineJob.EngineResourceFactory f;
  private final EngineJobListener g;
  private final GlideExecutor h;
  private final GlideExecutor i;
  private final GlideExecutor j;
  private final GlideExecutor k;
  private Key l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private Resource<?> q;
  private DataSource r;
  private boolean s;
  private GlideException t;
  private boolean u;
  private List<ResourceCallback> v;
  private EngineResource<?> w;
  private DecodeJob<R> x;
  private volatile boolean y;
  
  EngineJob(GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, EngineJobListener paramEngineJobListener, Pools.Pool<EngineJob<?>> paramPool)
  {
    this(paramGlideExecutor1, paramGlideExecutor2, paramGlideExecutor3, paramGlideExecutor4, paramEngineJobListener, paramPool, a);
  }
  
  @VisibleForTesting
  EngineJob(GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, EngineJobListener paramEngineJobListener, Pools.Pool<EngineJob<?>> paramPool, EngineJob.EngineResourceFactory paramEngineResourceFactory)
  {
    this.h = paramGlideExecutor1;
    this.i = paramGlideExecutor2;
    this.j = paramGlideExecutor3;
    this.k = paramGlideExecutor4;
    this.g = paramEngineJobListener;
    this.e = paramPool;
    this.f = paramEngineResourceFactory;
  }
  
  private void a(boolean paramBoolean)
  {
    Util.a();
    this.c.clear();
    this.l = null;
    this.w = null;
    this.q = null;
    List localList = this.v;
    if (localList != null) {
      localList.clear();
    }
    this.u = false;
    this.y = false;
    this.s = false;
    this.x.a(paramBoolean);
    this.x = null;
    this.t = null;
    this.r = null;
    this.e.release(this);
  }
  
  private void c(ResourceCallback paramResourceCallback)
  {
    if (this.v == null) {
      this.v = new ArrayList(2);
    }
    if (!this.v.contains(paramResourceCallback)) {
      this.v.add(paramResourceCallback);
    }
  }
  
  private boolean d(ResourceCallback paramResourceCallback)
  {
    List localList = this.v;
    return (localList != null) && (localList.contains(paramResourceCallback));
  }
  
  private GlideExecutor g()
  {
    if (this.n) {
      return this.j;
    }
    if (this.o) {
      return this.k;
    }
    return this.i;
  }
  
  @NonNull
  public StateVerifier E_()
  {
    return this.d;
  }
  
  @VisibleForTesting
  EngineJob<R> a(Key paramKey, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.l = paramKey;
    this.m = paramBoolean1;
    this.n = paramBoolean2;
    this.o = paramBoolean3;
    this.p = paramBoolean4;
    return this;
  }
  
  public void a(DecodeJob<?> paramDecodeJob)
  {
    g().execute(paramDecodeJob);
  }
  
  public void a(GlideException paramGlideException)
  {
    this.t = paramGlideException;
    b.obtainMessage(2, this).sendToTarget();
  }
  
  public void a(Resource<R> paramResource, DataSource paramDataSource)
  {
    this.q = paramResource;
    this.r = paramDataSource;
    b.obtainMessage(1, this).sendToTarget();
  }
  
  void a(ResourceCallback paramResourceCallback)
  {
    Util.a();
    this.d.b();
    if (this.s)
    {
      paramResourceCallback.a(this.w, this.r);
      return;
    }
    if (this.u)
    {
      paramResourceCallback.a(this.t);
      return;
    }
    this.c.add(paramResourceCallback);
  }
  
  boolean a()
  {
    return this.p;
  }
  
  void b()
  {
    if ((!this.u) && (!this.s))
    {
      if (this.y) {
        return;
      }
      this.y = true;
      this.x.b();
      this.g.a(this, this.l);
    }
  }
  
  public void b(DecodeJob<R> paramDecodeJob)
  {
    this.x = paramDecodeJob;
    GlideExecutor localGlideExecutor;
    if (paramDecodeJob.a()) {
      localGlideExecutor = this.h;
    } else {
      localGlideExecutor = g();
    }
    localGlideExecutor.execute(paramDecodeJob);
  }
  
  void b(ResourceCallback paramResourceCallback)
  {
    Util.a();
    this.d.b();
    if ((!this.s) && (!this.u))
    {
      this.c.remove(paramResourceCallback);
      if (this.c.isEmpty()) {
        b();
      }
    }
    else
    {
      c(paramResourceCallback);
    }
  }
  
  void c()
  {
    this.d.b();
    if (this.y)
    {
      this.q.f();
      a(false);
      return;
    }
    if (!this.c.isEmpty())
    {
      if (!this.s)
      {
        this.w = this.f.a(this.q, this.m);
        this.s = true;
        this.w.g();
        this.g.a(this, this.l, this.w);
        int i2 = this.c.size();
        int i1 = 0;
        while (i1 < i2)
        {
          localObject = (ResourceCallback)this.c.get(i1);
          if (!d((ResourceCallback)localObject))
          {
            this.w.g();
            ((ResourceCallback)localObject).a(this.w, this.r);
          }
          i1 += 1;
        }
        this.w.h();
        a(false);
        return;
      }
      throw new IllegalStateException("Already have resource");
    }
    Object localObject = new IllegalStateException("Received a resource without any callbacks to notify");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  void e()
  {
    this.d.b();
    if (this.y)
    {
      this.g.a(this, this.l);
      a(false);
      return;
    }
    throw new IllegalStateException("Not cancelled");
  }
  
  void f()
  {
    this.d.b();
    if (this.y)
    {
      a(false);
      return;
    }
    if (!this.c.isEmpty())
    {
      if (!this.u)
      {
        this.u = true;
        this.g.a(this, this.l, null);
        localObject = this.c.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ResourceCallback localResourceCallback = (ResourceCallback)((Iterator)localObject).next();
          if (!d(localResourceCallback)) {
            localResourceCallback.a(this.t);
          }
        }
        a(false);
        return;
      }
      throw new IllegalStateException("Already failed once");
    }
    Object localObject = new IllegalStateException("Received an exception without any callbacks to notify");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.EngineJob
 * JD-Core Version:    0.7.0.1
 */