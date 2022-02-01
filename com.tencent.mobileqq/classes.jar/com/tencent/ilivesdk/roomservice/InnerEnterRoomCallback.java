package com.tencent.ilivesdk.roomservice;

import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;

public abstract interface InnerEnterRoomCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSuccess(LiveInfo paramLiveInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.InnerEnterRoomCallback
 * JD-Core Version:    0.7.0.1
 */