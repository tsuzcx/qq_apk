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
    boolean bool = true;
    if ((!paramBoolean1) && (paramCodecCapabilities != null) && (isAdaptive(paramCodecCapabilities))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.adaptive = paramBoolean1;
    if ((paramCodecCapabilities != null) && (isTunneling(paramCodecCapabilities))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.tunneling = paramBoolean1;
    paramBoolean1 = bool;
    if (!paramBoolean2) {
      if ((paramCodecCapabilities != null) && (isSecure(paramCodecCapabilities))) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }
    }
    this.secure = paramBoolean1;
  }
  
  private static int adjustMaxInputChannelCount(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt <= 1)
    {
      if ((Util.SDK_INT >= 26) && (paramInt > 0)) {
        return paramInt;
      }
      if ((!"audio/mpeg".equals(paramString2)) && (!"audio/3gpp".equals(paramString2)) && (!"audio/amr-wb".equals(paramString2)) && (!"audio/mp4a-latm".equals(paramString2)) && (!"audio/vorbis".equals(paramString2)) && (!"audio/opus".equals(paramString2)) && (!"audio/raw".equals(paramString2)) && (!"audio/flac".equals(paramString2)) && (!"audio/g711-alaw".equals(paramString2)) && (!"audio/g711-mlaw".equals(paramString2)))
      {
        if ("audio/gsm".equals(paramString2)) {
          return paramInt;
        }
        int i;
        if ("audio/ac3".equals(paramString2)) {
          i = 6;
        } else if ("audio/eac3".equals(paramString2)) {
          i = 16;
        } else {
          i = 30;
        }
        paramString2 = new StringBuilder();
        paramString2.append("AssumedMaxChannelAdjustment: ");
        paramString2.append(paramString1);
        paramString2.append(", [");
        paramString2.append(paramInt);
        paramString2.append(" to ");
        paramString2.append(i);
        paramString2.append("]");
        Log.w("MediaCodecInfo", paramString2.toString());
        return i;
      }
    }
    return paramInt;
  }
  
  @TargetApi(21)
  private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramDouble != -1.0D) && (paramDouble > 0.0D)) {
      return paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
    }
    return paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssumedSupport [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] [");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mimeType);
    localStringBuilder.append("] [");
    localStringBuilder.append(Util.DEVICE_DEBUG_INFO);
    localStringBuilder.append("]");
    Log.d("MediaCodecInfo", localStringBuilder.toString());
  }
  
  private void logNoSupport(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NoSupport [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] [");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mimeType);
    localStringBuilder.append("] [");
    localStringBuilder.append(Util.DEVICE_DEBUG_INFO);
    localStringBuilder.append("]");
    Log.d("MediaCodecInfo", localStringBuilder.toString());
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
    Object localObject = this.capabilities;
    if (localObject == null)
    {
      logNoSupport("align.caps");
      return null;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
    if (localObject == null)
    {
      logNoSupport("align.vCaps");
      return null;
    }
    int i = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
    int j = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
    return new Point(Util.ceilDivide(paramInt1, i) * i, Util.ceilDivide(paramInt2, j) * j);
  }
  
  public MediaCodecInfo.CodecProfileLevel[] getProfileLevels()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = this.capabilities;
    if ((localCodecCapabilities != null) && (localCodecCapabilities.profileLevels != null)) {
      return this.capabilities.profileLevels;
    }
    return new MediaCodecInfo.CodecProfileLevel[0];
  }
  
  @TargetApi(21)
  public boolean isAudioChannelCountSupportedV21(int paramInt)
  {
    Object localObject = this.capabilities;
    if (localObject == null)
    {
      logNoSupport("channelCount.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getAudioCapabilities();
    if (localObject == null)
    {
      logNoSupport("channelCount.aCaps");
      return false;
    }
    if (adjustMaxInputChannelCount(this.name, this.mimeType, ((MediaCodecInfo.AudioCapabilities)localObject).getMaxInputChannelCount()) < paramInt)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("channelCount.support, ");
      ((StringBuilder)localObject).append(paramInt);
      logNoSupport(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  @TargetApi(21)
  public boolean isAudioSampleRateSupportedV21(int paramInt)
  {
    Object localObject = this.capabilities;
    if (localObject == null)
    {
      logNoSupport("sampleRate.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getAudioCapabilities();
    if (localObject == null)
    {
      logNoSupport("sampleRate.aCaps");
      return false;
    }
    if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(paramInt))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sampleRate.support, ");
      ((StringBuilder)localObject).append(paramInt);
      logNoSupport(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public boolean isCodecSupported(String paramString)
  {
    if (paramString != null)
    {
      if (this.mimeType == null) {
        return true;
      }
      String str = MimeTypes.getMediaMimeType(paramString);
      if (str == null) {
        return true;
      }
      if (!this.mimeType.equals(str))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("codec.mime ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(str);
        logNoSupport(((StringBuilder)localObject).toString());
        return false;
      }
      Object localObject = MediaCodecUtil.getCodecProfileAndLevel(paramString);
      if (localObject == null) {
        return true;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = getProfileLevels();
      int j = arrayOfCodecProfileLevel.length;
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
        if ((localCodecProfileLevel.profile == ((Integer)((Pair)localObject).first).intValue()) && (localCodecProfileLevel.level >= ((Integer)((Pair)localObject).second).intValue())) {
          return true;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("codec.profileLevel, ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(str);
      logNoSupport(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  @TargetApi(21)
  public boolean isVideoSizeAndRateSupportedV21(int paramInt1, int paramInt2, double paramDouble)
  {
    Object localObject = this.capabilities;
    if (localObject == null)
    {
      logNoSupport("sizeAndRate.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
    if (localObject == null)
    {
      logNoSupport("sizeAndRate.vCaps");
      return false;
    }
    if (!areSizeAndRateSupportedV21((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2, paramDouble)) {
      if ((paramInt1 < paramInt2) && (areSizeAndRateSupportedV21((MediaCodecInfo.VideoCapabilities)localObject, paramInt2, paramInt1, paramDouble)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sizeAndRate.rotated, ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramDouble);
        logAssumedSupport(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sizeAndRate.support, ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramDouble);
        logNoSupport(((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecInfo
 * JD-Core Version:    0.7.0.1
 */