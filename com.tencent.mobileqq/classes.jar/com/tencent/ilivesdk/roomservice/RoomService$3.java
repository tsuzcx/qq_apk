package com.tencent.ilivesdk.roomservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;

class RoomService$3
  implements EnterRoomCallback
{
  RoomService$3(RoomService paramRoomService, EnterExitRoomCallback paramEnterExitRoomCallback) {}
  
  public void onFail(int paramInt, String paramString)
  {
    this.val$callback.onFail(paramInt, paramString);
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    RoomService.access$002(this.this$0, paramLiveInfo);
    paramLiveInfo = RoomService.access$000(this.this$0).roomInfo;
    RoomService.access$100(this.this$0).getLogger().i("RoomService", "enterRoom--success roomInfo=" + paramLiveInfo.toString(), new Object[0]);
    RoomService.access$100(this.this$0).getLogger().i("RoomService", "enterRoom--success anchoInfo=" + RoomService.access$000(this.this$0).anchorInfo.toString(), new Object[0]);
    RoomService.access$100(this.this$0).getLogger().i("RoomService", "enterRoom--success mediaInfo=" + RoomService.access$000(this.this$0).watchMediaInfo.toString(), new Object[0]);
    RoomService.access$200(this.this$0).startSendHeart(paramLiveInfo);
    this.val$callback.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomService.3
 * JD-Core Version:    0.7.0.1
 */