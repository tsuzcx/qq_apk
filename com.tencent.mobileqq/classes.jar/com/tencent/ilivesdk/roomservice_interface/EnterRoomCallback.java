package com.tencent.ilivesdk.roomservice_interface;

import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;

public abstract interface EnterRoomCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSuccess(LiveInfo paramLiveInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback
 * JD-Core Version:    0.7.0.1
 */