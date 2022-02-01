package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;

class ResourceDecoderRegistry$Entry<T, R>
{
  final Class<R> a;
  final ResourceDecoder<T, R> b;
  private final Class<T> c;
  
  public ResourceDecoderRegistry$Entry(@NonNull Class<T> paramClass, @NonNull Class<R> paramClass1, ResourceDecoder<T, R> paramResourceDecoder)
  {
    this.c = paramClass;
    this.a = paramClass1;
    this.b = paramResourceDecoder;
  }
  
  public boolean a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
  {
    return (this.c.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.provider.ResourceDecoderRegistry.Entry
 * JD-Core Version:    0.7.0.1
 */