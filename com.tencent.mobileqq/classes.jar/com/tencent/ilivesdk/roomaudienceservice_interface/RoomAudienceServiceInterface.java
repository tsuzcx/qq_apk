package com.tencent.ilivesdk.roomaudienceservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface RoomAudienceServiceInterface
  extends ServiceBaseInterface
{
  public abstract void init(RoomAudienceServiceAdapter paramRoomAudienceServiceAdapter);
  
  public abstract void onEnterRoom();
  
  public abstract void queryRankUserList(long paramLong1, long paramLong2, ICallback paramICallback);
  
  public abstract void queryUserList(long paramLong, int paramInt, ICallback paramICallback);
  
  public abstract void registerUserChangeEvent(RoomAudienceServiceInterface.IUserEvent paramIUserEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceInterface
 * JD-Core Version:    0.7.0.1
 */