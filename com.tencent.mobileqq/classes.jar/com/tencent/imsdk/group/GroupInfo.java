package com.tencent.imsdk.group;

import java.util.HashMap;
import java.util.Map;

public class GroupInfo
{
  public static int GROUP_ADD_OPTION_ALLOW_ANY = 3;
  public static int GROUP_ADD_OPTION_FORBID_ANY = 1;
  public static int GROUP_ADD_OPTION_NEED_AUTHENTICATION = 2;
  public static long GROUP_INFO_MODIFY_FLAG_ADD_OPTION = 16L;
  public static long GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO = 512L;
  public static long GROUP_INFO_MODIFY_FLAG_FACE_URL = 8L;
  public static long GROUP_INFO_MODIFY_FLAG_GROUP_SEARCHABLE = 128L;
  public static long GROUP_INFO_MODIFY_FLAG_INTRODUCTION = 4L;
  public static long GROUP_INFO_MODIFY_FLAG_MAX_MEMBER_NUM = 32L;
  public static long GROUP_INFO_MODIFY_FLAG_MEMBER_VISIBLE = 64L;
  public static long GROUP_INFO_MODIFY_FLAG_NAME = 1L;
  public static long GROUP_INFO_MODIFY_FLAG_NONE = 0L;
  public static long GROUP_INFO_MODIFY_FLAG_NOTIFICATION = 2L;
  public static long GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL = 256L;
  private int addOption;
  private long createTime;
  private Map<String, byte[]> customInfo = new HashMap();
  private String faceUrl;
  private String groupID;
  private long groupInfoTimestamp;
  private String groupName;
  private GroupMemberInfo groupSelfInfo = new GroupMemberInfo();
  private String groupType;
  private String introduction;
  private boolean isAllShutUp;
  private boolean isGroupMemberVisible;
  private boolean isGroupSearchable;
  private long lastMessageTimestamp;
  private long memberCount;
  private long memberMaxCount;
  private long memberOnlineCount;
  private String notification;
  private String ownerUserID;
  
  public int getAddOption()
  {
    return this.addOption;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public Map<String, byte[]> getCustomInfo()
  {
    return this.customInfo;
  }
  
  public String getFaceUrl()
  {
    return this.faceUrl;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public long getGroupInfoTimestamp()
  {
    return this.groupInfoTimestamp;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public GroupMemberInfo getGroupSelfInfo()
  {
    return this.groupSelfInfo;
  }
  
  public String getGroupType()
  {
    return this.groupType;
  }
  
  public String getIntroduction()
  {
    return this.introduction;
  }
  
  public long getLastMessageTimestamp()
  {
    return this.lastMessageTimestamp;
  }
  
  public long getMemberCount()
  {
    return this.memberCount;
  }
  
  public long getMemberMaxCount()
  {
    return this.memberMaxCount;
  }
  
  public long getMemberOnlineCount()
  {
    return this.memberOnlineCount;
  }
  
  public String getNotification()
  {
    return this.notification;
  }
  
  public String getOwnerUserID()
  {
    return this.ownerUserID;
  }
  
  public boolean isAllShutUp()
  {
    return this.isAllShutUp;
  }
  
  public boolean isGroupMemberVisible()
  {
    return this.isGroupMemberVisible;
  }
  
  public boolean isGroupSearchable()
  {
    return this.isGroupSearchable;
  }
  
  public void setAddOption(int paramInt)
  {
    this.addOption = paramInt;
  }
  
  public void setAllShutUp(boolean paramBoolean)
  {
    this.isAllShutUp = paramBoolean;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setCustomInfo(Map<String, byte[]> paramMap)
  {
    this.customInfo = paramMap;
  }
  
  public void setFaceUrl(String paramString)
  {
    this.faceUrl = paramString;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setGroupInfoTimestamp(long paramLong)
  {
    this.groupInfoTimestamp = paramLong;
  }
  
  public void setGroupMemberVisible(boolean paramBoolean)
  {
    this.isGroupMemberVisible = paramBoolean;
  }
  
  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }
  
  public void setGroupSearchable(boolean paramBoolean)
  {
    this.isGroupSearchable = paramBoolean;
  }
  
  public void setGroupSelfInfo(GroupMemberInfo paramGroupMemberInfo)
  {
    this.groupSelfInfo = paramGroupMemberInfo;
  }
  
  public void setGroupType(String paramString)
  {
    this.groupType = paramString;
  }
  
  public void setIntroduction(String paramString)
  {
    this.introduction = paramString;
  }
  
  public void setLastMessageTimestamp(long paramLong)
  {
    this.lastMessageTimestamp = paramLong;
  }
  
  public void setMemberCount(long paramLong)
  {
    this.memberCount = paramLong;
  }
  
  public void setMemberMaxCount(long paramLong)
  {
    this.memberMaxCount = paramLong;
  }
  
  public void setMemberOnlineCount(long paramLong)
  {
    this.memberOnlineCount = paramLong;
  }
  
  public void setNotification(String paramString)
  {
    this.notification = paramString;
  }
  
  public void setOwnerUserID(String paramString)
  {
    this.ownerUserID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupInfo
 * JD-Core Version:    0.7.0.1
 */