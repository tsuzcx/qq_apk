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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.InBuffer
 * JD-Core Version:    0.7.0.1
 */