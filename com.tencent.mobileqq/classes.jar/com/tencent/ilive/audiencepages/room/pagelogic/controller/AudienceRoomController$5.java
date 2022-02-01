package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.livesdk.roomengine.RoomEnginLogic.ReWatchEnterRoomListener;

class AudienceRoomController$5
  implements RoomEnginLogic.ReWatchEnterRoomListener
{
  AudienceRoomController$5(AudienceRoomController paramAudienceRoomController) {}
  
  public void onFail(long paramLong, int paramInt, String paramString)
  {
    AudienceRoomController.access$1300(this.this$0, paramLong, paramInt, paramString);
  }
  
  public void onSuccess(long paramLong)
  {
    AudienceRoomController.access$1200(this.this$0, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.5
 * JD-Core Version:    0.7.0.1
 */