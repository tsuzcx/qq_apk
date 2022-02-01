package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;

public abstract interface ModelLoader<Model, Data>
{
  @Nullable
  public abstract ModelLoader.LoadData<Data> a(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull Options paramOptions);
  
  public abstract boolean a(@NonNull Model paramModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelLoader
 * JD-Core Version:    0.7.0.1
 */