package com.tencent.TMG.config;

import java.io.UnsupportedEncodingException;

public class ByteBuffer
{
  private static final int SIZE = 512;
  private byte[] buffer = null;
  private int bufferSize = 0;
  private int curIndex = 0;
  
  public ByteBuffer()
  {
    this.buffer = new byte[512];
    int i = 0;
    while (i < 512)
    {
      this.buffer[i] = 0;
      i += 1;
    }
    this.curIndex = 0;
    this.bufferSize = 0;
  }
  
  public ByteBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.buffer = new byte[512];
      int i = 0;
      while (i < 512)
      {
        this.buffer[i] = 0;
        i += 1;
      }
      this.curIndex = 0;
      this.bufferSize = 0;
      return;
    }
    this.buffer = paramArrayOfByte;
    this.curIndex = 0;
    this.bufferSize = paramArrayOfByte.length;
  }
  
  public boolean Consume(int paramInt)
  {
    if (paramInt > 0)
    {
      if (length() < paramInt) {
        return false;
      }
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.curIndex, arrayOfByte, 0, paramInt);
      this.curIndex += paramInt;
      return true;
    }
    return false;
  }
  
  public byte[] Data()
  {
    int i = this.bufferSize;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public String ReadString(int paramInt)
  {
    if (paramInt > 0)
    {
      if (length() < paramInt) {
        return null;
      }
      Object localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.curIndex, localObject, 0, paramInt);
      this.curIndex += paramInt;
      try
      {
        localObject = new String((byte[])localObject, "GBK");
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public short ReadUInt16()
  {
    if (length() < 2) {
      return -1;
    }
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte2 = this.buffer;
    int i = this.curIndex;
    this.curIndex = (i + 1);
    arrayOfByte1[0] = arrayOfByte2[i];
    i = this.curIndex;
    this.curIndex = (i + 1);
    arrayOfByte1[1] = arrayOfByte2[i];
    return (short)(arrayOfByte1[0] * 256 + arrayOfByte1[1]);
  }
  
  public short ReadUInt16Length()
  {
    if (length() < 2) {
      return -1;
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.curIndex;
    this.curIndex = (i + 1);
    i = (short)(arrayOfByte[i] << 8);
    int j = this.curIndex;
    this.curIndex = (j + 1);
    return (short)(i + (short)(arrayOfByte[j] & 0xFF));
  }
  
  public int ReadUInt32()
  {
    if (length() < 4) {
      return -1;
    }
    byte[] arrayOfByte = this.buffer;
    int n = this.curIndex;
    this.curIndex = (n + 1);
    int i = arrayOfByte[n];
    n = 0;
    int i1 = this.curIndex;
    this.curIndex = (i1 + 1);
    int j = arrayOfByte[i1];
    i1 = this.curIndex;
    this.curIndex = (i1 + 1);
    int k = arrayOfByte[i1];
    i1 = this.curIndex;
    this.curIndex = (i1 + 1);
    int m = arrayOfByte[i1];
    i1 = 0;
    while (n < 4)
    {
      i1 += new byte[] { i, j, k, m }[(3 - n)] * Common.intPow(16, n * 2);
      n += 1;
    }
    return i1;
  }
  
  public byte ReadUInt8()
  {
    if (length() < 1) {
      return -1;
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.curIndex;
    this.curIndex = (i + 1);
    return arrayOfByte[i];
  }
  
  public void WriteByteBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 1) {
        return;
      }
      System.arraycopy(paramArrayOfByte, 0, this.buffer, this.curIndex, paramArrayOfByte.length);
      this.curIndex += paramArrayOfByte.length;
      this.bufferSize += paramArrayOfByte.length;
    }
  }
  
  public void WriteString(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() < 1) {
        return;
      }
      try
      {
        paramString = paramString.getBytes("GBK");
        System.arraycopy(paramString, 0, this.buffer, this.curIndex, paramString.length);
        this.curIndex += paramString.length;
        this.bufferSize += paramString.length;
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void WriteUInt16(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    int j = (byte)(paramShort >> 8 & 0xFF);
    byte[] arrayOfByte = this.buffer;
    paramShort = this.curIndex;
    System.arraycopy(new byte[] { j, i }, 0, arrayOfByte, paramShort, 2);
    this.curIndex += 2;
    this.bufferSize += 2;
  }
  
  public void WriteUInt32(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    byte[] arrayOfByte = this.buffer;
    paramInt = this.curIndex;
    System.arraycopy(new byte[] { m, k, j, i }, 0, arrayOfByte, paramInt, 4);
    this.curIndex += 4;
    this.bufferSize += 4;
  }
  
  public void WriteUInt8(byte paramByte)
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.curIndex;
    arrayOfByte[i] = paramByte;
    this.curIndex = (i + 1);
    this.bufferSize += 1;
  }
  
  public int length()
  {
    return this.bufferSize - this.curIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */