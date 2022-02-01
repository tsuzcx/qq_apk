package com.bumptech.glide.load.resource.transcode;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TranscoderRegistry
{
  private final List<TranscoderRegistry.Entry<?, ?>> a = new ArrayList();
  
  @NonNull
  public <Z, R> ResourceTranscoder<Z, R> a(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      if (paramClass1.isAssignableFrom(paramClass))
      {
        paramClass = UnitTranscoder.a();
        return paramClass;
      }
      Object localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TranscoderRegistry.Entry localEntry = (TranscoderRegistry.Entry)((Iterator)localObject).next();
        if (localEntry.a(paramClass, paramClass1))
        {
          paramClass = localEntry.a;
          return paramClass;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No transcoder registered to transcode from ");
      ((StringBuilder)localObject).append(paramClass);
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(paramClass1);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public <Z, R> void a(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1, @NonNull ResourceTranscoder<Z, R> paramResourceTranscoder)
  {
    try
    {
      this.a.add(new TranscoderRegistry.Entry(paramClass, paramClass1, paramResourceTranscoder));
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  @NonNull
  public <Z, R> List<Class<R>> b(@NonNull Class<Z> paramClass, @NonNull Class<R> paramClass1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (paramClass1.isAssignableFrom(paramClass))
      {
        localArrayList.add(paramClass1);
        return localArrayList;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((TranscoderRegistry.Entry)localIterator.next()).a(paramClass, paramClass1)) {
          localArrayList.add(paramClass1);
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
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.TranscoderRegistry
 * JD-Core Version:    0.7.0.1
 */