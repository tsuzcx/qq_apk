package com.tencent.ilivesdk.liveoverservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface LiveOverServiceAdapter
{
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract LogInterface getLogUtil();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.liveoverservice_interface.LiveOverServiceAdapter
 * JD-Core Version:    0.7.0.1
 */