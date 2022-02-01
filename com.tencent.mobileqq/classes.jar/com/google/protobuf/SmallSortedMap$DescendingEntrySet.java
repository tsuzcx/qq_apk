package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class SmallSortedMap$DescendingEntrySet
  extends SmallSortedMap<K, V>.EntrySet
{
  private SmallSortedMap$DescendingEntrySet(SmallSortedMap paramSmallSortedMap)
  {
    super(paramSmallSortedMap, null);
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new SmallSortedMap.DescendingEntryIterator(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap.DescendingEntrySet
 * JD-Core Version:    0.7.0.1
 */