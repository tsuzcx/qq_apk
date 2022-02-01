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
      String str = "PendantEntryInfo{defaultResUrl='" + this.defaultResUrl + '\'' + ", defaultVideoUrl='" + this.defaultVideoUrl + '\'' + ", transitionBg='" + this.transitionBg + '\'' + ", loading='" + this.loading + '\'' + ", activityList=" + this.activityList + ", forbidRefresh=" + this.forbidRefresh + ", forbidRefreshIntervalBefore=" + this.forbidRefreshIntervalBefore + ", forbidRefreshIntervalAfter=" + this.forbidRefreshIntervalAfter + ", miniSmallBg='" + this.miniSmallBg + '\'' + '}';
      return str;
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