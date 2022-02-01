package com.bumptech.glide.disklrucache;

import java.util.concurrent.ThreadFactory;

final class DiskLruCache$DiskLruCacheThreadFactory
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable, "glide-disk-lru-cache-thread");
      paramRunnable.setPriority(1);
      return paramRunnable;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.DiskLruCache.DiskLruCacheThreadFactory
 * JD-Core Version:    0.7.0.1
 */