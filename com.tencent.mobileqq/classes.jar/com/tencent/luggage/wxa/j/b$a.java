package com.tencent.luggage.wxa.j;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
final class b$a
{
  private final MediaCodec.CryptoInfo a;
  private final MediaCodec.CryptoInfo.Pattern b;
  
  private b$a(MediaCodec.CryptoInfo paramCryptoInfo)
  {
    this.a = paramCryptoInfo;
    this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.b.set(paramInt1, paramInt2);
    this.a.setPattern(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.j.b.a
 * JD-Core Version:    0.7.0.1
 */