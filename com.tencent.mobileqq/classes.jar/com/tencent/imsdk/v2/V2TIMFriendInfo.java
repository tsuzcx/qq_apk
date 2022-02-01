package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class V2TIMFriendInfo
{
  private static final String FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_SNS_Custom_";
  private static final String FRIEND_PROFILE_TYPE_KEY_REMARK = "Tag_SNS_IM_Remark";
  public static final int V2TIM_FRIEND_TYPE_BOTH = 2;
  public static final int V2TIM_FRIEND_TYPE_SINGLE = 1;
  private FriendInfo friendInfo = new FriendInfo();
  private HashMap<String, Object> modifyFriendProfileHashMap = new HashMap();
  
  public HashMap<String, byte[]> getFriendCustomInfo()
  {
    return this.friendInfo.getFriendCustomInfo();
  }
  
  public List<String> getFriendGroups()
  {
    return this.friendInfo.getFriendGroups();
  }
  
  public String getFriendRemark()
  {
    return this.friendInfo.getRemark();
  }
  
  HashMap<String, Object> getModifyFriendInfo()
  {
    return this.modifyFriendProfileHashMap;
  }
  
  public String getUserID()
  {
    return this.friendInfo.getUserInfo().getUserID();
  }
  
  public V2TIMUserFullInfo getUserProfile()
  {
    UserInfo localUserInfo = this.friendInfo.getUserInfo();
    V2TIMUserFullInfo localV2TIMUserFullInfo = new V2TIMUserFullInfo();
    localV2TIMUserFullInfo.setUserInfo(localUserInfo);
    return localV2TIMUserFullInfo;
  }
  
  public void setFriendCustomInfo(HashMap<String, byte[]> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      if (this.modifyFriendProfileHashMap == null) {
        this.modifyFriendProfileHashMap = new HashMap();
      }
      if (paramHashMap.entrySet() != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramHashMap.next();
          if (((String)localEntry.getKey()).contains("Tag_SNS_Custom_"))
          {
            this.modifyFriendProfileHashMap.put(localEntry.getKey(), new String((byte[])localEntry.getValue()));
          }
          else
          {
            HashMap localHashMap = this.modifyFriendProfileHashMap;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Tag_SNS_Custom_");
            localStringBuilder.append((String)localEntry.getKey());
            localHashMap.put(localStringBuilder.toString(), new String((byte[])localEntry.getValue()));
          }
        }
      }
    }
  }
  
  protected void setFriendInfo(FriendInfo paramFriendInfo)
  {
    this.friendInfo = paramFriendInfo;
  }
  
  public void setFriendRemark(String paramString)
  {
    this.friendInfo.setRemark(paramString);
    this.modifyFriendProfileHashMap.put("Tag_SNS_IM_Remark", paramString);
  }
  
  public void setUserID(String paramString)
  {
    this.friendInfo.getUserInfo().setUserID(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("V2TIMFriendProfile--->");
    Object localObject2 = getFriendCustomInfo();
    Object localObject1 = new StringBuilder();
    if (localObject2 != null)
    {
      ((StringBuilder)localObject1).append("\n");
      localObject2 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" |key:");
        localStringBuilder2.append((String)localEntry.getKey());
        localStringBuilder2.append(", value:");
        localStringBuilder2.append(new String((byte[])localEntry.getValue()));
        ((StringBuilder)localObject1).append(localStringBuilder2.toString());
        ((StringBuilder)localObject1).append("\n");
      }
    }
    localStringBuilder1.append("userID:");
    localStringBuilder1.append(getUserID());
    localStringBuilder1.append(", remark:");
    localStringBuilder1.append(getFriendRemark());
    localStringBuilder1.append(", groupNames:");
    localStringBuilder1.append(getFriendGroups());
    localStringBuilder1.append(", friendCustomInfo:");
    localStringBuilder1.append(((StringBuilder)localObject1).toString());
    localStringBuilder1.append(", userProfile:");
    if (getUserProfile() == null) {
      localObject1 = "";
    } else {
      localObject1 = getUserProfile().toString();
    }
    localStringBuilder1.append((String)localObject1);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendInfo
 * JD-Core Version:    0.7.0.1
 */