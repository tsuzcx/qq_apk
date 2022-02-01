package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfo;
import java.util.Map;

public class V2TIMGroupMemberFullInfo
  extends V2TIMGroupMemberInfo
{
  public static final int V2TIM_GROUP_MEMBER_FILTER_ADMIN = 2;
  public static final int V2TIM_GROUP_MEMBER_FILTER_ALL = 0;
  public static final int V2TIM_GROUP_MEMBER_FILTER_COMMON = 4;
  public static final int V2TIM_GROUP_MEMBER_FILTER_OWNER = 1;
  public static final int V2TIM_GROUP_MEMBER_ROLE_ADMIN = 300;
  public static final int V2TIM_GROUP_MEMBER_ROLE_MEMBER = 200;
  public static final int V2TIM_GROUP_MEMBER_ROLE_OWNER = 400;
  public static final int V2TIM_GROUP_MEMBER_UNDEFINED = 0;
  private final String TAG = "V2TIMGroupMemberFullInfo";
  private long modifyFlag = 0L;
  
  public Map<String, byte[]> getCustomInfo()
  {
    return this.groupMemberInfo.getCustomInfo();
  }
  
  public long getJoinTime()
  {
    return this.groupMemberInfo.getJoinTime();
  }
  
  long getModifyFlag()
  {
    return this.modifyFlag;
  }
  
  public long getMuteUntil()
  {
    return this.groupMemberInfo.getShutUpTime();
  }
  
  public int getRole()
  {
    int i = this.groupMemberInfo.getRole();
    if (i == GroupMemberInfo.MEMBER_ROLE_MEMBER) {
      return 200;
    }
    if (i == GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR) {
      return 300;
    }
    if (i == GroupMemberInfo.MEMBER_ROLE_OWNER) {
      return 400;
    }
    return 0;
  }
  
  public String getUserID()
  {
    return this.groupMemberInfo.getUserID();
  }
  
  public void setCustomInfo(Map<String, byte[]> paramMap)
  {
    this.groupMemberInfo.setCustomInfo(paramMap);
    this.modifyFlag |= GroupMemberInfo.GROUP_MEMBER_INFO_MODIFY_FLAG_CUSTOM_INFO;
  }
  
  public void setNameCard(String paramString)
  {
    this.groupMemberInfo.setNameCard(paramString);
    this.modifyFlag |= GroupMemberInfo.GROUP_MEMBER_INFO_MODIFY_FLAG_NAME_CARD;
  }
  
  void setReceiveMessageOpt(int paramInt)
  {
    this.groupMemberInfo.setMessageReceiveOption(paramInt);
    this.modifyFlag |= GroupMemberInfo.GROUP_MEMBER_INFO_MODIFY_FLAG_MESSAGE_RECEIVE_FLAG;
  }
  
  void setRole(int paramInt)
  {
    if (200 == paramInt) {
      this.groupMemberInfo.setRole(GroupMemberInfo.MEMBER_ROLE_MEMBER);
    } else if (300 == paramInt) {
      this.groupMemberInfo.setRole(GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR);
    } else if (400 == paramInt) {
      this.groupMemberInfo.setRole(GroupMemberInfo.MEMBER_ROLE_OWNER);
    }
    this.modifyFlag |= GroupMemberInfo.GROUP_MEMBER_INFO_MODIFY_FLAG_MEMBER_ROLE;
  }
  
  void setShutUpTime(long paramLong)
  {
    this.groupMemberInfo.setShutUpTime(paramLong);
    this.modifyFlag |= GroupMemberInfo.GROUP_MEMBER_INFO_MODIFY_FLAG_SHUTUP_TIME;
  }
  
  public void setUserID(String paramString)
  {
    this.groupMemberInfo.setUserID(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMGroupMemberProfile--->");
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
    localStringBuilder.append(", role:");
    localStringBuilder.append(getRole());
    localStringBuilder.append(", muteUtil:");
    localStringBuilder.append(getMuteUntil());
    localStringBuilder.append(", joinTime:");
    localStringBuilder.append(getJoinTime());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo
 * JD-Core Version:    0.7.0.1
 */