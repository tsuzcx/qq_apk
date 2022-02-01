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
  
  /* Error */
  LinkedBlockingDeque$AbstractItr(LinkedBlockingDeque paramLinkedBlockingDeque)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 20	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:this$0	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;
    //   5: aload_0
    //   6: invokespecial 23	java/lang/Object:<init>	()V
    //   9: aload_1
    //   10: getfield 29	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 37	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:firstNode	()Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   23: putfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   26: aload_0
    //   27: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   30: ifnonnull +15 -> 45
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: putfield 41	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:nextItem	Ljava/lang/Object;
    //   40: aload_2
    //   41: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   44: return
    //   45: aload_0
    //   46: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   49: getfield 49	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   52: astore_1
    //   53: goto -18 -> 35
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	AbstractItr
    //   0	63	1	paramLinkedBlockingDeque	LinkedBlockingDeque
    //   13	45	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   18	33	56	finally
    //   35	40	56	finally
    //   45	53	56	finally
  }
  
  private LinkedBlockingDeque.Node<E> succ(LinkedBlockingDeque.Node<E> paramNode)
  {
    for (;;)
    {
      LinkedBlockingDeque.Node localNode = nextNode(paramNode);
      Object localObject;
      if (localNode == null) {
        localObject = null;
      }
      do
      {
        return localObject;
        localObject = localNode;
      } while (localNode.item != null);
      if (localNode == paramNode) {
        return firstNode();
      }
      paramNode = localNode;
    }
  }
  
  /* Error */
  void advance()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:this$0	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;
    //   4: getfield 29	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   18: invokespecial 60	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:succ	(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;)Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   21: putfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   24: aload_0
    //   25: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   28: ifnonnull +15 -> 43
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 41	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:nextItem	Ljava/lang/Object;
    //   38: aload_2
    //   39: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: return
    //   43: aload_0
    //   44: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   47: getfield 49	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	AbstractItr
    //   32	19	1	localObject1	Object
    //   54	6	1	localObject2	Object
    //   7	49	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   12	31	54	finally
    //   33	38	54	finally
    //   43	51	54	finally
  }
  
  abstract LinkedBlockingDeque.Node<E> firstNode();
  
  public boolean hasNext()
  {
    return this.next != null;
  }
  
  public E next()
  {
    if (this.next == null) {
      throw new NoSuchElementException();
    }
    this.lastRet = this.next;
    Object localObject = this.nextItem;
    advance();
    return localObject;
  }
  
  abstract LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode);
  
  public void remove()
  {
    LinkedBlockingDeque.Node localNode = this.lastRet;
    if (localNode == null) {
      throw new IllegalStateException();
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
 * JD-Core Version:    0.7.0.1
 */