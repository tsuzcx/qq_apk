package com.tencent.imsdk.group;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.manager.BaseManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupManager
{
  private GroupListener mGroupInternalListener;
  private GroupListener mGroupListener;
  
  public static GroupManager getInstance()
  {
    return GroupManager.GroupManagerHolder.access$000();
  }
  
  private void initGroupListener()
  {
    if (this.mGroupInternalListener == null) {
      this.mGroupInternalListener = new GroupManager.1(this);
    }
    nativeSetGroupListener(this.mGroupInternalListener);
  }
  
  public void acceptGroupApplication(GroupApplication paramGroupApplication, String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    paramGroupApplication.setResponseType(GroupApplication.RESPONSE_TYPE_AGREE);
    paramGroupApplication.setResponseMessage(paramString);
    nativeResponseGroupApplication(paramGroupApplication, paramIMCallback);
  }
  
  public void createGroup(GroupInfo paramGroupInfo, List<GroupMemberInfo> paramList, IMCallback<String> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeCreateGroup(paramGroupInfo, paramList, paramIMCallback);
  }
  
  public void createGroup(String paramString1, String paramString2, String paramString3, IMCallback<String> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setGroupID(paramString2);
    localGroupInfo.setGroupType(paramString1);
    localGroupInfo.setGroupName(paramString3);
    nativeCreateGroup(localGroupInfo, null, paramIMCallback);
  }
  
  public void deleteGroupAttributes(String paramString, List<String> paramList, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteGroupAttributes(paramString, paramList, paramIMCallback);
  }
  
  public void dismissGroup(String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDismissGroup(paramString, paramIMCallback);
  }
  
  public void getGroupApplicationList(IMCallback<GroupApplicationResult> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupApplicationList(paramIMCallback);
  }
  
  public void getGroupAttributes(String paramString, List<String> paramList, IMCallback<Map<String, String>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupAttributes(paramString, paramList, paramIMCallback);
  }
  
  public void getGroupMemberList(String paramString, int paramInt, long paramLong, IMCallback<GroupMemberInfoResult> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupMemberList(paramString, paramInt, paramLong, paramIMCallback);
  }
  
  public void getGroupMembersInfo(String paramString, List<String> paramList, IMCallback<List<GroupMemberInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupMembersInfo(paramString, paramList, paramIMCallback);
  }
  
  public void getGroupOnlineMemberCount(String paramString, IMCallback<Integer> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupOnlineMemberCount(paramString, paramIMCallback);
  }
  
  public void getGroupsInfo(List<String> paramList, IMCallback<List<GroupInfoGetResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetGroupsInfo(paramList, paramIMCallback);
  }
  
  public void getJoinedGroupList(IMCallback<List<GroupInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetJoinedGroupList(paramIMCallback);
  }
  
  public void init()
  {
    initGroupListener();
  }
  
  public void initGroupAttributes(String paramString, HashMap<String, String> paramHashMap, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeInitGroupAttributes(paramString, paramHashMap, paramIMCallback);
  }
  
  public void inviteUserToGroup(String paramString, List<String> paramList, IMCallback<List<GroupMemberOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeInviteGroupMembers(paramString, paramList, "", paramIMCallback);
  }
  
  public void joinGroup(String paramString1, String paramString2, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeJoinGroup(paramString1, paramString2, paramIMCallback);
  }
  
  public void kickGroupMember(String paramString1, List<String> paramList, String paramString2, IMCallback<List<GroupMemberOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteGroupMembers(paramString1, paramList, paramString2, paramIMCallback);
  }
  
  public void muteGroupMember(String paramString1, String paramString2, int paramInt, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeMuteGroupMember(paramString1, paramString2, paramInt, paramIMCallback);
  }
  
  protected native void nativeCreateGroup(GroupInfo paramGroupInfo, List<GroupMemberInfo> paramList, IMCallback<String> paramIMCallback);
  
  protected native void nativeDeleteGroupAttributes(String paramString, List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeDeleteGroupMembers(String paramString1, List<String> paramList, String paramString2, IMCallback paramIMCallback);
  
  protected native void nativeDismissGroup(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeGetGroupApplicationList(IMCallback paramIMCallback);
  
  protected native void nativeGetGroupAttributes(String paramString, List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeGetGroupMemberList(String paramString, int paramInt, long paramLong, IMCallback paramIMCallback);
  
  protected native void nativeGetGroupMembersInfo(String paramString, List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeGetGroupOnlineMemberCount(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeGetGroupsInfo(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeGetJoinedGroupList(IMCallback paramIMCallback);
  
  protected native void nativeInitGroupAttributes(String paramString, Map<String, String> paramMap, IMCallback paramIMCallback);
  
  protected native void nativeInviteGroupMembers(String paramString1, List<String> paramList, String paramString2, IMCallback paramIMCallback);
  
  protected native void nativeJoinGroup(String paramString1, String paramString2, IMCallback paramIMCallback);
  
  protected native void nativeMuteGroupMember(String paramString1, String paramString2, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeQuitGroup(String paramString, IMCallback paramIMCallback);
  
  protected native void nativeResponseGroupApplication(GroupApplication paramGroupApplication, IMCallback paramIMCallback);
  
  protected native void nativeSearchGroupMembersInfo(GroupMemberSearchParam paramGroupMemberSearchParam, IMCallback paramIMCallback);
  
  protected native void nativeSearchGroups(GroupSearchParam paramGroupSearchParam, IMCallback paramIMCallback);
  
  protected native void nativeSetGroupApplicationListRead(IMCallback paramIMCallback);
  
  protected native void nativeSetGroupInfo(GroupInfoModifyParam paramGroupInfoModifyParam, IMCallback paramIMCallback);
  
  protected native void nativeSetGroupListener(GroupListener paramGroupListener);
  
  protected native void nativeSetGroupMemberInfo(GroupMemberInfoModifyParam paramGroupMemberInfoModifyParam, IMCallback paramIMCallback);
  
  protected native void nativeSetGroupMemberRole(String paramString1, String paramString2, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeSetGroupMessageReceiveOption(String paramString, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeSetGroupOwner(String paramString1, String paramString2, IMCallback paramIMCallback);
  
  protected native void nativeUpdateGroupAttributes(String paramString, Map<String, String> paramMap, IMCallback paramIMCallback);
  
  public void quitGroup(String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeQuitGroup(paramString, paramIMCallback);
  }
  
  public void refuseGroupApplication(GroupApplication paramGroupApplication, String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    paramGroupApplication.setResponseType(GroupApplication.RESPONSE_TYPE_REFUSE);
    paramGroupApplication.setResponseMessage(paramString);
    nativeResponseGroupApplication(paramGroupApplication, paramIMCallback);
  }
  
  public void searchGroupMembersInfo(GroupMemberSearchParam paramGroupMemberSearchParam, IMCallback<HashMap<String, List<GroupMemberInfo>>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSearchGroupMembersInfo(paramGroupMemberSearchParam, paramIMCallback);
  }
  
  public void searchGroups(GroupSearchParam paramGroupSearchParam, IMCallback<List<GroupInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSearchGroups(paramGroupSearchParam, paramIMCallback);
  }
  
  public void setGroupApplicationRead(IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupApplicationListRead(paramIMCallback);
  }
  
  public void setGroupAttributes(String paramString, HashMap<String, String> paramHashMap, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeUpdateGroupAttributes(paramString, paramHashMap, paramIMCallback);
  }
  
  public void setGroupInfo(GroupInfoModifyParam paramGroupInfoModifyParam, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupInfo(paramGroupInfoModifyParam, paramIMCallback);
  }
  
  public void setGroupListener(GroupListener paramGroupListener)
  {
    this.mGroupListener = paramGroupListener;
  }
  
  public void setGroupMemberInfo(GroupMemberInfoModifyParam paramGroupMemberInfoModifyParam, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupMemberInfo(paramGroupMemberInfoModifyParam, paramIMCallback);
  }
  
  public void setGroupMemberRole(String paramString1, String paramString2, int paramInt, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupMemberRole(paramString1, paramString2, paramInt, paramIMCallback);
  }
  
  public void setGroupReceiveMessageOpt(String paramString, int paramInt, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupMessageReceiveOption(paramString, paramInt, paramIMCallback);
  }
  
  public void transferGroupOwner(String paramString1, String paramString2, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetGroupOwner(paramString1, paramString2, paramIMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager
 * JD-Core Version:    0.7.0.1
 */