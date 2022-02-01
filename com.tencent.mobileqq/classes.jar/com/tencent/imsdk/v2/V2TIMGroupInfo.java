package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import java.util.Map;

public class V2TIMGroupInfo
{
  static final String GROUP_TYPE_INTERNAL_CHATROOM = "ChatRoom";
  static final String GROUP_TYPE_INTERNAL_PRIVATE = "Private";
  public static final int V2TIM_GROUP_ADD_ANY = 2;
  public static final int V2TIM_GROUP_ADD_AUTH = 1;
  public static final int V2TIM_GROUP_ADD_FORBID = 0;
  private final String TAG = "V2TIMGroupInfo";
  private GroupInfo groupInfo = new GroupInfo();
  private int modifyFlag = 0;
  
  public long getCreateTime()
  {
    return this.groupInfo.getCreateTime();
  }
  
  public Map<String, byte[]> getCustomInfo()
  {
    return this.groupInfo.getCustomInfo();
  }
  
  public String getFaceUrl()
  {
    return this.groupInfo.getFaceUrl();
  }
  
  public int getGroupAddOpt()
  {
    long l = this.groupInfo.getAddOption();
    if (l == GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY) {
      return 2;
    }
    if (l == GroupInfo.GROUP_ADD_OPTION_FORBID_ANY) {
      return 0;
    }
    if (l == GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION) {
      return 1;
    }
    return 2;
  }
  
  public String getGroupID()
  {
    return this.groupInfo.getGroupID();
  }
  
  GroupInfo getGroupInfo()
  {
    return this.groupInfo;
  }
  
  public String getGroupName()
  {
    return this.groupInfo.getGroupName();
  }
  
  public String getGroupType()
  {
    String str2 = this.groupInfo.getGroupType();
    if (str2.equals("Private")) {
      return "Work";
    }
    String str1 = str2;
    if (str2.equals("ChatRoom")) {
      str1 = "Meeting";
    }
    return str1;
  }
  
  public String getIntroduction()
  {
    return this.groupInfo.getIntroduction();
  }
  
  public long getJoinTime()
  {
    return this.groupInfo.getGroupSelfInfo().getJoinTime();
  }
  
  public long getLastInfoTime()
  {
    return this.groupInfo.getGroupInfoTimestamp();
  }
  
  public long getLastMessageTime()
  {
    return this.groupInfo.getLastMessageTimestamp();
  }
  
  public int getMemberCount()
  {
    return (int)this.groupInfo.getMemberCount();
  }
  
  int getModifyFlag()
  {
    return this.modifyFlag;
  }
  
  public String getNotification()
  {
    return this.groupInfo.getNotification();
  }
  
  public int getOnlineCount()
  {
    return (int)this.groupInfo.getMemberOnlineCount();
  }
  
  public String getOwner()
  {
    return this.groupInfo.getOwnerUserID();
  }
  
  public int getRecvOpt()
  {
    int i = this.groupInfo.getGroupSelfInfo().getMessageReceiveOption();
    if (i == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
      return 0;
    }
    if (i == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
      return 1;
    }
    if (i == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
      return 2;
    }
    return 0;
  }
  
  public int getRole()
  {
    int i = this.groupInfo.getGroupSelfInfo().getRole();
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
  
  public boolean isAllMuted()
  {
    return this.groupInfo.isAllShutUp();
  }
  
  public void setAllMuted(boolean paramBoolean)
  {
    this.groupInfo.setAllShutUp(paramBoolean);
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL));
  }
  
  public void setCustomInfo(Map<String, byte[]> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.groupInfo.setCustomInfo(paramMap);
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO));
  }
  
  public void setFaceUrl(String paramString)
  {
    this.groupInfo.setFaceUrl(paramString);
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_FACE_URL));
  }
  
  public void setGroupAddOpt(int paramInt)
  {
    if (2 == paramInt) {
      this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY);
    } else if (paramInt == 0) {
      this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_FORBID_ANY);
    } else if (1 == paramInt) {
      this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION);
    }
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_ADD_OPTION));
  }
  
  public void setGroupID(String paramString)
  {
    this.groupInfo.setGroupID(paramString);
  }
  
  void setGroupInfo(GroupInfo paramGroupInfo)
  {
    this.groupInfo = paramGroupInfo;
  }
  
  public void setGroupName(String paramString)
  {
    this.groupInfo.setGroupName(paramString);
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NAME));
  }
  
  public void setGroupType(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMGroupInfo", "setGroupType error type is null");
      return;
    }
    boolean bool = paramString.equalsIgnoreCase("Work");
    String str = "ChatRoom";
    if (bool) {}
    do
    {
      paramString = "Private";
      break;
      if (paramString.equalsIgnoreCase("Meeting"))
      {
        paramString = str;
        break;
      }
    } while (paramString.equalsIgnoreCase("Private"));
    if (paramString.equalsIgnoreCase("ChatRoom")) {
      paramString = str;
    } else if (paramString.equalsIgnoreCase("Public")) {
      paramString = "Public";
    } else if (paramString.equalsIgnoreCase("AVChatRoom")) {
      paramString = "AVChatRoom";
    }
    this.groupInfo.setGroupType(paramString);
  }
  
  public void setIntroduction(String paramString)
  {
    this.groupInfo.setIntroduction(paramString);
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_INTRODUCTION));
  }
  
  void setModifyFlag(int paramInt)
  {
    this.modifyFlag = paramInt;
  }
  
  public void setNotification(String paramString)
  {
    this.groupInfo.setNotification(paramString);
    this.modifyFlag = ((int)(this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NOTIFICATION));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupInfo
 * JD-Core Version:    0.7.0.1
 */