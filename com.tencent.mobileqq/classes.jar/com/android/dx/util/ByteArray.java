package com.android.dx.util;

public final class ByteArray
{
  private final byte[] bytes;
  private final int size;
  private final int start;
  
  public ByteArray(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public ByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("start < 0");
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("end < start");
    }
    if (paramInt2 > paramArrayOfByte.length) {
      throw new IllegalArgumentException("end > bytes.length");
    }
    this.bytes = paramArrayOfByte;
    this.start = paramInt1;
    this.size = (paramInt2 - paramInt1);
  }
  
  private void checkOffsets(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > this.size)) {
      throw new IllegalArgumentException("bad range: " + paramInt1 + ".." + paramInt2 + "; actual size " + this.size);
    }
  }
  
  private int getByte0(int paramInt)
  {
    return this.bytes[(this.start + paramInt)];
  }
  
  private int getUnsignedByte0(int paramInt)
  {
    return this.bytes[(this.start + paramInt)] & 0xFF;
  }
  
  public int getByte(int paramInt)
  {
    checkOffsets(paramInt, paramInt + 1);
    return getByte0(paramInt);
  }
  
  public void getBytes(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length - paramInt < this.size) {
      throw new IndexOutOfBoundsException("(out.length - offset) < size()");
    }
    System.arraycopy(this.bytes, this.start, paramArrayOfByte, paramInt, this.size);
  }
  
  public int getInt(int paramInt)
  {
    checkOffsets(paramInt, paramInt + 4);
    return getByte0(paramInt) << 24 | getUnsignedByte0(paramInt + 1) << 16 | getUnsignedByte0(paramInt + 2) << 8 | getUnsignedByte0(paramInt + 3);
  }
  
  public long getLong(int paramInt)
  {
    checkOffsets(paramInt, paramInt + 8);
    int i = getByte0(paramInt);
    int j = getUnsignedByte0(paramInt + 1);
    int k = getUnsignedByte0(paramInt + 2);
    int m = getUnsignedByte0(paramInt + 3);
    long l = getByte0(paramInt + 4) << 24 | getUnsignedByte0(paramInt + 5) << 16 | getUnsignedByte0(paramInt + 6) << 8 | getUnsignedByte0(paramInt + 7);
    return (i << 24 | j << 16 | k << 8 | m) << 32 | l & 0xFFFFFFFF;
  }
  
  public int getShort(int paramInt)
  {
    checkOffsets(paramInt, paramInt + 2);
    return getByte0(paramInt) << 8 | getUnsignedByte0(paramInt + 1);
  }
  
  public int getUnsignedByte(int paramInt)
  {
    checkOffsets(paramInt, paramInt + 1);
    return getUnsignedByte0(paramInt);
  }
  
  public int getUnsignedShort(int paramInt)
  {
    checkOffsets(paramInt, paramInt + 2);
    return getUnsignedByte0(paramInt) << 8 | getUnsignedByte0(paramInt + 1);
  }
  
  public ByteArray.MyDataInputStream makeDataInputStream()
  {
    return new ByteArray.MyDataInputStream(makeInputStream());
  }
  
  public ByteArray.MyInputStream makeInputStream()
  {
    return new ByteArray.MyInputStream(this);
  }
  
  public int size()
  {
    return this.size;
  }
  
  public ByteArray slice(int paramInt1, int paramInt2)
  {
    checkOffsets(paramInt1, paramInt2);
    return new ByteArray(this.bytes, this.start + paramInt1, this.start + paramInt2);
  }
  
  public int underlyingOffset(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != this.bytes) {
      throw new IllegalArgumentException("wrong bytes");
    }
    return this.start + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ByteArray
 * JD-Core Version:    0.7.0.1
 */