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
    paramString = this.val$adapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestExitLive error isTimeout=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";code=");
    localStringBuilder.append(paramInt);
    paramString.e("RoomDataServer", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    this.val$adapter.getLogger().i("RoomDataServer", "requestExitLive success", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomDataServer.2
 * JD-Core Version:    0.7.0.1
 */