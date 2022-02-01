package com.tencent.mobileqq.activity.springfestival.config;

import java.io.Serializable;

public class SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$ActivityInfo
  implements Serializable
{
  public SpringFestivalRedpacketConfBean.TimeInfo activityTime = new SpringFestivalRedpacketConfBean.TimeInfo();
  public String id;
  public String logoUrl;
  public long pendantEndTime;
  public String resUrl;
  public String videoUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActivityInfo{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", activityTime=");
    localStringBuilder.append(this.activityTime);
    localStringBuilder.append(", resUrl='");
    localStringBuilder.append(this.resUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", logoUrl='");
    localStringBuilder.append(this.logoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pendantEndTime=");
    localStringBuilder.append(this.pendantEndTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */