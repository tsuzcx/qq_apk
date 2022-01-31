package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

final class LinkedTreeMap$KeySet
  extends AbstractSet<K>
{
  LinkedTreeMap$KeySet(LinkedTreeMap paramLinkedTreeMap) {}
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.this$0.containsKey(paramObject);
  }
  
  public Iterator<K> iterator()
  {
    return new LinkedTreeMap.KeySet.1(this);
  }
  
  public boolean remove(Object paramObject)
  {
    return this.this$0.removeInternalByKey(paramObject) != null;
  }
  
  public int size()
  {
    return this.this$0.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.KeySet
 * JD-Core Version:    0.7.0.1
 */