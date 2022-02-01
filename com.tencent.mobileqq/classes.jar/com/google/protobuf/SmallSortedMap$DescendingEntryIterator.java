package com.google.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SmallSortedMap$DescendingEntryIterator
  implements Iterator<Map.Entry<K, V>>
{
  private int b = SmallSortedMap.b(this.a).size();
  private Iterator<Map.Entry<K, V>> c;
  
  private SmallSortedMap$DescendingEntryIterator(SmallSortedMap paramSmallSortedMap) {}
  
  private Iterator<Map.Entry<K, V>> b()
  {
    if (this.c == null) {
      this.c = SmallSortedMap.d(this.a).entrySet().iterator();
    }
    return this.c;
  }
  
  public Map.Entry<K, V> a()
  {
    if (b().hasNext()) {
      return (Map.Entry)b().next();
    }
    List localList = SmallSortedMap.b(this.a);
    int i = this.b - 1;
    this.b = i;
    return (Map.Entry)localList.get(i);
  }
  
  public boolean hasNext()
  {
    int i = this.b;
    return ((i > 0) && (i <= SmallSortedMap.b(this.a).size())) || (b().hasNext());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap.DescendingEntryIterator
 * JD-Core Version:    0.7.0.1
 */