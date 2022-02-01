package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;

public class V2TIMGroupMemberInfo
  implements Serializable
{
  GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
  UserInfo userInfo;
  
  public String getFaceUrl()
  {
    if (!TextUtils.isEmpty(this.groupMemberInfo.getFaceUrl())) {
      return this.groupMemberInfo.getFaceUrl();
    }
    UserInfo localUserInfo = this.userInfo;
    if (localUserInfo != null) {
      return localUserInfo.getFaceUrl();
    }
    return "";
  }
  
  public String getFriendRemark()
  {
    return this.groupMemberInfo.getFriendRemark();
  }
  
  GroupMemberInfo getGroupMemberInfo()
  {
    return this.groupMemberInfo;
  }
  
  public String getNameCard()
  {
    return this.groupMemberInfo.getNameCard();
  }
  
  public String getNickName()
  {
    if (!TextUtils.isEmpty(this.groupMemberInfo.getNickname())) {
      return this.groupMemberInfo.getNickname();
    }
    UserInfo localUserInfo = this.userInfo;
    if (localUserInfo != null) {
      return localUserInfo.getNickname();
    }
    return "";
  }
  
  public String getUserID()
  {
    if (!TextUtils.isEmpty(this.groupMemberInfo.getUserID())) {
      return this.groupMemberInfo.getUserID();
    }
    UserInfo localUserInfo = this.userInfo;
    if (localUserInfo != null) {
      return localUserInfo.getUserID();
    }
    return "";
  }
  
  void setGroupMemberInfo(GroupMemberInfo paramGroupMemberInfo)
  {
    this.groupMemberInfo = paramGroupMemberInfo;
  }
  
  void setUserInfo(UserInfo paramUserInfo)
  {
    this.userInfo = paramUserInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMGroupMemberInfo--->");
    localStringBuilder.append("userID:");
    localStringBuilder.append(getUserID());
    localStringBuilder.append(", nickName:");
    localStringBuilder.append(getNickName());
    localStringBuilder.append(", nameCard:");
    localStringBuilder.append(getNameCard());
    localStringBuilder.append(", friendRemark:");
    localStringBuilder.append(getFriendRemark());
    localStringBuilder.append(", faceUrl:");
    localStringBuilder.append(getFaceUrl());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupMemberInfo
 * JD-Core Version:    0.7.0.1
 */