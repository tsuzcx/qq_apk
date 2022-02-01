package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class ot<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ot(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.b >= 0) && ((!this.a.isEmpty()) || (this.b == 0)))
        {
          if ((this.b > paramInt) && (!this.a.isEmpty()))
          {
            Object localObject3 = (Map.Entry)this.a.entrySet().iterator().next();
            localObject1 = ((Map.Entry)localObject3).getKey();
            localObject3 = ((Map.Entry)localObject3).getValue();
            this.a.remove(localObject1);
            this.b -= b(localObject1, localObject3);
            this.e += 1;
            a(true, localObject3);
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getClass().getName());
          ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
      finally {}
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private int b(K paramK, V paramV)
  {
    int i = a(paramV);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder("Negative size: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append("=");
    localStringBuilder.append(paramV);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected int a(V paramV)
  {
    return 1;
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.d += 1;
        this.b += b(paramK, paramV);
        paramV = this.a.put(paramK, paramV);
        if (paramV != null) {
          this.b -= b(paramK, paramV);
        }
        if (paramV != null) {
          a(false, paramV);
        }
        a(this.c);
        return paramV;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final void a()
  {
    a(-1);
  }
  
  protected void a(boolean paramBoolean, V paramV) {}
  
  public final V b(K paramK)
  {
    if (paramK != null) {
      try
      {
        paramK = this.a.get(paramK);
        if (paramK != null)
        {
          this.f += 1;
          return paramK;
        }
        this.g += 1;
        return null;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.f + this.g;
        if (i != 0)
        {
          i = this.f * 100 / i;
          String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ot
 * JD-Core Version:    0.7.0.1
 */