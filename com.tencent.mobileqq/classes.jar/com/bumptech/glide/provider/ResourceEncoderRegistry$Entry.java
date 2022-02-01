package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ResourceEncoder;

final class ResourceEncoderRegistry$Entry<T>
{
  final ResourceEncoder<T> a;
  private final Class<T> b;
  
  ResourceEncoderRegistry$Entry(@NonNull Class<T> paramClass, @NonNull ResourceEncoder<T> paramResourceEncoder)
  {
    this.b = paramClass;
    this.a = paramResourceEncoder;
  }
  
  boolean a(@NonNull Class<?> paramClass)
  {
    return this.b.isAssignableFrom(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.provider.ResourceEncoderRegistry.Entry
 * JD-Core Version:    0.7.0.1
 */