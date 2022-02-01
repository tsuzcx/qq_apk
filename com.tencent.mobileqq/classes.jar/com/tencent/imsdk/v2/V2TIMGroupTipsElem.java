package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class V2TIMGroupTipsElem
  extends V2TIMElem
{
  public static final int GROUP_TIPS_TYPE_INVALID = 0;
  public static final int V2TIM_GROUP_TIPS_TYPE_CANCEL_ADMIN = 6;
  public static final int V2TIM_GROUP_TIPS_TYPE_GROUP_INFO_CHANGE = 7;
  public static final int V2TIM_GROUP_TIPS_TYPE_INVITE = 2;
  public static final int V2TIM_GROUP_TIPS_TYPE_JOIN = 1;
  public static final int V2TIM_GROUP_TIPS_TYPE_KICKED = 4;
  public static final int V2TIM_GROUP_TIPS_TYPE_MEMBER_INFO_CHANGE = 8;
  public static final int V2TIM_GROUP_TIPS_TYPE_QUIT = 3;
  public static final int V2TIM_GROUP_TIPS_TYPE_SET_ADMIN = 5;
  
  private String getGroupType()
  {
    if (getElement() == null) {
      return null;
    }
    return ((GroupTipsElement)getElement()).getGroupType();
  }
  
  public List<V2TIMGroupChangeInfo> getGroupChangeInfoList()
  {
    if (getElement() == null) {
      return null;
    }
    Object localObject = ((GroupTipsElement)getElement()).getGroupInfoChangeItemList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GroupInfoChangeItem localGroupInfoChangeItem = (GroupInfoChangeItem)((Iterator)localObject).next();
      V2TIMGroupChangeInfo localV2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
      localV2TIMGroupChangeInfo.setGroupInfoChangeItem(localGroupInfoChangeItem);
      localArrayList.add(localV2TIMGroupChangeInfo);
    }
    return localArrayList;
  }
  
  public String getGroupID()
  {
    if (getElement() == null) {
      return null;
    }
    return ((GroupTipsElement)getElement()).getGroupID();
  }
  
  public List<V2TIMGroupMemberChangeInfo> getMemberChangeInfoList()
  {
    if (getElement() == null) {
      return null;
    }
    Object localObject = ((GroupTipsElement)getElement()).getGroupMemberInfoChangeItemList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GroupMemberInfoChangeItem localGroupMemberInfoChangeItem = (GroupMemberInfoChangeItem)((Iterator)localObject).next();
      V2TIMGroupMemberChangeInfo localV2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
      localV2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(localGroupMemberInfoChangeItem);
      localArrayList.add(localV2TIMGroupMemberChangeInfo);
    }
    return localArrayList;
  }
  
  public int getMemberCount()
  {
    if (getElement() == null) {
      return 0;
    }
    return ((GroupTipsElement)getElement()).getGroupMemberCount();
  }
  
  public List<V2TIMGroupMemberInfo> getMemberList()
  {
    if (getElement() == null) {
      return null;
    }
    Object localObject1 = (GroupTipsElement)getElement();
    if (localObject1 != null)
    {
      Object localObject3 = ((GroupTipsElement)localObject1).getTargetGroupMemberInfoList();
      Object localObject2 = ((GroupTipsElement)localObject1).getTargetUserInfoList();
      localObject1 = new ArrayList();
      HashMap localHashMap = new HashMap();
      localObject3 = ((List)localObject3).iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (GroupMemberInfo)((Iterator)localObject3).next();
        V2TIMGroupMemberInfo localV2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
        localV2TIMGroupMemberInfo.setGroupMemberInfo((GroupMemberInfo)localObject4);
        localHashMap.put(((GroupMemberInfo)localObject4).getUserID(), localV2TIMGroupMemberInfo);
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (UserInfo)((Iterator)localObject2).next();
        localObject4 = (V2TIMGroupMemberInfo)localHashMap.get(((UserInfo)localObject3).getUserID());
        if (localObject4 != null)
        {
          ((V2TIMGroupMemberInfo)localObject4).setUserInfo((UserInfo)localObject3);
          ((List)localObject1).add(localObject4);
        }
      }
      return localObject1;
    }
    return null;
  }
  
  public V2TIMGroupMemberInfo getOpMember()
  {
    if (getElement() == null) {
      return null;
    }
    Object localObject = (GroupTipsElement)getElement();
    if (localObject != null)
    {
      GroupMemberInfo localGroupMemberInfo = ((GroupTipsElement)localObject).getOperatorGroupMemberInfo();
      localObject = ((GroupTipsElement)localObject).getOperatorUserInfo();
      V2TIMGroupMemberInfo localV2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
      localV2TIMGroupMemberInfo.setGroupMemberInfo(localGroupMemberInfo);
      localV2TIMGroupMemberInfo.setUserInfo((UserInfo)localObject);
      return localV2TIMGroupMemberInfo;
    }
    return null;
  }
  
  public int getType()
  {
    GroupTipsElement localGroupTipsElement = (GroupTipsElement)getElement();
    int i = 0;
    if (localGroupTipsElement == null) {
      return 0;
    }
    int j = localGroupTipsElement.getGroupTipsType();
    if (j == 1)
    {
      if (getGroupType().equals("Private")) {
        return 2;
      }
      return 1;
    }
    if (j == 2) {
      return 3;
    }
    if (j == 3) {
      return 4;
    }
    if (j == 4) {
      return 5;
    }
    if (j == 5) {
      return 6;
    }
    if (j == 6) {
      return 7;
    }
    if (j == 7) {
      i = 8;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject1 = getGroupChangeInfoList().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (V2TIMGroupChangeInfo)((Iterator)localObject1).next();
      localStringBuilder1.append("sub type:");
      localStringBuilder1.append(((V2TIMGroupChangeInfo)localObject2).getType());
      localStringBuilder1.append(", key:");
      localStringBuilder1.append(((V2TIMGroupChangeInfo)localObject2).getKey());
      localStringBuilder1.append(", value:");
      localStringBuilder1.append(((V2TIMGroupChangeInfo)localObject2).getValue());
      localStringBuilder1.append("\n");
    }
    Object localObject2 = new StringBuilder();
    localObject1 = getMemberChangeInfoList().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (V2TIMGroupMemberChangeInfo)((Iterator)localObject1).next();
      ((StringBuilder)localObject2).append("userID:");
      ((StringBuilder)localObject2).append(((V2TIMGroupMemberChangeInfo)localObject3).getUserID());
      ((StringBuilder)localObject2).append(", muteTime:");
      ((StringBuilder)localObject2).append(((V2TIMGroupMemberChangeInfo)localObject3).getMuteTime());
      ((StringBuilder)localObject2).append("\n");
    }
    localObject1 = getMemberList();
    Object localObject3 = new StringBuilder();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((StringBuilder)localObject3).append(((V2TIMGroupMemberInfo)((Iterator)localObject1).next()).toString());
      ((StringBuilder)localObject3).append("\n");
    }
    localObject1 = getOpMember();
    if (localObject1 != null) {
      localObject1 = ((V2TIMGroupMemberInfo)localObject1).toString();
    } else {
      localObject1 = "";
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("V2TIMGroupTipsElem--->");
    localStringBuilder2.append("groupID:");
    localStringBuilder2.append(getGroupID());
    localStringBuilder2.append(", tips type:");
    localStringBuilder2.append(getType());
    localStringBuilder2.append(", memberCount:");
    localStringBuilder2.append(getMemberCount());
    localStringBuilder2.append("\n");
    localStringBuilder2.append(", memberList:");
    localStringBuilder2.append("\n");
    localStringBuilder2.append(((StringBuilder)localObject3).toString());
    localStringBuilder2.append(", groupChangedInfoList:");
    localStringBuilder2.append("\n");
    localStringBuilder2.append(localStringBuilder1.toString());
    localStringBuilder2.append(", memberChangedInfoList:");
    localStringBuilder2.append("\n");
    localStringBuilder2.append(((StringBuilder)localObject2).toString());
    localStringBuilder2.append(", opUser:");
    localStringBuilder2.append((String)localObject1);
    return localStringBuilder2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupTipsElem
 * JD-Core Version:    0.7.0.1
 */