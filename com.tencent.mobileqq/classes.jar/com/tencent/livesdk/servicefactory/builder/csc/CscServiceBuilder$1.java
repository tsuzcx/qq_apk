package com.tencent.livesdk.servicefactory.builder.csc;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.cscservice_interface.CscServiceInterface.CscServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;

class CscServiceBuilder$1
  implements CscServiceInterface.CscServiceAdapter
{
  CscServiceBuilder$1(CscServiceBuilder paramCscServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLogin()
  {
    return (LoginServiceInterface)ServiceAccessorMgr.getInstance().getUserAccessor().getService(LoginServiceInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.csc.CscServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */