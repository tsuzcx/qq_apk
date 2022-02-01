package com.tencent.imsdk.relationship;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendInfo
{
  private String addSource;
  private long addTime;
  private String addWording;
  private HashMap<String, byte[]> friendCustomInfo = new HashMap();
  private List<String> friendGroups = new ArrayList();
  private int relationType;
  private String remark;
  private UserInfo userInfo = new UserInfo();
  
  protected void addFriendCustomInfo(String paramString, byte[] paramArrayOfByte)
  {
    this.friendCustomInfo.put(paramString, paramArrayOfByte);
  }
  
  protected void addFriendGroup(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.friendGroups.add(paramString);
    }
  }
  
  public String getAddSource()
  {
    return this.addSource;
  }
  
  public long getAddTime()
  {
    return this.addTime;
  }
  
  public String getAddWording()
  {
    return this.addWording;
  }
  
  public HashMap<String, byte[]> getFriendCustomInfo()
  {
    return this.friendCustomInfo;
  }
  
  public List<String> getFriendGroups()
  {
    return this.friendGroups;
  }
  
  public int getRelationType()
  {
    return this.relationType;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public UserInfo getUserInfo()
  {
    return this.userInfo;
  }
  
  public void setAddSource(String paramString)
  {
    this.addSource = paramString;
  }
  
  public void setAddTime(long paramLong)
  {
    this.addTime = paramLong;
  }
  
  public void setAddWording(String paramString)
  {
    this.addWording = paramString;
  }
  
  public void setRelationType(int paramInt)
  {
    this.relationType = paramInt;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  protected void setUserInfo(UserInfo paramUserInfo)
  {
    this.userInfo = paramUserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.FriendInfo
 * JD-Core Version:    0.7.0.1
 */