package com.tencent.imsdk.relationship;

import java.util.HashMap;
import java.util.Map;

public class UserInfo
{
  public static final int USERINFO_ALLOWTYPE_ALLOWANY = 0;
  public static final int USERINFO_ALLOWTYPE_DENYANY = 2;
  public static final int USERINFO_ALLOWTYPE_NEEDCONFIRM = 1;
  public static final String USERINFO_ALLOWTYPE_TYPE_ALLOWANY = "AllowType_Type_AllowAny";
  public static final String USERINFO_ALLOWTYPE_TYPE_DENYANY = "AllowType_Type_DenyAny";
  public static final String USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM = "AllowType_Type_NeedConfirm";
  public static final int USERINFO_GENDER_FEMALE = 2;
  public static final int USERINFO_GENDER_MALE = 1;
  public static final String USERINFO_GENDER_TYPE_FEMALE = "Gender_Type_Female";
  public static final String USERINFO_GENDER_TYPE_MALE = "Gender_Type_Male";
  public static final String USERINFO_GENDER_TYPE_UNKNOWN = "Gender_Type_Unknown";
  public static final int USERINFO_GENDER_UNKNOWN = 0;
  public static final String USERINFO_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
  public static final String USERINFO_KEY_BIRTHDAY = "Tag_Profile_IM_BirthDay";
  public static final String USERINFO_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
  public static final String USERINFO_KEY_FACEURL = "Tag_Profile_IM_Image";
  public static final String USERINFO_KEY_GENDER = "Tag_Profile_IM_Gender";
  public static final String USERINFO_KEY_LEVEL = "Tag_Profile_IM_Level";
  public static final String USERINFO_KEY_NICK = "Tag_Profile_IM_Nick";
  public static final String USERINFO_KEY_ROLE = "Tag_Profile_IM_Role";
  public static final String USERINFO_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
  public static final int USER_NOT_RECEIVE_MESSAGE_NATIVE = 2;
  public static final int USER_RECEIVE_MESSAGE_NATIVE = 1;
  public static final int USER_RECEIVE_NOT_NOTIFY_MESSAGE_NATIVE = 3;
  private int allowType;
  private long birthday;
  private HashMap<String, Long> customUserInfoNumber = new HashMap();
  private HashMap<String, byte[]> customUserInfoString = new HashMap();
  private String faceUrl;
  private int gender;
  private long language;
  private int level;
  private String location;
  private String nickname;
  private int role;
  private String signature;
  private String userID;
  
  protected void addCustomUserInfoBytes(String paramString, byte[] paramArrayOfByte)
  {
    this.customUserInfoString.put(paramString, paramArrayOfByte);
  }
  
  protected void addCustomUserInfoNumber(String paramString, long paramLong)
  {
    this.customUserInfoNumber.put(paramString, Long.valueOf(paramLong));
  }
  
  public int getAllowType()
  {
    return this.allowType;
  }
  
  public long getBirthday()
  {
    return this.birthday;
  }
  
  public Map<String, Long> getCustomUserInfoNumber()
  {
    return this.customUserInfoNumber;
  }
  
  public HashMap<String, byte[]> getCustomUserInfoString()
  {
    return this.customUserInfoString;
  }
  
  public String getFaceUrl()
  {
    return this.faceUrl;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public long getLanguage()
  {
    return this.language;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public int getRole()
  {
    return this.role;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
  
  public void setAllowType(int paramInt)
  {
    this.allowType = paramInt;
  }
  
  public void setBirthday(long paramLong)
  {
    this.birthday = paramLong;
  }
  
  public void setFaceUrl(String paramString)
  {
    this.faceUrl = paramString;
  }
  
  public void setGender(int paramInt)
  {
    this.gender = paramInt;
  }
  
  public void setLanguage(long paramLong)
  {
    this.language = paramLong;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }
  
  public void setSignature(String paramString)
  {
    this.signature = paramString;
  }
  
  public void setUserID(String paramString)
  {
    this.userID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.UserInfo
 * JD-Core Version:    0.7.0.1
 */