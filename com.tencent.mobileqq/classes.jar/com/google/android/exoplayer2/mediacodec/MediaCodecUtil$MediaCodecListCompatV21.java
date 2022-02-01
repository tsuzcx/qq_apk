package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class MediaCodecUtil$MediaCodecListCompatV21
  implements MediaCodecUtil.MediaCodecListCompat
{
  private final int codecKind;
  private MediaCodecInfo[] mediaCodecInfos;
  
  public MediaCodecUtil$MediaCodecListCompatV21(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.codecKind = i;
      return;
    }
  }
  
  private void ensureMediaCodecInfosInitialized()
  {
    if (this.mediaCodecInfos == null) {
      this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
    }
  }
  
  public int getCodecCount()
  {
    ensureMediaCodecInfosInitialized();
    return this.mediaCodecInfos.length;
  }
  
  public MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    ensureMediaCodecInfosInitialized();
    return this.mediaCodecInfos[paramInt];
  }
  
  public boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  public boolean secureDecodersExplicit()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV21
 * JD-Core Version:    0.7.0.1
 */