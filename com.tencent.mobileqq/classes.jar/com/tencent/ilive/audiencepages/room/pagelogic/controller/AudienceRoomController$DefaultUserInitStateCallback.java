package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.UserInitStateCallback;

class AudienceRoomController$DefaultUserInitStateCallback
  implements UserInitStateCallback
{
  public boolean a;
  public boolean b;
  
  AudienceRoomController$DefaultUserInitStateCallback(AudienceRoomController paramAudienceRoomController) {}
  
  public void onAvInitFail() {}
  
  public void onAvInitSucceed() {}
  
  public void onLoginFail(int paramInt)
  {
    Object localObject = this.c.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doEnterRoom -login busy -to-  login onFail-errCode=");
    localStringBuilder.append(paramInt);
    ((LogInterface)localObject).e("RoomController", localStringBuilder.toString(), new Object[0]);
    if (this.c.isPageExit) {
      return;
    }
    if ((AudienceRoomController.access$800(this.c) != null) && (!AudienceRoomController.access$800(this.c).isLiteSdk))
    {
      localObject = this.c;
      AudienceRoomController.access$1000((AudienceRoomController)localObject, "进房失败：鉴权失败", AudienceRoomController.access$900((AudienceRoomController)localObject));
    }
    AudienceRoomController.access$1100(this.c).reportLoginFail(paramInt);
  }
  
  public void onLoginSucceed()
  {
    this.c.getLog().i("RoomController", "doEnterRoom -login busy -to- login success", new Object[0]);
    if (this.c.isPageExit) {
      return;
    }
    AudienceRoomController.access$600(this.c).reportLoginSuc();
    if (this.a) {
      AudienceRoomController.access$700(this.c, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.DefaultUserInitStateCallback
 * JD-Core Version:    0.7.0.1
 */