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
    if (localNode != this.this$0.header)
    {
      if (this.this$0.modCount == this.expectedModCount)
      {
        this.next = localNode.next;
        this.lastReturned = localNode;
        return localNode;
      }
      throw new ConcurrentModificationException();
    }
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    LinkedTreeMap.Node localNode = this.lastReturned;
    if (localNode != null)
    {
      this.this$0.removeInternal(localNode, true);
      this.lastReturned = null;
      this.expectedModCount = this.this$0.modCount;
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.LinkedTreeMapIterator
 * JD-Core Version:    0.7.0.1
 */