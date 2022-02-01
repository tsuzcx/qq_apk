package com.bumptech.glide.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V>
  extends ArrayMap<K, V>
{
  private int a;
  
  public void clear()
  {
    this.a = 0;
    super.clear();
  }
  
  public int hashCode()
  {
    if (this.a == 0) {
      this.a = super.hashCode();
    }
    return this.a;
  }
  
  public V put(K paramK, V paramV)
  {
    this.a = 0;
    return super.put(paramK, paramV);
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    this.a = 0;
    super.putAll(paramSimpleArrayMap);
  }
  
  public V removeAt(int paramInt)
  {
    this.a = 0;
    return super.removeAt(paramInt);
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    this.a = 0;
    return super.setValueAt(paramInt, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.CachedHashCodeArrayMap
 * JD-Core Version:    0.7.0.1
 */