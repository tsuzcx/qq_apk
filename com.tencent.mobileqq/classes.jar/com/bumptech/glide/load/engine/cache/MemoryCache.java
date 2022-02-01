package com.bumptech.glide.load.engine.cache;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public abstract interface MemoryCache
{
  public abstract long a();
  
  @Nullable
  public abstract Resource<?> a(@NonNull Key paramKey);
  
  public abstract void a(int paramInt);
  
  public abstract void a(@NonNull MemoryCache.ResourceRemovedListener paramResourceRemovedListener);
  
  public abstract long b();
  
  @Nullable
  public abstract Resource<?> b(@NonNull Key paramKey, @Nullable Resource<?> paramResource);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.MemoryCache
 * JD-Core Version:    0.7.0.1
 */