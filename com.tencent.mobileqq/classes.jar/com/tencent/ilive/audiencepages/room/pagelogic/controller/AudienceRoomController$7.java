package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

class AudienceRoomController$7
  implements EnterExitRoomCallback
{
  AudienceRoomController$7(AudienceRoomController paramAudienceRoomController, boolean paramBoolean) {}
  
  public void onFail(int paramInt, String paramString)
  {
    this.this$0.getLog().e("RoomController", "enterRoom--onFail--failCode=" + paramInt + ";errMsg=" + paramString, new Object[0]);
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.startsWith("wns_Error:")) {}
    }
    else
    {
      str = "进房失败，请稍后重试";
    }
    if ((!this.this$0.isPageExit) && (AudienceRoomController.access$700(this.this$0) != null) && (!AudienceRoomController.access$700(this.this$0).isLiteSdk)) {
      AudienceRoomController.access$2500(this.this$0, str, AudienceRoomController.access$800(this.this$0));
    }
    AudienceRoomController.access$2600(this.this$0, paramInt);
    if (this.val$isOutEnter) {
      AudienceRoomController.access$2700(this.this$0).reportEnterRoomFail(paramInt);
    }
    for (;;)
    {
      if (AudienceRoomController.access$000(this.this$0) != null) {
        AudienceRoomController.access$000(this.this$0).onEnterRoom(AudienceRoomController.access$2400(this.this$0), paramInt);
      }
      paramString = ((LoginServiceInterface)AudienceRoomController.access$2900(this.this$0).getService(LoginServiceInterface.class)).getLoginInfo();
      if (paramString != null)
      {
        long l = paramString.uid;
        ((LogSdkServiceInterface)AudienceRoomController.access$3000(this.this$0).getService(LogSdkServiceInterface.class)).setUid(String.valueOf(l));
        ((LogSdkServiceInterface)AudienceRoomController.access$3000(this.this$0).getService(LogSdkServiceInterface.class)).upload(String.valueOf(l));
      }
      return;
      AudienceRoomController.access$2800(this.this$0).reportSwitchEnterRoomFail(paramInt);
    }
  }
  
  public void onSuccess()
  {
    if (this.this$0.isPageExit)
    {
      this.this$0.getLog().i("RoomController", "enterRoom onSuccess isPageExit return", new Object[0]);
      return;
    }
    if (this.val$isOutEnter)
    {
      Log.i("AudienceTime", "-- enterroom onSuccess--");
      this.this$0.getLog().i("RoomController", "enterRoom--onSuccess--isFragmentCreated=" + AudienceRoomController.access$1900(this.this$0), new Object[0]);
      if (AudienceRoomController.access$1900(this.this$0)) {
        AudienceRoomController.access$2000(this.this$0, true);
      }
      AudienceRoomController.access$2102(this.this$0, true);
    }
    for (;;)
    {
      this.this$0.getRoomEngine().enterRoomSuccess();
      if (AudienceRoomController.access$000(this.this$0) == null) {
        break;
      }
      AudienceRoomController.access$000(this.this$0).onEnterRoom(AudienceRoomController.access$2400(this.this$0), 0);
      return;
      Log.i("AudienceTime", "-switch- enterroom onSuccess--isFragmentCreated=" + AudienceRoomController.access$1900(this.this$0));
      this.this$0.getLog().i("RoomController", "swich enterRoom--onSuccess--isFragmentCreated=" + AudienceRoomController.access$1900(this.this$0), new Object[0]);
      if (AudienceRoomController.access$2200(this.this$0)) {
        AudienceRoomController.access$2000(this.this$0, false);
      }
      AudienceRoomController.access$2302(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.7
 * JD-Core Version:    0.7.0.1
 */