package com.bumptech.glide.load.engine;

import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;

@VisibleForTesting
class Engine$DecodeJobFactory
{
  final DecodeJob.DiskCacheProvider a;
  final Pools.Pool<DecodeJob<?>> b = FactoryPools.a(150, new Engine.DecodeJobFactory.1(this));
  private int c;
  
  Engine$DecodeJobFactory(DecodeJob.DiskCacheProvider paramDiskCacheProvider)
  {
    this.a = paramDiskCacheProvider;
  }
  
  <R> DecodeJob<R> a(GlideContext paramGlideContext, Object paramObject, EngineKey paramEngineKey, Key paramKey, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, DiskCacheStrategy paramDiskCacheStrategy, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Options paramOptions, DecodeJob.Callback<R> paramCallback)
  {
    DecodeJob localDecodeJob = (DecodeJob)Preconditions.a((DecodeJob)this.b.acquire());
    int i = this.c;
    this.c = (i + 1);
    return localDecodeJob.a(paramGlideContext, paramObject, paramEngineKey, paramKey, paramInt1, paramInt2, paramClass, paramClass1, paramPriority, paramDiskCacheStrategy, paramMap, paramBoolean1, paramBoolean2, paramBoolean3, paramOptions, paramCallback, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Engine.DecodeJobFactory
 * JD-Core Version:    0.7.0.1
 */