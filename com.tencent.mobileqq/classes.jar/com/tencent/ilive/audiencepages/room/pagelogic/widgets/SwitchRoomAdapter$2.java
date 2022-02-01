package com.tencent.ilive.audiencepages.room.pagelogic.widgets;

import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import java.util.List;

class SwitchRoomAdapter$2
  implements RoomSwitchInterface.IRoomList
{
  SwitchRoomAdapter$2(SwitchRoomAdapter paramSwitchRoomAdapter) {}
  
  public void onResult(int paramInt1, int paramInt2, List<SwitchRoomInfo> paramList)
  {
    if (paramInt1 == 0) {
      this.this$0.updateSwichtRoomInfo(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.widgets.SwitchRoomAdapter.2
 * JD-Core Version:    0.7.0.1
 */