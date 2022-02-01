package com.bumptech.glide.load.engine.cache;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public class MemoryCacheAdapter
  implements MemoryCache
{
  private MemoryCache.ResourceRemovedListener a;
  
  public long a()
  {
    return 0L;
  }
  
  @Nullable
  public Resource<?> a(@NonNull Key paramKey)
  {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(@NonNull MemoryCache.ResourceRemovedListener paramResourceRemovedListener)
  {
    this.a = paramResourceRemovedListener;
  }
  
  public long b()
  {
    return 0L;
  }
  
  @Nullable
  public Resource<?> b(@NonNull Key paramKey, @Nullable Resource<?> paramResource)
  {
    if (paramResource != null) {
      this.a.b(paramResource);
    }
    return null;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.MemoryCacheAdapter
 * JD-Core Version:    0.7.0.1
 */