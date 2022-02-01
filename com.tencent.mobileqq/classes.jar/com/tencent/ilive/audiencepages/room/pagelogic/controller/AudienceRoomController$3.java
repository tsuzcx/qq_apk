package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.ilive.pages.room.events.PlayOverEvent;
import com.tencent.ilive.pages.room.events.ShowLiveOverEvent;
import com.tencent.ilive.pages.room.events.ShowLiveOverEvent.Source;

class AudienceRoomController$3
  implements Observer<PlayOverEvent>
{
  AudienceRoomController$3(AudienceRoomController paramAudienceRoomController) {}
  
  public void onChanged(@Nullable PlayOverEvent paramPlayOverEvent)
  {
    int i = AudienceRoomController.10.$SwitchMap$com$tencent$ilive$pages$room$events$PlayOverEvent$Source[paramPlayOverEvent.source.ordinal()];
    ShowLiveOverEvent.Source localSource;
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        localSource = null;
      } else {
        localSource = ShowLiveOverEvent.Source.WATCH_OVER;
      }
    }
    else {
      localSource = ShowLiveOverEvent.Source.ANCHOR_OVER;
    }
    if (AudienceRoomController.access$100(this.this$0) != null) {
      AudienceRoomController.access$100(this.this$0).onPlayOver();
    }
    if (AudienceRoomController.access$200(this.this$0) != null)
    {
      ((RoomBootBizModules)AudienceRoomController.access$300(this.this$0)).onPlayOver();
      AudienceRoomController.access$400(this.this$0).getRoomState().isPlayOver = true;
    }
    this.this$0.getEvent().post(new ShowLiveOverEvent(paramPlayOverEvent.notify, localSource));
    AudienceRoomController.access$500(this.this$0, 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.3
 * JD-Core Version:    0.7.0.1
 */