package com.bumptech.glide.load.resource.transcode;

import android.support.annotation.NonNull;

final class TranscoderRegistry$Entry<Z, R>
{
  final ResourceTranscoder<Z, R> a;
  private final Class<Z> b;
  private final Class<R> c;
  
  TranscoderRegistry$Entry(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1, @NonNull ResourceTranscoder<Z, R> paramResourceTranscoder)
  {
    this.b = paramClass;
    this.c = paramClass1;
    this.a = paramResourceTranscoder;
  }
  
  public boolean a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
  {
    return (this.b.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.TranscoderRegistry.Entry
 * JD-Core Version:    0.7.0.1
 */