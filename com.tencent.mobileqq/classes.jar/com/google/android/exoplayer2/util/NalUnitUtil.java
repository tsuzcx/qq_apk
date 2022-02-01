package com.google.android.exoplayer2.util;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil
{
  public static final float[] ASPECT_RATIO_IDC_VALUES;
  public static final int EXTENDED_SAR = 255;
  private static final int H264_NAL_UNIT_TYPE_SEI = 6;
  private static final int H264_NAL_UNIT_TYPE_SPS = 7;
  private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
  public static final byte[] NAL_START_CODE = { 0, 0, 0, 1 };
  private static final String TAG = "NalUnitUtil";
  private static int[] scratchEscapePositions = new int[10];
  private static final Object scratchEscapePositionsLock;
  
  static
  {
    ASPECT_RATIO_IDC_VALUES = new float[] { 1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454546F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424243F, 1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F };
    scratchEscapePositionsLock = new Object();
  }
  
  public static void clearPrefixFlags(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }
  
  public static void discardToSps(ByteBuffer paramByteBuffer)
  {
    int m = paramByteBuffer.position();
    int k = 0;
    int i = 0;
    while (k + 1 < m)
    {
      int n = paramByteBuffer.get(k) & 0xFF;
      int j;
      if (i == 3)
      {
        j = i;
        if (n == 1)
        {
          j = i;
          if ((paramByteBuffer.get(k + 1) & 0x1F) == 7)
          {
            ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
            localByteBuffer.position(k - 3);
            localByteBuffer.limit(m);
            paramByteBuffer.position(0);
            paramByteBuffer.put(localByteBuffer);
          }
        }
      }
      else
      {
        j = i;
        if (n == 0) {
          j = i + 1;
        }
      }
      i = j;
      if (n != 0) {
        i = 0;
      }
      k += 1;
    }
    paramByteBuffer.clear();
  }
  
  public static int findNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = true;
    int i = paramInt2 - paramInt1;
    if (i >= 0)
    {
      bool1 = true;
      Assertions.checkState(bool1);
      if (i != 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return paramInt2;
      bool1 = false;
      break;
      if (paramArrayOfBoolean != null)
      {
        if (paramArrayOfBoolean[0] != 0)
        {
          clearPrefixFlags(paramArrayOfBoolean);
          return paramInt1 - 3;
        }
        if ((i > 1) && (paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[paramInt1] == 1))
        {
          clearPrefixFlags(paramArrayOfBoolean);
          return paramInt1 - 2;
        }
        if ((i > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 1))
        {
          clearPrefixFlags(paramArrayOfBoolean);
          return paramInt1 - 1;
        }
      }
      paramInt1 += 2;
      if (paramInt1 < paramInt2 - 1)
      {
        if ((paramArrayOfByte[paramInt1] & 0xFE) != 0) {}
        for (;;)
        {
          paramInt1 += 3;
          break;
          if ((paramArrayOfByte[(paramInt1 - 2)] == 0) && (paramArrayOfByte[(paramInt1 - 1)] == 0) && (paramArrayOfByte[paramInt1] == 1))
          {
            if (paramArrayOfBoolean != null) {
              clearPrefixFlags(paramArrayOfBoolean);
            }
            return paramInt1 - 2;
          }
          paramInt1 -= 2;
        }
      }
    } while (paramArrayOfBoolean == null);
    if (i > 2) {
      if ((paramArrayOfByte[(paramInt2 - 3)] == 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
      {
        bool1 = true;
        paramArrayOfBoolean[0] = bool1;
        if (i <= 1) {
          break label356;
        }
        if ((paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[(paramInt2 - 1)] != 0)) {
          break label350;
        }
        bool1 = true;
        label252:
        paramArrayOfBoolean[1] = bool1;
        if (paramArrayOfByte[(paramInt2 - 1)] != 0) {
          break label382;
        }
      }
    }
    label350:
    label356:
    label382:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArrayOfBoolean[2] = bool1;
      return paramInt2;
      bool1 = false;
      break;
      if (i == 2)
      {
        if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
      }
      if ((paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label252;
      if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 0))
      {
        bool1 = true;
        break label252;
      }
      bool1 = false;
      break label252;
    }
  }
  
  private static int findNextUnescapeIndex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 < paramInt2 - 2)
      {
        if ((paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 0) && (paramArrayOfByte[(paramInt1 + 2)] == 3)) {
          i = paramInt1;
        }
      }
      else {
        return i;
      }
      paramInt1 += 1;
    }
  }
  
  public static int getH265NalUnitType(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0x7E) >> 1;
  }
  
  public static int getNalUnitType(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0x1F;
  }
  
  public static boolean isNalUnitSei(String paramString, byte paramByte)
  {
    return (("video/avc".equals(paramString)) && ((paramByte & 0x1F) == 6)) || (("video/hevc".equals(paramString)) && ((paramByte & 0x7E) >> 1 == 39));
  }
  
  public static NalUnitUtil.PpsData parsePpsNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new ParsableNalUnitBitArray(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.skipBits(8);
    paramInt1 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
    paramInt2 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
    paramArrayOfByte.skipBit();
    return new NalUnitUtil.PpsData(paramInt1, paramInt2, paramArrayOfByte.readBit());
  }
  
  public static NalUnitUtil.SpsData parseSpsNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new ParsableNalUnitBitArray(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.skipBits(8);
    paramInt1 = paramArrayOfByte.readBits(8);
    paramArrayOfByte.skipBits(16);
    int n = paramArrayOfByte.readUnsignedExpGolombCodedInt();
    boolean bool1 = false;
    int j;
    if ((paramInt1 == 100) || (paramInt1 == 110) || (paramInt1 == 122) || (paramInt1 == 244) || (paramInt1 == 44) || (paramInt1 == 83) || (paramInt1 == 86) || (paramInt1 == 118) || (paramInt1 == 128) || (paramInt1 == 138))
    {
      j = paramArrayOfByte.readUnsignedExpGolombCodedInt();
      if (j == 3) {
        bool1 = paramArrayOfByte.readBit();
      }
      paramArrayOfByte.readUnsignedExpGolombCodedInt();
      paramArrayOfByte.readUnsignedExpGolombCodedInt();
      paramArrayOfByte.skipBit();
      if (paramArrayOfByte.readBit())
      {
        if (j != 3)
        {
          paramInt1 = 8;
          paramInt2 = 0;
          label152:
          if (paramInt2 >= paramInt1) {
            break label200;
          }
          if (paramArrayOfByte.readBit()) {
            if (paramInt2 >= 6) {
              break label193;
            }
          }
        }
        label193:
        for (i = 16;; i = 64)
        {
          skipScalingList(paramArrayOfByte, i);
          paramInt2 += 1;
          break label152;
          paramInt1 = 12;
          break;
        }
      }
    }
    label200:
    for (int i = j;; i = 1)
    {
      int i1 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
      int i2 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
      j = 0;
      boolean bool2 = false;
      int k;
      boolean bool3;
      int m;
      int i3;
      int i4;
      if (i2 == 0)
      {
        paramInt2 = paramArrayOfByte.readUnsignedExpGolombCodedInt() + 4;
        paramArrayOfByte.readUnsignedExpGolombCodedInt();
        paramArrayOfByte.skipBit();
        k = paramArrayOfByte.readUnsignedExpGolombCodedInt();
        j = paramArrayOfByte.readUnsignedExpGolombCodedInt();
        bool3 = paramArrayOfByte.readBit();
        if (!bool3) {
          break label546;
        }
        paramInt1 = 1;
        if (!bool3) {
          paramArrayOfByte.skipBit();
        }
        paramArrayOfByte.skipBit();
        m = (k + 1) * 16;
        k = (2 - paramInt1) * (j + 1) * 16;
        if (!paramArrayOfByte.readBit()) {
          break label660;
        }
        int i5 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
        int i6 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
        i3 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
        i4 = paramArrayOfByte.readUnsignedExpGolombCodedInt();
        if (i != 0) {
          break label556;
        }
        i = 1;
        if (!bool3) {
          break label551;
        }
        paramInt1 = 1;
        label349:
        j = 2 - paramInt1;
        paramInt1 = i;
        i = j;
        paramInt1 = m - paramInt1 * (i5 + i6);
      }
      for (i = k - i * (i3 + i4);; i = k)
      {
        float f2 = 1.0F;
        float f1;
        if ((paramArrayOfByte.readBit()) && (paramArrayOfByte.readBit()))
        {
          j = paramArrayOfByte.readBits(8);
          if (j == 255)
          {
            j = paramArrayOfByte.readBits(16);
            k = paramArrayOfByte.readBits(16);
            f1 = f2;
            if (j != 0)
            {
              f1 = f2;
              if (k != 0) {
                f1 = j / k;
              }
            }
          }
        }
        for (;;)
        {
          return new NalUnitUtil.SpsData(n, paramInt1, i, f1, bool1, bool3, i1 + 4, i2, paramInt2, bool2);
          paramInt2 = j;
          if (i2 != 1) {
            break;
          }
          bool3 = paramArrayOfByte.readBit();
          paramArrayOfByte.readSignedExpGolombCodedInt();
          paramArrayOfByte.readSignedExpGolombCodedInt();
          long l = paramArrayOfByte.readUnsignedExpGolombCodedInt();
          paramInt1 = 0;
          for (;;)
          {
            paramInt2 = j;
            bool2 = bool3;
            if (paramInt1 >= l) {
              break;
            }
            paramArrayOfByte.readUnsignedExpGolombCodedInt();
            paramInt1 += 1;
          }
          paramInt1 = 0;
          break label268;
          paramInt1 = 0;
          break label349;
          if (i == 3)
          {
            paramInt1 = 1;
            if (i != 1) {
              break label598;
            }
            i = 2;
            if (!bool3) {
              break label604;
            }
          }
          label598:
          label604:
          for (j = 1;; j = 0)
          {
            i = (2 - j) * i;
            break;
            paramInt1 = 2;
            break label564;
            i = 1;
            break label573;
          }
          if (j < ASPECT_RATIO_IDC_VALUES.length)
          {
            f1 = ASPECT_RATIO_IDC_VALUES[j];
          }
          else
          {
            Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + j);
            f1 = 1.0F;
          }
        }
        paramInt1 = m;
      }
      bool1 = false;
    }
  }
  
  private static void skipScalingList(ParsableNalUnitBitArray paramParsableNalUnitBitArray, int paramInt)
  {
    int m = 8;
    int j = 0;
    int k = 8;
    if (j < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (paramParsableNalUnitBitArray.readSignedExpGolombCodedInt() + k + 256) % 256;
      }
      if (i == 0) {}
      for (;;)
      {
        j += 1;
        m = i;
        break;
        k = i;
      }
    }
  }
  
  public static int unescapeStream(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    Object localObject = scratchEscapePositionsLock;
    int j = 0;
    int i = 0;
    if (i < paramInt) {}
    for (;;)
    {
      int m;
      try
      {
        i = findNextUnescapeIndex(paramArrayOfByte, i, paramInt);
        if (i >= paramInt) {
          break label164;
        }
        if (scratchEscapePositions.length <= j) {
          scratchEscapePositions = Arrays.copyOf(scratchEscapePositions, scratchEscapePositions.length * 2);
        }
        scratchEscapePositions[j] = i;
        j += 1;
        i += 3;
        break;
      }
      finally {}
      if (paramInt < j)
      {
        m = scratchEscapePositions[paramInt] - i;
        System.arraycopy(paramArrayOfByte, i, paramArrayOfByte, k, m);
        k += m;
        int i1 = k + 1;
        paramArrayOfByte[k] = 0;
        k = i1 + 1;
        paramArrayOfByte[i1] = 0;
        i += m + 3;
        paramInt += 1;
      }
      else
      {
        System.arraycopy(paramArrayOfByte, i, paramArrayOfByte, k, n - k);
        return n;
        label164:
        break;
        int n = paramInt - j;
        m = 0;
        i = 0;
        paramInt = k;
        k = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.util.NalUnitUtil
 * JD-Core Version:    0.7.0.1
 */