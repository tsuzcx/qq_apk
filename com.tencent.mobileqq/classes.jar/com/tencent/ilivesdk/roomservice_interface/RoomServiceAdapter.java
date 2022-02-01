package com.tencent.ilivesdk.roomservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface RoomServiceAdapter
{
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract HostProxyInterface getHostProxyInterface();
  
  public abstract HttpInterface getHttpInterface();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter
 * JD-Core Version:    0.7.0.1
 */