package com.android.dx.cf.code;

import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.LabeledItem;

public final class ByteBlock
  implements LabeledItem
{
  private final ByteCatchList catches;
  private final int end;
  private final int label;
  private final int start;
  private final IntList successors;
  
  public ByteBlock(int paramInt1, int paramInt2, int paramInt3, IntList paramIntList, ByteCatchList paramByteCatchList)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("label < 0");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("start < 0");
    }
    if (paramInt3 <= paramInt2) {
      throw new IllegalArgumentException("end <= start");
    }
    if (paramIntList == null) {
      throw new NullPointerException("targets == null");
    }
    int j = paramIntList.size();
    int i = 0;
    while (i < j)
    {
      if (paramIntList.get(i) < 0) {
        throw new IllegalArgumentException("successors[" + i + "] == " + paramIntList.get(i));
      }
      i += 1;
    }
    if (paramByteCatchList == null) {
      throw new NullPointerException("catches == null");
    }
    this.label = paramInt1;
    this.start = paramInt2;
    this.end = paramInt3;
    this.successors = paramIntList;
    this.catches = paramByteCatchList;
  }
  
  public ByteCatchList getCatches()
  {
    return this.catches;
  }
  
  public int getEnd()
  {
    return this.end;
  }
  
  public int getLabel()
  {
    return this.label;
  }
  
  public int getStart()
  {
    return this.start;
  }
  
  public IntList getSuccessors()
  {
    return this.successors;
  }
  
  public String toString()
  {
    return '{' + Hex.u2(this.label) + ": " + Hex.u2(this.start) + ".." + Hex.u2(this.end) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ByteBlock
 * JD-Core Version:    0.7.0.1
 */