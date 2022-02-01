package com.google.protobuf;

import java.util.Map.Entry;

class SmallSortedMap$Entry
  implements Comparable<SmallSortedMap<K, V>.Entry>, Map.Entry<K, V>
{
  private final K b;
  private V c;
  
  SmallSortedMap$Entry(K paramK, V paramV)
  {
    this.b = paramV;
    Object localObject;
    this.c = localObject;
  }
  
  SmallSortedMap$Entry(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)localObject.getKey(), localObject.getValue());
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public int a(SmallSortedMap<K, V>.Entry paramSmallSortedMap)
  {
    return a().compareTo(paramSmallSortedMap.a());
  }
  
  public K a()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (a(this.b, paramObject.getKey())) && (a(this.c, paramObject.getValue()));
  }
  
  public V getValue()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.c;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public V setValue(V paramV)
  {
    SmallSortedMap.a(this.a);
    Object localObject = this.c;
    this.c = paramV;
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap.Entry
 * JD-Core Version:    0.7.0.1
 */