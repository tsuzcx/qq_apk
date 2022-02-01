package com.tencent.livesdk.servicefactory.builder.liveconfig;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;

class LiveConfigServiceBuilder$1
  implements LiveConfigServiceAdapter
{
  LiveConfigServiceBuilder$1(LiveConfigServiceBuilder paramLiveConfigServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LoginServiceInterface getAccount()
  {
    return (LoginServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(LoginServiceInterface.class);
  }
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.liveconfig.LiveConfigServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */