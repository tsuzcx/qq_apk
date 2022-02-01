package com.tencent.ilivesdk.roompushservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;

public abstract interface RoomPushServiceInterface
  extends ServiceBaseInterface
{
  public abstract PushReceiver createRoomPushReceiver();
  
  public abstract void onPause();
  
  public abstract void setPushInterval(long paramLong1, long paramLong2);
  
  public abstract void setRoomInfo(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface
 * JD-Core Version:    0.7.0.1
 */