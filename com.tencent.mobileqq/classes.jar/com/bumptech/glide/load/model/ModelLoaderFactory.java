package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;

public abstract interface ModelLoaderFactory<T, Y>
{
  @NonNull
  public abstract ModelLoader<T, Y> a(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelLoaderFactory
 * JD-Core Version:    0.7.0.1
 */