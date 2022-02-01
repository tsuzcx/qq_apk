package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

final class DiskCacheWriteLocker
{
  private final Map<String, DiskCacheWriteLocker.WriteLock> a = new HashMap();
  private final DiskCacheWriteLocker.WriteLockPool b = new DiskCacheWriteLocker.WriteLockPool();
  
  void a(String paramString)
  {
    try
    {
      DiskCacheWriteLocker.WriteLock localWriteLock2 = (DiskCacheWriteLocker.WriteLock)this.a.get(paramString);
      DiskCacheWriteLocker.WriteLock localWriteLock1 = localWriteLock2;
      if (localWriteLock2 == null)
      {
        localWriteLock1 = this.b.a();
        this.a.put(paramString, localWriteLock1);
      }
      localWriteLock1.b += 1;
      localWriteLock1.a.lock();
      return;
    }
    finally {}
  }
  
  void b(String paramString)
  {
    try
    {
      DiskCacheWriteLocker.WriteLock localWriteLock = (DiskCacheWriteLocker.WriteLock)Preconditions.a(this.a.get(paramString));
      if (localWriteLock.b >= 1)
      {
        localWriteLock.b -= 1;
        if (localWriteLock.b == 0)
        {
          localObject = (DiskCacheWriteLocker.WriteLock)this.a.remove(paramString);
          if (localObject.equals(localWriteLock))
          {
            this.b.a((DiskCacheWriteLocker.WriteLock)localObject);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Removed the wrong lock, expected to remove: ");
            localStringBuilder.append(localWriteLock);
            localStringBuilder.append(", but actually removed: ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", safeKey: ");
            localStringBuilder.append(paramString);
            throw new IllegalStateException(localStringBuilder.toString());
          }
        }
        localWriteLock.a.unlock();
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot release a lock that is not held, safeKey: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", interestedThreads: ");
      ((StringBuilder)localObject).append(localWriteLock.b);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker
 * JD-Core Version:    0.7.0.1
 */