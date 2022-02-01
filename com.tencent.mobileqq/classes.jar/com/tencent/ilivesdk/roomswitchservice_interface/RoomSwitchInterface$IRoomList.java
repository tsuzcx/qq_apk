package com.tencent.ilivesdk.roomswitchservice_interface;

import java.util.List;

public abstract interface RoomSwitchInterface$IRoomList
{
  public static final int STATUS_FAIL = -1;
  public static final int STATUS_SUCCESS = 0;
  
  public abstract void onResult(int paramInt1, int paramInt2, List<SwitchRoomInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList
 * JD-Core Version:    0.7.0.1
 */