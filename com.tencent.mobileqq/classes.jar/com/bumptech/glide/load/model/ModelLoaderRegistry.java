package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelLoaderRegistry
{
  private final MultiModelLoaderFactory a;
  private final ModelLoaderRegistry.ModelLoaderCache b = new ModelLoaderRegistry.ModelLoaderCache();
  
  public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this(new MultiModelLoaderFactory(paramPool));
  }
  
  private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    this.a = paramMultiModelLoaderFactory;
  }
  
  @NonNull
  private static <A> Class<A> b(@NonNull A paramA)
  {
    return paramA.getClass();
  }
  
  @NonNull
  private <A> List<ModelLoader<A, ?>> b(@NonNull Class<A> paramClass)
  {
    List localList2 = this.b.a(paramClass);
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = Collections.unmodifiableList(this.a.a(paramClass));
      this.b.a(paramClass, localList1);
    }
    return localList1;
  }
  
  @NonNull
  public List<Class<?>> a(@NonNull Class<?> paramClass)
  {
    try
    {
      paramClass = this.a.b(paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @NonNull
  public <A> List<ModelLoader<A, ?>> a(@NonNull A paramA)
  {
    try
    {
      List localList = b(b(paramA));
      int j = localList.size();
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        ModelLoader localModelLoader = (ModelLoader)localList.get(i);
        if (localModelLoader.a(paramA)) {
          localArrayList.add(localModelLoader);
        }
        i += 1;
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramA;
    }
  }
  
  public <Model, Data> void a(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory)
  {
    try
    {
      this.a.a(paramClass, paramClass1, paramModelLoaderFactory);
      this.b.a();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelLoaderRegistry
 * JD-Core Version:    0.7.0.1
 */