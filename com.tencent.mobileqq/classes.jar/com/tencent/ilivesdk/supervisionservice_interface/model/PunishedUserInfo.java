package com.tencent.ilivesdk.supervisionservice_interface.model;

public class PunishedUserInfo
  extends SpvSimpleUserInfo
{
  public long endTime;
  public SpvSimpleUserInfo userInfo;
  
  public String toString()
  {
    return "RoomAdminInfo {userInfo=" + this.userInfo.toString() + "\nendTime=" + this.endTime + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.PunishedUserInfo
 * JD-Core Version:    0.7.0.1
 */