package com.tencent.ilivesdk.avmediaservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface ChangeVideoRateServiceAdapter
{
  public abstract ChannelInterface getChannel();
  
  public abstract LogInterface getLogger();
  
  public abstract PushReceiver getPushReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.ChangeVideoRateServiceAdapter
 * JD-Core Version:    0.7.0.1
 */