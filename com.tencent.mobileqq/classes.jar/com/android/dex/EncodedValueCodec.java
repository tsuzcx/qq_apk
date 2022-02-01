package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;

public final class EncodedValueCodec
{
  public static int readSignedInt(ByteInput paramByteInput, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    while (i >= 0)
    {
      j = j >>> 8 | (paramByteInput.readByte() & 0xFF) << 24;
      i -= 1;
    }
    return j >> (3 - paramInt) * 8;
  }
  
  public static long readSignedLong(ByteInput paramByteInput, int paramInt)
  {
    long l = 0L;
    int i = paramInt;
    while (i >= 0)
    {
      l = l >>> 8 | (paramByteInput.readByte() & 0xFF) << 56;
      i -= 1;
    }
    return l >> (7 - paramInt) * 8;
  }
  
  public static int readUnsignedInt(ByteInput paramByteInput, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    int j = paramInt;
    if (!paramBoolean)
    {
      j = 0;
      i = paramInt;
      while (i >= 0)
      {
        j = j >>> 8 | (paramByteInput.readByte() & 0xFF) << 24;
        i -= 1;
      }
      paramInt = j >>> (3 - paramInt) * 8;
      return paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (j < 0) {
        break;
      }
      i = i >>> 8 | (paramByteInput.readByte() & 0xFF) << 24;
      j -= 1;
    }
  }
  
  public static long readUnsignedLong(ByteInput paramByteInput, int paramInt, boolean paramBoolean)
  {
    long l1 = 0L;
    int i = paramInt;
    long l2;
    if (!paramBoolean)
    {
      l1 = 0L;
      i = paramInt;
      while (i >= 0)
      {
        l1 = l1 >>> 8 | (paramByteInput.readByte() & 0xFF) << 56;
        i -= 1;
      }
      l2 = l1 >>> (7 - paramInt) * 8;
      return l2;
    }
    for (;;)
    {
      l2 = l1;
      if (i < 0) {
        break;
      }
      l1 = l1 >>> 8 | (paramByteInput.readByte() & 0xFF) << 56;
      i -= 1;
    }
  }
  
  public static void writeRightZeroExtendedValue(ByteOutput paramByteOutput, int paramInt, long paramLong)
  {
    int j = 64 - Long.numberOfTrailingZeros(paramLong);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    i = i + 7 >> 3;
    paramLong >>= 64 - i * 8;
    paramByteOutput.writeByte(i - 1 << 5 | paramInt);
    paramInt = i;
    while (paramInt > 0)
    {
      paramByteOutput.writeByte((byte)(int)paramLong);
      paramLong >>= 8;
      paramInt -= 1;
    }
  }
  
  public static void writeSignedIntegralValue(ByteOutput paramByteOutput, int paramInt, long paramLong)
  {
    int i = 65 - Long.numberOfLeadingZeros(paramLong >> 63 ^ paramLong) + 7 >> 3;
    paramByteOutput.writeByte(i - 1 << 5 | paramInt);
    paramInt = i;
    while (paramInt > 0)
    {
      paramByteOutput.writeByte((byte)(int)paramLong);
      paramLong >>= 8;
      paramInt -= 1;
    }
  }
  
  public static void writeUnsignedIntegralValue(ByteOutput paramByteOutput, int paramInt, long paramLong)
  {
    int j = 64 - Long.numberOfLeadingZeros(paramLong);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    i = i + 7 >> 3;
    paramByteOutput.writeByte(i - 1 << 5 | paramInt);
    paramInt = i;
    while (paramInt > 0)
    {
      paramByteOutput.writeByte((byte)(int)paramLong);
      paramLong >>= 8;
      paramInt -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.EncodedValueCodec
 * JD-Core Version:    0.7.0.1
 */