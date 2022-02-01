package com.tencent.falco.base.libapi.channel;

import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;

public abstract interface ChannelServiceAdapter
{
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract String getAppVersion();
  
  public abstract LogInterface getLogger();
  
  public abstract ToastInterface getToast();
  
  public abstract int getVersionCode();
  
  public abstract WnsInterface getWns();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.ChannelServiceAdapter
 * JD-Core Version:    0.7.0.1
 */