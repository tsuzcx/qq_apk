package com.google.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class SmallSortedMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  private SmallSortedMap$EntrySet(SmallSortedMap paramSmallSortedMap) {}
  
  public boolean a(Map.Entry<K, V> paramEntry)
  {
    if (!contains(paramEntry))
    {
      this.b.a((Comparable)paramEntry.getKey(), paramEntry.getValue());
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    this.b.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.b.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new SmallSortedMap.EntryIterator(this.b, null);
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.b.remove(paramObject.getKey());
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap.EntrySet
 * JD-Core Version:    0.7.0.1
 */