package com.google.android.exoplayer2.ext.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AudioUtil
{
  public static final double PCM_EACH_MAX_16BIT = 1073676289.0D;
  
  public static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02x ", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static short byteToShort(byte paramByte1, byte paramByte2)
  {
    return (short)((paramByte2 & 0xFF) << 8 | paramByte1 & 0xFF);
  }
  
  private static short byteToShort2(byte paramByte1, byte paramByte2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put(paramByte1);
    localByteBuffer.put(paramByte2);
    return localByteBuffer.getShort(0);
  }
  
  public static double mean(double[] paramArrayOfDouble, int paramInt)
  {
    int i = Math.min(paramInt, paramArrayOfDouble.length);
    double d = 0.0D;
    paramInt = 0;
    while (paramInt < i)
    {
      d += paramArrayOfDouble[paramInt];
      paramInt += 1;
    }
    return d / i;
  }
  
  public static double min(double[] paramArrayOfDouble, int paramInt)
  {
    int i = Math.min(paramInt, paramArrayOfDouble.length);
    double d = 0.0D;
    paramInt = 0;
    while (paramInt < i)
    {
      d = Math.min(d, paramArrayOfDouble[paramInt]);
      paramInt += 1;
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.util.AudioUtil
 * JD-Core Version:    0.7.0.1
 */