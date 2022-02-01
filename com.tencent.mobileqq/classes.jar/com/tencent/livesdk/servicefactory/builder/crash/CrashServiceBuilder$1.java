package com.tencent.livesdk.servicefactory.builder.crash;

import com.tencent.falco.base.libapi.crash.CrashInterface.CrashAdapter;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class CrashServiceBuilder$1
  implements CrashInterface.CrashAdapter
{
  CrashServiceBuilder$1(CrashServiceBuilder paramCrashServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public String crashAppId()
  {
    return "2580281995";
  }
  
  public String getDeviceId()
  {
    return ((AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class)).getDeviceID();
  }
  
  public String getVersion()
  {
    return ((AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class)).getVersionName();
  }
  
  public String liveAppId()
  {
    return ((AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class)).getAppId();
  }
  
  public void onCrashHandleStart()
  {
    ((LogSdkServiceInterface)this.val$serviceManager.getService(LogSdkServiceInterface.class)).flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.crash.CrashServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */