package com.tencent.ilivesdk.balanceservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface BalanceServiceAdapter
{
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReport();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.balanceservice_interface.BalanceServiceAdapter
 * JD-Core Version:    0.7.0.1
 */