package com.google.android.exoplayer2.util;

public final class ParsableBitArray
{
  private int bitOffset;
  private int byteLimit;
  private int byteOffset;
  public byte[] data;
  
  public ParsableBitArray() {}
  
  public ParsableBitArray(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public ParsableBitArray(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.byteLimit = paramInt;
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
  
  public void byteAlign()
  {
    if (this.bitOffset == 0) {
      return;
    }
    this.bitOffset = 0;
    this.byteOffset += 1;
    assertValidOffset();
  }
  
  public int getBytePosition()
  {
    boolean bool;
    if (this.bitOffset == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    return this.byteOffset;
  }
  
  public int getPosition()
  {
    return this.byteOffset * 8 + this.bitOffset;
  }
  
  public void putInt(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 < 32) {
      i = paramInt1 & (1 << paramInt2) - 1;
    }
    int j = Math.min(8 - this.bitOffset, paramInt2);
    int m = this.bitOffset;
    paramInt1 = 8 - m - j;
    byte[] arrayOfByte = this.data;
    int k = this.byteOffset;
    arrayOfByte[k] = ((byte)((65280 >> m | (1 << paramInt1) - 1) & arrayOfByte[k]));
    j = paramInt2 - j;
    arrayOfByte[k] = ((byte)(i >>> j << paramInt1 | arrayOfByte[k]));
    paramInt1 = k + 1;
    while (j > 8)
    {
      this.data[paramInt1] = ((byte)(i >>> j - 8));
      j -= 8;
      paramInt1 += 1;
    }
    k = 8 - j;
    arrayOfByte = this.data;
    arrayOfByte[paramInt1] = ((byte)(arrayOfByte[paramInt1] & (1 << k) - 1));
    arrayOfByte[paramInt1] = ((byte)((i & (1 << j) - 1) << k | arrayOfByte[paramInt1]));
    skipBits(paramInt2);
    assertValidOffset();
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
    if (paramInt == 0) {
      return 0;
    }
    this.bitOffset += paramInt;
    int i = 0;
    int j;
    for (;;)
    {
      j = this.bitOffset;
      if (j <= 8) {
        break;
      }
      this.bitOffset = (j - 8);
      arrayOfByte = this.data;
      j = this.byteOffset;
      this.byteOffset = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.bitOffset;
    }
    byte[] arrayOfByte = this.data;
    int k = this.byteOffset;
    int m = arrayOfByte[k];
    if (j == 8)
    {
      this.bitOffset = 0;
      this.byteOffset = (k + 1);
    }
    assertValidOffset();
    return -1 >>> 32 - paramInt & (i | (m & 0xFF) >> 8 - j);
  }
  
  public void readBits(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = (paramInt2 >> 3) + paramInt1;
    while (paramInt1 < i)
    {
      arrayOfByte = this.data;
      j = this.byteOffset;
      this.byteOffset = (j + 1);
      k = arrayOfByte[j];
      j = this.bitOffset;
      paramArrayOfByte[paramInt1] = ((byte)(k << j));
      k = paramArrayOfByte[paramInt1];
      paramArrayOfByte[paramInt1] = ((byte)((0xFF & arrayOfByte[this.byteOffset]) >> 8 - j | k));
      paramInt1 += 1;
    }
    paramInt1 = paramInt2 & 0x7;
    if (paramInt1 == 0) {
      return;
    }
    paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] & 255 >> paramInt1));
    paramInt2 = this.bitOffset;
    if (paramInt2 + paramInt1 > 8)
    {
      j = paramArrayOfByte[i];
      arrayOfByte = this.data;
      k = this.byteOffset;
      this.byteOffset = (k + 1);
      paramArrayOfByte[i] = ((byte)(j | (byte)((arrayOfByte[k] & 0xFF) << paramInt2)));
      this.bitOffset = (paramInt2 - 8);
    }
    this.bitOffset += paramInt1;
    byte[] arrayOfByte = this.data;
    paramInt2 = this.byteOffset;
    int j = arrayOfByte[paramInt2];
    int k = this.bitOffset;
    int m = paramArrayOfByte[i];
    paramArrayOfByte[i] = ((byte)((byte)((j & 0xFF) >> 8 - k << 8 - paramInt1) | m));
    if (k == 8)
    {
      this.bitOffset = 0;
      this.byteOffset = (paramInt2 + 1);
    }
    assertValidOffset();
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (this.bitOffset == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    System.arraycopy(this.data, this.byteOffset, paramArrayOfByte, paramInt1, paramInt2);
    this.byteOffset += paramInt2;
    assertValidOffset();
  }
  
  public void reset(ParsableByteArray paramParsableByteArray)
  {
    reset(paramParsableByteArray.data, paramParsableByteArray.limit());
    setPosition(paramParsableByteArray.getPosition() * 8);
  }
  
  public void reset(byte[] paramArrayOfByte)
  {
    reset(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void reset(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.byteOffset = 0;
    this.bitOffset = 0;
    this.byteLimit = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.byteOffset = (paramInt / 8);
    this.bitOffset = (paramInt - this.byteOffset * 8);
    assertValidOffset();
  }
  
  public void skipBit()
  {
    int i = this.bitOffset + 1;
    this.bitOffset = i;
    if (i == 8)
    {
      this.bitOffset = 0;
      this.byteOffset += 1;
    }
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
  
  public void skipBytes(int paramInt)
  {
    boolean bool;
    if (this.bitOffset == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.byteOffset += paramInt;
    assertValidOffset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ParsableBitArray
 * JD-Core Version:    0.7.0.1
 */