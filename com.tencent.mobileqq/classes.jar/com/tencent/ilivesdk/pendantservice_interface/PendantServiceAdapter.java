package com.tencent.ilivesdk.pendantservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface PendantServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract LogInterface getLogger();
  
  public abstract long getRoomId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pendantservice_interface.PendantServiceAdapter
 * JD-Core Version:    0.7.0.1
 */