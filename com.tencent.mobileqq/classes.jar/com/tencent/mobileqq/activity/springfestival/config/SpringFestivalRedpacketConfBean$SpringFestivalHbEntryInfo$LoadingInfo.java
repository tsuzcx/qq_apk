package com.tencent.mobileqq.activity.springfestival.config;

import java.io.Serializable;

public class SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$LoadingInfo
  implements Serializable
{
  public SpringFestivalRedpacketConfBean.TimeInfo loadingTime = new SpringFestivalRedpacketConfBean.TimeInfo();
  public String loadingTips;
  public String loadingUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadingInfo{loadingTime=");
    localStringBuilder.append(this.loadingTime);
    localStringBuilder.append(", loadingUrl='");
    localStringBuilder.append(this.loadingUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", loadingTips='");
    localStringBuilder.append(this.loadingTips);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo
 * JD-Core Version:    0.7.0.1
 */