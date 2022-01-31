package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class LinkedHashTreeMap$LinkedTreeMapIterator<T>
  implements Iterator<T>
{
  int expectedModCount = this.this$0.modCount;
  LinkedHashTreeMap.Node<K, V> lastReturned = null;
  LinkedHashTreeMap.Node<K, V> next = this.this$0.header.next;
  
  LinkedHashTreeMap$LinkedTreeMapIterator(LinkedHashTreeMap paramLinkedHashTreeMap) {}
  
  public final boolean hasNext()
  {
    return this.next != this.this$0.header;
  }
  
  final LinkedHashTreeMap.Node<K, V> nextNode()
  {
    LinkedHashTreeMap.Node localNode = this.next;
    if (localNode == this.this$0.header) {
      throw new NoSuchElementException();
    }
    if (this.this$0.modCount != this.expectedModCount) {
      throw new ConcurrentModificationException();
    }
    this.next = localNode.next;
    this.lastReturned = localNode;
    return localNode;
  }
  
  public final void remove()
  {
    if (this.lastReturned == null) {
      throw new IllegalStateException();
    }
    this.this$0.removeInternal(this.lastReturned, true);
    this.lastReturned = null;
    this.expectedModCount = this.this$0.modCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap.LinkedTreeMapIterator
 * JD-Core Version:    0.7.0.1
 */