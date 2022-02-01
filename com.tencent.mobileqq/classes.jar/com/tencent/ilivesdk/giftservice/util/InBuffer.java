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
    if ((paramInt > 0) && (paramInt <= 8))
    {
      localObject = new byte[paramInt];
      if (this.buffer.markSupported()) {
        this.buffer.mark(paramInt);
      }
      ByteArrayInputStream localByteArrayInputStream = this.buffer;
      int j = 0;
      int i = localByteArrayInputStream.read((byte[])localObject, 0, paramInt);
      if (i <= 0)
      {
        this.buffer = null;
        return -1L;
      }
      if (this.endian) {
        paramInt = j;
      } else {
        paramInt = i - 1;
      }
      boolean bool = this.endian;
      j = -1;
      if (!bool) {
        i = -1;
      }
      if (this.endian) {
        j = 1;
      }
      long l = 0L;
      while (paramInt != i)
      {
        l = l << 8 | localObject[paramInt] & 0xFF;
        paramInt += j;
      }
      return l;
    }
    Object localObject = new IllegalArgumentException("integer length must between 1 and 8 bytes.");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public int readShort()
  {
    return (int)readNumber(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.util.InBuffer
 * JD-Core Version:    0.7.0.1
 */