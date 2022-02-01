package com.google.gson.internal;

class LinkedTreeMap$KeySet$1
  extends LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>
{
  LinkedTreeMap$KeySet$1(LinkedTreeMap.KeySet paramKeySet)
  {
    super(paramKeySet.this$0);
  }
  
  public K next()
  {
    return nextNode().key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.KeySet.1
 * JD-Core Version:    0.7.0.1
 */