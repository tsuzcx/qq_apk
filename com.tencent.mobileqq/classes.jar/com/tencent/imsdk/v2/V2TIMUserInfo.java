package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.util.HashMap;

public class V2TIMUserInfo
{
  HashMap<String, Object> modifyParams = new HashMap();
  UserInfo userInfo = new UserInfo();
  
  public long getBirthday()
  {
    return this.userInfo.getBirthday();
  }
  
  public String getFaceUrl()
  {
    return this.userInfo.getFaceUrl();
  }
  
  HashMap<String, Object> getModifyParams()
  {
    return this.modifyParams;
  }
  
  public String getNickName()
  {
    return this.userInfo.getNickname();
  }
  
  public String getUserID()
  {
    return this.userInfo.getUserID();
  }
  
  UserInfo getUserInfo()
  {
    return this.userInfo;
  }
  
  public void setBirthday(long paramLong)
  {
    this.userInfo.setBirthday(paramLong);
    this.modifyParams.put("Tag_Profile_IM_BirthDay", Long.valueOf(paramLong));
  }
  
  protected void setFaceUrl(String paramString)
  {
    this.userInfo.setFaceUrl(paramString);
    this.modifyParams.put("Tag_Profile_IM_Image", paramString);
  }
  
  protected void setNickName(String paramString)
  {
    this.userInfo.setNickname(paramString);
    this.modifyParams.put("Tag_Profile_IM_Nick", paramString);
  }
  
  protected void setUserID(String paramString)
  {
    this.userInfo.setUserID(paramString);
  }
  
  void setUserInfo(UserInfo paramUserInfo)
  {
    this.userInfo = paramUserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMUserInfo
 * JD-Core Version:    0.7.0.1
 */