package com.tencent.ilivesdk.startliveservice_interface;

import com.tencent.ilivesdk.startliveservice_interface.model.LiveApplyRoomInfo;

public abstract interface StartLiveApplyCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSuccess(LiveApplyRoomInfo paramLiveApplyRoomInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.StartLiveApplyCallback
 * JD-Core Version:    0.7.0.1
 */