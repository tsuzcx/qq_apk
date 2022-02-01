package com.tencent.ilivesdk.roomservice;

import android.content.Context;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;

public class RoomService
  implements RoomServiceInterface
{
  private final String TAG = "RoomService";
  private EnterRoomInfo enterRoomInfo;
  private RoomServiceAdapter mAdapter;
  private Context mContext;
  private LiveInfo mLiveInfo;
  private int reEnterNum = 0;
  private RoomHeartController roomHeartController;
  
  private void doWatchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    RoomDataServer.requestWatchEnterRoom(this.mContext, this.mAdapter, paramEnterRoomInfo, new RoomService.3(this, paramEnterExitRoomCallback));
  }
  
  public void anchorEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.enterRoomInfo = paramEnterRoomInfo;
    RoomDataServer.requestEnterRoom(this.mContext, this.mAdapter, paramEnterRoomInfo, new RoomService.1(this, paramEnterExitRoomCallback));
  }
  
  public void clearEventOutput() {}
  
  public void exitRoom(EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    if ((getLiveInfo() != null) && (getLiveInfo().roomInfo != null))
    {
      RoomDataServer.requestExitRoom(this.mAdapter, getLiveInfo().roomInfo);
      paramEnterExitRoomCallback.onSuccess();
    }
    else
    {
      paramEnterExitRoomCallback.onFail(-1, "");
    }
    this.roomHeartController.cancelHeart();
    this.enterRoomInfo = null;
  }
  
  public EnterRoomInfo getEnterRoomInfo()
  {
    return this.enterRoomInfo;
  }
  
  public LiveInfo getLiveInfo()
  {
    return this.mLiveInfo;
  }
  
  public void init(RoomServiceAdapter paramRoomServiceAdapter)
  {
    this.mAdapter = paramRoomServiceAdapter;
    this.roomHeartController = new RoomHeartController(paramRoomServiceAdapter);
  }
  
  public void onCreate(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void onDestroy()
  {
    this.mLiveInfo = null;
    RoomHeartController localRoomHeartController = this.roomHeartController;
    if (localRoomHeartController != null) {
      localRoomHeartController.cancelHeart();
    }
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.enterRoomInfo = paramEnterRoomInfo;
    this.reEnterNum = 0;
    doWatchEnterRoom(paramEnterRoomInfo, new RoomService.2(this, paramEnterExitRoomCallback, paramEnterRoomInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomService
 * JD-Core Version:    0.7.0.1
 */