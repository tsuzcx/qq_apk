package com.tencent.ilivesdk.messageservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.messagefilterserviceinterface.MessageFilterServiceInterface;

public abstract interface MessageServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract long getAccountUin();
  
  public abstract long getAnchorUin();
  
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReport();
  
  public abstract HostProxyInterface getHostProxyInterface();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract MessageFilterServiceInterface getMessageFilterService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.messageservice_interface.MessageServiceAdapter
 * JD-Core Version:    0.7.0.1
 */