package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.core.SingleLinkedListNode;
import com.tencent.luan.ioc.Injector;

public class FixObjectWrapper<T>
  implements ObjectWrapper<T>
{
  private final SingleLinkedListNode<T> node;
  
  public FixObjectWrapper(T paramT)
  {
    this.node = new SingleLinkedListNode(paramT);
  }
  
  public ObjectWrapper<T> combine(T paramT)
  {
    if ((!this.node.hasNext()) && (this.node.getValue() != paramT)) {
      this.node.setNext(new SingleLinkedListNode(paramT));
    }
    return this;
  }
  
  public ObjectHolder<T> createObjectIfAbsent(Injector paramInjector)
  {
    if (!this.node.hasNext()) {
      return new ObjectHolder(this.node.getValue(), false);
    }
    throw new IllegalStateException("fix object wrapper has more than one object");
  }
  
  public boolean needCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.FixObjectWrapper
 * JD-Core Version:    0.7.0.1
 */