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
    if ((2 <= paramInt) && (paramInt < this.byteLimit))
    {
      byte[] arrayOfByte = this.data;
      if ((arrayOfByte[paramInt] == 3) && (arrayOfByte[(paramInt - 2)] == 0) && (arrayOfByte[(paramInt - 1)] == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean canReadBits(int paramInt)
  {
    int k = this.byteOffset;
    int i = paramInt / 8;
    int j = k + i;
    int m = this.bitOffset + paramInt - i * 8;
    paramInt = j;
    i = m;
    if (m > 7)
    {
      paramInt = j + 1;
      i = m - 8;
    }
    boolean bool = true;
    j = paramInt;
    paramInt = k;
    for (;;)
    {
      k = paramInt + 1;
      if ((k > j) || (j >= this.byteLimit)) {
        break;
      }
      paramInt = k;
      if (shouldSkipByte(k))
      {
        j += 1;
        paramInt = k + 2;
      }
    }
    paramInt = this.byteLimit;
    if (j >= paramInt)
    {
      if ((j == paramInt) && (i == 0)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean canReadExpGolombCodedNum()
  {
    int k = this.byteOffset;
    int m = this.bitOffset;
    boolean bool2 = false;
    int i = 0;
    while ((this.byteOffset < this.byteLimit) && (!readBit())) {
      i += 1;
    }
    int j;
    if (this.byteOffset == this.byteLimit) {
      j = 1;
    } else {
      j = 0;
    }
    this.byteOffset = k;
    this.bitOffset = m;
    boolean bool1 = bool2;
    if (j == 0)
    {
      bool1 = bool2;
      if (canReadBits(i * 2 + 1)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean readBit()
  {
    boolean bool;
    if ((this.data[this.byteOffset] & 128 >> this.bitOffset) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    skipBit();
    return bool;
  }
  
  public int readBits(int paramInt)
  {
    this.bitOffset += paramInt;
    int i = 0;
    int k;
    int j;
    for (;;)
    {
      k = this.bitOffset;
      j = 2;
      if (k <= 8) {
        break;
      }
      this.bitOffset = (k - 8);
      arrayOfByte = this.data;
      k = this.byteOffset;
      i |= (arrayOfByte[k] & 0xFF) << this.bitOffset;
      if (!shouldSkipByte(k + 1)) {
        j = 1;
      }
      this.byteOffset = (k + j);
    }
    byte[] arrayOfByte = this.data;
    int m = this.byteOffset;
    int n = arrayOfByte[m];
    if (k == 8)
    {
      this.bitOffset = 0;
      if (!shouldSkipByte(m + 1)) {
        j = 1;
      }
      this.byteOffset = (m + j);
    }
    assertValidOffset();
    return -1 >>> 32 - paramInt & (i | (n & 0xFF) >> 8 - k);
  }
  
  public int readSignedExpGolombCodedInt()
  {
    int j = readExpGolombCodeNum();
    int i;
    if (j % 2 == 0) {
      i = -1;
    } else {
      i = 1;
    }
    return i * ((j + 1) / 2);
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
    int j = this.bitOffset;
    int i = 1;
    j += 1;
    this.bitOffset = j;
    if (j == 8)
    {
      this.bitOffset = 0;
      j = this.byteOffset;
      if (shouldSkipByte(j + 1)) {
        i = 2;
      }
      this.byteOffset = (j + i);
    }
    assertValidOffset();
  }
  
  public void skipBits(int paramInt)
  {
    int i = this.byteOffset;
    int j = paramInt / 8;
    this.byteOffset = (i + j);
    this.bitOffset += paramInt - j * 8;
    j = this.bitOffset;
    paramInt = i;
    if (j > 7)
    {
      this.byteOffset += 1;
      this.bitOffset = (j - 8);
      paramInt = i;
    }
    for (;;)
    {
      i = paramInt + 1;
      if (i > this.byteOffset) {
        break;
      }
      paramInt = i;
      if (shouldSkipByte(i))
      {
        this.byteOffset += 1;
        paramInt = i + 2;
      }
    }
    assertValidOffset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ParsableNalUnitBitArray
 * JD-Core Version:    0.7.0.1
 */