package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendApplication;
import java.io.Serializable;

public class V2TIMFriendApplication
  implements Serializable
{
  public static final int V2TIM_FRIEND_ACCEPT_AGREE = 0;
  public static final int V2TIM_FRIEND_ACCEPT_AGREE_AND_ADD = 1;
  public static final int V2TIM_FRIEND_APPLICATION_BOTH = 3;
  public static final int V2TIM_FRIEND_APPLICATION_COME_IN = 1;
  public static final int V2TIM_FRIEND_APPLICATION_SEND_OUT = 2;
  private FriendApplication friendApplication = new FriendApplication();
  
  public String getAddSource()
  {
    return this.friendApplication.getAddSource();
  }
  
  public long getAddTime()
  {
    return this.friendApplication.getAddTime();
  }
  
  public String getAddWording()
  {
    return this.friendApplication.getAddWording();
  }
  
  public String getFaceUrl()
  {
    return this.friendApplication.getFaceUrl();
  }
  
  public String getNickname()
  {
    return this.friendApplication.getNickName();
  }
  
  public int getType()
  {
    return this.friendApplication.getApplicationType();
  }
  
  public String getUserID()
  {
    return this.friendApplication.getUserID();
  }
  
  protected void setFriendApplication(FriendApplication paramFriendApplication)
  {
    this.friendApplication = paramFriendApplication;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMFriendApplication--->");
    localStringBuilder.append("userID:");
    localStringBuilder.append(getUserID());
    localStringBuilder.append(", nickName:");
    localStringBuilder.append(getNickname());
    localStringBuilder.append(", faceUrl:");
    localStringBuilder.append(getFaceUrl());
    localStringBuilder.append(", addSource:");
    localStringBuilder.append(getAddSource());
    localStringBuilder.append(", addWording:");
    localStringBuilder.append(getAddWording());
    localStringBuilder.append(", addTime:");
    localStringBuilder.append(getAddTime());
    localStringBuilder.append(", type:");
    localStringBuilder.append(getType());
    localStringBuilder.append("(1:comeIn, 2:sendOut, 3:both)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendApplication
 * JD-Core Version:    0.7.0.1
 */