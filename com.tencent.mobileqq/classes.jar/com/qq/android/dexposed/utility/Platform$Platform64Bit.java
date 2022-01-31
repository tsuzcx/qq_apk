package com.qq.android.dexposed.utility;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class Platform$Platform64Bit
  extends Platform
{
  public int getIntSize()
  {
    return 8;
  }
  
  public int orderByteToInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt();
  }
  
  public long orderByteToLong(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public byte[] orderIntToByte(int paramInt)
  {
    return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array();
  }
  
  public byte[] orderLongToByte(long paramLong, int paramInt)
  {
    return ByteBuffer.allocate(paramInt).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong).array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Platform.Platform64Bit
 * JD-Core Version:    0.7.0.1
 */