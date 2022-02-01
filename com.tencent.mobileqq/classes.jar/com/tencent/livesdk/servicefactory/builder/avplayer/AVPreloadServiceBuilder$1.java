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
  
  public AppGeneralInfoService a()
  {
    return (AppGeneralInfoService)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(AppGeneralInfoService.class);
  }
  
  public HttpInterface a()
  {
    return (HttpInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(HttpInterface.class);
  }
  
  public LogInterface a()
  {
    return (LogInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPreloadServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */