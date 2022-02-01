package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Assertions;

final class VorbisBitArray
{
  private int bitOffset;
  private final int byteLimit;
  private int byteOffset;
  private final byte[] data;
  
  public VorbisBitArray(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    this.byteLimit = paramArrayOfByte.length;
  }
  
  private void assertValidOffset()
  {
    int i = this.byteOffset;
    if (i >= 0)
    {
      int j = this.byteLimit;
      if ((i < j) || ((i == j) && (this.bitOffset == 0)))
      {
        bool = true;
        break label38;
      }
    }
    boolean bool = false;
    label38:
    Assertions.checkState(bool);
  }
  
  public int bitsLeft()
  {
    return (this.byteLimit - this.byteOffset) * 8 - this.bitOffset;
  }
  
  public int getPosition()
  {
    return this.byteOffset * 8 + this.bitOffset;
  }
  
  public boolean readBit()
  {
    boolean bool;
    if (((this.data[this.byteOffset] & 0xFF) >> this.bitOffset & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    skipBits(1);
    return bool;
  }
  
  public int readBits(int paramInt)
  {
    int k = this.byteOffset;
    int j = Math.min(paramInt, 8 - this.bitOffset);
    byte[] arrayOfByte = this.data;
    int i = k + 1;
    k = (arrayOfByte[k] & 0xFF) >> this.bitOffset & 255 >> 8 - j;
    while (j < paramInt)
    {
      k |= (this.data[i] & 0xFF) << j;
      j += 8;
      i += 1;
    }
    skipBits(paramInt);
    return k & -1 >>> 32 - paramInt;
  }
  
  public void reset()
  {
    this.byteOffset = 0;
    this.bitOffset = 0;
  }
  
  public void setPosition(int paramInt)
  {
    this.byteOffset = (paramInt / 8);
    this.bitOffset = (paramInt - this.byteOffset * 8);
    assertValidOffset();
  }
  
  public void skipBits(int paramInt)
  {
    int i = paramInt / 8;
    this.byteOffset += i;
    this.bitOffset += paramInt - i * 8;
    paramInt = this.bitOffset;
    if (paramInt > 7)
    {
      this.byteOffset += 1;
      this.bitOffset = (paramInt - 8);
    }
    assertValidOffset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.VorbisBitArray
 * JD-Core Version:    0.7.0.1
 */