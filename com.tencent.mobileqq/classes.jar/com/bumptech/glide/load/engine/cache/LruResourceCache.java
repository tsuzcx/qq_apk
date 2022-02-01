package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache
  extends LruCache<Key, Resource<?>>
  implements MemoryCache
{
  private MemoryCache.ResourceRemovedListener a;
  
  public LruResourceCache(long paramLong)
  {
    super(paramLong);
  }
  
  protected int a(@Nullable Resource<?> paramResource)
  {
    if (paramResource == null) {
      return super.a(null);
    }
    return paramResource.e();
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (paramInt >= 40)
    {
      c();
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      a(b() / 2L);
    }
  }
  
  protected void a(@NonNull Key paramKey, @Nullable Resource<?> paramResource)
  {
    paramKey = this.a;
    if ((paramKey != null) && (paramResource != null)) {
      paramKey.b(paramResource);
    }
  }
  
  public void a(@NonNull MemoryCache.ResourceRemovedListener paramResourceRemovedListener)
  {
    this.a = paramResourceRemovedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.LruResourceCache
 * JD-Core Version:    0.7.0.1
 */