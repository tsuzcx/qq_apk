package com.tencent.livesdk.servicefactory.builder.login;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;
import com.tencent.falco.base.libapi.web.WebInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LoginServiceBuilder$1
  implements LoginServiceAdapter
{
  LoginServiceBuilder$1(LoginServiceBuilder paramLoginServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceAccessor.getService(ChannelInterface.class);
  }
  
  public int getClientType()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).getClientType();
  }
  
  public DataReportInterface getDataReportInterface()
  {
    return (DataReportInterface)this.val$serviceAccessor.getService(DataReportInterface.class);
  }
  
  public String getDeviceID()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).getDeviceID();
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.val$serviceAccessor.getService(HostProxyInterface.class);
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceAccessor.getService(HttpInterface.class);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
  
  public int getVersionCode()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).getVersionCode();
  }
  
  public WebInterface getWebInterface()
  {
    return (WebInterface)this.val$serviceAccessor.getService(WebInterface.class);
  }
  
  public boolean isTestEnv()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).isSvrTestEnv();
  }
  
  public boolean loginByWns()
  {
    return ((AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class)).isLiteSdk() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.login.LoginServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */