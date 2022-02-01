package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gw.b;
import com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni;

public class h
  implements j
{
  private int a = 0;
  private int b = 0;
  private AudioFFmpegDecodeJni c;
  private String d;
  
  public boolean a()
  {
    AudioFFmpegDecodeJni localAudioFFmpegDecodeJni = this.c;
    localAudioFFmpegDecodeJni.clearResample(this.d, localAudioFFmpegDecodeJni);
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    b.b("MicroMsg.Mix.FFmpegResampleAlgorithm", "ffmpeg resample algorithm  sSample:%d, dSample:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString;
    this.c = new AudioFFmpegDecodeJni();
    AudioFFmpegDecodeJni localAudioFFmpegDecodeJni = this.c;
    localAudioFFmpegDecodeJni.initResample(paramString, paramInt1, paramInt2, 2, 2, localAudioFFmpegDecodeJni);
    return true;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    float f1 = paramArrayOfByte.length / 2;
    int i = this.b;
    float f2 = i;
    int j = this.a;
    byte[] arrayOfByte = new byte[(int)(f1 * (f2 / j)) * 2];
    AudioFFmpegDecodeJni localAudioFFmpegDecodeJni = this.c;
    localAudioFFmpegDecodeJni.resamplePcm(this.d, j, i, paramArrayOfByte, paramArrayOfByte.length, arrayOfByte, arrayOfByte.length, localAudioFFmpegDecodeJni);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.h
 * JD-Core Version:    0.7.0.1
 */