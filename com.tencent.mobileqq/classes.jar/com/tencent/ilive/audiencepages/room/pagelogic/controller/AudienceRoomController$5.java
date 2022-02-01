package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.hostproxy.LoginRequestCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.livesdk.accountengine.UserEngine;

class AudienceRoomController$5
  implements LoginRequestCallback
{
  AudienceRoomController$5(AudienceRoomController paramAudienceRoomController, UserEngine paramUserEngine, boolean paramBoolean) {}
  
  public void onGetFail()
  {
    this.this$0.getLog().e("RoomController", "doEnterRoom -- no login --login but no LoginRequestInfo", new Object[0]);
    if (this.this$0.isPageExit) {
      return;
    }
    AudienceRoomController.access$1400(this.this$0, "进房失败，无账号信息", AudienceRoomController.access$800(this.this$0));
    AudienceRoomController.access$1500(this.this$0).reportLoginFail(-99);
  }
  
  public void onGetSuccess(LoginRequest paramLoginRequest)
  {
    if (paramLoginRequest != null)
    {
      this.val$userEngine.initLoginRequestData(paramLoginRequest);
      AudienceRoomController.access$1100(this.this$0, this.val$userEngine, AudienceRoomController.access$800(this.this$0), this.val$enterRoom);
    }
    do
    {
      return;
      this.this$0.getLog().e("RoomController", "doEnterRoom -- no login --login but no LoginRequestInfo", new Object[0]);
    } while (this.this$0.isPageExit);
    AudienceRoomController.access$1200(this.this$0, "进房失败，无账号信息", AudienceRoomController.access$800(this.this$0));
    AudienceRoomController.access$1300(this.this$0).reportLoginFail(-99);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.5
 * JD-Core Version:    0.7.0.1
 */