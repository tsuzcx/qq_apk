package com.tencent.ilive.pages.room;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;

class RoomBootBizModules$3
  implements Observer<FirstFrameEvent>
{
  RoomBootBizModules$3(RoomBootBizModules paramRoomBootBizModules) {}
  
  public void onChanged(@Nullable FirstFrameEvent paramFirstFrameEvent)
  {
    this.this$0.onFistFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.pages.room.RoomBootBizModules.3
 * JD-Core Version:    0.7.0.1
 */