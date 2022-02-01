package com.tencent.ilivesdk.roomservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;

class RoomService$2
  implements EnterExitRoomCallback
{
  RoomService$2(RoomService paramRoomService, EnterExitRoomCallback paramEnterExitRoomCallback, EnterRoomInfo paramEnterRoomInfo) {}
  
  public void onFail(int paramInt, String paramString)
  {
    LogInterface localLogInterface = RoomService.access$100(this.this$0).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom--onFail failCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";errMsg=");
    localStringBuilder.append(paramString);
    localLogInterface.i("RoomService", localStringBuilder.toString(), new Object[0]);
    if (paramString.startsWith("wns_Error:"))
    {
      if (RoomService.access$300(this.this$0) < 1)
      {
        RoomService.access$100(this.this$0).getLogger().i("RoomService", "enterRoom-retry", new Object[0]);
        RoomService.access$400(this.this$0, this.val$enterRoomInfo, this.val$callback);
        RoomService.access$308(this.this$0);
        return;
      }
      this.val$callback.onFail(paramInt, paramString);
      return;
    }
    this.val$callback.onFail(paramInt, paramString);
  }
  
  public void onSuccess()
  {
    this.val$callback.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomService.2
 * JD-Core Version:    0.7.0.1
 */