package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer
{
  private boolean isCompleted;
  private boolean isFilling;
  public byte[] nalData;
  public int nalLength;
  private final int targetType;
  
  public NalUnitTargetBuffer(int paramInt1, int paramInt2)
  {
    this.targetType = paramInt1;
    this.nalData = new byte[paramInt2 + 3];
    this.nalData[2] = 1;
  }
  
  public void appendToNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.isFilling) {
      return;
    }
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = this.nalData;
    int i = arrayOfByte.length;
    int j = this.nalLength;
    if (i < j + paramInt2) {
      this.nalData = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.nalLength, paramInt2);
    this.nalLength += paramInt2;
  }
  
  public boolean endNalUnit(int paramInt)
  {
    if (!this.isFilling) {
      return false;
    }
    this.nalLength -= paramInt;
    this.isFilling = false;
    this.isCompleted = true;
    return true;
  }
  
  public boolean isCompleted()
  {
    return this.isCompleted;
  }
  
  public void reset()
  {
    this.isFilling = false;
    this.isCompleted = false;
  }
  
  public void startNalUnit(int paramInt)
  {
    boolean bool2 = this.isFilling;
    boolean bool1 = true;
    Assertions.checkState(bool2 ^ true);
    if (paramInt != this.targetType) {
      bool1 = false;
    }
    this.isFilling = bool1;
    if (this.isFilling)
    {
      this.nalLength = 3;
      this.isCompleted = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer
 * JD-Core Version:    0.7.0.1
 */