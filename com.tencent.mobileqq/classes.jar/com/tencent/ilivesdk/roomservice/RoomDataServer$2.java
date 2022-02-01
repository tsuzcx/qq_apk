package com.tencent.ilivesdk.roomservice;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;

final class RoomDataServer$2
  implements ChannelCallback
{
  RoomDataServer$2(RoomServiceAdapter paramRoomServiceAdapter) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.val$adapter.getLogger().e("RoomDataServer", "requestExitLive error isTimeout=" + paramBoolean + ";code=" + paramInt, new Object[0]);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    this.val$adapter.getLogger().i("RoomDataServer", "requestExitLive success", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomDataServer.2
 * JD-Core Version:    0.7.0.1
 */