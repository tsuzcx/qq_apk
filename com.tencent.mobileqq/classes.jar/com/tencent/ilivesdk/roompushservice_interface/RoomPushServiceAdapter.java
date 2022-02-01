package com.tencent.ilivesdk.roompushservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface RoomPushServiceAdapter
{
  public abstract AppGeneralInfoService getAppGeneralInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract HostProxyInterface getHostProxyInterface();
  
  public abstract LogInterface getLogger();
  
  public abstract LoginServiceInterface getLoginInfo();
  
  public abstract String getProgramId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceAdapter
 * JD-Core Version:    0.7.0.1
 */