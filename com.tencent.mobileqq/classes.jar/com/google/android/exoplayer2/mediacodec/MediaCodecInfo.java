package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

@TargetApi(16)
public final class MediaCodecInfo
{
  public static final String TAG = "MediaCodecInfo";
  public final boolean adaptive;
  private final MediaCodecInfo.CodecCapabilities capabilities;
  private final String mimeType;
  public final String name;
  public final boolean secure;
  public final boolean tunneling;
  
  private MediaCodecInfo(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.name = ((String)Assertions.checkNotNull(paramString1));
    this.mimeType = paramString2;
    this.capabilities = paramCodecCapabilities;
    if ((!paramBoolean1) && (paramCodecCapabilities != null) && (isAdaptive(paramCodecCapabilities)))
    {
      paramBoolean1 = true;
      this.adaptive = paramBoolean1;
      if ((paramCodecCapabilities == null) || (!isTunneling(paramCodecCapabilities))) {
        break label113;
      }
    }
    label113:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.tunneling = paramBoolean1;
      if (!paramBoolean2)
      {
        paramBoolean1 = bool;
        if (paramCodecCapabilities != null)
        {
          paramBoolean1 = bool;
          if (!isSecure(paramCodecCapabilities)) {}
        }
      }
      else
      {
        paramBoolean1 = true;
      }
      this.secure = paramBoolean1;
      return;
      paramBoolean1 = false;
      break;
    }
  }
  
  private static int adjustMaxInputChannelCount(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt > 1) || ((Util.SDK_INT >= 26) && (paramInt > 0))) {}
    while (("audio/mpeg".equals(paramString2)) || ("audio/3gpp".equals(paramString2)) || ("audio/amr-wb".equals(paramString2)) || ("audio/mp4a-latm".equals(paramString2)) || ("audio/vorbis".equals(paramString2)) || ("audio/opus".equals(paramString2)) || ("audio/raw".equals(paramString2)) || ("audio/flac".equals(paramString2)) || ("audio/g711-alaw".equals(paramString2)) || ("audio/g711-mlaw".equals(paramString2)) || ("audio/gsm".equals(paramString2))) {
      return paramInt;
    }
    int i;
    if ("audio/ac3".equals(paramString2)) {
      i = 6;
    }
    for (;;)
    {
      Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + paramString1 + ", [" + paramInt + " to " + i + "]");
      return i;
      if ("audio/eac3".equals(paramString2)) {
        i = 16;
      } else {
        i = 30;
      }
    }
  }
  
  @TargetApi(21)
  private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramDouble == -1.0D) || (paramDouble <= 0.0D)) {
      return paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
    }
    return paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
  }
  
  private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Util.SDK_INT >= 19) && (isAdaptiveV19(paramCodecCapabilities));
  }
  
  @TargetApi(19)
  private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("adaptive-playback");
  }
  
  private static boolean isSecure(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Util.SDK_INT >= 21) && (isSecureV21(paramCodecCapabilities));
  }
  
  @TargetApi(21)
  private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  private static boolean isTunneling(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Util.SDK_INT >= 21) && (isTunnelingV21(paramCodecCapabilities));
  }
  
  @TargetApi(21)
  private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("tunneled-playback");
  }
  
  private void logAssumedSupport(String paramString)
  {
    Log.d("MediaCodecInfo", "AssumedSupport [" + paramString + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
  }
  
  private void logNoSupport(String paramString)
  {
    Log.d("MediaCodecInfo", "NoSupport [" + paramString + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
  }
  
  public static MediaCodecInfo newInstance(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return new MediaCodecInfo(paramString1, paramString2, paramCodecCapabilities, false, false);
  }
  
  public static MediaCodecInfo newInstance(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new MediaCodecInfo(paramString1, paramString2, paramCodecCapabilities, paramBoolean1, paramBoolean2);
  }
  
  public static MediaCodecInfo newPassthroughInstance(String paramString)
  {
    return new MediaCodecInfo(paramString, null, null, false, false);
  }
  
  @TargetApi(21)
  public Point alignVideoSizeV21(int paramInt1, int paramInt2)
  {
    if (this.capabilities == null)
    {
      logNoSupport("align.caps");
      return null;
    }
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = this.capabilities.getVideoCapabilities();
    if (localVideoCapabilities == null)
    {
      logNoSupport("align.vCaps");
      return null;
    }
    int i = localVideoCapabilities.getWidthAlignment();
    int j = localVideoCapabilities.getHeightAlignment();
    return new Point(i * Util.ceilDivide(paramInt1, i), j * Util.ceilDivide(paramInt2, j));
  }
  
  public MediaCodecInfo.CodecProfileLevel[] getProfileLevels()
  {
    if ((this.capabilities == null) || (this.capabilities.profileLevels == null)) {
      return new MediaCodecInfo.CodecProfileLevel[0];
    }
    return this.capabilities.profileLevels;
  }
  
  @TargetApi(21)
  public boolean isAudioChannelCountSupportedV21(int paramInt)
  {
    if (this.capabilities == null)
    {
      logNoSupport("channelCount.caps");
      return false;
    }
    MediaCodecInfo.AudioCapabilities localAudioCapabilities = this.capabilities.getAudioCapabilities();
    if (localAudioCapabilities == null)
    {
      logNoSupport("channelCount.aCaps");
      return false;
    }
    if (adjustMaxInputChannelCount(this.name, this.mimeType, localAudioCapabilities.getMaxInputChannelCount()) < paramInt)
    {
      logNoSupport("channelCount.support, " + paramInt);
      return false;
    }
    return true;
  }
  
  @TargetApi(21)
  public boolean isAudioSampleRateSupportedV21(int paramInt)
  {
    if (this.capabilities == null)
    {
      logNoSupport("sampleRate.caps");
      return false;
    }
    MediaCodecInfo.AudioCapabilities localAudioCapabilities = this.capabilities.getAudioCapabilities();
    if (localAudioCapabilities == null)
    {
      logNoSupport("sampleRate.aCaps");
      return false;
    }
    if (!localAudioCapabilities.isSampleRateSupported(paramInt))
    {
      logNoSupport("sampleRate.support, " + paramInt);
      return false;
    }
    return true;
  }
  
  public boolean isCodecSupported(String paramString)
  {
    if ((paramString == null) || (this.mimeType == null)) {
      return true;
    }
    String str = MimeTypes.getMediaMimeType(paramString);
    if (str == null) {
      return true;
    }
    if (!this.mimeType.equals(str))
    {
      logNoSupport("codec.mime " + paramString + ", " + str);
      return false;
    }
    Pair localPair = MediaCodecUtil.getCodecProfileAndLevel(paramString);
    if (localPair == null) {
      return true;
    }
    MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = getProfileLevels();
    int j = arrayOfCodecProfileLevel.length;
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
      if ((localCodecProfileLevel.profile == ((Integer)localPair.first).intValue()) && (localCodecProfileLevel.level >= ((Integer)localPair.second).intValue())) {
        return true;
      }
      i += 1;
    }
    logNoSupport("codec.profileLevel, " + paramString + ", " + str);
    return false;
  }
  
  @TargetApi(21)
  public boolean isVideoSizeAndRateSupportedV21(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.capabilities == null)
    {
      logNoSupport("sizeAndRate.caps");
      return false;
    }
    MediaCodecInfo.VideoCapabilities localVideoCapabilities = this.capabilities.getVideoCapabilities();
    if (localVideoCapabilities == null)
    {
      logNoSupport("sizeAndRate.vCaps");
      return false;
    }
    if (!areSizeAndRateSupportedV21(localVideoCapabilities, paramInt1, paramInt2, paramDouble))
    {
      if ((paramInt1 >= paramInt2) || (!areSizeAndRateSupportedV21(localVideoCapabilities, paramInt2, paramInt1, paramDouble)))
      {
        logNoSupport("sizeAndRate.support, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
        return false;
      }
      logAssumedSupport("sizeAndRate.rotated, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecInfo
 * JD-Core Version:    0.7.0.1
 */