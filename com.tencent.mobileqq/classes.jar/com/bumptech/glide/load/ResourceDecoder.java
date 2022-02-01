package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;

public abstract interface ResourceDecoder<T, Z>
{
  @Nullable
  public abstract Resource<Z> a(@NonNull T paramT, int paramInt1, int paramInt2, @NonNull Options paramOptions);
  
  public abstract boolean a(@NonNull T paramT, @NonNull Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.ResourceDecoder
 * JD-Core Version:    0.7.0.1
 */