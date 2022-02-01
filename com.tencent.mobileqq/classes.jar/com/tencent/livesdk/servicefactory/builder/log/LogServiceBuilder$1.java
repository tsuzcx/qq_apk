package com.tencent.livesdk.servicefactory.builder.log;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogInterface.LogAdapter;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LogServiceBuilder$1
  implements LogInterface.LogAdapter
{
  LogServiceBuilder$1(LogServiceBuilder paramLogServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLog()
  {
    return ((LogSdkServiceInterface)this.val$serviceManager.getService(LogSdkServiceInterface.class)).getLog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.log.LogServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */