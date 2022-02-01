package com.tencent.livesdk.roomengine;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.servicefactory.BaseEnginLogic;
import com.tencent.livesdk.servicefactory.ServiceManager;

public class RoomEnginLogic
  extends BaseEnginLogic
{
  private final String TAG = "RoomEnginLogic";
  LogInterface logInterface;
  ServiceManager mServiceManager;
  private RoomEnginLogic.ReWatchEnterRoomListener reWatchEnterRoomListener;
  RoomServiceInterface roomServiceInterface;
  
  public RoomEnginLogic(ServiceManager paramServiceManager)
  {
    this.mServiceManager = paramServiceManager;
    this.logInterface = ((LogInterface)this.mServiceManager.getService(LogInterface.class));
    this.roomServiceInterface = ((RoomServiceInterface)this.mServiceManager.getService(RoomServiceInterface.class));
  }
  
  public void exitRoom(EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.roomServiceInterface.exitRoom(paramEnterExitRoomCallback);
  }
  
  public LiveInfo getLiveInfo()
  {
    return this.roomServiceInterface.getLiveInfo();
  }
  
  public void reWatchEnterRoom(EnterRoomInfo paramEnterRoomInfo)
  {
    this.roomServiceInterface.watchEnterRoom(paramEnterRoomInfo, new RoomEnginLogic.2(this, paramEnterRoomInfo));
  }
  
  public void setReWatchEnterRoomListener(RoomEnginLogic.ReWatchEnterRoomListener paramReWatchEnterRoomListener)
  {
    this.reWatchEnterRoomListener = paramReWatchEnterRoomListener;
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.roomServiceInterface.watchEnterRoom(paramEnterRoomInfo, new RoomEnginLogic.1(this, paramEnterRoomInfo, paramEnterExitRoomCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.roomengine.RoomEnginLogic
 * JD-Core Version:    0.7.0.1
 */