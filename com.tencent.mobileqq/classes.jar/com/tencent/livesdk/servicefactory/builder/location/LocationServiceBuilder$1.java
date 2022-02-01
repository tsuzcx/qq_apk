package com.tencent.livesdk.servicefactory.builder.location;

import com.tencent.falco.base.libapi.location.LocationInterface.LocationInterfaceAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LocationServiceBuilder$1
  implements LocationInterface.LocationInterfaceAdapter
{
  LocationServiceBuilder$1(LocationServiceBuilder paramLocationServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.location.LocationServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */