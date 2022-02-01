package com.tencent.ilivesdk.roomlikeservice_interface;

import com.tencent.ilivesdk.roomlikeservice_interface.Model.RoomlikeInfo;

public abstract interface GetRoomlikeInfoCallback
{
  public abstract void onFailure(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onSuccess(RoomlikeInfo paramRoomlikeInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomlikeservice_interface.GetRoomlikeInfoCallback
 * JD-Core Version:    0.7.0.1
 */