package com.tencent.luggage.wxa.u;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class d$d
  implements d.c
{
  public int a()
  {
    return MediaCodecList.getCodecCount();
  }
  
  public MediaCodecInfo a(int paramInt)
  {
    return MediaCodecList.getCodecInfoAt(paramInt);
  }
  
  public boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return "video/avc".equals(paramString);
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.d.d
 * JD-Core Version:    0.7.0.1
 */