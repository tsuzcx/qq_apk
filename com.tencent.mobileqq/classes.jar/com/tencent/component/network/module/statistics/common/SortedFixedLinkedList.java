package com.tencent.component.network.module.statistics.common;

import java.util.Comparator;

public class SortedFixedLinkedList
  extends FixedLinkedList
{
  private final Comparator mComparator;
  
  public SortedFixedLinkedList(int paramInt, Comparator paramComparator)
  {
    super(paramInt);
    this.mComparator = paramComparator;
  }
  
  public SortedFixedLinkedList(int paramInt, Comparator paramComparator, boolean paramBoolean)
  {
    super(paramInt, paramBoolean);
    this.mComparator = paramComparator;
  }
  
  public void add(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (this.mComparator == null)
    {
      super.add(paramInt, paramObject);
      return;
    }
    add(paramObject);
  }
  
  public boolean add(Object paramObject)
  {
    int i = 0;
    if (paramObject == null) {
      return false;
    }
    if (this.mComparator == null) {
      return super.add(paramObject);
    }
    int j = size();
    if (i < j)
    {
      Object localObject = get(i);
      if (localObject == null) {}
      while (this.mComparator.compare(paramObject, localObject) > 0)
      {
        i += 1;
        break;
      }
    }
    super.add(i, paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.common.SortedFixedLinkedList
 * JD-Core Version:    0.7.0.1
 */