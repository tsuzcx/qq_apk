package com.tencent.imsdk.group;

import java.util.List;
import java.util.Map;

public abstract class GroupListener
{
  public void onApplicationProcessed(String paramString1, GroupMemberInfo paramGroupMemberInfo, boolean paramBoolean, String paramString2) {}
  
  public void onGrantAdministrator(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList) {}
  
  public void onGroupAttributeChanged(String paramString, Map<String, String> paramMap) {}
  
  public void onGroupCreated(String paramString) {}
  
  public void onGroupDismissed(String paramString, GroupMemberInfo paramGroupMemberInfo) {}
  
  public void onGroupInfoChanged(String paramString, List<GroupInfoChangeItem> paramList) {}
  
  public void onGroupRecycled(String paramString, GroupMemberInfo paramGroupMemberInfo) {}
  
  public void onMemberEnter(String paramString, List<GroupMemberInfo> paramList) {}
  
  public void onMemberInfoChanged(String paramString, List<GroupMemberInfoChangeItem> paramList) {}
  
  public void onMemberInvited(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList) {}
  
  public void onMemberKicked(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList) {}
  
  public void onMemberLeave(String paramString, GroupMemberInfo paramGroupMemberInfo) {}
  
  public void onQuitFromGroup(String paramString) {}
  
  public void onReceiveJoinApplication(String paramString1, GroupMemberInfo paramGroupMemberInfo, String paramString2) {}
  
  public void onReceiveRESTCustomData(String paramString, byte[] paramArrayOfByte) {}
  
  public void onRevokeAdministrator(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupListener
 * JD-Core Version:    0.7.0.1
 */