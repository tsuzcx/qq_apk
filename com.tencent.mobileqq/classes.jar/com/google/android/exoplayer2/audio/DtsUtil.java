package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class DtsUtil
{
  private static final int[] CHANNELS_BY_AMODE = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final byte FIRST_BYTE_14B_BE = 31;
  private static final byte FIRST_BYTE_14B_LE = -1;
  private static final byte FIRST_BYTE_BE = 127;
  private static final byte FIRST_BYTE_LE = -2;
  private static final int[] SAMPLE_RATE_BY_SFREQ = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int SYNC_VALUE_14B_BE = 536864768;
  private static final int SYNC_VALUE_14B_LE = -14745368;
  private static final int SYNC_VALUE_BE = 2147385345;
  private static final int SYNC_VALUE_LE = -25230976;
  private static final int[] TWICE_BITRATE_KBPS_BY_RATE = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };
  
  public static int getDtsFrameSize(byte[] paramArrayOfByte)
  {
    int k = 0;
    int i = paramArrayOfByte[0];
    if (i != -2) {
      if (i != -1) {
        if (i != 31) {
          i = (paramArrayOfByte[5] & 0x3) << 12 | (paramArrayOfByte[6] & 0xFF) << 4;
        }
      }
    }
    for (int j = paramArrayOfByte[7];; j = paramArrayOfByte[6])
    {
      i = ((j & 0xF0) >> 4 | i) + 1;
      j = k;
      break;
      i = (paramArrayOfByte[6] & 0x3) << 12 | (paramArrayOfByte[7] & 0xFF) << 4;
      j = paramArrayOfByte[8];
      break label120;
      i = (paramArrayOfByte[7] & 0x3) << 12 | (paramArrayOfByte[6] & 0xFF) << 4;
      j = paramArrayOfByte[9];
      label120:
      i = ((j & 0x3C) >> 2 | i) + 1;
      j = 1;
      break;
      i = (paramArrayOfByte[4] & 0x3) << 12 | (paramArrayOfByte[7] & 0xFF) << 4;
    }
    k = i;
    if (j != 0) {
      k = i * 16 / 14;
    }
    return k;
  }
  
  private static ParsableBitArray getNormalizedFrameHeader(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] == 127) {
      return new ParsableBitArray(paramArrayOfByte);
    }
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    if (isLittleEndianFrameHeader(paramArrayOfByte))
    {
      int j = 0;
      while (j < paramArrayOfByte.length - 1)
      {
        int i = paramArrayOfByte[j];
        int k = j + 1;
        paramArrayOfByte[j] = paramArrayOfByte[k];
        paramArrayOfByte[k] = i;
        j += 2;
      }
    }
    ParsableBitArray localParsableBitArray1 = new ParsableBitArray(paramArrayOfByte);
    if (paramArrayOfByte[0] == 31)
    {
      ParsableBitArray localParsableBitArray2 = new ParsableBitArray(paramArrayOfByte);
      while (localParsableBitArray2.bitsLeft() >= 16)
      {
        localParsableBitArray2.skipBits(2);
        localParsableBitArray1.putInt(localParsableBitArray2.readBits(14), 14);
      }
    }
    localParsableBitArray1.reset(paramArrayOfByte);
    return localParsableBitArray1;
  }
  
  private static boolean isLittleEndianFrameHeader(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if ((paramArrayOfByte[0] == -2) || (paramArrayOfByte[0] == -1)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSyncWord(int paramInt)
  {
    return (paramInt == 2147385345) || (paramInt == -25230976) || (paramInt == 536864768) || (paramInt == -14745368);
  }
  
  public static int parseDtsAudioSampleCount(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.position();
    int i = paramByteBuffer.get(j);
    if (i != -2) {
      if (i != -1) {
        if (i != 31) {
          i = (paramByteBuffer.get(j + 4) & 0x1) << 6;
        }
      }
    }
    for (j = paramByteBuffer.get(j + 5);; j = paramByteBuffer.get(j + 4))
    {
      j &= 0xFC;
      for (;;)
      {
        break;
        i = (paramByteBuffer.get(j + 5) & 0x7) << 4;
        j = paramByteBuffer.get(j + 6);
        break label105;
        i = (paramByteBuffer.get(j + 4) & 0x7) << 4;
        j = paramByteBuffer.get(j + 7);
        label105:
        j &= 0x3C;
      }
      i = (paramByteBuffer.get(j + 5) & 0x1) << 6;
    }
    return ((j >> 2 | i) + 1) * 32;
  }
  
  public static int parseDtsAudioSampleCount(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    if (i != -2) {
      if (i != -1) {
        if (i != 31) {
          i = (paramArrayOfByte[4] & 0x1) << 6;
        }
      }
    }
    for (int j = paramArrayOfByte[5];; j = paramArrayOfByte[4])
    {
      j &= 0xFC;
      for (;;)
      {
        break;
        i = (paramArrayOfByte[5] & 0x7) << 4;
        j = paramArrayOfByte[6];
        break label74;
        i = (paramArrayOfByte[4] & 0x7) << 4;
        j = paramArrayOfByte[7];
        label74:
        j &= 0x3C;
      }
      i = (paramArrayOfByte[5] & 0x1) << 6;
    }
    return ((j >> 2 | i) + 1) * 32;
  }
  
  public static Format parseDtsFormat(byte[] paramArrayOfByte, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    paramArrayOfByte = getNormalizedFrameHeader(paramArrayOfByte);
    paramArrayOfByte.skipBits(60);
    int i = paramArrayOfByte.readBits(6);
    int k = CHANNELS_BY_AMODE[i];
    i = paramArrayOfByte.readBits(4);
    int m = SAMPLE_RATE_BY_SFREQ[i];
    i = paramArrayOfByte.readBits(5);
    int[] arrayOfInt = TWICE_BITRATE_KBPS_BY_RATE;
    if (i >= arrayOfInt.length) {
      i = -1;
    } else {
      i = arrayOfInt[i] * 1000 / 2;
    }
    paramArrayOfByte.skipBits(10);
    int j;
    if (paramArrayOfByte.readBits(2) > 0) {
      j = 1;
    } else {
      j = 0;
    }
    return Format.createAudioSampleFormat(paramString1, "audio/vnd.dts", null, i, -1, k + j, m, null, paramDrmInitData, 0, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DtsUtil
 * JD-Core Version:    0.7.0.1
 */