package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;

public final class CodecSpecificDataUtil
{
  private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
  private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
  private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
  private static final int AUDIO_OBJECT_TYPE_PS = 29;
  private static final int AUDIO_OBJECT_TYPE_SBR = 5;
  private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
  private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
  private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
  private static final byte[] NAL_START_CODE = { 0, 0, 0, 1 };
  
  static
  {
    AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  }
  
  public static byte[] buildAacAudioSpecificConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
  
  public static byte[] buildAacLcAudioSpecificConfig(int paramInt1, int paramInt2)
  {
    int m = 0;
    int i = 0;
    int j = -1;
    for (;;)
    {
      localObject = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
      if (i >= localObject.length) {
        break;
      }
      if (paramInt1 == localObject[i]) {
        j = i;
      }
      i += 1;
    }
    int k = -1;
    i = m;
    for (;;)
    {
      localObject = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
      if (i >= localObject.length) {
        break;
      }
      if (paramInt2 == localObject[i]) {
        k = i;
      }
      i += 1;
    }
    if ((paramInt1 != -1) && (k != -1)) {
      return buildAacAudioSpecificConfig(2, j, k);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid sample rate or number of channels: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static byte[] buildNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = NAL_START_CODE;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt2];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, NAL_START_CODE.length, paramInt2);
    return arrayOfByte2;
  }
  
  private static int findNalStartCode(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    int j = NAL_START_CODE.length;
    while (paramInt <= i - j)
    {
      if (isNalStartCode(paramArrayOfByte, paramInt)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private static int getAacAudioObjectType(ParsableBitArray paramParsableBitArray)
  {
    int j = paramParsableBitArray.readBits(5);
    int i = j;
    if (j == 31) {
      i = paramParsableBitArray.readBits(6) + 32;
    }
    return i;
  }
  
  private static int getAacSamplingFrequency(ParsableBitArray paramParsableBitArray)
  {
    int i = paramParsableBitArray.readBits(4);
    if (i == 15) {
      return paramParsableBitArray.readBits(24);
    }
    boolean bool;
    if (i < 13) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[i];
  }
  
  private static boolean isNalStartCode(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length - paramInt <= NAL_START_CODE.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = NAL_START_CODE;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[(paramInt + i)] != arrayOfByte[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray paramParsableBitArray, boolean paramBoolean)
  {
    int n = getAacAudioObjectType(paramParsableBitArray);
    int i = getAacSamplingFrequency(paramParsableBitArray);
    int m = paramParsableBitArray.readBits(4);
    int k;
    if (n != 5)
    {
      j = n;
      k = m;
      if (n != 29) {}
    }
    else
    {
      n = getAacSamplingFrequency(paramParsableBitArray);
      int i1 = getAacAudioObjectType(paramParsableBitArray);
      j = i1;
      i = n;
      k = m;
      if (i1 == 22)
      {
        k = paramParsableBitArray.readBits(4);
        i = n;
        j = i1;
      }
    }
    boolean bool = true;
    if (paramBoolean)
    {
      if ((j != 1) && (j != 2) && (j != 3) && (j != 4) && (j != 6) && (j != 7) && (j != 17)) {
        switch (j)
        {
        default: 
          paramParsableBitArray = new StringBuilder();
          paramParsableBitArray.append("Unsupported audio object type: ");
          paramParsableBitArray.append(j);
          throw new ParserException(paramParsableBitArray.toString());
        }
      }
      parseGaSpecificConfig(paramParsableBitArray, j, k);
      switch (j)
      {
      case 18: 
      default: 
        break;
      case 17: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
        j = paramParsableBitArray.readBits(2);
        if ((j == 2) || (j == 3))
        {
          paramParsableBitArray = new StringBuilder();
          paramParsableBitArray.append("Unsupported epConfig: ");
          paramParsableBitArray.append(j);
          throw new ParserException(paramParsableBitArray.toString());
        }
        break;
      }
    }
    int j = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[k];
    if (j != -1) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    Assertions.checkArgument(paramBoolean);
    return Pair.create(Integer.valueOf(i), Integer.valueOf(j));
  }
  
  public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] paramArrayOfByte)
  {
    return parseAacAudioSpecificConfig(new ParsableBitArray(paramArrayOfByte), false);
  }
  
  private static void parseGaSpecificConfig(ParsableBitArray paramParsableBitArray, int paramInt1, int paramInt2)
  {
    paramParsableBitArray.skipBits(1);
    if (paramParsableBitArray.readBit()) {
      paramParsableBitArray.skipBits(14);
    }
    boolean bool = paramParsableBitArray.readBit();
    if (paramInt2 != 0)
    {
      if ((paramInt1 == 6) || (paramInt1 == 20)) {
        paramParsableBitArray.skipBits(3);
      }
      if (bool)
      {
        if (paramInt1 == 22) {
          paramParsableBitArray.skipBits(16);
        }
        if ((paramInt1 == 17) || (paramInt1 == 19) || (paramInt1 == 20) || (paramInt1 == 23)) {
          paramParsableBitArray.skipBits(3);
        }
        paramParsableBitArray.skipBits(1);
      }
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public static byte[][] splitNalUnits(byte[] paramArrayOfByte)
  {
    if (!isNalStartCode(paramArrayOfByte, 0)) {
      return (byte[][])null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j;
    do
    {
      localArrayList.add(Integer.valueOf(i));
      j = findNalStartCode(paramArrayOfByte, i + NAL_START_CODE.length);
      i = j;
    } while (j != -1);
    byte[][] arrayOfByte = new byte[localArrayList.size()][];
    i = 0;
    while (i < localArrayList.size())
    {
      int k = ((Integer)localArrayList.get(i)).intValue();
      if (i < localArrayList.size() - 1) {
        j = ((Integer)localArrayList.get(i + 1)).intValue();
      } else {
        j = paramArrayOfByte.length;
      }
      byte[] arrayOfByte1 = new byte[j - k];
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, arrayOfByte1.length);
      arrayOfByte[i] = arrayOfByte1;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.CodecSpecificDataUtil
 * JD-Core Version:    0.7.0.1
 */