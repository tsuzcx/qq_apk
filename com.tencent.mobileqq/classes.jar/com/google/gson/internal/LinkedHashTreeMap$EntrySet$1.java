package com.google.gson.internal;

import java.util.Map.Entry;

class LinkedHashTreeMap$EntrySet$1
  extends LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>
{
  LinkedHashTreeMap$EntrySet$1(LinkedHashTreeMap.EntrySet paramEntrySet)
  {
    super(paramEntrySet.this$0);
  }
  
  public Map.Entry<K, V> next()
  {
    return nextNode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap.EntrySet.1
 * JD-Core Version:    0.7.0.1
 */