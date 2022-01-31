package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

public class SpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo
  implements Serializable
{
  public String activityPrefix;
  public String activityUrl;
  public String branchActivityPrefix;
  public String emergencyUrl;
  public ArrayList<SpringFestivalRedpacketConfBean.TimeInfo> entryShowTime;
  public int entrySwitch;
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo fixedEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.FixedEntryInfo();
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo loadingInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.LoadingInfo();
  public long pendantDelay;
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo pendantEntryInfo = new SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo();
  public int pendantSwitch;
  public int webType;
  
  public String toString()
  {
    try
    {
      String str = "SpringFestivalHbEntryInfo{pendantEntryInfo=" + this.pendantEntryInfo + ", fixedEntryInfo=" + this.fixedEntryInfo + ", loadingInfo=" + this.loadingInfo + ", activityUrl='" + this.activityUrl + '\'' + ", emergencyUrl='" + this.emergencyUrl + '\'' + ", webType=" + this.webType + ", pendantSwitch=" + this.pendantSwitch + ", entrySwitch=" + this.entrySwitch + ", activityPrefix='" + this.activityPrefix + '\'' + ", entryShowTime=" + this.entryShowTime + ", pendantDelay=" + this.pendantDelay + '}';
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfBean", 1, localThrowable, new Object[0]);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo
 * JD-Core Version:    0.7.0.1
 */