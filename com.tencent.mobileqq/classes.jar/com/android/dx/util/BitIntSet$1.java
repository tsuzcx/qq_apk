package com.android.dx.util;

import java.util.NoSuchElementException;

class BitIntSet$1
  implements IntIterator
{
  private int idx = Bits.findFirst(this.this$0.bits, 0);
  
  BitIntSet$1(BitIntSet paramBitIntSet) {}
  
  public boolean hasNext()
  {
    return this.idx >= 0;
  }
  
  public int next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    int i = this.idx;
    this.idx = Bits.findFirst(this.this$0.bits, this.idx + 1);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.BitIntSet.1
 * JD-Core Version:    0.7.0.1
 */