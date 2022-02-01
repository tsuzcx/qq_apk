package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;

public final class GlideBuilder
{
  private final Map<Class<?>, TransitionOptions<?, ?>> a = new ArrayMap();
  private Engine b;
  private BitmapPool c;
  private ArrayPool d;
  private MemoryCache e;
  private GlideExecutor f;
  private GlideExecutor g;
  private DiskCache.Factory h;
  private MemorySizeCalculator i;
  private ConnectivityMonitorFactory j;
  private int k = 4;
  private RequestOptions l = new RequestOptions();
  @Nullable
  private RequestManagerRetriever.RequestManagerFactory m;
  private GlideExecutor n;
  private boolean o;
  
  @NonNull
  Glide a(@NonNull Context paramContext)
  {
    if (this.f == null) {
      this.f = GlideExecutor.b();
    }
    if (this.g == null) {
      this.g = GlideExecutor.a();
    }
    if (this.n == null) {
      this.n = GlideExecutor.d();
    }
    if (this.i == null) {
      this.i = new MemorySizeCalculator.Builder(paramContext).a();
    }
    if (this.j == null) {
      this.j = new DefaultConnectivityMonitorFactory();
    }
    if (this.c == null)
    {
      int i1 = this.i.b();
      if (i1 > 0) {
        this.c = new LruBitmapPool(i1);
      } else {
        this.c = new BitmapPoolAdapter();
      }
    }
    if (this.d == null) {
      this.d = new LruArrayPool(this.i.c());
    }
    if (this.e == null) {
      this.e = new LruResourceCache(this.i.a());
    }
    if (this.h == null) {
      this.h = new InternalCacheDiskCacheFactory(paramContext);
    }
    if (this.b == null) {
      this.b = new Engine(this.e, this.h, this.g, this.f, GlideExecutor.c(), GlideExecutor.d(), this.o);
    }
    RequestManagerRetriever localRequestManagerRetriever = new RequestManagerRetriever(this.m);
    return new Glide(paramContext, this.b, this.e, this.c, this.d, localRequestManagerRetriever, this.j, this.k, this.l.g(), this.a);
  }
  
  void a(@Nullable RequestManagerRetriever.RequestManagerFactory paramRequestManagerFactory)
  {
    this.m = paramRequestManagerFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.GlideBuilder
 * JD-Core Version:    0.7.0.1
 */