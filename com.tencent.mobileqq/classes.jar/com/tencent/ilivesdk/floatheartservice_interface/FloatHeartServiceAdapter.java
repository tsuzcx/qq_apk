package com.tencent.ilivesdk.floatheartservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import org.json.JSONObject;

public abstract interface FloatHeartServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract long getAnchorUid();
  
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReport();
  
  public abstract JSONObject getFloatHeartURLConfig();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract String getProgramId();
  
  public abstract long getRoomId();
  
  public abstract JSONObject updateGiftLogoFormatKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceAdapter
 * JD-Core Version:    0.7.0.1
 */