package com.tencent.imsdk.relationship;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class FriendGroup
{
  private String groupName;
  private int userCount;
  private List<String> userIDList = new ArrayList();
  
  protected void addUserID(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.userIDList.add(paramString);
    }
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public int getUserCount()
  {
    return this.userCount;
  }
  
  public List<String> getUserIDList()
  {
    return this.userIDList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.FriendGroup
 * JD-Core Version:    0.7.0.1
 */