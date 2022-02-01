package com.android.dx.util;

public class BitIntSet
  implements IntSet
{
  int[] bits;
  
  public BitIntSet(int paramInt)
  {
    this.bits = Bits.makeBitSet(paramInt);
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt >= Bits.getMax(this.bits))
    {
      int[] arrayOfInt = Bits.makeBitSet(Math.max(paramInt + 1, Bits.getMax(this.bits) * 2));
      System.arraycopy(this.bits, 0, arrayOfInt, 0, this.bits.length);
      this.bits = arrayOfInt;
    }
  }
  
  public void add(int paramInt)
  {
    ensureCapacity(paramInt);
    Bits.set(this.bits, paramInt, true);
  }
  
  public int elements()
  {
    return Bits.bitCount(this.bits);
  }
  
  public boolean has(int paramInt)
  {
    return (paramInt < Bits.getMax(this.bits)) && (Bits.get(this.bits, paramInt));
  }
  
  public IntIterator iterator()
  {
    return new BitIntSet.1(this);
  }
  
  public void merge(IntSet paramIntSet)
  {
    if ((paramIntSet instanceof BitIntSet))
    {
      paramIntSet = (BitIntSet)paramIntSet;
      ensureCapacity(Bits.getMax(paramIntSet.bits) + 1);
      Bits.or(this.bits, paramIntSet.bits);
    }
    for (;;)
    {
      return;
      if ((paramIntSet instanceof ListIntSet))
      {
        paramIntSet = (ListIntSet)paramIntSet;
        int i = paramIntSet.ints.size();
        if (i > 0) {
          ensureCapacity(paramIntSet.ints.get(i - 1));
        }
        i = 0;
        while (i < paramIntSet.ints.size())
        {
          Bits.set(this.bits, paramIntSet.ints.get(i), true);
          i += 1;
        }
      }
      else
      {
        paramIntSet = paramIntSet.iterator();
        while (paramIntSet.hasNext()) {
          add(paramIntSet.next());
        }
      }
    }
  }
  
  public void remove(int paramInt)
  {
    if (paramInt < Bits.getMax(this.bits)) {
      Bits.set(this.bits, paramInt, false);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    int j = 1;
    int i = Bits.findFirst(this.bits, 0);
    while (i >= 0)
    {
      if (j == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(i);
      i = Bits.findFirst(this.bits, i + 1);
      j = 0;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.BitIntSet
 * JD-Core Version:    0.7.0.1
 */