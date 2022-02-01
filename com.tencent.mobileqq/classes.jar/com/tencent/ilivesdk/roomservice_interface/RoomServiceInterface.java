package com.tencent.ilivesdk.roomservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;

public abstract interface RoomServiceInterface
  extends ServiceBaseInterface
{
  public abstract void anchorEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback);
  
  public abstract void exitRoom(EnterExitRoomCallback paramEnterExitRoomCallback);
  
  public abstract EnterRoomInfo getEnterRoomInfo();
  
  public abstract LiveInfo getLiveInfo();
  
  public abstract void init(RoomServiceAdapter paramRoomServiceAdapter);
  
  public abstract void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface
 * JD-Core Version:    0.7.0.1
 */