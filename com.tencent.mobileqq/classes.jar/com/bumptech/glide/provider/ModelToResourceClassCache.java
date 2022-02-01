package com.bumptech.glide.provider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache
{
  private final AtomicReference<MultiClassKey> a = new AtomicReference();
  private final ArrayMap<MultiClassKey, List<Class<?>>> b = new ArrayMap();
  
  @Nullable
  public List<Class<?>> a(@NonNull Class<?> paramClass1, @NonNull Class<?> arg2)
  {
    Object localObject = (MultiClassKey)this.a.getAndSet(null);
    if (localObject == null)
    {
      paramClass1 = new MultiClassKey(paramClass1, ???);
    }
    else
    {
      ((MultiClassKey)localObject).a(paramClass1, ???);
      paramClass1 = (Class<?>)localObject;
    }
    synchronized (this.b)
    {
      localObject = (List)this.b.get(paramClass1);
      this.a.set(paramClass1);
      return localObject;
    }
  }
  
  public void a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2, @NonNull List<Class<?>> paramList)
  {
    synchronized (this.b)
    {
      this.b.put(new MultiClassKey(paramClass1, paramClass2), paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.provider.ModelToResourceClassCache
 * JD-Core Version:    0.7.0.1
 */