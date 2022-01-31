package com.tencent.component.network.module.statistics.common;

import java.util.LinkedList;

public class FixedLinkedList
  extends LinkedList
{
  private final int mCapacity;
  private final boolean mTrimHead;
  
  public FixedLinkedList(int paramInt)
  {
    this(paramInt, true);
  }
  
  public FixedLinkedList(int paramInt, boolean paramBoolean)
  {
    this.mCapacity = paramInt;
    this.mTrimHead = paramBoolean;
  }
  
  private void a()
  {
    while ((this.mCapacity > 0) && (size() > this.mCapacity)) {
      if (this.mTrimHead) {
        removeFirst();
      } else {
        removeLast();
      }
    }
  }
  
  public void add(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    super.add(paramInt, paramObject);
    a();
  }
  
  public boolean add(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    boolean bool = super.add(paramObject);
    a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.common.FixedLinkedList
 * JD-Core Version:    0.7.0.1
 */