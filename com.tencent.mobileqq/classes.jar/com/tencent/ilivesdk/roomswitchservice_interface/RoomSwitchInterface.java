package com.tencent.ilivesdk.roomswitchservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.List;

public abstract interface RoomSwitchInterface
  extends ServiceBaseInterface
{
  public abstract boolean closeRoomSwitch();
  
  public abstract RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger();
  
  public abstract void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList);
  
  public abstract void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface
 * JD-Core Version:    0.7.0.1
 */