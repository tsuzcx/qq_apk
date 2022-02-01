package com.tencent.imsdk.message;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.List;

public class GroupTipsElement
  extends MessageBaseElement
{
  public static final int GROUP_TIPS_TYPE_GRANT_ADMINISTRATOR = 4;
  public static final int GROUP_TIPS_TYPE_GROUP_INFO_CHANGE = 6;
  public static final int GROUP_TIPS_TYPE_GROUP_MEMBER_INFO_CHANGE = 7;
  public static final int GROUP_TIPS_TYPE_JOIN = 1;
  public static final int GROUP_TIPS_TYPE_KICK = 3;
  public static final int GROUP_TIPS_TYPE_NONE = 0;
  public static final int GROUP_TIPS_TYPE_QUIT = 2;
  public static final int GROUP_TIPS_TYPE_REVOKE_ADMINISTRATOR = 5;
  private String groupID;
  private List<GroupInfoChangeItem> groupInfoChangeItemList = new ArrayList();
  private int groupMemberCount;
  private List<GroupMemberInfoChangeItem> groupMemberInfoChangeItemList = new ArrayList();
  private String groupName;
  private int groupTipsType;
  private String groupType;
  private GroupMemberInfo operatorGroupMemberInfo;
  private String operatorPlatForm;
  private String operatorUserID;
  private UserInfo operatorUserInfo;
  private List<GroupMemberInfo> targetGroupMemberInfoList = new ArrayList();
  private List<String> targetUserIDList = new ArrayList();
  private List<UserInfo> targetUserInfoList = new ArrayList();
  
  void addGroupInfoChangeItem(GroupInfoChangeItem paramGroupInfoChangeItem)
  {
    if (paramGroupInfoChangeItem == null) {
      return;
    }
    this.groupInfoChangeItemList.add(paramGroupInfoChangeItem);
  }
  
  void addGroupMemberInfoChangeItem(GroupMemberInfoChangeItem paramGroupMemberInfoChangeItem)
  {
    if (paramGroupMemberInfoChangeItem == null) {
      return;
    }
    this.groupMemberInfoChangeItemList.add(paramGroupMemberInfoChangeItem);
  }
  
  void addTargetGroupMemberInfo(GroupMemberInfo paramGroupMemberInfo)
  {
    if (paramGroupMemberInfo == null) {
      return;
    }
    this.targetGroupMemberInfoList.add(paramGroupMemberInfo);
  }
  
  void addTargetUserID(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.targetUserIDList.add(paramString);
  }
  
  void addTargetUserInfo(UserInfo paramUserInfo)
  {
    this.targetUserInfoList.add(paramUserInfo);
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public List<GroupInfoChangeItem> getGroupInfoChangeItemList()
  {
    return this.groupInfoChangeItemList;
  }
  
  public int getGroupMemberCount()
  {
    return this.groupMemberCount;
  }
  
  public List<GroupMemberInfoChangeItem> getGroupMemberInfoChangeItemList()
  {
    return this.groupMemberInfoChangeItemList;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public int getGroupTipsType()
  {
    return this.groupTipsType;
  }
  
  public String getGroupType()
  {
    return this.groupType;
  }
  
  public GroupMemberInfo getOperatorGroupMemberInfo()
  {
    return this.operatorGroupMemberInfo;
  }
  
  public String getOperatorPlatForm()
  {
    return this.operatorPlatForm;
  }
  
  public String getOperatorUserID()
  {
    return this.operatorUserID;
  }
  
  public UserInfo getOperatorUserInfo()
  {
    return this.operatorUserInfo;
  }
  
  public List<GroupMemberInfo> getTargetGroupMemberInfoList()
  {
    return this.targetGroupMemberInfoList;
  }
  
  public List<String> getTargetUserIDList()
  {
    return this.targetUserIDList;
  }
  
  public List<UserInfo> getTargetUserInfoList()
  {
    return this.targetUserInfoList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.GroupTipsElement
 * JD-Core Version:    0.7.0.1
 */