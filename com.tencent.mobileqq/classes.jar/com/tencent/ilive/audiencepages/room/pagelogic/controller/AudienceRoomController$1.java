package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;

class AudienceRoomController$1
  implements Observer<FirstFrameEvent>
{
  AudienceRoomController$1(AudienceRoomController paramAudienceRoomController) {}
  
  public void onChanged(FirstFrameEvent paramFirstFrameEvent)
  {
    if (AudienceRoomController.access$000(this.this$0) != null) {
      AudienceRoomController.access$000(this.this$0).onFirstFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.1
 * JD-Core Version:    0.7.0.1
 */