package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Options;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class MultiModelLoader<Model, Data>
  implements ModelLoader<Model, Data>
{
  private final List<ModelLoader<Model, Data>> a;
  private final Pools.Pool<List<Throwable>> b;
  
  MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> paramList, @NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this.a = paramList;
    this.b = paramPool;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    int j = this.a.size();
    ArrayList localArrayList = new ArrayList(j);
    Object localObject3 = null;
    int i = 0;
    Object localObject2;
    for (Object localObject1 = null; i < j; localObject1 = localObject2)
    {
      Object localObject4 = (ModelLoader)this.a.get(i);
      localObject2 = localObject1;
      if (((ModelLoader)localObject4).a(paramModel))
      {
        localObject4 = ((ModelLoader)localObject4).a(paramModel, paramInt1, paramInt2, paramOptions);
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject2 = ((ModelLoader.LoadData)localObject4).a;
          localArrayList.add(((ModelLoader.LoadData)localObject4).c);
        }
      }
      i += 1;
    }
    paramModel = localObject3;
    if (!localArrayList.isEmpty())
    {
      paramModel = localObject3;
      if (localObject1 != null) {
        paramModel = new ModelLoader.LoadData(localObject1, new MultiModelLoader.MultiFetcher(localArrayList, this.b));
      }
    }
    return paramModel;
  }
  
  public boolean a(@NonNull Model paramModel)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((ModelLoader)localIterator.next()).a(paramModel)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiModelLoader{modelLoaders=");
    localStringBuilder.append(Arrays.toString(this.a.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MultiModelLoader
 * JD-Core Version:    0.7.0.1
 */