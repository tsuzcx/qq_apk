package com.tencent.mobileqq.app;

import java.io.Serializable;

public class DeviceProfileManager$DPCConfigInfo
  implements Serializable, Cloneable
{
  public static final String DPCINFO_FEATUREVALUE_DEFAULTVAL = "";
  public String featureValue = "";
  
  public Object clone()
  {
    try
    {
      DPCConfigInfo localDPCConfigInfo = (DPCConfigInfo)super.clone();
      if (localDPCConfigInfo == null) {
        return this;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      Object localObject;
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
        localObject = null;
      }
      localObject.featureValue = this.featureValue;
      return localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("DPCConfigInfo: featureValue=");
    localStringBuilder.append(this.featureValue);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager.DPCConfigInfo
 * JD-Core Version:    0.7.0.1
 */