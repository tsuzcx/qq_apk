package com.bumptech.glide.load.model;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ModelLoaderRegistry$ModelLoaderCache
{
  private final Map<Class<?>, ModelLoaderRegistry.ModelLoaderCache.Entry<?>> a = new HashMap();
  
  @Nullable
  public <Model> List<ModelLoader<Model, ?>> a(Class<Model> paramClass)
  {
    paramClass = (ModelLoaderRegistry.ModelLoaderCache.Entry)this.a.get(paramClass);
    if (paramClass == null) {
      return null;
    }
    return paramClass.a;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public <Model> void a(Class<Model> paramClass, List<ModelLoader<Model, ?>> paramList)
  {
    if ((ModelLoaderRegistry.ModelLoaderCache.Entry)this.a.put(paramClass, new ModelLoaderRegistry.ModelLoaderCache.Entry(paramList)) == null) {
      return;
    }
    paramList = new StringBuilder();
    paramList.append("Already cached loaders for model: ");
    paramList.append(paramClass);
    throw new IllegalStateException(paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelLoaderRegistry.ModelLoaderCache
 * JD-Core Version:    0.7.0.1
 */