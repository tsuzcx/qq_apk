package com.tencent.imsdk.v2;

import java.util.List;
import java.util.Map;

public abstract class V2TIMGroupListener
{
  public void onApplicationProcessed(String paramString1, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, boolean paramBoolean, String paramString2) {}
  
  public void onGrantAdministrator(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> paramList) {}
  
  public void onGroupAttributeChanged(String paramString, Map<String, String> paramMap) {}
  
  public void onGroupCreated(String paramString) {}
  
  public void onGroupDismissed(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo) {}
  
  public void onGroupInfoChanged(String paramString, List<V2TIMGroupChangeInfo> paramList) {}
  
  public void onGroupRecycled(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo) {}
  
  public void onMemberEnter(String paramString, List<V2TIMGroupMemberInfo> paramList) {}
  
  public void onMemberInfoChanged(String paramString, List<V2TIMGroupMemberChangeInfo> paramList) {}
  
  public void onMemberInvited(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> paramList) {}
  
  public void onMemberKicked(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> paramList) {}
  
  public void onMemberLeave(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo) {}
  
  public void onQuitFromGroup(String paramString) {}
  
  public void onReceiveJoinApplication(String paramString1, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, String paramString2) {}
  
  public void onReceiveRESTCustomData(String paramString, byte[] paramArrayOfByte) {}
  
  public void onRevokeAdministrator(String paramString, V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, List<V2TIMGroupMemberInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupListener
 * JD-Core Version:    0.7.0.1
 */