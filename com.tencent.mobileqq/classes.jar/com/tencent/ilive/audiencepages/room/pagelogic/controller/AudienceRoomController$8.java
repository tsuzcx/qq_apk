package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic.ReWatchEnterRoomListener;

class AudienceRoomController$8
  implements RoomEnginLogic.ReWatchEnterRoomListener
{
  AudienceRoomController$8(AudienceRoomController paramAudienceRoomController) {}
  
  public void onFail(long paramLong, int paramInt, String paramString)
  {
    if ((AudienceRoomController.access$700(this.this$0) != null) && (!AudienceRoomController.access$700(this.this$0).isLiteSdk)) {
      AudienceRoomController.access$3100(this.this$0, paramString, AudienceRoomController.access$800(this.this$0));
    }
    if (AudienceRoomController.access$000(this.this$0) != null) {
      AudienceRoomController.access$000(this.this$0).onEnterRoom(paramLong, paramInt);
    }
    AudienceRoomController.access$2600(this.this$0, paramInt);
  }
  
  public void onSuccess(long paramLong)
  {
    if (AudienceRoomController.access$000(this.this$0) != null) {
      AudienceRoomController.access$000(this.this$0).onEnterRoom(paramLong, 0);
    }
    this.this$0.getLog().i("RoomController", "re-login enter room success", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.8
 * JD-Core Version:    0.7.0.1
 */