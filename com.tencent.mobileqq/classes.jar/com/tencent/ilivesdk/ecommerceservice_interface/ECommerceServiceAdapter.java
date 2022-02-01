package com.tencent.ilivesdk.ecommerceservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface ECommerceServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract ChannelInterface getChannel();
  
  public abstract int getClientType();
  
  public abstract DataReportInterface getDataReport();
  
  public abstract LogInterface getLogger();
  
  public abstract String getProgramId();
  
  public abstract long getRoomId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceAdapter
 * JD-Core Version:    0.7.0.1
 */