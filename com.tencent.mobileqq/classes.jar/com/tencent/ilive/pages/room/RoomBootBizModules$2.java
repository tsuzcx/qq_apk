package com.tencent.ilive.pages.room;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.ExitRoomtEvent;

class RoomBootBizModules$2
  implements Observer<ExitRoomtEvent>
{
  RoomBootBizModules$2(RoomBootBizModules paramRoomBootBizModules) {}
  
  public void onChanged(@Nullable ExitRoomtEvent paramExitRoomtEvent)
  {
    this.this$0.onExitRoom(paramExitRoomtEvent.isFinishPage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.pages.room.RoomBootBizModules.2
 * JD-Core Version:    0.7.0.1
 */