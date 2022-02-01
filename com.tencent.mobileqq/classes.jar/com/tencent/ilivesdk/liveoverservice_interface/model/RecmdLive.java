package com.tencent.ilivesdk.liveoverservice_interface.model;

import java.util.Objects;

public class RecmdLive
{
  public int anchorType;
  public String jumpUrl;
  public String roomPic;
  public int userNum;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (RecmdLive)paramObject;
    } while ((this.userNum == paramObject.userNum) && (this.anchorType == paramObject.anchorType) && (Objects.equals(this.roomPic, paramObject.roomPic)) && (Objects.equals(this.jumpUrl, paramObject.jumpUrl)));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.roomPic, Integer.valueOf(this.userNum), this.jumpUrl, Integer.valueOf(this.anchorType) });
  }
  
  public String toString()
  {
    return "RecmdLive{roomPic='" + this.roomPic + '\'' + ", userNum=" + this.userNum + ", jumpUrl='" + this.jumpUrl + '\'' + ", anchorType=" + this.anchorType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.liveoverservice_interface.model.RecmdLive
 * JD-Core Version:    0.7.0.1
 */