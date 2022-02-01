package com.tencent.commonsdk.soload;

import java.nio.ByteOrder;

public class Memory
{
  public static int peekInt(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    int i;
    int j;
    if (paramByteOrder == ByteOrder.BIG_ENDIAN)
    {
      i = paramInt + 1;
      j = paramArrayOfByte[paramInt];
      paramInt = i + 1;
      i = (j & 0xFF) << 24 | (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 8;
    }
    for (paramInt = (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 0;; paramInt = (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 24)
    {
      return paramInt | i;
      i = paramInt + 1;
      j = paramArrayOfByte[paramInt];
      paramInt = i + 1;
      i = (j & 0xFF) << 0 | (paramArrayOfByte[i] & 0xFF) << 8 | (paramArrayOfByte[paramInt] & 0xFF) << 16;
    }
  }
  
  public static short peekShort(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    int i;
    if (paramByteOrder == ByteOrder.BIG_ENDIAN) {
      i = paramArrayOfByte[paramInt] << 8;
    }
    for (paramInt = paramArrayOfByte[(paramInt + 1)];; paramInt = paramArrayOfByte[paramInt])
    {
      return (short)(paramInt & 0xFF | i);
      i = paramArrayOfByte[(paramInt + 1)] << 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.soload.Memory
 * JD-Core Version:    0.7.0.1
 */