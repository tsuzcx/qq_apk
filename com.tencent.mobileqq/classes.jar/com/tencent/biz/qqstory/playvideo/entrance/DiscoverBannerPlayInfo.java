package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class DiscoverBannerPlayInfo
  implements Serializable
{
  public final String bannerId;
  
  public DiscoverBannerPlayInfo(String paramString)
  {
    this.bannerId = paramString;
  }
  
  public String toString()
  {
    return "DiscoverBannerPlayInfo{bannerId='" + this.bannerId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo
 * JD-Core Version:    0.7.0.1
 */