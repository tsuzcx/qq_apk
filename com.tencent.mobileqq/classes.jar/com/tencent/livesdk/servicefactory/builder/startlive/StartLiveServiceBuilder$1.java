package com.tencent.livesdk.servicefactory.builder.startlive;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.startliveservice_interface.StartLiveServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class StartLiveServiceBuilder$1
  implements StartLiveServiceAdapter
{
  StartLiveServiceBuilder$1(StartLiveServiceBuilder paramStartLiveServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceAccessor.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceAccessor.getService(DataReportInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.startlive.StartLiveServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */