package com.tencent.ilivesdk.supervisionservice_interface.model;

public class RoomAdminInfo
{
  public boolean isInRoom;
  public SpvSimpleUserInfo userInfo;
  
  public String toString()
  {
    return "RoomAdminInfo {userInfo=" + this.userInfo.toString() + "\nisInRoom=" + this.isInRoom + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.RoomAdminInfo
 * JD-Core Version:    0.7.0.1
 */