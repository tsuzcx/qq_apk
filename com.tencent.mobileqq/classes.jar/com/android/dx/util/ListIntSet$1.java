package com.android.dx.util;

import java.util.NoSuchElementException;

class ListIntSet$1
  implements IntIterator
{
  private int idx = 0;
  
  ListIntSet$1(ListIntSet paramListIntSet) {}
  
  public boolean hasNext()
  {
    return this.idx < this.this$0.ints.size();
  }
  
  public int next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    IntList localIntList = this.this$0.ints;
    int i = this.idx;
    this.idx = (i + 1);
    return localIntList.get(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ListIntSet.1
 * JD-Core Version:    0.7.0.1
 */