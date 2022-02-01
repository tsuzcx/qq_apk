package com.bumptech.glide.load.engine.cache;

import android.content.Context;

public final class InternalCacheDiskCacheFactory
  extends DiskLruCacheFactory
{
  public InternalCacheDiskCacheFactory(Context paramContext)
  {
    this(paramContext, "image_manager_disk_cache", 262144000L);
  }
  
  public InternalCacheDiskCacheFactory(Context paramContext, String paramString, long paramLong)
  {
    super(new InternalCacheDiskCacheFactory.1(paramContext, paramString), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
 * JD-Core Version:    0.7.0.1
 */