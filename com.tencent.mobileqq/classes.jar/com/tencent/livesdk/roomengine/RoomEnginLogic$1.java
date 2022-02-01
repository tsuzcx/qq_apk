package com.tencent.livesdk.roomengine;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceManager;

class RoomEnginLogic$1
  implements EnterExitRoomCallback
{
  RoomEnginLogic$1(RoomEnginLogic paramRoomEnginLogic, EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback) {}
  
  public void onFail(int paramInt, String paramString)
  {
    this.this$0.logInterface.e("RoomEnginLogic", "enterRoom--onFail--failCode=" + paramInt + ";errMsg=" + paramString, new Object[0]);
    if (this.val$callback != null) {
      this.val$callback.onFail(paramInt, paramString);
    }
  }
  
  public void onSuccess()
  {
    LiveRoomInfo localLiveRoomInfo = this.this$0.roomServiceInterface.getLiveInfo().roomInfo;
    this.this$0.logInterface.i("RoomEnginLogic", "onEnterRoom--roomid=" + localLiveRoomInfo.roomId, new Object[0]);
    if (!this.val$enterRoomInfo.isLiteSdk) {
      ((RoomPushServiceInterface)this.this$0.mServiceManager.getService(RoomPushServiceInterface.class)).setRoomInfo(localLiveRoomInfo.roomType, (int)localLiveRoomInfo.roomId);
    }
    if (this.val$callback != null) {
      this.val$callback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.roomengine.RoomEnginLogic.1
 * JD-Core Version:    0.7.0.1
 */