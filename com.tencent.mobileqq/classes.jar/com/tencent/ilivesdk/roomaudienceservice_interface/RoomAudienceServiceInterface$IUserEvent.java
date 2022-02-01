package com.tencent.ilivesdk.roomaudienceservice_interface;

import java.util.List;

public abstract interface RoomAudienceServiceInterface$IUserEvent
{
  public abstract void userEnter(long paramLong, UserServer paramUserServer, int paramInt);
  
  public abstract void userExit(long paramLong, UserServer paramUserServer, int paramInt);
  
  public abstract void userRankChanged(List<UserServer> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceInterface.IUserEvent
 * JD-Core Version:    0.7.0.1
 */