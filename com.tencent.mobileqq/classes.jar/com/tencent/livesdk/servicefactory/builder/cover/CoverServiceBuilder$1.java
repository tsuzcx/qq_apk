package com.tencent.livesdk.servicefactory.builder.cover;

import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.coverservice_interface.CoverServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class CoverServiceBuilder$1
  implements CoverServiceAdapter
{
  CoverServiceBuilder$1(CoverServiceBuilder paramCoverServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceAccessor.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLoginService()
  {
    return (LoginServiceInterface)this.val$serviceAccessor.getService(LoginServiceInterface.class);
  }
  
  public boolean isSvrTestEnv()
  {
    AppGeneralInfoService localAppGeneralInfoService = (AppGeneralInfoService)this.val$serviceAccessor.getService(AppGeneralInfoService.class);
    if (localAppGeneralInfoService != null) {
      return localAppGeneralInfoService.isSvrTestEnv();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.cover.CoverServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */