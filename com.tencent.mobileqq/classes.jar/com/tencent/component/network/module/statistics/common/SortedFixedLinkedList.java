package com.tencent.component.network.module.statistics.common;

import java.util.Comparator;

public class SortedFixedLinkedList<V>
  extends FixedLinkedList<V>
{
  private final Comparator<V> mComparator;
  
  public SortedFixedLinkedList(int paramInt, Comparator<V> paramComparator)
  {
    super(paramInt);
    this.mComparator = paramComparator;
  }
  
  public SortedFixedLinkedList(int paramInt, Comparator<V> paramComparator, boolean paramBoolean)
  {
    super(paramInt, paramBoolean);
    this.mComparator = paramComparator;
  }
  
  public void add(int paramInt, V paramV)
  {
    if (paramV == null) {
      return;
    }
    if (this.mComparator == null)
    {
      super.add(paramInt, paramV);
      return;
    }
    add(paramV);
  }
  
  public boolean add(V paramV)
  {
    int i = 0;
    if (paramV == null) {
      return false;
    }
    if (this.mComparator == null) {
      return super.add(paramV);
    }
    int j = size();
    if (i < j)
    {
      Object localObject = get(i);
      if (localObject == null) {}
      while (this.mComparator.compare(paramV, localObject) > 0)
      {
        i += 1;
        break;
      }
    }
    super.add(i, paramV);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.common.SortedFixedLinkedList
 * JD-Core Version:    0.7.0.1
 */