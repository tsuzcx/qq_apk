package com.bumptech.glide.load.engine.cache;

import java.io.File;

public class DiskLruCacheFactory
  implements DiskCache.Factory
{
  private final long a;
  private final DiskLruCacheFactory.CacheDirectoryGetter b;
  
  public DiskLruCacheFactory(DiskLruCacheFactory.CacheDirectoryGetter paramCacheDirectoryGetter, long paramLong)
  {
    this.a = paramLong;
    this.b = paramCacheDirectoryGetter;
  }
  
  public DiskCache a()
  {
    File localFile = this.b.a();
    if (localFile == null) {
      return null;
    }
    if ((!localFile.mkdirs()) && ((!localFile.exists()) || (!localFile.isDirectory()))) {
      return null;
    }
    return DiskLruCacheWrapper.a(localFile, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
 * JD-Core Version:    0.7.0.1
 */