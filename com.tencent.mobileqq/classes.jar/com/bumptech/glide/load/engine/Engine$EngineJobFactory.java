package com.bumptech.glide.load.engine;

import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;

@VisibleForTesting
class Engine$EngineJobFactory
{
  final GlideExecutor a;
  final GlideExecutor b;
  final GlideExecutor c;
  final GlideExecutor d;
  final EngineJobListener e;
  final Pools.Pool<EngineJob<?>> f = FactoryPools.a(150, new Engine.EngineJobFactory.1(this));
  
  Engine$EngineJobFactory(GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, EngineJobListener paramEngineJobListener)
  {
    this.a = paramGlideExecutor1;
    this.b = paramGlideExecutor2;
    this.c = paramGlideExecutor3;
    this.d = paramGlideExecutor4;
    this.e = paramEngineJobListener;
  }
  
  <R> EngineJob<R> a(Key paramKey, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return ((EngineJob)Preconditions.a((EngineJob)this.f.acquire())).a(paramKey, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Engine.EngineJobFactory
 * JD-Core Version:    0.7.0.1
 */