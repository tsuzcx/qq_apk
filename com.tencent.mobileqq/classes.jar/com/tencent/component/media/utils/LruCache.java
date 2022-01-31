package com.tencent.component.media.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache
{
  private int jdField_a_of_type_Int;
  private final LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public LruCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int a(Object paramObject1, Object paramObject2)
  {
    int i = sizeOf(paramObject1, paramObject2);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramObject1 + "=" + paramObject2);
    }
    return i;
  }
  
  protected Object create(Object paramObject)
  {
    return null;
  }
  
  public final int createCount()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object get(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramObject);
      if (localObject1 != null)
      {
        this.f += 1;
        return localObject1;
      }
      this.g += 1;
      localObject1 = create(paramObject);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.d += 1;
      Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject, localObject1);
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramObject, localObject1, localObject2);
        return localObject2;
        this.jdField_a_of_type_Int += a(paramObject, localObject1);
      }
      trimToSize(this.b);
    }
    finally {}
    return localObject1;
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.c += 1;
      this.jdField_a_of_type_Int += a(paramObject1, paramObject2);
      Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject1, paramObject2);
      if (localObject != null) {
        this.jdField_a_of_type_Int -= a(paramObject1, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramObject1, localObject, paramObject2);
      }
      trimToSize(this.b);
      return localObject;
    }
    finally {}
  }
  
  public final int putCount()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object remove(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramObject);
      if (localObject != null) {
        this.jdField_a_of_type_Int -= a(paramObject, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramObject, localObject, null);
      }
      return localObject;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int sizeOf(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final Map snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.jdField_a_of_type_JavaUtilLinkedHashMap);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.f + this.g;
      if (j != 0) {
        i = this.f * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  public void trimToSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Int < 0) || ((this.jdField_a_of_type_JavaUtilLinkedHashMap.isEmpty()) && (this.jdField_a_of_type_Int != 0)))
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
          this.jdField_a_of_type_Int = 0;
          return;
        }
        if ((this.jdField_a_of_type_Int <= paramInt) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.isEmpty())) {
          return;
        }
      }
      finally {}
      Object localObject3 = (Map.Entry)this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator().next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localObject2);
      this.jdField_a_of_type_Int -= a(localObject2, localObject3);
      this.e += 1;
      entryRemoved(true, localObject2, localObject3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.utils.LruCache
 * JD-Core Version:    0.7.0.1
 */