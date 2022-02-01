package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry
{
  private final List<String> a = new ArrayList();
  private final Map<String, List<ResourceDecoderRegistry.Entry<?, ?>>> b = new HashMap();
  
  @NonNull
  private List<ResourceDecoderRegistry.Entry<?, ?>> a(@NonNull String paramString)
  {
    try
    {
      if (!this.a.contains(paramString)) {
        this.a.add(paramString);
      }
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.b.put(paramString, localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  @NonNull
  public <T, R> List<ResourceDecoder<T, R>> a(@NonNull Class<T> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ResourceDecoderRegistry.Entry localEntry = (ResourceDecoderRegistry.Entry)((Iterator)localObject).next();
            if (localEntry.a(paramClass, paramClass1)) {
              localArrayList.add(localEntry.b);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public <T, R> void a(@NonNull String paramString, @NonNull ResourceDecoder<T, R> paramResourceDecoder, @NonNull Class<T> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      a(paramString).add(new ResourceDecoderRegistry.Entry(paramClass, paramClass1, paramResourceDecoder));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(@NonNull List<String> paramList)
  {
    try
    {
      Object localObject = new ArrayList(this.a);
      this.a.clear();
      this.a.addAll(paramList);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramList.contains(str)) {
          this.a.add(str);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  @NonNull
  public <T, R> List<Class<R>> b(@NonNull Class<T> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.b.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ResourceDecoderRegistry.Entry localEntry = (ResourceDecoderRegistry.Entry)((Iterator)localObject).next();
            if ((localEntry.a(paramClass, paramClass1)) && (!localArrayList.contains(localEntry.a))) {
              localArrayList.add(localEntry.a);
            }
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.provider.ResourceDecoderRegistry
 * JD-Core Version:    0.7.0.1
 */