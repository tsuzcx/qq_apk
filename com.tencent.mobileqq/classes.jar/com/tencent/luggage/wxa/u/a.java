package com.tencent.luggage.wxa.u;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.ao.j;
import com.tencent.luggage.wxa.ao.x;

@TargetApi(16)
public final class a
{
  public final String a;
  public final boolean b;
  public final boolean c;
  public final boolean d;
  private final String e;
  private final MediaCodecInfo.CodecCapabilities f;
  
  private a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = ((String)com.tencent.luggage.wxa.ao.a.a(paramString1));
    this.e = paramString2;
    this.f = paramCodecCapabilities;
    boolean bool = true;
    if ((!paramBoolean1) && (paramCodecCapabilities != null) && (a(paramCodecCapabilities))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.b = paramBoolean1;
    if ((paramCodecCapabilities != null) && (c(paramCodecCapabilities))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.c = paramBoolean1;
    paramBoolean1 = bool;
    if (!paramBoolean2) {
      if ((paramCodecCapabilities != null) && (e(paramCodecCapabilities))) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }
    }
    this.d = paramBoolean1;
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt <= 1)
    {
      if ((x.a >= 26) && (paramInt > 0)) {
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
  
  public static a a(String paramString)
  {
    return new a(paramString, null, null, false, false);
  }
  
  public static a a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new a(paramString1, paramString2, paramCodecCapabilities, paramBoolean1, paramBoolean2);
  }
  
  private static boolean a(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (x.a >= 19) && (b(paramCodecCapabilities));
  }
  
  @TargetApi(21)
  private static boolean a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramDouble != -1.0D) && (paramDouble > 0.0D)) {
      return paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
    }
    return paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
  }
  
  @TargetApi(19)
  private static boolean b(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("adaptive-playback");
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NoSupport [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] [");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("] [");
    localStringBuilder.append(x.e);
    localStringBuilder.append("]");
    Log.d("MediaCodecInfo", localStringBuilder.toString());
  }
  
  private static boolean c(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (x.a >= 21) && (d(paramCodecCapabilities));
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssumedSupport [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] [");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("] [");
    localStringBuilder.append(x.e);
    localStringBuilder.append("]");
    Log.d("MediaCodecInfo", localStringBuilder.toString());
  }
  
  @TargetApi(21)
  private static boolean d(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("tunneled-playback");
  }
  
  private static boolean e(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (x.a >= 21) && (f(paramCodecCapabilities));
  }
  
  @TargetApi(21)
  private static boolean f(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  @TargetApi(21)
  public Point a(int paramInt1, int paramInt2)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      c("align.caps");
      return null;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
    if (localObject == null)
    {
      c("align.vCaps");
      return null;
    }
    int i = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
    int j = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
    return new Point(x.a(paramInt1, i) * i, x.a(paramInt2, j) * j);
  }
  
  @TargetApi(21)
  public boolean a(int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      c("sampleRate.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getAudioCapabilities();
    if (localObject == null)
    {
      c("sampleRate.aCaps");
      return false;
    }
    if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(paramInt))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sampleRate.support, ");
      ((StringBuilder)localObject).append(paramInt);
      c(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  @TargetApi(21)
  public boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      c("sizeAndRate.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getVideoCapabilities();
    if (localObject == null)
    {
      c("sizeAndRate.vCaps");
      return false;
    }
    if (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2, paramDouble)) {
      if ((paramInt1 < paramInt2) && (a((MediaCodecInfo.VideoCapabilities)localObject, paramInt2, paramInt1, paramDouble)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sizeAndRate.rotated, ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramDouble);
        d(((StringBuilder)localObject).toString());
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
        c(((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public MediaCodecInfo.CodecProfileLevel[] a()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = this.f;
    if ((localCodecCapabilities != null) && (localCodecCapabilities.profileLevels != null)) {
      return this.f.profileLevels;
    }
    return new MediaCodecInfo.CodecProfileLevel[0];
  }
  
  @TargetApi(21)
  public boolean b(int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      c("channelCount.caps");
      return false;
    }
    localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getAudioCapabilities();
    if (localObject == null)
    {
      c("channelCount.aCaps");
      return false;
    }
    if (a(this.a, this.e, ((MediaCodecInfo.AudioCapabilities)localObject).getMaxInputChannelCount()) < paramInt)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("channelCount.support, ");
      ((StringBuilder)localObject).append(paramInt);
      c(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (paramString != null)
    {
      if (this.e == null) {
        return true;
      }
      String str = j.f(paramString);
      if (str == null) {
        return true;
      }
      if (!this.e.equals(str))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("codec.mime ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(str);
        c(((StringBuilder)localObject).toString());
        return false;
      }
      Object localObject = d.a(paramString);
      if (localObject == null) {
        return true;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = a();
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
      c(((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.a
 * JD-Core Version:    0.7.0.1
 */