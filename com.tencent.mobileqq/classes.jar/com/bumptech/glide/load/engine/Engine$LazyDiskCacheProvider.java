package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;

class Engine$LazyDiskCacheProvider
  implements DecodeJob.DiskCacheProvider
{
  private final DiskCache.Factory a;
  private volatile DiskCache b;
  
  Engine$LazyDiskCacheProvider(DiskCache.Factory paramFactory)
  {
    this.a = paramFactory;
  }
  
  public DiskCache a()
  {
    if (this.b == null) {
      try
      {
        if (this.b == null) {
          this.b = this.a.a();
        }
        if (this.b == null) {
          this.b = new DiskCacheAdapter();
        }
      }
      finally {}
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Engine.LazyDiskCacheProvider
 * JD-Core Version:    0.7.0.1
 */