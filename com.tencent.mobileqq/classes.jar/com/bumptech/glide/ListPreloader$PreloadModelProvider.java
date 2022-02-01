package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;

public abstract interface ListPreloader$PreloadModelProvider<U>
{
  @Nullable
  public abstract RequestBuilder<?> a(@NonNull U paramU);
  
  @NonNull
  public abstract List<U> a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.ListPreloader.PreloadModelProvider
 * JD-Core Version:    0.7.0.1
 */