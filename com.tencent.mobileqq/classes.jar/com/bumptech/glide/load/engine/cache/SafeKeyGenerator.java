package com.bumptech.glide.load.engine.cache;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import java.security.MessageDigest;

public class SafeKeyGenerator
{
  private final LruCache<Key, String> a = new LruCache(1000L);
  private final Pools.Pool<SafeKeyGenerator.PoolableDigestContainer> b = FactoryPools.b(10, new SafeKeyGenerator.1(this));
  
  private String b(Key paramKey)
  {
    SafeKeyGenerator.PoolableDigestContainer localPoolableDigestContainer = (SafeKeyGenerator.PoolableDigestContainer)Preconditions.a(this.b.acquire());
    try
    {
      paramKey.a(localPoolableDigestContainer.a);
      paramKey = Util.a(localPoolableDigestContainer.a.digest());
      return paramKey;
    }
    finally
    {
      this.b.release(localPoolableDigestContainer);
    }
  }
  
  public String a(Key paramKey)
  {
    synchronized (this.a)
    {
      ??? = (String)this.a.b(paramKey);
      ??? = ???;
      if (??? == null) {
        ??? = b(paramKey);
      }
      synchronized (this.a)
      {
        this.a.b(paramKey, ???);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.SafeKeyGenerator
 * JD-Core Version:    0.7.0.1
 */