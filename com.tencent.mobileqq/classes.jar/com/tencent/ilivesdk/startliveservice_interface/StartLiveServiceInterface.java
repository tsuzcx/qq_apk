package com.tencent.ilivesdk.startliveservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.startliveservice_interface.model.LiveApplyInfo;
import com.tencent.ilivesdk.startliveservice_interface.model.LiveApplyRoomInfo;
import com.tencent.ilivesdk.startliveservice_interface.model.StartLiveInfo;

public abstract interface StartLiveServiceInterface
  extends ServiceBaseInterface
{
  public abstract void applyLive(LiveApplyInfo paramLiveApplyInfo, StartLiveApplyCallback paramStartLiveApplyCallback);
  
  public abstract LiveApplyRoomInfo getLiveApplyRoomInfo();
  
  public abstract void init(StartLiveServiceAdapter paramStartLiveServiceAdapter);
  
  public abstract void startLive(StartLiveInfo paramStartLiveInfo, StartLiveCallback paramStartLiveCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.StartLiveServiceInterface
 * JD-Core Version:    0.7.0.1
 */