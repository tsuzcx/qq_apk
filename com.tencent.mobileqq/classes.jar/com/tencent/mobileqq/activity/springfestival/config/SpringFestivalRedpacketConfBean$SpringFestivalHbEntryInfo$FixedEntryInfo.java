package com.tencent.mobileqq.activity.springfestival.config;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

public class SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$FixedEntryInfo
  implements Serializable
{
  public String defaultBanner;
  public ArrayList<SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo> entryBannerList = new ArrayList();
  public int staggerPeakIntervalBefore;
  public int useStagger;
  
  public String toString()
  {
    try
    {
      String str = "FixedEntryInfo{defaultBanner='" + this.defaultBanner + '\'' + ", useStagger=" + this.useStagger + ", staggerPeakIntervalBefore=" + this.staggerPeakIntervalBefore + ", entryBannerList=" + this.entryBannerList + '}';
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
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo
 * JD-Core Version:    0.7.0.1
 */