package com.bumptech.glide.disklrucache;

import java.util.concurrent.Callable;

class DiskLruCache$1
  implements Callable<Void>
{
  DiskLruCache$1(DiskLruCache paramDiskLruCache) {}
  
  public Void a()
  {
    synchronized (this.a)
    {
      if (DiskLruCache.a(this.a) == null) {
        return null;
      }
      DiskLruCache.b(this.a);
      if (DiskLruCache.c(this.a))
      {
        DiskLruCache.d(this.a);
        DiskLruCache.a(this.a, 0);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.DiskLruCache.1
 * JD-Core Version:    0.7.0.1
 */