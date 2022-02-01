package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
final class CryptoInfo$PatternHolderV24
{
  private final MediaCodec.CryptoInfo frameworkCryptoInfo;
  private final MediaCodec.CryptoInfo.Pattern pattern;
  
  private CryptoInfo$PatternHolderV24(MediaCodec.CryptoInfo paramCryptoInfo)
  {
    this.frameworkCryptoInfo = paramCryptoInfo;
    this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
  }
  
  private void set(int paramInt1, int paramInt2)
  {
    this.pattern.set(paramInt1, paramInt2);
    this.frameworkCryptoInfo.setPattern(this.pattern);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.CryptoInfo.PatternHolderV24
 * JD-Core Version:    0.7.0.1
 */