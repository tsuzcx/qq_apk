package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.util.Map;

public class Engine
  implements EngineJobListener, EngineResource.ResourceListener, MemoryCache.ResourceRemovedListener
{
  private static final boolean a = Log.isLoggable("Engine", 2);
  private final Jobs b;
  private final EngineKeyFactory c;
  private final MemoryCache d;
  private final Engine.EngineJobFactory e;
  private final ResourceRecycler f;
  private final Engine.LazyDiskCacheProvider g;
  private final Engine.DecodeJobFactory h;
  private final ActiveResources i;
  
  @VisibleForTesting
  Engine(MemoryCache paramMemoryCache, DiskCache.Factory paramFactory, GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, Jobs paramJobs, EngineKeyFactory paramEngineKeyFactory, ActiveResources paramActiveResources, Engine.EngineJobFactory paramEngineJobFactory, Engine.DecodeJobFactory paramDecodeJobFactory, ResourceRecycler paramResourceRecycler, boolean paramBoolean)
  {
    this.d = paramMemoryCache;
    this.g = new Engine.LazyDiskCacheProvider(paramFactory);
    if (paramActiveResources == null) {
      paramActiveResources = new ActiveResources(paramBoolean);
    }
    this.i = paramActiveResources;
    paramActiveResources.a(this);
    if (paramEngineKeyFactory == null) {
      paramEngineKeyFactory = new EngineKeyFactory();
    }
    this.c = paramEngineKeyFactory;
    if (paramJobs == null) {
      paramJobs = new Jobs();
    }
    this.b = paramJobs;
    if (paramEngineJobFactory == null) {
      paramEngineJobFactory = new Engine.EngineJobFactory(paramGlideExecutor1, paramGlideExecutor2, paramGlideExecutor3, paramGlideExecutor4, this);
    }
    this.e = paramEngineJobFactory;
    if (paramDecodeJobFactory == null) {
      paramDecodeJobFactory = new Engine.DecodeJobFactory(this.g);
    }
    this.h = paramDecodeJobFactory;
    if (paramResourceRecycler == null) {
      paramResourceRecycler = new ResourceRecycler();
    }
    this.f = paramResourceRecycler;
    paramMemoryCache.a(this);
  }
  
  public Engine(MemoryCache paramMemoryCache, DiskCache.Factory paramFactory, GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, boolean paramBoolean)
  {
    this(paramMemoryCache, paramFactory, paramGlideExecutor1, paramGlideExecutor2, paramGlideExecutor3, paramGlideExecutor4, null, null, null, null, null, null, paramBoolean);
  }
  
  private EngineResource<?> a(Key paramKey)
  {
    paramKey = this.d.a(paramKey);
    if (paramKey == null) {
      return null;
    }
    if ((paramKey instanceof EngineResource)) {
      return (EngineResource)paramKey;
    }
    return new EngineResource(paramKey, true, true);
  }
  
  @Nullable
  private EngineResource<?> a(Key paramKey, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return null;
    }
    paramKey = this.i.b(paramKey);
    if (paramKey != null) {
      paramKey.g();
    }
    return paramKey;
  }
  
  private static void a(String paramString, long paramLong, Key paramKey)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" in ");
    localStringBuilder.append(LogTime.a(paramLong));
    localStringBuilder.append("ms, key: ");
    localStringBuilder.append(paramKey);
    Log.v("Engine", localStringBuilder.toString());
  }
  
  private EngineResource<?> b(Key paramKey, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return null;
    }
    EngineResource localEngineResource = a(paramKey);
    if (localEngineResource != null)
    {
      localEngineResource.g();
      this.i.a(paramKey, localEngineResource);
    }
    return localEngineResource;
  }
  
  public <R> Engine.LoadStatus a(GlideContext paramGlideContext, Object paramObject, Key paramKey, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, DiskCacheStrategy paramDiskCacheStrategy, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, Options paramOptions, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ResourceCallback paramResourceCallback)
  {
    
    long l;
    if (a) {
      l = LogTime.a();
    } else {
      l = 0L;
    }
    EngineKey localEngineKey = this.c.a(paramObject, paramKey, paramInt1, paramInt2, paramMap, paramClass, paramClass1, paramOptions);
    Object localObject = a(localEngineKey, paramBoolean3);
    if (localObject != null)
    {
      paramResourceCallback.a((Resource)localObject, DataSource.MEMORY_CACHE);
      if (a) {
        a("Loaded resource from active resources", l, localEngineKey);
      }
      return null;
    }
    localObject = b(localEngineKey, paramBoolean3);
    if (localObject != null)
    {
      paramResourceCallback.a((Resource)localObject, DataSource.MEMORY_CACHE);
      if (a) {
        a("Loaded resource from cache", l, localEngineKey);
      }
      return null;
    }
    localObject = this.b.a(localEngineKey, paramBoolean6);
    if (localObject != null)
    {
      ((EngineJob)localObject).a(paramResourceCallback);
      if (a) {
        a("Added to existing load", l, localEngineKey);
      }
      return new Engine.LoadStatus(paramResourceCallback, (EngineJob)localObject);
    }
    localObject = this.e.a(localEngineKey, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
    paramGlideContext = this.h.a(paramGlideContext, paramObject, localEngineKey, paramKey, paramInt1, paramInt2, paramClass, paramClass1, paramPriority, paramDiskCacheStrategy, paramMap, paramBoolean1, paramBoolean2, paramBoolean6, paramOptions, (DecodeJob.Callback)localObject);
    this.b.a(localEngineKey, (EngineJob)localObject);
    ((EngineJob)localObject).a(paramResourceCallback);
    ((EngineJob)localObject).b(paramGlideContext);
    if (a) {
      a("Started new load", l, localEngineKey);
    }
    return new Engine.LoadStatus(paramResourceCallback, (EngineJob)localObject);
  }
  
  public void a(Key paramKey, EngineResource<?> paramEngineResource)
  {
    Util.a();
    this.i.a(paramKey);
    if (paramEngineResource.b())
    {
      this.d.b(paramKey, paramEngineResource);
      return;
    }
    this.f.a(paramEngineResource);
  }
  
  public void a(EngineJob<?> paramEngineJob, Key paramKey)
  {
    Util.a();
    this.b.b(paramKey, paramEngineJob);
  }
  
  public void a(EngineJob<?> paramEngineJob, Key paramKey, EngineResource<?> paramEngineResource)
  {
    
    if (paramEngineResource != null)
    {
      paramEngineResource.a(paramKey, this);
      if (paramEngineResource.b()) {
        this.i.a(paramKey, paramEngineResource);
      }
    }
    this.b.b(paramKey, paramEngineJob);
  }
  
  public void a(Resource<?> paramResource)
  {
    
    if ((paramResource instanceof EngineResource))
    {
      ((EngineResource)paramResource).h();
      return;
    }
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  public void b(@NonNull Resource<?> paramResource)
  {
    Util.a();
    this.f.a(paramResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Engine
 * JD-Core Version:    0.7.0.1
 */