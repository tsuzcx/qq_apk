package com.tencent.mobileqq.activity.springfestival.config;

import java.io.Serializable;

public class SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo$BannerInfo
  implements Serializable
{
  public static final int STATUS_ING = 1;
  public static final int STATUS_SOON = 0;
  public int bannerHeight;
  public SpringFestivalRedpacketConfBean.TimeInfo bannerTime = new SpringFestivalRedpacketConfBean.TimeInfo();
  public String bannerUrl;
  public String popUpBgUrl;
  public String previewActivityUrl;
  public SpringFestivalRedpacketConfBean.TimeInfo soonTime = new SpringFestivalRedpacketConfBean.TimeInfo();
  public int status;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BannerInfo{bannerTime=");
    localStringBuilder.append(this.bannerTime);
    localStringBuilder.append(", soonTime=");
    localStringBuilder.append(this.soonTime);
    localStringBuilder.append(", bannerUrl='");
    localStringBuilder.append(this.bannerUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", previewActivityUrl='");
    localStringBuilder.append(this.previewActivityUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", bannerHeight=");
    localStringBuilder.append(this.bannerHeight);
    localStringBuilder.append(", popUpBgUrl='");
    localStringBuilder.append(this.popUpBgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo
 * JD-Core Version:    0.7.0.1
 */