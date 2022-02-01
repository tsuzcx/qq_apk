package com.android.dx.cf.code;

import com.android.dx.util.Hex;
import com.android.dx.util.LabeledList;

public final class ByteBlockList
  extends LabeledList
{
  public ByteBlockList(int paramInt)
  {
    super(paramInt);
  }
  
  public ByteBlock get(int paramInt)
  {
    return (ByteBlock)get0(paramInt);
  }
  
  public ByteBlock labelToBlock(int paramInt)
  {
    int i = indexOfLabel(paramInt);
    if (i < 0) {
      throw new IllegalArgumentException("no such label: " + Hex.u2(paramInt));
    }
    return get(i);
  }
  
  public void set(int paramInt, ByteBlock paramByteBlock)
  {
    super.set(paramInt, paramByteBlock);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ByteBlockList
 * JD-Core Version:    0.7.0.1
 */