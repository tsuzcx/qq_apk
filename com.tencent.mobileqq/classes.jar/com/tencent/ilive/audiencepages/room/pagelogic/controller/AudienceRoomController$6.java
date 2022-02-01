package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.SdkLoginCallback;

class AudienceRoomController$6
  implements SdkLoginCallback
{
  AudienceRoomController$6(AudienceRoomController paramAudienceRoomController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onFail(int paramInt, String paramString)
  {
    LogInterface localLogInterface = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doEnterRoom -- login onFail--code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";msg=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isPageExit=");
    localStringBuilder.append(this.this$0.isPageExit);
    localLogInterface.e("RoomController", localStringBuilder.toString(), new Object[0]);
    if (this.this$0.isPageExit) {
      return;
    }
    if ((AudienceRoomController.access$800(this.this$0) != null) && (!AudienceRoomController.access$800(this.this$0).isLiteSdk))
    {
      paramString = this.this$0;
      AudienceRoomController.access$1500(paramString, "进房失败：鉴权失败", AudienceRoomController.access$900(paramString));
    }
    AudienceRoomController.access$1600(this.this$0).reportLoginFail(paramInt);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    paramLoginInfo = this.this$0.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doEnterRoom -- login success, isPageExit = ");
    localStringBuilder.append(this.this$0.isPageExit);
    paramLoginInfo.i("RoomController", localStringBuilder.toString(), new Object[0]);
    if (this.this$0.isPageExit) {
      return;
    }
    AudienceRoomController.access$1400(this.this$0).reportLoginSuc();
    if (this.val$enter) {
      AudienceRoomController.access$700(this.this$0, this.val$isOutEnter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.6
 * JD-Core Version:    0.7.0.1
 */