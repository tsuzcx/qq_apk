package com.tencent.commonsdk.soload;

import java.nio.ByteOrder;

public class Memory
{
  public static int peekInt(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    if (paramByteOrder == ByteOrder.BIG_ENDIAN)
    {
      i = paramInt + 1;
      paramInt = paramArrayOfByte[paramInt];
      j = i + 1;
      return (paramArrayOfByte[i] & 0xFF) << 16 | (paramInt & 0xFF) << 24 | (paramArrayOfByte[j] & 0xFF) << 8 | (paramArrayOfByte[(j + 1)] & 0xFF) << 0;
    }
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    return (paramArrayOfByte[i] & 0xFF) << 8 | (paramInt & 0xFF) << 0 | (paramArrayOfByte[j] & 0xFF) << 16 | (paramArrayOfByte[(j + 1)] & 0xFF) << 24;
  }
  
  public static short peekShort(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    if (paramByteOrder == ByteOrder.BIG_ENDIAN) {
      return (short)(paramArrayOfByte[paramInt] << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF);
    }
    return (short)(paramArrayOfByte[(paramInt + 1)] << 8 | paramArrayOfByte[paramInt] & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.Memory
 * JD-Core Version:    0.7.0.1
 */