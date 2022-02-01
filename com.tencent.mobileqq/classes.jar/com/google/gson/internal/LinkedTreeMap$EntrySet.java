package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class LinkedTreeMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  LinkedTreeMap$EntrySet(LinkedTreeMap paramLinkedTreeMap) {}
  
  public void clear()
  {
    this.this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return ((paramObject instanceof Map.Entry)) && (this.this$0.findByEntry((Map.Entry)paramObject) != null);
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new LinkedTreeMap.EntrySet.1(this);
  }
  
  public boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = this.this$0.findByEntry((Map.Entry)paramObject);
    if (paramObject == null) {
      return false;
    }
    this.this$0.removeInternal(paramObject, true);
    return true;
  }
  
  public int size()
  {
    return this.this$0.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.EntrySet
 * JD-Core Version:    0.7.0.1
 */