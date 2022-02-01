package com.tencent.ilivesdk.service;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface RoomSwitchServiceAdapter
{
  public abstract ChannelInterface getChannel();
  
  public abstract HttpInterface getHttpInterface();
  
  public abstract LogInterface getLogger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.service.RoomSwitchServiceAdapter
 * JD-Core Version:    0.7.0.1
 */