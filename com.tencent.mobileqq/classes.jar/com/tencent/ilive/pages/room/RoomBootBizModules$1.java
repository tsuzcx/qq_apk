package com.tencent.ilive.pages.room;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.EnterRoomEvent;

class RoomBootBizModules$1
  implements Observer<EnterRoomEvent>
{
  RoomBootBizModules$1(RoomBootBizModules paramRoomBootBizModules) {}
  
  public void onChanged(@Nullable EnterRoomEvent paramEnterRoomEvent)
  {
    this.this$0.onEnterRoom(paramEnterRoomEvent.isOutEnter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.pages.room.RoomBootBizModules.1
 * JD-Core Version:    0.7.0.1
 */