package com.google.protobuf;

import java.util.Map.Entry;

class LazyField$LazyEntry<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, LazyField> a;
  
  private LazyField$LazyEntry(Map.Entry<K, LazyField> paramEntry)
  {
    this.a = paramEntry;
  }
  
  public LazyField a()
  {
    return (LazyField)this.a.getValue();
  }
  
  public K getKey()
  {
    return this.a.getKey();
  }
  
  public Object getValue()
  {
    LazyField localLazyField = (LazyField)this.a.getValue();
    if (localLazyField == null) {
      return null;
    }
    return localLazyField.a();
  }
  
  public Object setValue(Object paramObject)
  {
    if ((paramObject instanceof MessageLite)) {
      return ((LazyField)this.a.getValue()).b((MessageLite)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyField.LazyEntry
 * JD-Core Version:    0.7.0.1
 */