package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class LazyField$LazyIterator<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> a;
  
  public LazyField$LazyIterator(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.a = paramIterator;
  }
  
  public Map.Entry<K, Object> a()
  {
    Map.Entry localEntry = (Map.Entry)this.a.next();
    if ((localEntry.getValue() instanceof LazyField)) {
      return new LazyField.LazyEntry(localEntry, null);
    }
    return localEntry;
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public void remove()
  {
    this.a.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyField.LazyIterator
 * JD-Core Version:    0.7.0.1
 */