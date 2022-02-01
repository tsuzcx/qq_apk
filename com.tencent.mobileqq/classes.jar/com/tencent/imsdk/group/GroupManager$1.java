package com.tencent.imsdk.group;

import com.tencent.imsdk.common.IMContext;
import java.util.List;
import java.util.Map;

class GroupManager$1
  extends GroupListener
{
  GroupManager$1(GroupManager paramGroupManager) {}
  
  public void onApplicationProcessed(String paramString1, GroupMemberInfo paramGroupMemberInfo, boolean paramBoolean, String paramString2)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.11(this, paramString1, paramGroupMemberInfo, paramBoolean, paramString2));
  }
  
  public void onGrantAdministrator(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.12(this, paramString, paramGroupMemberInfo, paramList));
  }
  
  public void onGroupAttributeChanged(String paramString, Map<String, String> paramMap)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.16(this, paramString, paramMap));
  }
  
  public void onGroupCreated(String paramString)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.6(this, paramString));
  }
  
  public void onGroupDismissed(String paramString, GroupMemberInfo paramGroupMemberInfo)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.7(this, paramString, paramGroupMemberInfo));
  }
  
  public void onGroupInfoChanged(String paramString, List<GroupInfoChangeItem> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.9(this, paramString, paramList));
  }
  
  public void onGroupRecycled(String paramString, GroupMemberInfo paramGroupMemberInfo)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.8(this, paramString, paramGroupMemberInfo));
  }
  
  public void onMemberEnter(String paramString, List<GroupMemberInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.1(this, paramString, paramList));
  }
  
  public void onMemberInfoChanged(String paramString, List<GroupMemberInfoChangeItem> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.5(this, paramString, paramList));
  }
  
  public void onMemberInvited(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.3(this, paramString, paramGroupMemberInfo, paramList));
  }
  
  public void onMemberKicked(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.4(this, paramString, paramGroupMemberInfo, paramList));
  }
  
  public void onMemberLeave(String paramString, GroupMemberInfo paramGroupMemberInfo)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.2(this, paramString, paramGroupMemberInfo));
  }
  
  public void onQuitFromGroup(String paramString)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.14(this, paramString));
  }
  
  public void onReceiveJoinApplication(String paramString1, GroupMemberInfo paramGroupMemberInfo, String paramString2)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.10(this, paramString1, paramGroupMemberInfo, paramString2));
  }
  
  public void onReceiveRESTCustomData(String paramString, byte[] paramArrayOfByte)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.15(this, paramString, paramArrayOfByte));
  }
  
  public void onRevokeAdministrator(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new GroupManager.1.13(this, paramString, paramGroupMemberInfo, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1
 * JD-Core Version:    0.7.0.1
 */