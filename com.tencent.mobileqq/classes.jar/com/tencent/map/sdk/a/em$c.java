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
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        localObject = paramObject.getValue();
      } while (!this.a.equals(paramObject.getKey()));
      if (this.b != null) {
        break;
      }
    } while (localObject != null);
    for (;;)
    {
      return true;
      if (!this.b.equals(localObject)) {
        break;
      }
    }
  }
  
  public final V getValue()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    int j = this.a.hashCode();
    if (this.b == null) {}
    for (int i = 0;; i = this.b.hashCode()) {
      return i ^ j;
    }
  }
  
  public final V setValue(V paramV)
  {
    Object localObject = this.b;
    this.b = paramV;
    return localObject;
  }
  
  public final String toString()
  {
    return this.a + "=" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.em.c
 * JD-Core Version:    0.7.0.1
 */