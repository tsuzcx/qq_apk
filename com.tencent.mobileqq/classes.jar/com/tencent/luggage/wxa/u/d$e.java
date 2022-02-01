package com.tencent.luggage.wxa.u;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class d$e
  implements d.c
{
  private final int a;
  private MediaCodecInfo[] b;
  
  public d$e(boolean paramBoolean) {}
  
  private void c()
  {
    if (this.b == null) {
      this.b = new MediaCodecList(this.a).getCodecInfos();
    }
  }
  
  public int a()
  {
    c();
    return this.b.length;
  }
  
  public MediaCodecInfo a(int paramInt)
  {
    c();
    return this.b[paramInt];
  }
  
  public boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.d.e
 * JD-Core Version:    0.7.0.1
 */