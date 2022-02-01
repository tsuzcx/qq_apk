package com.tencent.livesdk.livesdkplayer;

public class LiveSdkPlayerHelper$PlayerParams
{
  public static final int HIGH = 3;
  public static final int LOW = 1;
  public static final int NORMAL = 2;
  public long anchorUin;
  public int level = 2;
  public String originUrl;
  public long roomId;
  public int roomType;
  public byte[] sig;
  public String url;
  public String url_high;
  public String url_low;
  public String userId;
  public int videoType;
  
  public String getPlayUrl()
  {
    return getPlayUrl(this.level);
  }
  
  public String getPlayUrl(int paramInt)
  {
    this.level = paramInt;
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.url;
    case 1: 
      return this.url_low;
    }
    return this.url_high;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.PlayerParams
 * JD-Core Version:    0.7.0.1
 */