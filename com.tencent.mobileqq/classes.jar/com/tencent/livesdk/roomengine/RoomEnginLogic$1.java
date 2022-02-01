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
    Object localObject = this.this$0.logInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom--onFail--failCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";errMsg=");
    localStringBuilder.append(paramString);
    ((LogInterface)localObject).e("RoomEnginLogic", localStringBuilder.toString(), new Object[0]);
    localObject = this.val$callback;
    if (localObject != null) {
      ((EnterExitRoomCallback)localObject).onFail(paramInt, paramString);
    }
  }
  
  public void onSuccess()
  {
    Object localObject = this.this$0.roomServiceInterface.getLiveInfo().roomInfo;
    LogInterface localLogInterface = this.this$0.logInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom--roomid=");
    localStringBuilder.append(((LiveRoomInfo)localObject).roomId);
    localLogInterface.i("RoomEnginLogic", localStringBuilder.toString(), new Object[0]);
    if (!this.val$enterRoomInfo.isLiteSdk) {
      ((RoomPushServiceInterface)this.this$0.mServiceManager.getService(RoomPushServiceInterface.class)).setRoomInfo(((LiveRoomInfo)localObject).roomType, (int)((LiveRoomInfo)localObject).roomId);
    }
    localObject = this.val$callback;
    if (localObject != null) {
      ((EnterExitRoomCallback)localObject).onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.roomengine.RoomEnginLogic.1
 * JD-Core Version:    0.7.0.1
 */