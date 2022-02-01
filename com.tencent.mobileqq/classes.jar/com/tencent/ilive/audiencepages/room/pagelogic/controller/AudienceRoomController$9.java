package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;

class AudienceRoomController$9
  implements EnterExitRoomCallback
{
  AudienceRoomController$9(AudienceRoomController paramAudienceRoomController) {}
  
  public void onFail(int paramInt, String paramString)
  {
    this.this$0.getLog().i("RoomController", "exitLive--onFail-failCode=" + paramInt + ";errMsg=" + paramString, new Object[0]);
  }
  
  public void onSuccess()
  {
    this.this$0.getLog().i("RoomController", "exitLive--onSuccess", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.9
 * JD-Core Version:    0.7.0.1
 */