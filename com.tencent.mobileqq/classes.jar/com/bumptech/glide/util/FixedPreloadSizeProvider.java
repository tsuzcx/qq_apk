package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.ListPreloader.PreloadSizeProvider;

public class FixedPreloadSizeProvider<T>
  implements ListPreloader.PreloadSizeProvider<T>
{
  private final int[] a;
  
  @Nullable
  public int[] a(@NonNull T paramT, int paramInt1, int paramInt2)
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.FixedPreloadSizeProvider
 * JD-Core Version:    0.7.0.1
 */