package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupInfoModifyParam;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoModifyParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class V2TIMGroupManagerImpl
  extends V2TIMGroupManager
{
  private final String TAG = "V2TIMAdvGroupMgrImpl";
  
  static V2TIMGroupManagerImpl getInstance()
  {
    return V2TIMGroupManagerImpl.V2TIMGroupManagerImplHolder.access$100();
  }
  
  public void acceptGroupApplication(V2TIMGroupApplication paramV2TIMGroupApplication, String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMGroupApplication == null)
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication is null");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "v2TIMGroupApplication is null");
      }
      return;
    }
    GroupManager.getInstance().acceptGroupApplication(paramV2TIMGroupApplication.getGroupApplication(), paramString, new V2TIMGroupManagerImpl.26(this, paramV2TIMCallback));
  }
  
  public void createGroup(V2TIMGroupInfo paramV2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> paramList, V2TIMValueCallback<String> paramV2TIMValueCallback)
  {
    if (paramV2TIMGroupInfo == null)
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "createGroup, null info");
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "info is null");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        V2TIMCreateGroupMemberInfo localV2TIMCreateGroupMemberInfo = (V2TIMCreateGroupMemberInfo)paramList.next();
        GroupMemberInfo localGroupMemberInfo = new GroupMemberInfo();
        localGroupMemberInfo.setUserID(localV2TIMCreateGroupMemberInfo.getUserID());
        localGroupMemberInfo.setRole(localV2TIMCreateGroupMemberInfo.getRole());
        localArrayList.add(localGroupMemberInfo);
      }
    }
    GroupManager.getInstance().createGroup(paramV2TIMGroupInfo.getGroupInfo(), localArrayList, new V2TIMGroupManagerImpl.1(this, paramV2TIMValueCallback));
  }
  
  public void deleteGroupAttributes(String paramString, List<String> paramList, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "deleteGroupAttributes error, groupID is empty");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    GroupManager.getInstance().deleteGroupAttributes(paramString, paramList, new V2TIMGroupManagerImpl.7(this, paramV2TIMCallback));
  }
  
  public void getGroupApplicationList(V2TIMValueCallback<V2TIMGroupApplicationResult> paramV2TIMValueCallback)
  {
    paramV2TIMValueCallback = new V2TIMGroupManagerImpl.24(this, paramV2TIMValueCallback);
    GroupManager.getInstance().getGroupApplicationList(new V2TIMGroupManagerImpl.25(this, paramV2TIMValueCallback));
  }
  
  public void getGroupAttributes(String paramString, List<String> paramList, V2TIMValueCallback<Map<String, String>> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupAttributes error, groupID is empty");
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    GroupManager.getInstance().getGroupAttributes(paramString, paramList, new V2TIMGroupManagerImpl.8(this, paramV2TIMValueCallback));
  }
  
  public void getGroupMemberList(String paramString, int paramInt, long paramLong, V2TIMValueCallback<V2TIMGroupMemberInfoResult> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberList error, groupID is empty");
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    int i = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ALL;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 4) {
          paramInt = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ALL;
        }
      }
    }
    for (;;)
    {
      break;
      paramInt = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_MEMBER;
      continue;
      paramInt = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ADMINISTRATOR;
      continue;
      paramInt = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_OWNER;
    }
    paramV2TIMValueCallback = new V2TIMGroupManagerImpl.10(this, paramV2TIMValueCallback);
    GroupManager.getInstance().getGroupMemberList(paramString, paramInt, paramLong, new V2TIMGroupManagerImpl.11(this, paramV2TIMValueCallback));
  }
  
  public void getGroupMembersInfo(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMGroupManagerImpl.12(this, paramV2TIMValueCallback);
      GroupManager.getInstance().getGroupMembersInfo(paramString, paramList, new V2TIMGroupManagerImpl.13(this, paramV2TIMValueCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupMembersInfo fail, memberList is empty");
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "memberList is empty");
    }
  }
  
  public void getGroupOnlineMemberCount(String paramString, V2TIMValueCallback<Integer> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    GroupManager.getInstance().getGroupOnlineMemberCount(paramString, new V2TIMGroupManagerImpl.9(this, paramV2TIMValueCallback));
  }
  
  public void getGroupsInfo(List<String> paramList, V2TIMValueCallback<List<V2TIMGroupInfoResult>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMGroupManagerImpl.2(this, paramV2TIMValueCallback);
      GroupManager.getInstance().getGroupsInfo(paramList, new V2TIMGroupManagerImpl.3(this, paramV2TIMValueCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupsInfo error, empty groupIDList");
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "empty groupIDList");
    }
  }
  
  public void getJoinedGroupList(V2TIMValueCallback<List<V2TIMGroupInfo>> paramV2TIMValueCallback)
  {
    paramV2TIMValueCallback = new V2TIMGroupManagerImpl.22(this, paramV2TIMValueCallback);
    GroupManager.getInstance().getJoinedGroupList(new V2TIMGroupManagerImpl.23(this, paramV2TIMValueCallback));
  }
  
  public void initGroupAttributes(String paramString, HashMap<String, String> paramHashMap, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "initGroupAttributes error, groupID is empty");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    GroupManager.getInstance().initGroupAttributes(paramString, paramHashMap, new V2TIMGroupManagerImpl.5(this, paramV2TIMCallback));
  }
  
  public void inviteUserToGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> paramV2TIMValueCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramV2TIMValueCallback = new V2TIMGroupManagerImpl.16(this, paramV2TIMValueCallback);
      GroupManager.getInstance().inviteUserToGroup(paramString, paramList, new V2TIMGroupManagerImpl.17(this, paramV2TIMValueCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "inviteUserToGroup error, groupID or userList is empty");
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "groupID or userList is empty");
    }
  }
  
  public void kickGroupMember(String paramString1, List<String> paramList, String paramString2, V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> paramV2TIMValueCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMGroupManagerImpl.18(this, paramV2TIMValueCallback);
      GroupManager.getInstance().kickGroupMember(paramString1, paramList, paramString2, new V2TIMGroupManagerImpl.19(this, paramV2TIMValueCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "kickGroupMember error, groupID or memberList is empty");
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "groupID or memberList is empty");
    }
  }
  
  public void muteGroupMember(String paramString1, String paramString2, int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      GroupManager.getInstance().muteGroupMember(paramString1, paramString2, paramInt, new V2TIMGroupManagerImpl.15(this, paramV2TIMCallback));
      return;
    }
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "groupID or userID is empty");
    }
  }
  
  public void refuseGroupApplication(V2TIMGroupApplication paramV2TIMGroupApplication, String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMGroupApplication == null)
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication is null");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "v2TIMGroupApplication is null");
      }
      return;
    }
    GroupManager.getInstance().refuseGroupApplication(paramV2TIMGroupApplication.getGroupApplication(), paramString, new V2TIMGroupManagerImpl.27(this, paramV2TIMCallback));
  }
  
  public void setGroupApplicationRead(V2TIMCallback paramV2TIMCallback)
  {
    GroupManager.getInstance().setGroupApplicationRead(new V2TIMGroupManagerImpl.28(this, paramV2TIMCallback));
  }
  
  public void setGroupAttributes(String paramString, HashMap<String, String> paramHashMap, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, groupID is empty");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    if ((paramHashMap != null) && (paramHashMap.size() != 0))
    {
      GroupManager.getInstance().setGroupAttributes(paramString, paramHashMap, new V2TIMGroupManagerImpl.6(this, paramV2TIMCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, attributes is empty");
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "attributes is empty");
    }
  }
  
  public void setGroupInfo(V2TIMGroupInfo paramV2TIMGroupInfo, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMGroupInfo == null)
    {
      IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupInfo error, null info");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "null info");
      }
      return;
    }
    long l = paramV2TIMGroupInfo.getModifyFlag();
    paramV2TIMGroupInfo = paramV2TIMGroupInfo.getGroupInfo();
    GroupInfoModifyParam localGroupInfoModifyParam = new GroupInfoModifyParam();
    localGroupInfoModifyParam.setGroupInfo(paramV2TIMGroupInfo);
    localGroupInfoModifyParam.setModifyFlag(l);
    GroupManager.getInstance().setGroupInfo(localGroupInfoModifyParam, new V2TIMGroupManagerImpl.4(this, paramV2TIMCallback));
  }
  
  public void setGroupMemberInfo(String paramString, V2TIMGroupMemberFullInfo paramV2TIMGroupMemberFullInfo, V2TIMCallback paramV2TIMCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramV2TIMGroupMemberFullInfo != null))
    {
      GroupMemberInfoModifyParam localGroupMemberInfoModifyParam = new GroupMemberInfoModifyParam();
      localGroupMemberInfoModifyParam.setModifyFlag(paramV2TIMGroupMemberFullInfo.getModifyFlag());
      localGroupMemberInfoModifyParam.setMemberInfo(paramV2TIMGroupMemberFullInfo.getGroupMemberInfo());
      localGroupMemberInfoModifyParam.getMemberInfo().setGroupID(paramString);
      GroupManager.getInstance().setGroupMemberInfo(localGroupMemberInfoModifyParam, new V2TIMGroupManagerImpl.14(this, paramV2TIMCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberInfo error, groupID is empty or profile is null");
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "groupID is empty or profile is null");
    }
  }
  
  public void setGroupMemberRole(String paramString1, String paramString2, int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      int i = GroupMemberInfo.MEMBER_ROLE_MEMBER;
      if (400 == paramInt) {
        paramInt = GroupMemberInfo.MEMBER_ROLE_OWNER;
      } else if (300 == paramInt) {
        paramInt = GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR;
      } else {
        paramInt = GroupMemberInfo.MEMBER_ROLE_MEMBER;
      }
      GroupManager.getInstance().setGroupMemberRole(paramString1, paramString2, paramInt, new V2TIMGroupManagerImpl.20(this, paramV2TIMCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberRole error, groupID or userID is empty");
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "groupID or userID is empty");
    }
  }
  
  public void transferGroupOwner(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      GroupManager.getInstance().transferGroupOwner(paramString1, paramString2, new V2TIMGroupManagerImpl.21(this, paramV2TIMCallback));
      return;
    }
    IMLog.e("V2TIMAdvGroupMgrImpl", "transferGroupOwner error, groupID or userID is empty");
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "groupID or userID is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupManagerImpl
 * JD-Core Version:    0.7.0.1
 */