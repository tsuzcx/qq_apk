package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;

abstract interface MediaCodecUtil$MediaCodecListCompat
{
  public abstract int getCodecCount();
  
  public abstract MediaCodecInfo getCodecInfoAt(int paramInt);
  
  public abstract boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
  
  public abstract boolean secureDecodersExplicit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
 * JD-Core Version:    0.7.0.1
 */