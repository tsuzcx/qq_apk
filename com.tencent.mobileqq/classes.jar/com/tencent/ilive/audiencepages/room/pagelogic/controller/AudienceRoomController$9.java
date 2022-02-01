package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;

class AudienceRoomController$9
  implements EnterExitRoomCallback
{
  AudienceRoomController$9(AudienceRoomController paramAudienceRoomController) {}
  
  public void onFail(int paramInt, String paramString)
  {
    LogInterface localLogInterface = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitLive--onFail-failCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";errMsg=");
    localStringBuilder.append(paramString);
    localLogInterface.i("RoomController", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onSuccess()
  {
    this.this$0.getLog().i("RoomController", "exitLive--onSuccess", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.9
 * JD-Core Version:    0.7.0.1
 */