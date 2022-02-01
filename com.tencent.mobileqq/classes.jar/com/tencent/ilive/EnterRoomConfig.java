package com.tencent.ilive;

import android.os.Bundle;

public class EnterRoomConfig
{
  public static final int VIDEO_FLV = 2;
  public static final int VIDEO_RTMP = 1;
  public static final int VIDEO_VIDEO = 3;
  public byte[] coverBitmapBytes;
  public Bundle extData;
  public boolean isLiteSdk;
  public boolean mutilRoom = false;
  public boolean preloadedVideo;
  public long roomId;
  public String source;
  public EnterRoomConfig.VideoFormat[] supportVideoFormats;
  public int videoFormat = 1;
  public String videoId;
  public boolean videoIsOrigin = false;
  public int videoLevel = -1;
  public String videoUrl;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.EnterRoomConfig
 * JD-Core Version:    0.7.0.1
 */