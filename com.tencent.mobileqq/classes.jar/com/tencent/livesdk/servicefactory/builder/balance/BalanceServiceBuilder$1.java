package com.tencent.livesdk.servicefactory.builder.balance;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.balanceservice_interface.BalanceServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class BalanceServiceBuilder$1
  implements BalanceServiceAdapter
{
  BalanceServiceBuilder$1(BalanceServiceBuilder paramBalanceServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReport()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.balance.BalanceServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */