package com.tencent.ilivesdk.giftservice.util;

import java.io.ByteArrayInputStream;

public class InBuffer
{
  public static final boolean NET_ENDIAN = true;
  public ByteArrayInputStream buffer = null;
  private boolean endian = false;
  
  public InBuffer(byte[] paramArrayOfByte)
  {
    this.buffer = new ByteArrayInputStream(paramArrayOfByte);
    this.endian = true;
  }
  
  public int readBuffer(byte[] paramArrayOfByte)
  {
    return this.buffer.read(paramArrayOfByte);
  }
  
  public int readByte()
  {
    return this.buffer.read();
  }
  
  public long readInt()
  {
    return readNumber(4);
  }
  
  public long readNumber(int paramInt)
  {
    int k = 0;
    int j = -1;
    if ((paramInt <= 0) || (paramInt > 8)) {
      throw new IllegalArgumentException("integer length must between 1 and 8 bytes.");
    }
    byte[] arrayOfByte = new byte[paramInt];
    if (this.buffer.markSupported()) {
      this.buffer.mark(paramInt);
    }
    int i = this.buffer.read(arrayOfByte, 0, paramInt);
    if (i <= 0)
    {
      this.buffer = null;
      return -1L;
    }
    if (this.endian)
    {
      paramInt = k;
      if (!this.endian) {
        break label138;
      }
    }
    long l;
    for (;;)
    {
      if (this.endian) {
        j = 1;
      }
      l = 0L;
      while (paramInt != i)
      {
        l = l << 8 | arrayOfByte[paramInt] & 0xFF;
        paramInt += j;
      }
      paramInt = i - 1;
      break;
      label138:
      i = -1;
    }
    return l;
  }
  
  public int readShort()
  {
    return (int)readNumber(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.util.InBuffer
 * JD-Core Version:    0.7.0.1
 */