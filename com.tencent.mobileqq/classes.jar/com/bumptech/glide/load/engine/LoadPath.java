package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode>
{
  private final Class<Data> a;
  private final Pools.Pool<List<Throwable>> b;
  private final List<? extends DecodePath<Data, ResourceType, Transcode>> c;
  private final String d;
  
  public LoadPath(Class<Data> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<DecodePath<Data, ResourceType, Transcode>> paramList, Pools.Pool<List<Throwable>> paramPool)
  {
    this.a = paramClass;
    this.b = paramPool;
    this.c = ((List)Preconditions.a(paramList));
    paramList = new StringBuilder();
    paramList.append("Failed LoadPath{");
    paramList.append(paramClass.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass1.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass2.getSimpleName());
    paramList.append("}");
    this.d = paramList.toString();
  }
  
  private Resource<Transcode> a(DataRewinder<Data> paramDataRewinder, @NonNull Options paramOptions, int paramInt1, int paramInt2, DecodePath.DecodeCallback<ResourceType> paramDecodeCallback, List<Throwable> paramList)
  {
    int j = this.c.size();
    int i = 0;
    Object localObject1 = null;
    Object localObject3;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = (DecodePath)this.c.get(i);
      try
      {
        localObject2 = ((DecodePath)localObject2).a(paramDataRewinder, paramInt1, paramInt2, paramOptions, paramDecodeCallback);
        localObject1 = localObject2;
      }
      catch (GlideException localGlideException)
      {
        paramList.add(localGlideException);
      }
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        break;
      }
      i += 1;
    }
    if (localObject3 != null) {
      return localObject3;
    }
    paramDataRewinder = new GlideException(this.d, new ArrayList(paramList));
    for (;;)
    {
      throw paramDataRewinder;
    }
  }
  
  public Resource<Transcode> a(DataRewinder<Data> paramDataRewinder, @NonNull Options paramOptions, int paramInt1, int paramInt2, DecodePath.DecodeCallback<ResourceType> paramDecodeCallback)
  {
    List localList = (List)Preconditions.a(this.b.acquire());
    try
    {
      paramDataRewinder = a(paramDataRewinder, paramOptions, paramInt1, paramInt2, paramDecodeCallback, localList);
      return paramDataRewinder;
    }
    finally
    {
      this.b.release(localList);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadPath{decodePaths=");
    localStringBuilder.append(Arrays.toString(this.c.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.LoadPath
 * JD-Core Version:    0.7.0.1
 */