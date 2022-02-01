package com.tencent.livesdk.servicefactory.builder.livestartcustomerconfig;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.livestartcustomerconfigservice_interface.LiveStartCusConfServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LiveStartCusConfServiceBuilder$1
  implements LiveStartCusConfServiceAdapter
{
  LiveStartCusConfServiceBuilder$1(LiveStartCusConfServiceBuilder paramLiveStartCusConfServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.livestartcustomerconfig.LiveStartCusConfServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */