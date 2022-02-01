package com.bumptech.glide.load.engine.cache;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.File;

public abstract interface DiskCache
{
  @Nullable
  public abstract File a(Key paramKey);
  
  public abstract void a(Key paramKey, DiskCache.Writer paramWriter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.DiskCache
 * JD-Core Version:    0.7.0.1
 */