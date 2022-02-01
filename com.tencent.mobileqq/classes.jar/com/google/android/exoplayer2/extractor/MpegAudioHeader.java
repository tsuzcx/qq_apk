package com.google.android.exoplayer2.extractor;

public final class MpegAudioHeader
{
  private static final int[] BITRATE_V1_L1;
  private static final int[] BITRATE_V1_L2 = { 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 };
  private static final int[] BITRATE_V1_L3 = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 };
  private static final int[] BITRATE_V2 = { 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
  private static final int[] BITRATE_V2_L1;
  public static final int MAX_FRAME_SIZE_BYTES = 4096;
  private static final String[] MIME_TYPE_BY_LAYER = { "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg" };
  private static final int[] SAMPLING_RATE_V1 = { 44100, 48000, 32000 };
  public int bitrate;
  public int channels;
  public int frameSize;
  public String mimeType;
  public int sampleRate;
  public int samplesPerFrame;
  public int version;
  
  static
  {
    BITRATE_V1_L1 = new int[] { 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 };
    BITRATE_V2_L1 = new int[] { 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 };
  }
  
  public static int getFrameSize(int paramInt)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {
      return -1;
    }
    int m = paramInt >>> 19 & 0x3;
    if (m == 1) {
      return -1;
    }
    int k = paramInt >>> 17 & 0x3;
    if (k == 0) {
      return -1;
    }
    int i1 = paramInt >>> 12 & 0xF;
    if (i1 != 0)
    {
      if (i1 == 15) {
        return -1;
      }
      int i = paramInt >>> 10 & 0x3;
      if (i == 3) {
        return -1;
      }
      int j = SAMPLING_RATE_V1[i];
      if (m == 2)
      {
        i = j / 2;
      }
      else
      {
        i = j;
        if (m == 0) {
          i = j / 4;
        }
      }
      int n = paramInt >>> 9 & 0x1;
      if (k == 3)
      {
        if (m == 3) {
          paramInt = BITRATE_V1_L1[(i1 - 1)];
        } else {
          paramInt = BITRATE_V2_L1[(i1 - 1)];
        }
        return (paramInt * 12000 / i + n) * 4;
      }
      if (m == 3)
      {
        if (k == 2) {
          paramInt = BITRATE_V1_L2[(i1 - 1)];
        } else {
          paramInt = BITRATE_V1_L3[(i1 - 1)];
        }
      }
      else {
        paramInt = BITRATE_V2[(i1 - 1)];
      }
      j = 144000;
      if (m == 3) {
        return paramInt * 144000 / i + n;
      }
      if (k == 1) {
        j = 72000;
      }
      return j * paramInt / i + n;
    }
    return -1;
  }
  
  public static boolean populateHeader(int paramInt, MpegAudioHeader paramMpegAudioHeader)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {
      return false;
    }
    int i1 = paramInt >>> 19 & 0x3;
    if (i1 == 1) {
      return false;
    }
    int i2 = paramInt >>> 17 & 0x3;
    if (i2 == 0) {
      return false;
    }
    int n = paramInt >>> 12 & 0xF;
    if (n != 0)
    {
      if (n == 15) {
        return false;
      }
      int i = paramInt >>> 10 & 0x3;
      if (i == 3) {
        return false;
      }
      int j = SAMPLING_RATE_V1[i];
      if (i1 == 2)
      {
        i = j / 2;
      }
      else
      {
        i = j;
        if (i1 == 0) {
          i = j / 4;
        }
      }
      int m = paramInt >>> 9 & 0x1;
      j = 1152;
      int k;
      if (i2 == 3)
      {
        if (i1 == 3) {
          j = BITRATE_V1_L1[(n - 1)];
        } else {
          j = BITRATE_V2_L1[(n - 1)];
        }
        k = (j * 12000 / i + m) * 4;
        m = 384;
      }
      else
      {
        k = 144000;
        if (i1 == 3)
        {
          if (i2 == 2) {
            j = BITRATE_V1_L2[(n - 1)];
          } else {
            j = BITRATE_V1_L3[(n - 1)];
          }
          k = 144000 * j / i + m;
          m = 1152;
        }
        else
        {
          n = BITRATE_V2[(n - 1)];
          if (i2 == 1) {
            j = 576;
          }
          if (i2 == 1) {
            k = 72000;
          }
          k = k * n / i + m;
          m = j;
          j = n;
        }
      }
      String str = MIME_TYPE_BY_LAYER[(3 - i2)];
      if ((paramInt >> 6 & 0x3) == 3) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      paramMpegAudioHeader.setValues(i1, str, k, i, paramInt, j * 1000, m);
      return true;
    }
    return false;
  }
  
  private void setValues(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.version = paramInt1;
    this.mimeType = paramString;
    this.frameSize = paramInt2;
    this.sampleRate = paramInt3;
    this.channels = paramInt4;
    this.bitrate = paramInt5;
    this.samplesPerFrame = paramInt6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.MpegAudioHeader
 * JD-Core Version:    0.7.0.1
 */