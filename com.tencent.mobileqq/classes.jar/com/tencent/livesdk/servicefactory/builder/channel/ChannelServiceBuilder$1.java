package com.tencent.livesdk.servicefactory.builder.channel;

import com.tencent.falco.base.libapi.channel.ChannelServiceAdapter;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ChannelServiceBuilder$1
  implements ChannelServiceAdapter
{
  ChannelServiceBuilder$1(ChannelServiceBuilder paramChannelServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class);
  }
  
  public String getAppVersion()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).getVersionName();
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
  
  public ToastInterface getToast()
  {
    return (ToastInterface)this.val$serviceAccessor.getService(ToastInterface.class);
  }
  
  public int getVersionCode()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).getVersionCode();
  }
  
  public WnsInterface getWns()
  {
    return (WnsInterface)this.val$serviceAccessor.getService(WnsInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.channel.ChannelServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */