package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class Internal$MapAdapter$IteratorAdapter
  implements Iterator<Map.Entry<K, V>>
{
  private final Iterator<Map.Entry<K, RealValue>> b;
  
  public Internal$MapAdapter$IteratorAdapter(Iterator<Map.Entry<K, RealValue>> paramIterator)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public Map.Entry<K, V> a()
  {
    return new Internal.MapAdapter.EntryAdapter(this.a, (Map.Entry)this.b.next());
  }
  
  public boolean hasNext()
  {
    return this.b.hasNext();
  }
  
  public void remove()
  {
    this.b.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal.MapAdapter.IteratorAdapter
 * JD-Core Version:    0.7.0.1
 */