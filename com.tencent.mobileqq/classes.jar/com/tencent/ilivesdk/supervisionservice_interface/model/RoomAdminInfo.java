package com.tencent.ilivesdk.supervisionservice_interface.model;

public class RoomAdminInfo
{
  public boolean isInRoom;
  public SpvSimpleUserInfo userInfo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoomAdminInfo {userInfo=");
    localStringBuilder.append(this.userInfo.toString());
    localStringBuilder.append("\nisInRoom=");
    localStringBuilder.append(this.isInRoom);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.RoomAdminInfo
 * JD-Core Version:    0.7.0.1
 */