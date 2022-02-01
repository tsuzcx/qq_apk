package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model>
  implements ModelLoader<Model, Model>
{
  private static final UnitModelLoader<?> a = new UnitModelLoader();
  
  public static <T> UnitModelLoader<T> a()
  {
    return a;
  }
  
  public ModelLoader.LoadData<Model> a(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramModel), new UnitModelLoader.UnitFetcher(paramModel));
  }
  
  public boolean a(@NonNull Model paramModel)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UnitModelLoader
 * JD-Core Version:    0.7.0.1
 */