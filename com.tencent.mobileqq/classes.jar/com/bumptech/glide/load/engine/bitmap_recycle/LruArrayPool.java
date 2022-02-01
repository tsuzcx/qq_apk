package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool
  implements ArrayPool
{
  private final GroupedLinkedMap<LruArrayPool.Key, Object> a = new GroupedLinkedMap();
  private final LruArrayPool.KeyPool b = new LruArrayPool.KeyPool();
  private final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
  private final Map<Class<?>, ArrayAdapterInterface<?>> d = new HashMap();
  private final int e;
  private int f;
  
  @VisibleForTesting
  public LruArrayPool()
  {
    this.e = 4194304;
  }
  
  public LruArrayPool(int paramInt)
  {
    this.e = paramInt;
  }
  
  @Nullable
  private <T> T a(LruArrayPool.Key paramKey)
  {
    return this.a.a(paramKey);
  }
  
  private <T> T a(LruArrayPool.Key paramKey, Class<T> paramClass)
  {
    ArrayAdapterInterface localArrayAdapterInterface = b(paramClass);
    Object localObject = a(paramKey);
    if (localObject != null)
    {
      this.f -= localArrayAdapterInterface.a(localObject) * localArrayAdapterInterface.b();
      c(localArrayAdapterInterface.a(localObject), paramClass);
    }
    paramClass = (Class<T>)localObject;
    if (localObject == null)
    {
      if (Log.isLoggable(localArrayAdapterInterface.a(), 2))
      {
        paramClass = localArrayAdapterInterface.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Allocated ");
        ((StringBuilder)localObject).append(paramKey.a);
        ((StringBuilder)localObject).append(" bytes");
        Log.v(paramClass, ((StringBuilder)localObject).toString());
      }
      paramClass = localArrayAdapterInterface.a(paramKey.a);
    }
    return paramClass;
  }
  
  private NavigableMap<Integer, Integer> a(Class<?> paramClass)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.c.get(paramClass);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.c.put(paramClass, localObject);
    }
    return localObject;
  }
  
  private boolean a(int paramInt, Integer paramInteger)
  {
    return (paramInteger != null) && ((b()) || (paramInteger.intValue() <= paramInt * 8));
  }
  
  private <T> ArrayAdapterInterface<T> b(Class<T> paramClass)
  {
    Object localObject = (ArrayAdapterInterface)this.d.get(paramClass);
    if (localObject == null)
    {
      if (paramClass.equals([I.class))
      {
        localObject = new IntegerArrayAdapter();
      }
      else
      {
        if (!paramClass.equals([B.class)) {
          break label69;
        }
        localObject = new ByteArrayAdapter();
      }
      this.d.put(paramClass, localObject);
      return localObject;
      label69:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No array pool found for: ");
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return localObject;
  }
  
  private <T> ArrayAdapterInterface<T> b(T paramT)
  {
    return b(paramT.getClass());
  }
  
  private boolean b()
  {
    int i = this.f;
    return (i == 0) || (this.e / i >= 2);
  }
  
  private boolean b(int paramInt)
  {
    return paramInt <= this.e / 2;
  }
  
  private void c()
  {
    c(this.e);
  }
  
  private void c(int paramInt)
  {
    while (this.f > paramInt)
    {
      Object localObject = this.a.a();
      Preconditions.a(localObject);
      ArrayAdapterInterface localArrayAdapterInterface = b(localObject);
      this.f -= localArrayAdapterInterface.a(localObject) * localArrayAdapterInterface.b();
      c(localArrayAdapterInterface.a(localObject), localObject.getClass());
      if (Log.isLoggable(localArrayAdapterInterface.a(), 2))
      {
        String str = localArrayAdapterInterface.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("evicted: ");
        localStringBuilder.append(localArrayAdapterInterface.a(localObject));
        Log.v(str, localStringBuilder.toString());
      }
    }
  }
  
  private void c(int paramInt, Class<?> paramClass)
  {
    paramClass = a(paramClass);
    Integer localInteger = (Integer)paramClass.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      if (localInteger.intValue() == 1)
      {
        paramClass.remove(Integer.valueOf(paramInt));
        return;
      }
      paramClass.put(Integer.valueOf(paramInt), Integer.valueOf(localInteger.intValue() - 1));
      return;
    }
    paramClass = new StringBuilder();
    paramClass.append("Tried to decrement empty size, size: ");
    paramClass.append(paramInt);
    paramClass.append(", this: ");
    paramClass.append(this);
    throw new NullPointerException(paramClass.toString());
  }
  
  public <T> T a(int paramInt, Class<T> paramClass)
  {
    try
    {
      Object localObject = (Integer)a(paramClass).ceilingKey(Integer.valueOf(paramInt));
      if (a(paramInt, (Integer)localObject)) {
        localObject = this.b.a(((Integer)localObject).intValue(), paramClass);
      } else {
        localObject = this.b.a(paramInt, paramClass);
      }
      paramClass = a((LruArrayPool.Key)localObject, paramClass);
      return paramClass;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      c(0);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 40) {}
    for (;;)
    {
      try
      {
        a();
        continue;
        c(this.e / 2);
        return;
      }
      finally
      {
        Object localObject1;
        continue;
      }
      throw localObject1;
      if (paramInt < 20) {
        if (paramInt != 15) {}
      }
    }
  }
  
  public <T> void a(T paramT)
  {
    try
    {
      Object localObject2 = paramT.getClass();
      Object localObject1 = b((Class)localObject2);
      int i = ((ArrayAdapterInterface)localObject1).a(paramT);
      int j = ((ArrayAdapterInterface)localObject1).b() * i;
      boolean bool = b(j);
      if (!bool) {
        return;
      }
      localObject1 = this.b.a(i, (Class)localObject2);
      this.a.a((Poolable)localObject1, paramT);
      paramT = a((Class)localObject2);
      localObject2 = (Integer)paramT.get(Integer.valueOf(((LruArrayPool.Key)localObject1).a));
      int k = ((LruArrayPool.Key)localObject1).a;
      i = 1;
      if (localObject2 != null) {
        i = 1 + ((Integer)localObject2).intValue();
      }
      paramT.put(Integer.valueOf(k), Integer.valueOf(i));
      this.f += j;
      c();
      return;
    }
    finally {}
  }
  
  public <T> T b(int paramInt, Class<T> paramClass)
  {
    try
    {
      paramClass = a(this.b.a(paramInt, paramClass), paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool
 * JD-Core Version:    0.7.0.1
 */