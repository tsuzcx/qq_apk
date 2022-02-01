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
    LogInterface localLogInterface = this.mAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start heartRoom--roomid=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(";roomType=");
    localStringBuilder.append(paramInt1);
    localLogInterface.d("RoomHeartController", localStringBuilder.toString(), new Object[0]);
    this.mChannel.send(29952, 4, localLeaveLiveRoomReq.toByteArray(), new RoomHeartController.2(this, paramInt1, paramInt2, paramInt3));
  }
  
  void cancelHeart()
  {
    Timer localTimer = this.mTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.mTimer.purge();
      this.mTimer = null;
    }
  }
  
  public void startNextHeartbeat(int paramInt1, int paramInt2, int paramInt3)
  {
    Timer localTimer = this.mTimer;
    if (localTimer != null) {
      localTimer.schedule(new RoomHeartController.1(this, paramInt1, paramInt2, paramInt3), 0L, this.mHeartbeatInterval);
    }
  }
  
  void startSendHeart(LiveRoomInfo paramLiveRoomInfo)
  {
    if (paramLiveRoomInfo != null) {
      startNextHeartbeat(paramLiveRoomInfo.roomType, (int)paramLiveRoomInfo.roomId, (int)paramLiveRoomInfo.roomId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomHeartController
 * JD-Core Version:    0.7.0.1
 */