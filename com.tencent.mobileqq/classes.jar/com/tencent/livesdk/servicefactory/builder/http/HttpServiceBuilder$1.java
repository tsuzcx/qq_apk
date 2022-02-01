package com.tencent.livesdk.servicefactory.builder.http;

import com.tencent.falco.base.libapi.http.HttpInterface.HttpComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class HttpServiceBuilder$1
  implements HttpInterface.HttpComponentAdapter
{
  HttpServiceBuilder$1(HttpServiceBuilder paramHttpServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.http.HttpServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */