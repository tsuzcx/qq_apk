package com.tencent.ilivesdk.supervisionservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface SupervisionServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract LoginServiceInterface getAccount();
  
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.SupervisionServiceAdapter
 * JD-Core Version:    0.7.0.1
 */