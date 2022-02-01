package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class LinkedTreeMap$LinkedTreeMapIterator<T>
  implements Iterator<T>
{
  int expectedModCount = this.this$0.modCount;
  LinkedTreeMap.Node<K, V> lastReturned = null;
  LinkedTreeMap.Node<K, V> next = this.this$0.header.next;
  
  LinkedTreeMap$LinkedTreeMapIterator(LinkedTreeMap paramLinkedTreeMap) {}
  
  public final boolean hasNext()
  {
    return this.next != this.this$0.header;
  }
  
  final LinkedTreeMap.Node<K, V> nextNode()
  {
    LinkedTreeMap.Node localNode = this.next;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.LinkedTreeMapIterator
 * JD-Core Version:    0.7.0.1
 */