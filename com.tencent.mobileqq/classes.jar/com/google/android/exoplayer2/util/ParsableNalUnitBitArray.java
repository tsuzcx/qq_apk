package com.google.android.exoplayer2.util;

public final class ParsableNalUnitBitArray
{
  private int bitOffset;
  private int byteLimit;
  private int byteOffset;
  private byte[] data;
  
  public ParsableNalUnitBitArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    reset(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void assertValidOffset()
  {
    if ((this.byteOffset >= 0) && ((this.byteOffset < this.byteLimit) || ((this.byteOffset == this.byteLimit) && (this.bitOffset == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      return;
    }
  }
  
  private int readExpGolombCodeNum()
  {
    int j = 0;
    int i = 0;
    while (!readBit()) {
      i += 1;
    }
    if (i > 0) {
      j = readBits(i);
    }
    return (1 << i) - 1 + j;
  }
  
  private boolean shouldSkipByte(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.byteLimit) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  public boolean canReadBits(int paramInt)
  {
    int m = this.byteOffset;
    int i = paramInt / 8;
    int j = this.byteOffset + i;
    int k = this.bitOffset + paramInt - i * 8;
    i = k;
    paramInt = j;
    if (k > 7)
    {
      paramInt = j + 1;
      i = k - 8;
    }
    j = m + 1;
    k = paramInt;
    paramInt = j;
    while ((paramInt <= k) && (k < this.byteLimit))
    {
      m = paramInt;
      j = k;
      if (shouldSkipByte(paramInt))
      {
        j = k + 1;
        m = paramInt + 2;
      }
      paramInt = m + 1;
      k = j;
    }
    return (k < this.byteLimit) || ((k == this.byteLimit) && (i == 0));
  }
  
  public boolean canReadExpGolombCodedNum()
  {
    int k = this.byteOffset;
    int m = this.bitOffset;
    int i = 0;
    while ((this.byteOffset < this.byteLimit) && (!readBit())) {
      i += 1;
    }
    if (this.byteOffset == this.byteLimit) {}
    for (int j = 1;; j = 0)
    {
      this.byteOffset = k;
      this.bitOffset = m;
      if ((j != 0) || (!canReadBits(i * 2 + 1))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean readBit()
  {
    if ((this.data[this.byteOffset] & 128 >> this.bitOffset) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      skipBit();
      return bool;
    }
  }
  
  public int readBits(int paramInt)
  {
    int j = 2;
    this.bitOffset += paramInt;
    int i = 0;
    if (this.bitOffset > 8)
    {
      this.bitOffset -= 8;
      k = i | (this.data[this.byteOffset] & 0xFF) << this.bitOffset;
      m = this.byteOffset;
      if (shouldSkipByte(this.byteOffset + 1)) {}
      for (i = 2;; i = 1)
      {
        this.byteOffset = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.byteOffset];
    int m = this.bitOffset;
    int n;
    if (this.bitOffset == 8)
    {
      this.bitOffset = 0;
      n = this.byteOffset;
      if (!shouldSkipByte(this.byteOffset + 1)) {
        break label180;
      }
    }
    for (;;)
    {
      this.byteOffset = (n + j);
      assertValidOffset();
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label180:
      j = 1;
    }
  }
  
  public int readSignedExpGolombCodedInt()
  {
    int j = readExpGolombCodeNum();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1) {
      return i * ((j + 1) / 2);
    }
  }
  
  public int readUnsignedExpGolombCodedInt()
  {
    return readExpGolombCodeNum();
  }
  
  public void reset(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.byteOffset = paramInt1;
    this.byteLimit = paramInt2;
    this.bitOffset = 0;
    assertValidOffset();
  }
  
  public void skipBit()
  {
    int i = this.bitOffset + 1;
    this.bitOffset = i;
    int j;
    if (i == 8)
    {
      this.bitOffset = 0;
      j = this.byteOffset;
      if (!shouldSkipByte(this.byteOffset + 1)) {
        break label55;
      }
    }
    label55:
    for (i = 2;; i = 1)
    {
      this.byteOffset = (i + j);
      assertValidOffset();
      return;
    }
  }
  
  public void skipBits(int paramInt)
  {
    int i = this.byteOffset;
    int j = paramInt / 8;
    this.byteOffset += j;
    this.bitOffset = (paramInt - j * 8 + this.bitOffset);
    if (this.bitOffset > 7)
    {
      this.byteOffset += 1;
      this.bitOffset -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.byteOffset; paramInt = i + 1)
    {
      i = paramInt;
      if (shouldSkipByte(paramInt))
      {
        this.byteOffset += 1;
        i = paramInt + 2;
      }
    }
    assertValidOffset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ParsableNalUnitBitArray
 * JD-Core Version:    0.7.0.1
 */