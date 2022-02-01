package com.tencent.ilivesdk.roomlikeservice_interface.Model;

public class RoomlikeInfo
{
  public long total;
  public long uin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total: ");
    localStringBuilder.append(this.total);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomlikeservice_interface.Model.RoomlikeInfo
 * JD-Core Version:    0.7.0.1
 */