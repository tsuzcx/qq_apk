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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (RecmdLive)paramObject;
      return (this.userNum == paramObject.userNum) && (this.anchorType == paramObject.anchorType) && (Objects.equals(this.roomPic, paramObject.roomPic)) && (Objects.equals(this.jumpUrl, paramObject.jumpUrl));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.roomPic, Integer.valueOf(this.userNum), this.jumpUrl, Integer.valueOf(this.anchorType) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecmdLive{roomPic='");
    localStringBuilder.append(this.roomPic);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userNum=");
    localStringBuilder.append(this.userNum);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", anchorType=");
    localStringBuilder.append(this.anchorType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.liveoverservice_interface.model.RecmdLive
 * JD-Core Version:    0.7.0.1
 */