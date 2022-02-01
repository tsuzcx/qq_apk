package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.OverPageExitEvent;

class AudienceRoomController$4
  implements Observer<OverPageExitEvent>
{
  AudienceRoomController$4(AudienceRoomController paramAudienceRoomController) {}
  
  public void onChanged(@Nullable OverPageExitEvent paramOverPageExitEvent)
  {
    this.this$0.exitRoomToPage(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.4
 * JD-Core Version:    0.7.0.1
 */