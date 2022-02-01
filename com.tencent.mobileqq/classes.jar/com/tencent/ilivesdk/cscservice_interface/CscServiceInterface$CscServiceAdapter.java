package com.tencent.ilivesdk.cscservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface CscServiceInterface$CscServiceAdapter
{
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract LogInterface getLog();
  
  public abstract LoginServiceInterface getLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.cscservice_interface.CscServiceInterface.CscServiceAdapter
 * JD-Core Version:    0.7.0.1
 */