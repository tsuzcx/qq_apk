package com.tencent.ilivesdk.violationstrikeservice_interface;

import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface ViolationStrikeServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract LogInterface getLog();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.violationstrikeservice_interface.ViolationStrikeServiceAdapter
 * JD-Core Version:    0.7.0.1
 */