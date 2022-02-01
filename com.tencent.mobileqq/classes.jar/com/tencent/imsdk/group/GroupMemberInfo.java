package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GroupMemberInfo
  implements Serializable
{
  public static int GROUP_MEMBER_FILTER_FLAG_ADMINISTRATOR = 3;
  public static int GROUP_MEMBER_FILTER_FLAG_ALL = 1;
  public static int GROUP_MEMBER_FILTER_FLAG_MEMBER = 4;
  public static int GROUP_MEMBER_FILTER_FLAG_OWNER = 2;
  public static long GROUP_MEMBER_INFO_MODIFY_FLAG_CUSTOM_INFO = 16L;
  public static long GROUP_MEMBER_INFO_MODIFY_FLAG_MEMBER_ROLE = 2L;
  public static long GROUP_MEMBER_INFO_MODIFY_FLAG_MESSAGE_RECEIVE_FLAG = 1L;
  public static long GROUP_MEMBER_INFO_MODIFY_FLAG_NAME_CARD = 8L;
  public static long GROUP_MEMBER_INFO_MODIFY_FLAG_NONE = 0L;
  public static long GROUP_MEMBER_INFO_MODIFY_FLAG_SHUTUP_TIME = 4L;
  public static int MEMBER_ROLE_ADMINISTRATOR = 300;
  public static int MEMBER_ROLE_MEMBER = 200;
  public static int MEMBER_ROLE_OWNER = 400;
  public static int MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE = 1;
  public static int MESSAGE_RECEIVE_OPTION_NOT_RECEIVE = 2;
  public static int MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH = 3;
  private Map<String, byte[]> customInfo = new HashMap();
  private String faceUrl;
  private String friendRemark;
  private String groupID;
  private long joinTime;
  private long messageReadSequence;
  private int messageReceiveOption;
  private String nameCard;
  private String nickname;
  private int role;
  private long shutUpTime;
  private String userID;
  
  private void addCustomInfo(String paramString, byte[] paramArrayOfByte)
  {
    this.customInfo.put(paramString, paramArrayOfByte);
  }
  
  public Map<String, byte[]> getCustomInfo()
  {
    return this.customInfo;
  }
  
  public String getFaceUrl()
  {
    return this.faceUrl;
  }
  
  public String getFriendRemark()
  {
    return this.friendRemark;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public long getJoinTime()
  {
    return this.joinTime;
  }
  
  public long getMessageReadSequence()
  {
    return this.messageReadSequence;
  }
  
  public int getMessageReceiveOption()
  {
    return this.messageReceiveOption;
  }
  
  public String getNameCard()
  {
    return this.nameCard;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public int getRole()
  {
    return this.role;
  }
  
  public long getShutUpTime()
  {
    return this.shutUpTime;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
  
  public void setCustomInfo(Map<String, byte[]> paramMap)
  {
    this.customInfo = paramMap;
  }
  
  public void setFaceUrl(String paramString)
  {
    this.faceUrl = paramString;
  }
  
  public void setFriendRemark(String paramString)
  {
    this.friendRemark = paramString;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setJoinTime(long paramLong)
  {
    this.joinTime = paramLong;
  }
  
  public void setMessageReadSequence(long paramLong)
  {
    this.messageReadSequence = paramLong;
  }
  
  public void setMessageReceiveOption(int paramInt)
  {
    this.messageReceiveOption = paramInt;
  }
  
  public void setNameCard(String paramString)
  {
    this.nameCard = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }
  
  public void setShutUpTime(long paramLong)
  {
    this.shutUpTime = paramLong;
  }
  
  public void setUserID(String paramString)
  {
    this.userID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupMemberInfo
 * JD-Core Version:    0.7.0.1
 */