package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V2TIMUserFullInfo
  extends V2TIMUserInfo
{
  public static final String PROFILE_TYPE_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
  public static final String PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
  public static final String PROFILE_TYPE_KEY_FACEURL = "Tag_Profile_IM_Image";
  public static final String PROFILE_TYPE_KEY_GENDER = "Tag_Profile_IM_Gender";
  public static final String PROFILE_TYPE_KEY_NICK = "Tag_Profile_IM_Nick";
  public static final String PROFILE_TYPE_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
  public static final int V2TIM_FRIEND_ALLOW_ANY = 0;
  public static final int V2TIM_FRIEND_DENY_ANY = 2;
  public static final int V2TIM_FRIEND_NEED_CONFIRM = 1;
  public static final int V2TIM_GENDER_FEMALE = 2;
  public static final int V2TIM_GENDER_MALE = 1;
  public static final int V2TIM_GENDER_UNKNOWN = 0;
  
  public int getAllowType()
  {
    int i = this.userInfo.getAllowType();
    if (i == 2) {
      return 2;
    }
    if (i == 1) {
      return 1;
    }
    if (i == 0) {
      return 0;
    }
    return 1;
  }
  
  public HashMap<String, byte[]> getCustomInfo()
  {
    return this.userInfo.getCustomUserInfoString();
  }
  
  public int getGender()
  {
    int i = this.userInfo.getGender();
    if (i == 1) {
      return 1;
    }
    if (i == 2) {
      return 2;
    }
    return 0;
  }
  
  public int getLevel()
  {
    return this.userInfo.getLevel();
  }
  
  public int getRole()
  {
    return this.userInfo.getRole();
  }
  
  public String getSelfSignature()
  {
    return this.userInfo.getSignature();
  }
  
  public void setAllowType(int paramInt)
  {
    if (paramInt == 0)
    {
      this.userInfo.setAllowType(0);
      this.modifyParams.put("Tag_Profile_IM_AllowType", "AllowType_Type_AllowAny");
      return;
    }
    if (2 == paramInt)
    {
      this.userInfo.setAllowType(2);
      this.modifyParams.put("Tag_Profile_IM_AllowType", "AllowType_Type_DenyAny");
      return;
    }
    if (1 == paramInt)
    {
      this.userInfo.setAllowType(1);
      this.modifyParams.put("Tag_Profile_IM_AllowType", "AllowType_Type_NeedConfirm");
      return;
    }
    this.userInfo.setAllowType(1);
    this.modifyParams.put("Tag_Profile_IM_AllowType", "AllowType_Type_NeedConfirm");
  }
  
  public void setCustomInfo(HashMap<String, byte[]> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        if (((String)localEntry.getKey()).contains("Tag_Profile_Custom_"))
        {
          this.modifyParams.put(localEntry.getKey(), localEntry.getValue());
        }
        else
        {
          HashMap localHashMap = this.modifyParams;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Tag_Profile_Custom_");
          localStringBuilder.append((String)localEntry.getKey());
          localHashMap.put(localStringBuilder.toString(), new String((byte[])localEntry.getValue()));
        }
      }
    }
  }
  
  public void setFaceUrl(String paramString)
  {
    super.setFaceUrl(paramString);
  }
  
  public void setGender(int paramInt)
  {
    if (1 == paramInt)
    {
      this.userInfo.setGender(1);
      this.modifyParams.put("Tag_Profile_IM_Gender", "Gender_Type_Male");
      return;
    }
    if (2 == paramInt)
    {
      this.userInfo.setGender(2);
      this.modifyParams.put("Tag_Profile_IM_Gender", "Gender_Type_Female");
      return;
    }
    this.userInfo.setGender(0);
    this.modifyParams.put("Tag_Profile_IM_Gender", "Gender_Type_Unknown");
  }
  
  public void setLevel(int paramInt)
  {
    this.userInfo.setLevel(paramInt);
    this.modifyParams.put("Tag_Profile_IM_Level", Integer.valueOf(paramInt));
  }
  
  public void setNickname(String paramString)
  {
    super.setNickName(paramString);
  }
  
  public void setRole(int paramInt)
  {
    this.userInfo.setRole(paramInt);
    this.modifyParams.put("Tag_Profile_IM_Role", Integer.valueOf(paramInt));
  }
  
  public void setSelfSignature(String paramString)
  {
    this.userInfo.setSignature(paramString);
    this.modifyParams.put("Tag_Profile_IM_SelfSignature", paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("V2TIMUserFullInfo--->");
    Object localObject = getCustomInfo();
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (localObject != null)
    {
      localStringBuilder2.append("\n");
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append(" |key:");
        localStringBuilder3.append((String)localEntry.getKey());
        localStringBuilder3.append(", value:");
        localStringBuilder3.append(new String((byte[])localEntry.getValue()));
        localStringBuilder2.append(localStringBuilder3.toString());
        localStringBuilder2.append("\n");
      }
    }
    localStringBuilder1.append("userID:");
    localStringBuilder1.append(getUserID());
    localStringBuilder1.append(", nickName:");
    localStringBuilder1.append(getNickName());
    localStringBuilder1.append(", gender:");
    localStringBuilder1.append(getGender());
    localStringBuilder1.append(", faceUrl:");
    localStringBuilder1.append(getFaceUrl());
    localStringBuilder1.append(", selfSignature:");
    localStringBuilder1.append(getSelfSignature());
    localStringBuilder1.append(", allowType:");
    localStringBuilder1.append(getAllowType());
    localStringBuilder1.append(", customInfo:");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMUserFullInfo
 * JD-Core Version:    0.7.0.1
 */