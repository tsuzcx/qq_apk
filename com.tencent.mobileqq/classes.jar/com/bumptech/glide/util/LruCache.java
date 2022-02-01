package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache<T, Y>
{
  private final Map<T, Y> a = new LinkedHashMap(100, 0.75F, true);
  private final long b;
  private long c;
  private long d;
  
  public LruCache(long paramLong)
  {
    this.b = paramLong;
    this.c = paramLong;
  }
  
  private void d()
  {
    a(this.c);
  }
  
  protected int a(@Nullable Y paramY)
  {
    return 1;
  }
  
  public long a()
  {
    try
    {
      long l = this.d;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(long paramLong)
  {
    try
    {
      while (this.d > paramLong)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject3).getValue();
        this.d -= a(localObject2);
        localObject3 = ((Map.Entry)localObject3).getKey();
        localIterator.remove();
        a(localObject3, localObject2);
      }
      return;
    }
    finally
    {
      localObject1 = finally;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  protected void a(@NonNull T paramT, @Nullable Y paramY) {}
  
  public long b()
  {
    try
    {
      long l = this.c;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public Y b(@NonNull T paramT)
  {
    try
    {
      paramT = this.a.get(paramT);
      return paramT;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  @Nullable
  public Y b(@NonNull T paramT, @Nullable Y paramY)
  {
    try
    {
      long l = a(paramY);
      if (l >= this.c)
      {
        a(paramT, paramY);
        return null;
      }
      if (paramY != null) {
        this.d += l;
      }
      Object localObject = this.a.put(paramT, paramY);
      if (localObject != null)
      {
        this.d -= a(localObject);
        if (!localObject.equals(paramY)) {
          a(paramT, localObject);
        }
      }
      d();
      return localObject;
    }
    finally {}
  }
  
  @Nullable
  public Y c(@NonNull T paramT)
  {
    try
    {
      paramT = this.a.remove(paramT);
      if (paramT != null) {
        this.d -= a(paramT);
      }
      return paramT;
    }
    finally {}
  }
  
  public void c()
  {
    a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.LruCache
 * JD-Core Version:    0.7.0.1
 */