package com.tencent.ilivesdk.roomservice;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.UserHeartBeatRsp;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Timer;

class RoomHeartController$2
  implements ChannelCallback
{
  RoomHeartController$2(RoomHeartController paramRoomHeartController, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    pbexit_heart_list_room.UserHeartBeatRsp localUserHeartBeatRsp = new pbexit_heart_list_room.UserHeartBeatRsp();
    try
    {
      localUserHeartBeatRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = RoomHeartController.access$100(this.this$0).getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start heartRoom-suc-interval=");
      localStringBuilder.append(localUserHeartBeatRsp.interval.get());
      paramArrayOfByte.d("RoomHeartController", localStringBuilder.toString(), new Object[0]);
      if ((RoomHeartController.access$200(this.this$0) != localUserHeartBeatRsp.interval.get()) && (RoomHeartController.access$300(this.this$0) != null) && (localUserHeartBeatRsp.interval.get() > 0))
      {
        RoomHeartController.access$202(this.this$0, localUserHeartBeatRsp.interval.get());
        this.this$0.cancelHeart();
        if (RoomHeartController.access$300(this.this$0) == null) {
          RoomHeartController.access$302(this.this$0, new Timer());
        }
        this.this$0.startNextHeartbeat(this.val$roomType, this.val$roomId, this.val$subRoomId);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomHeartController.2
 * JD-Core Version:    0.7.0.1
 */