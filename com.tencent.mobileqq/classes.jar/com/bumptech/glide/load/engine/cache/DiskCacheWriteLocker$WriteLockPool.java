package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.Queue;

class DiskCacheWriteLocker$WriteLockPool
{
  private final Queue<DiskCacheWriteLocker.WriteLock> a = new ArrayDeque();
  
  DiskCacheWriteLocker.WriteLock a()
  {
    synchronized (this.a)
    {
      DiskCacheWriteLocker.WriteLock localWriteLock = (DiskCacheWriteLocker.WriteLock)this.a.poll();
      ??? = localWriteLock;
      if (localWriteLock == null) {
        ??? = new DiskCacheWriteLocker.WriteLock();
      }
      return ???;
    }
  }
  
  void a(DiskCacheWriteLocker.WriteLock paramWriteLock)
  {
    synchronized (this.a)
    {
      if (this.a.size() < 10) {
        this.a.offer(paramWriteLock);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLockPool
 * JD-Core Version:    0.7.0.1
 */