package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.SdkLoginCallback;

class AudienceRoomController$6
  implements SdkLoginCallback
{
  AudienceRoomController$6(AudienceRoomController paramAudienceRoomController, boolean paramBoolean) {}
  
  public void onFail(int paramInt, String paramString)
  {
    this.this$0.getLog().e("RoomController", "doEnterRoom -- login onFail--code=" + paramInt + ";msg=" + paramString + " isPageExit=" + this.this$0.isPageExit, new Object[0]);
    if (this.this$0.isPageExit) {
      return;
    }
    if ((AudienceRoomController.access$700(this.this$0) != null) && (!AudienceRoomController.access$700(this.this$0).isLiteSdk)) {
      AudienceRoomController.access$1700(this.this$0, "进房失败：鉴权失败", AudienceRoomController.access$800(this.this$0));
    }
    AudienceRoomController.access$1800(this.this$0).reportLoginFail(paramInt);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    this.this$0.getLog().i("RoomController", "doEnterRoom -- login success, isPageExit = " + this.this$0.isPageExit, new Object[0]);
    if (this.this$0.isPageExit) {}
    do
    {
      return;
      AudienceRoomController.access$1600(this.this$0).reportLoginSuc();
    } while (!this.val$enterRoom);
    AudienceRoomController.access$600(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.6
 * JD-Core Version:    0.7.0.1
 */