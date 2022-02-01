package com.taobao.android.dexposed.utility;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class Platform$Platform32Bit
  extends Platform
{
  public int getIntSize()
  {
    return 4;
  }
  
  public int orderByteToInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt();
  }
  
  public long orderByteToLong(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFF;
  }
  
  public byte[] orderIntToByte(int paramInt)
  {
    return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array();
  }
  
  public byte[] orderLongToByte(long paramLong, int paramInt)
  {
    return ByteBuffer.allocate(paramInt).order(ByteOrder.LITTLE_ENDIAN).putInt((int)paramLong).array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.utility.Platform.Platform32Bit
 * JD-Core Version:    0.7.0.1
 */