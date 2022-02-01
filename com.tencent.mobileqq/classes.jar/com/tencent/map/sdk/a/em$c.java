package com.tencent.map.sdk.a;

import java.util.Map.Entry;

public final class em$c<K extends Comparable<K>, V>
  implements Map.Entry<K, V>
{
  K a;
  private V b;
  private c<K, V> c;
  private c<K, V> d;
  private c<K, V> e;
  private boolean f = false;
  private c<K, V> g;
  private c<K, V> h;
  
  em$c(c<K, V> paramc1, c<K, V> paramc2, K paramK, V paramV)
  {
    this.c = paramc1;
    this.h = paramc2;
    this.a = paramK;
    this.b = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    Object localObject = (Map.Entry)paramObject;
    paramObject = ((Map.Entry)localObject).getValue();
    if (this.a.equals(((Map.Entry)localObject).getKey()))
    {
      localObject = this.b;
      if (localObject == null ? paramObject == null : localObject.equals(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public final V getValue()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    int j = this.a.hashCode();
    Object localObject = this.b;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    return j ^ i;
  }
  
  public final V setValue(V paramV)
  {
    Object localObject = this.b;
    this.b = paramV;
    return localObject;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.em.c
 * JD-Core Version:    0.7.0.1
 */