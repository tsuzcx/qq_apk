package com.android.dx.dex.code;

import com.android.dx.rop.code.SourcePosition;

public class PositionList$Entry
{
  private final int address;
  private final SourcePosition position;
  
  public PositionList$Entry(int paramInt, SourcePosition paramSourcePosition)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("address < 0");
    }
    if (paramSourcePosition == null) {
      throw new NullPointerException("position == null");
    }
    this.address = paramInt;
    this.position = paramSourcePosition;
  }
  
  public int getAddress()
  {
    return this.address;
  }
  
  public SourcePosition getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.PositionList.Entry
 * JD-Core Version:    0.7.0.1
 */