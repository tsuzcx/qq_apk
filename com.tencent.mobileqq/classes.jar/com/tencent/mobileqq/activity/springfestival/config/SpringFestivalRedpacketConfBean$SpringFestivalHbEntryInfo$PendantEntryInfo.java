package com.tencent.mobileqq.activity.springfestival.config;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

public class SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo
  implements Serializable
{
  public ArrayList<SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.ActivityInfo> activityList = new ArrayList();
  public String defaultResUrl;
  public String defaultVideoUrl;
  public int forbidRefresh;
  public int forbidRefreshIntervalAfter;
  public int forbidRefreshIntervalBefore;
  public String loading;
  public String miniSmallBg;
  public String transitionBg;
  
  public String toString()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PendantEntryInfo{defaultResUrl='");
      ((StringBuilder)localObject).append(this.defaultResUrl);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", defaultVideoUrl='");
      ((StringBuilder)localObject).append(this.defaultVideoUrl);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", transitionBg='");
      ((StringBuilder)localObject).append(this.transitionBg);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", loading='");
      ((StringBuilder)localObject).append(this.loading);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", activityList=");
      ((StringBuilder)localObject).append(this.activityList);
      ((StringBuilder)localObject).append(", forbidRefresh=");
      ((StringBuilder)localObject).append(this.forbidRefresh);
      ((StringBuilder)localObject).append(", forbidRefreshIntervalBefore=");
      ((StringBuilder)localObject).append(this.forbidRefreshIntervalBefore);
      ((StringBuilder)localObject).append(", forbidRefreshIntervalAfter=");
      ((StringBuilder)localObject).append(this.forbidRefreshIntervalAfter);
      ((StringBuilder)localObject).append(", miniSmallBg='");
      ((StringBuilder)localObject).append(this.miniSmallBg);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append('}');
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfBean", 1, localThrowable, new Object[0]);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo
 * JD-Core Version:    0.7.0.1
 */