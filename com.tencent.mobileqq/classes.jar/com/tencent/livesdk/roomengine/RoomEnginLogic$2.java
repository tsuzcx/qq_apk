package com.tencent.livesdk.roomengine;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceManager;

class RoomEnginLogic$2
  implements EnterExitRoomCallback
{
  RoomEnginLogic$2(RoomEnginLogic paramRoomEnginLogic, EnterRoomInfo paramEnterRoomInfo) {}
  
  public void onFail(int paramInt, String paramString)
  {
    if (RoomEnginLogic.access$000(this.this$0) != null) {
      RoomEnginLogic.access$000(this.this$0).onFail(this.val$enterRoomInfo.roomId, paramInt, paramString);
    }
    ((LogSdkServiceInterface)this.this$0.mServiceManager.getService(LogSdkServiceInterface.class)).getLog().e("RoomEnginLogic", "re-login enter room fail, errCode=" + paramInt + ", errMsg:" + paramString, new Object[0]);
  }
  
  public void onSuccess()
  {
    if (RoomEnginLogic.access$000(this.this$0) != null) {
      RoomEnginLogic.access$000(this.this$0).onSuccess(this.val$enterRoomInfo.roomId);
    }
    ((LoginServiceInterface)this.this$0.mServiceManager.getService(LoginServiceInterface.class)).notifyLoginRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.roomengine.RoomEnginLogic.2
 * JD-Core Version:    0.7.0.1
 */