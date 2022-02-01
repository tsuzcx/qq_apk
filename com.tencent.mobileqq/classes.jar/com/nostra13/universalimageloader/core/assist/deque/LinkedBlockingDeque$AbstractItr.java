package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

abstract class LinkedBlockingDeque$AbstractItr
  implements Iterator<E>
{
  private LinkedBlockingDeque.Node<E> lastRet;
  LinkedBlockingDeque.Node<E> next;
  E nextItem;
  
  LinkedBlockingDeque$AbstractItr(LinkedBlockingDeque paramLinkedBlockingDeque)
  {
    ReentrantLock localReentrantLock = paramLinkedBlockingDeque.lock;
    localReentrantLock.lock();
    try
    {
      this.next = firstNode();
      if (this.next == null) {
        paramLinkedBlockingDeque = null;
      } else {
        paramLinkedBlockingDeque = this.next.item;
      }
      this.nextItem = paramLinkedBlockingDeque;
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private LinkedBlockingDeque.Node<E> succ(LinkedBlockingDeque.Node<E> paramNode)
  {
    for (;;)
    {
      LinkedBlockingDeque.Node localNode = nextNode(paramNode);
      if (localNode == null) {
        return null;
      }
      if (localNode.item != null) {
        return localNode;
      }
      if (localNode == paramNode) {
        return firstNode();
      }
      paramNode = localNode;
    }
  }
  
  void advance()
  {
    ReentrantLock localReentrantLock = this.this$0.lock;
    localReentrantLock.lock();
    try
    {
      this.next = succ(this.next);
      Object localObject1;
      if (this.next == null) {
        localObject1 = null;
      } else {
        localObject1 = this.next.item;
      }
      this.nextItem = localObject1;
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  abstract LinkedBlockingDeque.Node<E> firstNode();
  
  public boolean hasNext()
  {
    return this.next != null;
  }
  
  public E next()
  {
    Object localObject = this.next;
    if (localObject != null)
    {
      this.lastRet = ((LinkedBlockingDeque.Node)localObject);
      localObject = this.nextItem;
      advance();
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  abstract LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode);
  
  public void remove()
  {
    LinkedBlockingDeque.Node localNode = this.lastRet;
    if (localNode != null)
    {
      this.lastRet = null;
      ReentrantLock localReentrantLock = this.this$0.lock;
      localReentrantLock.lock();
      try
      {
        if (localNode.item != null) {
          this.this$0.unlink(localNode);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
 * JD-Core Version:    0.7.0.1
 */