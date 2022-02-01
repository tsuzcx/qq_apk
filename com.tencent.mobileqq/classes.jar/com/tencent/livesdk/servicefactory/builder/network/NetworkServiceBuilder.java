package com.tencent.livesdk.servicefactory.builder.network;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.ilivesdk.network.NetworkService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class NetworkServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    NetworkService localNetworkService = new NetworkService();
    localNetworkService.init(new NetworkServiceBuilder.1(this, paramServiceAccessor));
    return localNetworkService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.network.NetworkServiceBuilder
 * JD-Core Version:    0.7.0.1
 */