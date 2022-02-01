package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

public final class Ac3Util
{
  private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
  private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
  private static final int[] BITRATE_BY_HALF_FRMSIZECOD = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = { 1, 2, 3, 6 };
  private static final int[] CHANNEL_COUNT_BY_ACMOD;
  private static final int[] SAMPLE_RATE_BY_FSCOD = { 48000, 44100, 32000 };
  private static final int[] SAMPLE_RATE_BY_FSCOD2 = { 24000, 22050, 16000 };
  private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 8;
  public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 12;
  
  static
  {
    CHANNEL_COUNT_BY_ACMOD = new int[] { 2, 1, 2, 3, 3, 4, 4, 5 };
  }
  
  public static int getAc3SyncframeAudioSampleCount()
  {
    return 1536;
  }
  
  private static int getAc3SyncframeSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    if (paramInt1 >= 0)
    {
      int[] arrayOfInt1 = SAMPLE_RATE_BY_FSCOD;
      if ((paramInt1 < arrayOfInt1.length) && (paramInt2 >= 0))
      {
        int[] arrayOfInt2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i < arrayOfInt2.length)
        {
          paramInt1 = arrayOfInt1[paramInt1];
          if (paramInt1 == 44100) {
            return (arrayOfInt2[i] + paramInt2 % 2) * 2;
          }
          paramInt2 = BITRATE_BY_HALF_FRMSIZECOD[i];
          if (paramInt1 == 32000) {
            return paramInt2 * 6;
          }
          return paramInt2 * 4;
        }
      }
    }
    return -1;
  }
  
  public static Format parseAc3AnnexFFormat(ParsableByteArray paramParsableByteArray, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    int i = paramParsableByteArray.readUnsignedByte();
    int k = SAMPLE_RATE_BY_FSCOD[((i & 0xC0) >> 6)];
    int m = paramParsableByteArray.readUnsignedByte();
    int j = CHANNEL_COUNT_BY_ACMOD[((m & 0x38) >> 3)];
    i = j;
    if ((m & 0x4) != 0) {
      i = j + 1;
    }
    return Format.createAudioSampleFormat(paramString1, "audio/ac3", null, -1, -1, i, k, null, paramDrmInitData, 0, paramString2);
  }
  
  public static Ac3Util.Ac3SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray paramParsableBitArray)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int parseAc3SyncframeSize(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 5) {
      return -1;
    }
    return getAc3SyncframeSize((paramArrayOfByte[4] & 0xC0) >> 6, paramArrayOfByte[4] & 0x3F);
  }
  
  public static Format parseEAc3AnnexFFormat(ParsableByteArray paramParsableByteArray, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    paramParsableByteArray.skipBytes(2);
    int i = paramParsableByteArray.readUnsignedByte();
    int k = SAMPLE_RATE_BY_FSCOD[((i & 0xC0) >> 6)];
    int m = paramParsableByteArray.readUnsignedByte();
    int j = CHANNEL_COUNT_BY_ACMOD[((m & 0xE) >> 1)];
    i = j;
    if ((m & 0x1) != 0) {
      i = j + 1;
    }
    j = i;
    if ((paramParsableByteArray.readUnsignedByte() & 0x1E) >> 1 > 0)
    {
      j = i;
      if ((0x2 & paramParsableByteArray.readUnsignedByte()) != 0) {
        j = i + 2;
      }
    }
    if ((paramParsableByteArray.bytesLeft() > 0) && ((paramParsableByteArray.readUnsignedByte() & 0x1) != 0)) {
      paramParsableByteArray = "audio/eac3-joc";
    } else {
      paramParsableByteArray = "audio/eac3";
    }
    return Format.createAudioSampleFormat(paramString1, paramParsableByteArray, null, -1, -1, j, k, null, paramDrmInitData, 0, paramString2);
  }
  
  public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.get(paramByteBuffer.position() + 4);
    int i = 6;
    if ((j & 0xC0) >> 6 != 3) {
      i = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0x30) >> 4)];
    }
    return i * 256;
  }
  
  public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.getInt(paramByteBuffer.position() + 4) != -1167101192) {
      return 0;
    }
    return 40 << (paramByteBuffer.get(paramByteBuffer.position() + 8) & 0x7);
  }
  
  public static int parseTrueHdSyncframeAudioSampleCount(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[4] == -8) && (paramArrayOfByte[5] == 114) && (paramArrayOfByte[6] == 111) && (paramArrayOfByte[7] == -70)) {
      return 40 << (paramArrayOfByte[8] & 0x7);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.Ac3Util
 * JD-Core Version:    0.7.0.1
 */