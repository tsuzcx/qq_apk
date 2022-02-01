package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapFieldLite<K, V>
  extends LinkedHashMap<K, V>
{
  private static final MapFieldLite a = new MapFieldLite();
  private boolean isMutable = true;
  
  static
  {
    a.makeImmutable();
  }
  
  private MapFieldLite() {}
  
  private MapFieldLite(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private static int a(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return Internal.c((byte[])paramObject);
    }
    if (!(paramObject instanceof Internal.EnumLite)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  private void a()
  {
    if (isMutable()) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private static void a(Map<?, ?> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Internal.a(localObject);
      Internal.a(paramMap.get(localObject));
    }
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      localObject = Arrays.copyOf(paramObject, paramObject.length);
    }
    return localObject;
  }
  
  static <K, V> int calculateHashCodeForMap(Map<K, V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int j = a(localEntry.getKey());
      i += (a(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  static <K, V> Map<K, V> copy(Map<K, V> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), b(localEntry.getValue()));
    }
    return localLinkedHashMap;
  }
  
  public static <K, V> MapFieldLite<K, V> emptyMapField()
  {
    return a;
  }
  
  static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    if (paramMap1 == paramMap2) {
      return true;
    }
    if (paramMap1.size() != paramMap2.size()) {
      return false;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      if (!paramMap2.containsKey(localEntry.getKey())) {
        return false;
      }
      if (!a(localEntry.getValue(), paramMap2.get(localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public void clear()
  {
    a();
    super.clear();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (equals(this, (Map)paramObject));
  }
  
  public int hashCode()
  {
    return calculateHashCodeForMap(this);
  }
  
  public boolean isMutable()
  {
    return this.isMutable;
  }
  
  public void makeImmutable()
  {
    this.isMutable = false;
  }
  
  public void mergeFrom(MapFieldLite<K, V> paramMapFieldLite)
  {
    a();
    if (!paramMapFieldLite.isEmpty()) {
      putAll(paramMapFieldLite);
    }
  }
  
  public MapFieldLite<K, V> mutableCopy()
  {
    if (isEmpty()) {
      return new MapFieldLite();
    }
    return new MapFieldLite(this);
  }
  
  public V put(K paramK, V paramV)
  {
    a();
    Internal.a(paramK);
    Internal.a(paramV);
    return super.put(paramK, paramV);
  }
  
  public V put(Map.Entry<K, V> paramEntry)
  {
    return put(paramEntry.getKey(), paramEntry.getValue());
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    a();
    a(paramMap);
    super.putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    a();
    return super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapFieldLite
 * JD-Core Version:    0.7.0.1
 */