package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;

class AudienceRoomController$8
  implements EnterExitRoomCallback
{
  AudienceRoomController$8(AudienceRoomController paramAudienceRoomController) {}
  
  public void onFail(int paramInt, String paramString)
  {
    AudienceRoomController.access$2400(this.this$0, paramInt, paramString);
  }
  
  public void onSuccess()
  {
    AudienceRoomController.access$2300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.8
 * JD-Core Version:    0.7.0.1
 */