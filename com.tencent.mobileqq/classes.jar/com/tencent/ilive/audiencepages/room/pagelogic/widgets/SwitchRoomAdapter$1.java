package com.tencent.ilive.audiencepages.room.pagelogic.widgets;

import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;

class SwitchRoomAdapter$1
  implements RoomSwitchInterface.QueryRoomListTrigger
{
  SwitchRoomAdapter$1(SwitchRoomAdapter paramSwitchRoomAdapter) {}
  
  public void doQueryRoomList()
  {
    SwitchRoomAdapter localSwitchRoomAdapter = this.this$0;
    localSwitchRoomAdapter.queryAndUpdateRoomListFromServer(0, SwitchRoomAdapter.access$000(localSwitchRoomAdapter).getLastIndex());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.widgets.SwitchRoomAdapter.1
 * JD-Core Version:    0.7.0.1
 */