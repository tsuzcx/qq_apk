package com.tencent.livesdk.servicefactory.builder.location;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.location.LocationComponent;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LocationServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LocationComponent localLocationComponent = new LocationComponent();
    localLocationComponent.init(new LocationServiceBuilder.1(this, paramServiceAccessor));
    return localLocationComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.location.LocationServiceBuilder
 * JD-Core Version:    0.7.0.1
 */