package com.tencent.mm.audio.mix.jni;

import com.tencent.luggage.wxa.gq.o;

public class AudioFFmpegDecodeJni
{
  protected long a = 0L;
  protected long b = 0L;
  
  static
  {
    System.loadLibrary("FFmpeg");
  }
  
  public static native int decode(int paramInt1, int paramInt2, int paramInt3, String paramString, o paramo);
  
  public native int clearResample(String paramString, Object paramObject);
  
  public native int initResample(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject);
  
  public native int resamplePcm(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni
 * JD-Core Version:    0.7.0.1
 */