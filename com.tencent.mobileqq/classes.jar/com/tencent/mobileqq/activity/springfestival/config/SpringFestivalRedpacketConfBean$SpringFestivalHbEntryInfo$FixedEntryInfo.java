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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FixedEntryInfo{defaultBanner='");
      ((StringBuilder)localObject).append(this.defaultBanner);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", useStagger=");
      ((StringBuilder)localObject).append(this.useStagger);
      ((StringBuilder)localObject).append(", staggerPeakIntervalBefore=");
      ((StringBuilder)localObject).append(this.staggerPeakIntervalBefore);
      ((StringBuilder)localObject).append(", entryBannerList=");
      ((StringBuilder)localObject).append(this.entryBannerList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo
 * JD-Core Version:    0.7.0.1
 */