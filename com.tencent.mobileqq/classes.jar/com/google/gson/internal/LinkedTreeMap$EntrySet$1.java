package com.google.gson.internal;

import java.util.Map.Entry;

class LinkedTreeMap$EntrySet$1
  extends LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>
{
  LinkedTreeMap$EntrySet$1(LinkedTreeMap.EntrySet paramEntrySet)
  {
    super(paramEntrySet.this$0);
  }
  
  public Map.Entry<K, V> next()
  {
    return nextNode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.EntrySet.1
 * JD-Core Version:    0.7.0.1
 */