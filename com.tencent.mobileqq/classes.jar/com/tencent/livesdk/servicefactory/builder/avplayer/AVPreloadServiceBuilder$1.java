package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class AVPreloadServiceBuilder$1
  implements AVPreloadServiceAdapter
{
  AVPreloadServiceBuilder$1(AVPreloadServiceBuilder paramAVPreloadServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface a()
  {
    return (LogInterface)this.a.getService(LogInterface.class);
  }
  
  public AppGeneralInfoService b()
  {
    return (AppGeneralInfoService)this.a.getService(AppGeneralInfoService.class);
  }
  
  public HttpInterface c()
  {
    return (HttpInterface)this.a.getService(HttpInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPreloadServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */