package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class V2TIMManagerImpl$18
  extends GroupListener
{
  V2TIMManagerImpl$18(V2TIMManagerImpl paramV2TIMManagerImpl) {}
  
  V2TIMGroupMemberInfo convertToV2GroupMemberInfo(GroupMemberInfo paramGroupMemberInfo)
  {
    V2TIMGroupMemberInfo localV2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
    if (paramGroupMemberInfo != null) {
      localV2TIMGroupMemberInfo.setGroupMemberInfo(paramGroupMemberInfo);
    }
    return localV2TIMGroupMemberInfo;
  }
  
  List<V2TIMGroupMemberInfo> convertToV2GroupMemberInfoList(List<GroupMemberInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(convertToV2GroupMemberInfo((GroupMemberInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public void onApplicationProcessed(String paramString1, GroupMemberInfo paramGroupMemberInfo, boolean paramBoolean, String paramString2)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onApplicationProcessed(paramString1, convertToV2GroupMemberInfo(paramGroupMemberInfo), paramBoolean, paramString2);
    }
  }
  
  public void onGrantAdministrator(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onGrantAdministrator(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo), convertToV2GroupMemberInfoList(paramList));
    }
  }
  
  public void onGroupAttributeChanged(String paramString, Map<String, String> paramMap)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onGroupAttributeChanged(paramString, paramMap);
    }
  }
  
  public void onGroupCreated(String paramString)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onGroupCreated(paramString);
    }
  }
  
  public void onGroupDismissed(String paramString, GroupMemberInfo paramGroupMemberInfo)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onGroupDismissed(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo));
    }
  }
  
  public void onGroupInfoChanged(String paramString, List<GroupInfoChangeItem> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupInfoChangeItem localGroupInfoChangeItem = (GroupInfoChangeItem)paramList.next();
        V2TIMGroupChangeInfo localV2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
        localV2TIMGroupChangeInfo.setGroupInfoChangeItem(localGroupInfoChangeItem);
        localArrayList.add(localV2TIMGroupChangeInfo);
      }
      V2TIMManagerImpl.access$300(this.this$0).onGroupInfoChanged(paramString, localArrayList);
    }
  }
  
  public void onGroupRecycled(String paramString, GroupMemberInfo paramGroupMemberInfo)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onGroupRecycled(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo));
    }
  }
  
  public void onMemberEnter(String paramString, List<GroupMemberInfo> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onMemberEnter(paramString, convertToV2GroupMemberInfoList(paramList));
    }
  }
  
  public void onMemberInfoChanged(String paramString, List<GroupMemberInfoChangeItem> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupMemberInfoChangeItem localGroupMemberInfoChangeItem = (GroupMemberInfoChangeItem)paramList.next();
        V2TIMGroupMemberChangeInfo localV2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
        localV2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(localGroupMemberInfoChangeItem);
        localArrayList.add(localV2TIMGroupMemberChangeInfo);
      }
      V2TIMManagerImpl.access$300(this.this$0).onMemberInfoChanged(paramString, localArrayList);
    }
  }
  
  public void onMemberInvited(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onMemberInvited(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo), convertToV2GroupMemberInfoList(paramList));
    }
  }
  
  public void onMemberKicked(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onMemberKicked(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo), convertToV2GroupMemberInfoList(paramList));
    }
  }
  
  public void onMemberLeave(String paramString, GroupMemberInfo paramGroupMemberInfo)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onMemberLeave(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo));
    }
  }
  
  public void onQuitFromGroup(String paramString)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onQuitFromGroup(paramString);
    }
  }
  
  public void onReceiveJoinApplication(String paramString1, GroupMemberInfo paramGroupMemberInfo, String paramString2)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onReceiveJoinApplication(paramString1, convertToV2GroupMemberInfo(paramGroupMemberInfo), paramString2);
    }
  }
  
  public void onReceiveRESTCustomData(String paramString, byte[] paramArrayOfByte)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onReceiveRESTCustomData(paramString, paramArrayOfByte);
    }
  }
  
  public void onRevokeAdministrator(String paramString, GroupMemberInfo paramGroupMemberInfo, List<GroupMemberInfo> paramList)
  {
    if (V2TIMManagerImpl.access$300(this.this$0) != null) {
      V2TIMManagerImpl.access$300(this.this$0).onRevokeAdministrator(paramString, convertToV2GroupMemberInfo(paramGroupMemberInfo), convertToV2GroupMemberInfoList(paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.18
 * JD-Core Version:    0.7.0.1
 */