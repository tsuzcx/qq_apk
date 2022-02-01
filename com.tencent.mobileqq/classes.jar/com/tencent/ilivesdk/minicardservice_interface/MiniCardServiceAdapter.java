package com.tencent.ilivesdk.minicardservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface MiniCardServiceAdapter
{
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceAdapter
 * JD-Core Version:    0.7.0.1
 */