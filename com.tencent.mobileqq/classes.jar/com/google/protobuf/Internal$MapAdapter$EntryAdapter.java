package com.google.protobuf;

import java.util.Map.Entry;

class Internal$MapAdapter$EntryAdapter
  implements Map.Entry<K, V>
{
  private final Map.Entry<K, RealValue> b;
  
  public Internal$MapAdapter$EntryAdapter(Map.Entry<K, RealValue> paramEntry)
  {
    Object localObject;
    this.b = localObject;
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
    return (getKey().equals(paramObject.getKey())) && (getValue().equals(getValue()));
  }
  
  public K getKey()
  {
    return this.b.getKey();
  }
  
  public V getValue()
  {
    return Internal.MapAdapter.a(this.a).b(this.b.getValue());
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public V setValue(V paramV)
  {
    paramV = this.b.setValue(Internal.MapAdapter.a(this.a).a(paramV));
    if (paramV == null) {
      return null;
    }
    return Internal.MapAdapter.a(this.a).b(paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal.MapAdapter.EntryAdapter
 * JD-Core Version:    0.7.0.1
 */