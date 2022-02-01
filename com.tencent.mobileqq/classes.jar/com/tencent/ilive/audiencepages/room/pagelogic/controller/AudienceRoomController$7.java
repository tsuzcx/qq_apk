package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.hostproxy.LoginRequestCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.livesdk.accountengine.UserEngine;

class AudienceRoomController$7
  implements LoginRequestCallback
{
  AudienceRoomController$7(AudienceRoomController paramAudienceRoomController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetFail()
  {
    this.this$0.getLog().e("RoomController", "doEnterRoom -- no login --login but no LoginRequestInfo", new Object[0]);
    if (this.this$0.isPageExit) {
      return;
    }
    AudienceRoomController localAudienceRoomController = this.this$0;
    AudienceRoomController.access$2100(localAudienceRoomController, "进房失败，无账号信息", AudienceRoomController.access$900(localAudienceRoomController));
    AudienceRoomController.access$2200(this.this$0).reportLoginFail(-99);
  }
  
  public void onGetSuccess(LoginRequest paramLoginRequest)
  {
    if (paramLoginRequest != null)
    {
      AudienceRoomController.access$1700(this.this$0).initLoginRequestData(paramLoginRequest);
      AudienceRoomController.access$1800(this.this$0, this.val$enterRoom, this.val$isOutEnter);
      return;
    }
    this.this$0.getLog().e("RoomController", "doEnterRoom -- no login --login but no LoginRequestInfo", new Object[0]);
    if (this.this$0.isPageExit) {
      return;
    }
    paramLoginRequest = this.this$0;
    AudienceRoomController.access$1900(paramLoginRequest, "进房失败，无账号信息", AudienceRoomController.access$900(paramLoginRequest));
    AudienceRoomController.access$2000(this.this$0).reportLoginFail(-99);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.7
 * JD-Core Version:    0.7.0.1
 */