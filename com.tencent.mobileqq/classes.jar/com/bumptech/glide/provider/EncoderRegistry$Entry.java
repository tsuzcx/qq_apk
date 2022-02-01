package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Encoder;

final class EncoderRegistry$Entry<T>
{
  final Encoder<T> a;
  private final Class<T> b;
  
  EncoderRegistry$Entry(@NonNull Class<T> paramClass, @NonNull Encoder<T> paramEncoder)
  {
    this.b = paramClass;
    this.a = paramEncoder;
  }
  
  boolean a(@NonNull Class<?> paramClass)
  {
    return this.b.isAssignableFrom(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.provider.EncoderRegistry.Entry
 * JD-Core Version:    0.7.0.1
 */