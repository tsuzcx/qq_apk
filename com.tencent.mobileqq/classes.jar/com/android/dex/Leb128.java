package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;

public final class Leb128
{
  public static int readSignedLeb128(ByteInput paramByteInput)
  {
    int j = 0;
    int m = -1;
    int i = 0;
    int i2;
    int k;
    int n;
    int i1;
    do
    {
      i2 = paramByteInput.readByte() & 0xFF;
      k = i | (i2 & 0x7F) << j * 7;
      n = m << 7;
      i1 = j + 1;
      if ((i2 & 0x80) != 128) {
        break;
      }
      m = n;
      j = i1;
      i = k;
    } while (i1 < 5);
    if ((i2 & 0x80) == 128) {
      throw new DexException("invalid LEB128 sequence");
    }
    i = k;
    if ((n >> 1 & k) != 0) {
      i = k | n;
    }
    return i;
  }
  
  public static int readUnsignedLeb128(ByteInput paramByteInput)
  {
    int j = 0;
    int i = 0;
    int n;
    int k;
    int m;
    do
    {
      n = paramByteInput.readByte() & 0xFF;
      k = i | (n & 0x7F) << j * 7;
      m = j + 1;
      if ((n & 0x80) != 128) {
        break;
      }
      j = m;
      i = k;
    } while (m < 5);
    if ((n & 0x80) == 128) {
      throw new DexException("invalid LEB128 sequence");
    }
    return k;
  }
  
  public static int signedLeb128Size(int paramInt)
  {
    int j;
    int k;
    int m;
    if ((0x80000000 & paramInt) == 0)
    {
      j = 0;
      k = 0;
      int n = paramInt >> 7;
      i = 1;
      m = paramInt;
      paramInt = n;
      label25:
      if (i == 0) {
        return k;
      }
      if ((paramInt == j) && ((paramInt & 0x1) == (m >> 6 & 0x1))) {
        break label69;
      }
    }
    label69:
    for (int i = 1;; i = 0)
    {
      k += 1;
      m = paramInt;
      paramInt >>= 7;
      break label25;
      j = -1;
      break;
    }
    return k;
  }
  
  public static int unsignedLeb128Size(int paramInt)
  {
    int i = paramInt >> 7;
    paramInt = 0;
    while (i != 0)
    {
      i >>= 7;
      paramInt += 1;
    }
    return paramInt + 1;
  }
  
  public static void writeSignedLeb128(ByteOutput paramByteOutput, int paramInt)
  {
    int j;
    int i;
    int k;
    if ((0x80000000 & paramInt) == 0)
    {
      j = 0;
      i = 1;
      m = paramInt >> 7;
      k = paramInt;
      paramInt = m;
      label23:
      if (i == 0) {
        return;
      }
      if ((paramInt == j) && ((paramInt & 0x1) == (k >> 6 & 0x1))) {
        break label87;
      }
      i = 1;
      label47:
      if (i == 0) {
        break label92;
      }
    }
    label87:
    label92:
    for (int m = 128;; m = 0)
    {
      paramByteOutput.writeByte((byte)(m | k & 0x7F));
      k = paramInt;
      paramInt >>= 7;
      break label23;
      j = -1;
      break;
      i = 0;
      break label47;
    }
  }
  
  public static void writeUnsignedLeb128(ByteOutput paramByteOutput, int paramInt)
  {
    int j = paramInt >>> 7;
    int i = paramInt;
    paramInt = j;
    while (paramInt != 0)
    {
      paramByteOutput.writeByte((byte)(i & 0x7F | 0x80));
      i = paramInt;
      paramInt >>>= 7;
    }
    paramByteOutput.writeByte((byte)(i & 0x7F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Leb128
 * JD-Core Version:    0.7.0.1
 */