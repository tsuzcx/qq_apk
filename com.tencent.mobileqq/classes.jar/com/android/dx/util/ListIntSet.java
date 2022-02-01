package com.android.dx.util;

public class ListIntSet
  implements IntSet
{
  final IntList ints = new IntList();
  
  public ListIntSet()
  {
    this.ints.sort();
  }
  
  public void add(int paramInt)
  {
    int i = this.ints.binarysearch(paramInt);
    if (i < 0) {
      this.ints.insert(-(i + 1), paramInt);
    }
  }
  
  public int elements()
  {
    return this.ints.size();
  }
  
  public boolean has(int paramInt)
  {
    return this.ints.indexOf(paramInt) >= 0;
  }
  
  public IntIterator iterator()
  {
    return new ListIntSet.1(this);
  }
  
  public void merge(IntSet paramIntSet)
  {
    int j = 0;
    int i = 0;
    if ((paramIntSet instanceof ListIntSet))
    {
      paramIntSet = (ListIntSet)paramIntSet;
      int i1 = this.ints.size();
      int n = paramIntSet.ints.size();
      int k = 0;
      j = i;
      int m;
      if (i < n)
      {
        j = i;
        if (k < i1)
        {
          j = i;
          while ((j < n) && (paramIntSet.ints.get(j) < this.ints.get(k)))
          {
            add(paramIntSet.ints.get(j));
            j += 1;
          }
          m = k;
          if (j != n) {
            break label136;
          }
        }
      }
      while (j < n)
      {
        add(paramIntSet.ints.get(j));
        j += 1;
      }
      for (;;)
      {
        label136:
        i = j;
        k = m;
        if (m >= i1) {
          break;
        }
        i = j;
        k = m;
        if (paramIntSet.ints.get(j) < this.ints.get(m)) {
          break;
        }
        m += 1;
      }
      this.ints.sort();
    }
    for (;;)
    {
      return;
      if ((paramIntSet instanceof BitIntSet))
      {
        paramIntSet = (BitIntSet)paramIntSet;
        for (i = j; i >= 0; i = Bits.findFirst(paramIntSet.bits, i + 1)) {
          this.ints.add(i);
        }
        this.ints.sort();
        return;
      }
      paramIntSet = paramIntSet.iterator();
      while (paramIntSet.hasNext()) {
        add(paramIntSet.next());
      }
    }
  }
  
  public void remove(int paramInt)
  {
    paramInt = this.ints.indexOf(paramInt);
    if (paramInt >= 0) {
      this.ints.removeIndex(paramInt);
    }
  }
  
  public String toString()
  {
    return this.ints.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ListIntSet
 * JD-Core Version:    0.7.0.1
 */