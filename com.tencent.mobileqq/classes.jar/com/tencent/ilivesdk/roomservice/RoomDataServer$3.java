package com.tencent.ilivesdk.roomservice;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomReply;

final class RoomDataServer$3
  implements ChannelCallback
{
  RoomDataServer$3(EnterRoomInfo paramEnterRoomInfo, RoomServiceAdapter paramRoomServiceAdapter, EnterRoomCallback paramEnterRoomCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.val$callback.onFail(paramInt, paramString);
    this.val$adapter.getLogger().e("RoomDataServer", "进房错误：onError, isTimeout = " + paramBoolean + " errCode = " + paramInt + " msg = " + paramString, new Object[0]);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = LiveInfoProvider.parseLiveAudienceLiveInfo(EnterRoomReply.parseFrom(paramArrayOfByte), this.val$roomInfo, this.val$adapter.getLogger());
      this.val$callback.onSuccess(paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      this.val$callback.onFail(-1, "进房错误：exception");
      this.val$adapter.getLogger().e("RoomDataServer", "进房错误：exception = " + paramArrayOfByte.getMessage(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomDataServer.3
 * JD-Core Version:    0.7.0.1
 */