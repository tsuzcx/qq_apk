package com.google.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class Internal$MapAdapter$SetAdapter
  extends AbstractSet<Map.Entry<K, V>>
{
  private final Set<Map.Entry<K, RealValue>> b;
  
  public Internal$MapAdapter$SetAdapter(Set<Map.Entry<K, RealValue>> paramSet)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new Internal.MapAdapter.IteratorAdapter(this.a, this.b.iterator());
  }
  
  public int size()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal.MapAdapter.SetAdapter
 * JD-Core Version:    0.7.0.1
 */