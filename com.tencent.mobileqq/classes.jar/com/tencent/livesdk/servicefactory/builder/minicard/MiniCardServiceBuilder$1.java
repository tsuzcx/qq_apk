package com.tencent.livesdk.servicefactory.builder.minicard;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class MiniCardServiceBuilder$1
  implements MiniCardServiceAdapter
{
  MiniCardServiceBuilder$1(MiniCardServiceBuilder paramMiniCardServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.minicard.MiniCardServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */