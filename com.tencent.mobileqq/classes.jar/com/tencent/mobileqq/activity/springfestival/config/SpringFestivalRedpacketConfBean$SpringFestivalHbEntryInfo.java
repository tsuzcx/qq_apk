package com.tencent.mobileqq.activity.springfestival.config;

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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SpringFestivalHbEntryInfo{pendantEntryInfo=");
      ((StringBuilder)localObject).append(this.pendantEntryInfo);
      ((StringBuilder)localObject).append(", fixedEntryInfo=");
      ((StringBuilder)localObject).append(this.fixedEntryInfo);
      ((StringBuilder)localObject).append(", loadingInfo=");
      ((StringBuilder)localObject).append(this.loadingInfo);
      ((StringBuilder)localObject).append(", activityUrl='");
      ((StringBuilder)localObject).append(this.activityUrl);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", emergencyUrl='");
      ((StringBuilder)localObject).append(this.emergencyUrl);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", webType=");
      ((StringBuilder)localObject).append(this.webType);
      ((StringBuilder)localObject).append(", pendantSwitch=");
      ((StringBuilder)localObject).append(this.pendantSwitch);
      ((StringBuilder)localObject).append(", entrySwitch=");
      ((StringBuilder)localObject).append(this.entrySwitch);
      ((StringBuilder)localObject).append(", activityPrefix='");
      ((StringBuilder)localObject).append(this.activityPrefix);
      ((StringBuilder)localObject).append('\'');
      ((StringBuilder)localObject).append(", entryShowTime=");
      ((StringBuilder)localObject).append(this.entryShowTime);
      ((StringBuilder)localObject).append(", pendantDelay=");
      ((StringBuilder)localObject).append(this.pendantDelay);
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
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo
 * JD-Core Version:    0.7.0.1
 */