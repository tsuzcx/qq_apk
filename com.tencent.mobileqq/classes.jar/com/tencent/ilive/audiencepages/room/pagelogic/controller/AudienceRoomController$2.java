package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;

class AudienceRoomController$2
  implements Observer<RoomCloseEvent>
{
  AudienceRoomController$2(AudienceRoomController paramAudienceRoomController) {}
  
  public void onChanged(@Nullable RoomCloseEvent paramRoomCloseEvent)
  {
    this.this$0.exitRoomToServer(paramRoomCloseEvent.sceneId, true);
    this.this$0.exitRoomToPage(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.2
 * JD-Core Version:    0.7.0.1
 */