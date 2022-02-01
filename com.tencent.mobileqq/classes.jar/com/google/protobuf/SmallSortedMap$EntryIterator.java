package com.google.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SmallSortedMap$EntryIterator
  implements Iterator<Map.Entry<K, V>>
{
  private int b = -1;
  private boolean c;
  private Iterator<Map.Entry<K, V>> d;
  
  private SmallSortedMap$EntryIterator(SmallSortedMap paramSmallSortedMap) {}
  
  private Iterator<Map.Entry<K, V>> b()
  {
    if (this.d == null) {
      this.d = SmallSortedMap.c(this.a).entrySet().iterator();
    }
    return this.d;
  }
  
  public Map.Entry<K, V> a()
  {
    this.c = true;
    int i = this.b + 1;
    this.b = i;
    if (i < SmallSortedMap.b(this.a).size()) {
      return (Map.Entry)SmallSortedMap.b(this.a).get(this.b);
    }
    return (Map.Entry)b().next();
  }
  
  public boolean hasNext()
  {
    int i = this.b;
    boolean bool = true;
    if (i + 1 >= SmallSortedMap.b(this.a).size())
    {
      if ((!SmallSortedMap.c(this.a).isEmpty()) && (b().hasNext())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void remove()
  {
    if (this.c)
    {
      this.c = false;
      SmallSortedMap.a(this.a);
      if (this.b < SmallSortedMap.b(this.a).size())
      {
        SmallSortedMap localSmallSortedMap = this.a;
        int i = this.b;
        this.b = (i - 1);
        SmallSortedMap.a(localSmallSortedMap, i);
        return;
      }
      b().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap.EntryIterator
 * JD-Core Version:    0.7.0.1
 */