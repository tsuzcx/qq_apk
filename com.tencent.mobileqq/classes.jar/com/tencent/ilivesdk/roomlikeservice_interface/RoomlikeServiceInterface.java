package com.tencent.ilivesdk.roomlikeservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomlikeservice_interface.Model.RoomlikeInfoReq;

public abstract interface RoomlikeServiceInterface
  extends ServiceBaseInterface
{
  public abstract void getRoomlikeInfo(RoomlikeInfoReq paramRoomlikeInfoReq, GetRoomlikeInfoCallback paramGetRoomlikeInfoCallback);
  
  public abstract void init(RoomlikeServiceAdapter paramRoomlikeServiceAdapter);
  
  public abstract void setReceiveLikeListener(RoomlikeServiceInterface.ReceiveLikeListener paramReceiveLikeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomlikeservice_interface.RoomlikeServiceInterface
 * JD-Core Version:    0.7.0.1
 */