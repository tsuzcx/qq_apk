package com.tencent.falco.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class InBuffer
{
  public static final boolean BIG_ENDIAN = true;
  public static final boolean HOST_ENDIAN = false;
  public static final boolean LE_ENDIAN = false;
  public static final int MAX_READ_SIZE = 1024;
  public static final boolean NET_ENDIAN = true;
  public ByteArrayInputStream buffer = null;
  private boolean endian = false;
  
  public InBuffer(byte[] paramArrayOfByte)
  {
    this.buffer = new ByteArrayInputStream(paramArrayOfByte);
    this.endian = true;
  }
  
  public InBuffer(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.buffer = new ByteArrayInputStream(paramArrayOfByte);
    this.endian = paramBoolean;
  }
  
  public int available()
  {
    return this.buffer.available();
  }
  
  public boolean hasData()
  {
    return this.buffer.available() != 0;
  }
  
  public int readBuffer(byte[] paramArrayOfByte)
  {
    return this.buffer.read(paramArrayOfByte);
  }
  
  public int readByte()
  {
    return this.buffer.read();
  }
  
  public byte[] readCStrBuffer()
  {
    int i = readByte();
    if (i == 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    readBuffer(arrayOfByte);
    return arrayOfByte;
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
  
  public String readString()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = this.buffer.read();
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(i);
    }
    return localByteArrayOutputStream.toString();
  }
  
  public byte[] readWStrBuffer()
  {
    int i = readShort();
    if (i == 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    readBuffer(arrayOfByte);
    return arrayOfByte;
  }
  
  public String readWString()
  {
    byte[] arrayOfByte = new byte[readShort()];
    readBuffer(arrayOfByte);
    return new String(arrayOfByte, "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.InBuffer
 * JD-Core Version:    0.7.0.1
 */