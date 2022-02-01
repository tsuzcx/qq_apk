package com.tencent.ilivesdk.roomservice;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.LeaveLiveRoomReq;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Timer;

public class RoomHeartController
{
  private static final int DEFAULT_HEART_BEAT_INTERVAL = 30000;
  private final String TAG = "RoomHeartController";
  private RoomServiceAdapter mAdapter;
  private ChannelInterface mChannel;
  private int mHeartbeatInterval = 30000;
  private Timer mTimer;
  
  public RoomHeartController(RoomServiceAdapter paramRoomServiceAdapter)
  {
    this.mAdapter = paramRoomServiceAdapter;
    this.mChannel = this.mAdapter.getChannel();
    if (this.mTimer == null) {
      this.mTimer = new Timer();
    }
  }
  
  private void heartRoom(int paramInt1, int paramInt2, int paramInt3)
  {
    pbexit_heart_list_room.LeaveLiveRoomReq localLeaveLiveRoomReq = new pbexit_heart_list_room.LeaveLiveRoomReq();
    localLeaveLiveRoomReq.roomid.set(paramInt2);
    localLeaveLiveRoomReq.sub_roomid.set(paramInt3);
    this.mAdapter.getLogger().d("RoomHeartController", "start heartRoom--roomid=" + paramInt2 + ";roomType=" + paramInt1, new Object[0]);
    this.mChannel.send(29952, 4, localLeaveLiveRoomReq.toByteArray(), new RoomHeartController.2(this, paramInt1, paramInt2, paramInt3));
  }
  
  void cancelHeart()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer.purge();
      this.mTimer = null;
    }
  }
  
  public void startNextHeartbeat(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mTimer != null) {
      this.mTimer.schedule(new RoomHeartController.1(this, paramInt1, paramInt2, paramInt3), 0L, this.mHeartbeatInterval);
    }
  }
  
  void startSendHeart(LiveRoomInfo paramLiveRoomInfo)
  {
    if (paramLiveRoomInfo != null) {
      startNextHeartbeat(paramLiveRoomInfo.roomType, (int)paramLiveRoomInfo.roomId, (int)paramLiveRoomInfo.roomId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomHeartController
 * JD-Core Version:    0.7.0.1
 */