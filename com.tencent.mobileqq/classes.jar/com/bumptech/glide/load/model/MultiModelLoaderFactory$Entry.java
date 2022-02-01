package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;

class MultiModelLoaderFactory$Entry<Model, Data>
{
  final Class<Data> a;
  final ModelLoaderFactory<? extends Model, ? extends Data> b;
  private final Class<Model> c;
  
  public MultiModelLoaderFactory$Entry(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory)
  {
    this.c = paramClass;
    this.a = paramClass1;
    this.b = paramModelLoaderFactory;
  }
  
  public boolean a(@NonNull Class<?> paramClass)
  {
    return this.c.isAssignableFrom(paramClass);
  }
  
  public boolean a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
  {
    return (a(paramClass1)) && (this.a.isAssignableFrom(paramClass2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry
 * JD-Core Version:    0.7.0.1
 */