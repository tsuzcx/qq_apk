package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;

public class UnitModelLoader$Factory<Model>
  implements ModelLoaderFactory<Model, Model>
{
  private static final Factory<?> a = new Factory();
  
  public static <T> Factory<T> a()
  {
    return a;
  }
  
  @NonNull
  public ModelLoader<Model, Model> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return UnitModelLoader.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UnitModelLoader.Factory
 * JD-Core Version:    0.7.0.1
 */