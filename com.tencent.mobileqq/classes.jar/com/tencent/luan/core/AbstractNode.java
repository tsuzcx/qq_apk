package com.tencent.luan.core;

public abstract class AbstractNode<E>
  implements Iterable<E>
{
  protected final E element;
  
  public AbstractNode(E paramE)
  {
    this.element = paramE;
  }
  
  public E getValue()
  {
    return this.element;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.luan.core.AbstractNode
 * JD-Core Version:    0.7.0.1
 */