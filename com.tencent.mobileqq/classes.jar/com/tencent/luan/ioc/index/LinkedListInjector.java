package com.tencent.luan.ioc.index;

import com.tencent.luan.core.SingleLinkedListNode;
import com.tencent.luan.ioc.Injector;

public class LinkedListInjector
  implements Injector
{
  private SingleLinkedListNode<Object> headNode;
  private SingleLinkedListNode<Object> tailNode;
  
  private Object popNextValue()
  {
    Object localObject = this.headNode.getValue();
    this.headNode = this.headNode.next();
    if (this.headNode == null) {
      this.tailNode = null;
    }
    return localObject;
  }
  
  public void addLast(Object paramObject)
  {
    paramObject = new SingleLinkedListNode(paramObject);
    SingleLinkedListNode localSingleLinkedListNode = this.tailNode;
    if (localSingleLinkedListNode == null) {
      this.headNode = paramObject;
    } else {
      localSingleLinkedListNode.setNext(paramObject);
    }
    this.tailNode = paramObject;
  }
  
  public Object getOrCreateObject(Class<?> paramClass)
  {
    return popNextValue();
  }
  
  public Object getOrCreateObject(String paramString)
  {
    return popNextValue();
  }
  
  public void setHead(Object paramObject)
  {
    paramObject = new SingleLinkedListNode(paramObject);
    SingleLinkedListNode localSingleLinkedListNode = this.headNode;
    if (localSingleLinkedListNode == null)
    {
      this.headNode = paramObject;
      this.tailNode = paramObject;
      return;
    }
    paramObject.setNext(localSingleLinkedListNode);
    this.headNode = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.index.LinkedListInjector
 * JD-Core Version:    0.7.0.1
 */