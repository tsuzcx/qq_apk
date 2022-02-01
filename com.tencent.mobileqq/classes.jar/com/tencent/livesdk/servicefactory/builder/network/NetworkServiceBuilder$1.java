package com.tencent.livesdk.servicefactory.builder.network;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.network.NetworkStateAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class NetworkServiceBuilder$1
  implements NetworkStateAdapter
{
  NetworkServiceBuilder$1(NetworkServiceBuilder paramNetworkServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.network.NetworkServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */