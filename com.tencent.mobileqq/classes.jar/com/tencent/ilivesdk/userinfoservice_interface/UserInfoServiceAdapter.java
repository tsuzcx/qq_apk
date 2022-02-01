package com.tencent.ilivesdk.userinfoservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface UserInfoServiceAdapter
{
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceAdapter
 * JD-Core Version:    0.7.0.1
 */