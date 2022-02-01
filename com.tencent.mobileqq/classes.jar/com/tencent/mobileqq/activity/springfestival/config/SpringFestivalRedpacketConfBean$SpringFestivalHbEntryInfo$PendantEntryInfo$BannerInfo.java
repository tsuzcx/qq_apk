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
    return "BannerInfo{bannerTime=" + this.bannerTime + ", soonTime=" + this.soonTime + ", bannerUrl='" + this.bannerUrl + '\'' + ", previewActivityUrl='" + this.previewActivityUrl + '\'' + ", status=" + this.status + ", bannerHeight=" + this.bannerHeight + ", popUpBgUrl='" + this.popUpBgUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo
 * JD-Core Version:    0.7.0.1
 */