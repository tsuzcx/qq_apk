package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import java.util.List;

class MultiModelLoaderFactory$Factory
{
  @NonNull
  public <Model, Data> MultiModelLoader<Model, Data> a(@NonNull List<ModelLoader<Model, Data>> paramList, @NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    return new MultiModelLoader(paramList, paramPool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MultiModelLoaderFactory.Factory
 * JD-Core Version:    0.7.0.1
 */