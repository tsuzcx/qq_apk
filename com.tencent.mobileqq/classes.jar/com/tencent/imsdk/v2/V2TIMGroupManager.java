package com.tencent.imsdk.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class V2TIMGroupManager
{
  static V2TIMGroupManager getInstance()
  {
    return V2TIMGroupManagerImpl.getInstance();
  }
  
  public abstract void acceptGroupApplication(V2TIMGroupApplication paramV2TIMGroupApplication, String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void createGroup(V2TIMGroupInfo paramV2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> paramList, V2TIMValueCallback<String> paramV2TIMValueCallback);
  
  public abstract void deleteGroupAttributes(String paramString, List<String> paramList, V2TIMCallback paramV2TIMCallback);
  
  public abstract void getGroupApplicationList(V2TIMValueCallback<V2TIMGroupApplicationResult> paramV2TIMValueCallback);
  
  public abstract void getGroupAttributes(String paramString, List<String> paramList, V2TIMValueCallback<Map<String, String>> paramV2TIMValueCallback);
  
  public abstract void getGroupMemberList(String paramString, int paramInt, long paramLong, V2TIMValueCallback<V2TIMGroupMemberInfoResult> paramV2TIMValueCallback);
  
  public abstract void getGroupMembersInfo(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> paramV2TIMValueCallback);
  
  public abstract void getGroupOnlineMemberCount(String paramString, V2TIMValueCallback<Integer> paramV2TIMValueCallback);
  
  public abstract void getGroupsInfo(List<String> paramList, V2TIMValueCallback<List<V2TIMGroupInfoResult>> paramV2TIMValueCallback);
  
  public abstract void getJoinedGroupList(V2TIMValueCallback<List<V2TIMGroupInfo>> paramV2TIMValueCallback);
  
  public abstract void initGroupAttributes(String paramString, HashMap<String, String> paramHashMap, V2TIMCallback paramV2TIMCallback);
  
  public abstract void inviteUserToGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> paramV2TIMValueCallback);
  
  public abstract void kickGroupMember(String paramString1, List<String> paramList, String paramString2, V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> paramV2TIMValueCallback);
  
  public abstract void muteGroupMember(String paramString1, String paramString2, int paramInt, V2TIMCallback paramV2TIMCallback);
  
  public abstract void refuseGroupApplication(V2TIMGroupApplication paramV2TIMGroupApplication, String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setGroupApplicationRead(V2TIMCallback paramV2TIMCallback);
  
  public abstract void setGroupAttributes(String paramString, HashMap<String, String> paramHashMap, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setGroupInfo(V2TIMGroupInfo paramV2TIMGroupInfo, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setGroupMemberInfo(String paramString, V2TIMGroupMemberFullInfo paramV2TIMGroupMemberFullInfo, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setGroupMemberRole(String paramString1, String paramString2, int paramInt, V2TIMCallback paramV2TIMCallback);
  
  public abstract void transferGroupOwner(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManager
 * JD-Core Version:    0.7.0.1
 */