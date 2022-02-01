package com.android.dx.ssa.back;

class FirstFitLocalCombiningAllocator$Multiset
{
  private final int[] count;
  private final int[] reg;
  private int size;
  
  public FirstFitLocalCombiningAllocator$Multiset(int paramInt)
  {
    this.reg = new int[paramInt];
    this.count = new int[paramInt];
    this.size = 0;
  }
  
  public void add(int paramInt)
  {
    int i = 0;
    while (i < this.size)
    {
      if (this.reg[i] == paramInt)
      {
        int[] arrayOfInt = this.count;
        arrayOfInt[i] += 1;
        return;
      }
      i += 1;
    }
    this.reg[this.size] = paramInt;
    this.count[this.size] = 1;
    this.size += 1;
  }
  
  public int getAndRemoveHighestCount()
  {
    int k = 0;
    int m = -1;
    int j = -1;
    int i = 0;
    while (i < this.size)
    {
      int n = k;
      if (k < this.count[i])
      {
        m = this.reg[i];
        n = this.count[i];
        j = i;
      }
      i += 1;
      k = n;
    }
    this.count[j] = 0;
    return m;
  }
  
  public int getSize()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Multiset
 * JD-Core Version:    0.7.0.1
 */