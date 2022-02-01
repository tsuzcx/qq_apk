package com.tencent.ilivesdk.supervisionservice_interface.model;

public class PunishedUserInfo
  extends SpvSimpleUserInfo
{
  public long endTime;
  public SpvSimpleUserInfo userInfo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoomAdminInfo {userInfo=");
    localStringBuilder.append(this.userInfo.toString());
    localStringBuilder.append("\nendTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.PunishedUserInfo
 * JD-Core Version:    0.7.0.1
 */