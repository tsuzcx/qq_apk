package com.qq.wx.voice.vad;

public class TRSilk
{
  public static int MAX_FRAME_SIZE = 64;
  public static final int TRSILK_ERROR_ALREADY_INIT = -103;
  public static final int TRSILK_ERROR_BIT_RATE = -105;
  public static final int TRSILK_ERROR_ENGINE = -101;
  public static final int TRSILK_ERROR_ILLEGAL_PARAM = -104;
  public static final int TRSILK_ERROR_INPUT_TOO_LONG = -107;
  public static final int TRSILK_ERROR_OUT_OF_MEMORY = -100;
  public static final int TRSILK_ERROR_SAMPLE_RATE = -106;
  public static final int TRSILK_ERROR_UN_INIT = -102;
  public static int defaultBitRate = 24000;
  public static int defaultSampleRate = 16000;
  private byte[] a;
  private byte[] b;
  private boolean c;
  private boolean d;
  private TRSilkNative e;
  
  public TRSilk()
  {
    int i = MAX_FRAME_SIZE;
    this.a = new byte[i * 100];
    this.b = new byte[i * 100];
    this.c = false;
    this.d = false;
    this.e = new TRSilkNative();
  }
  
  public byte[] silkDecode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.d)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        paramInt1 = this.e.nativeTRSilkDecode(paramArrayOfByte, paramInt1, paramInt2, this.b);
        if (paramInt1 == 0) {
          return null;
        }
        if (paramInt1 >= 0)
        {
          paramArrayOfByte = new byte[paramInt1];
          System.arraycopy(this.b, 0, paramArrayOfByte, 0, paramInt1);
          return paramArrayOfByte;
        }
        throw new TRSilkException(paramInt1);
      }
      throw new TRSilkException(-104);
    }
    throw new TRSilkException(-102);
  }
  
  public int silkDecodeInit()
  {
    return silkDecodeInit(defaultBitRate, defaultSampleRate);
  }
  
  public int silkDecodeInit(int paramInt1, int paramInt2)
  {
    if (this.d) {
      return -103;
    }
    paramInt1 = this.e.nativeTRSilkDecodeInit(paramInt1, paramInt2);
    if (paramInt1 == 0) {
      this.d = true;
    }
    return paramInt1;
  }
  
  public int silkDecodeRelease()
  {
    if (!this.d) {
      return -102;
    }
    this.d = false;
    return this.e.nativeTRSilkDecodeRelease();
  }
  
  public byte[] silkEncode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        paramInt1 = this.e.nativeTRSilkEncode(paramArrayOfByte, paramInt1, paramInt2, this.a);
        if (paramInt1 == 0) {
          return null;
        }
        if (paramInt1 >= 0)
        {
          paramArrayOfByte = new byte[paramInt1];
          System.arraycopy(this.a, 0, paramArrayOfByte, 0, paramInt1);
          return paramArrayOfByte;
        }
        throw new TRSilkException(paramInt1);
      }
      throw new TRSilkException(-104);
    }
    throw new TRSilkException(-102);
  }
  
  public int silkInit()
  {
    return silkInit(defaultBitRate, defaultSampleRate);
  }
  
  public int silkInit(int paramInt1, int paramInt2)
  {
    if (this.c) {
      return -103;
    }
    paramInt1 = this.e.nativeTRSilkInit(paramInt1, paramInt2);
    if (paramInt1 == 0) {
      this.c = true;
    }
    return paramInt1;
  }
  
  public int silkRelease()
  {
    if (!this.c) {
      return -102;
    }
    this.c = false;
    return this.e.nativeTRSilkRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.vad.TRSilk
 * JD-Core Version:    0.7.0.1
 */