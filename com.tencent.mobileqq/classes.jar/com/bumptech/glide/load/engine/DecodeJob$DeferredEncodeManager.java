package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.util.pool.GlideTrace;

class DecodeJob$DeferredEncodeManager<Z>
{
  private Key a;
  private ResourceEncoder<Z> b;
  private LockedResource<Z> c;
  
  <X> void a(Key paramKey, ResourceEncoder<X> paramResourceEncoder, LockedResource<X> paramLockedResource)
  {
    this.a = paramKey;
    this.b = paramResourceEncoder;
    this.c = paramLockedResource;
  }
  
  void a(DecodeJob.DiskCacheProvider paramDiskCacheProvider, Options paramOptions)
  {
    GlideTrace.a("DecodeJob.encode");
    try
    {
      paramDiskCacheProvider.a().a(this.a, new DataCacheWriter(this.b, this.c, paramOptions));
      return;
    }
    finally
    {
      this.c.a();
      GlideTrace.a();
    }
  }
  
  boolean a()
  {
    return this.c != null;
  }
  
  void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodeJob.DeferredEncodeManager
 * JD-Core Version:    0.7.0.1
 */