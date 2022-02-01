package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class MediaCodecUtil$MediaCodecListCompatV16
  implements MediaCodecUtil.MediaCodecListCompat
{
  public int getCodecCount()
  {
    return MediaCodecList.getCodecCount();
  }
  
  public MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    return MediaCodecList.getCodecInfoAt(paramInt);
  }
  
  public boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return "video/avc".equals(paramString);
  }
  
  public boolean secureDecodersExplicit()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompatV16
 * JD-Core Version:    0.7.0.1
 */