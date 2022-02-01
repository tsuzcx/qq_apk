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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscoverBannerPlayInfo{bannerId='");
    localStringBuilder.append(this.bannerId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo
 * JD-Core Version:    0.7.0.1
 */