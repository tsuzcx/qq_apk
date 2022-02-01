package com.tencent.ilivesdk.roomservice;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.protobuf.iliveRoomPlay.nano.EnterRsp;

final class RoomDataServer$1
  implements ChannelCallback
{
  RoomDataServer$1(EnterRoomInfo paramEnterRoomInfo, EnterRoomCallback paramEnterRoomCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.val$callback.onFail(paramInt, paramString);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = EnterRsp.parseFrom(paramArrayOfByte);
      if (paramArrayOfByte.ret == 0)
      {
        paramArrayOfByte = LiveInfoProvider.parseLiveInfo(paramArrayOfByte, this.val$roomInfo);
        this.val$callback.onSuccess(paramArrayOfByte);
        return;
      }
      this.val$callback.onFail(paramArrayOfByte.ret, paramArrayOfByte.msg);
      return;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomDataServer.1
 * JD-Core Version:    0.7.0.1
 */