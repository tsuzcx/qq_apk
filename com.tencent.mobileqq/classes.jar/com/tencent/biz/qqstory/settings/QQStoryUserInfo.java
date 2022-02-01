package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.ChnToSpell;

public class QQStoryUserInfo
  extends Entity
  implements Comparable<QQStoryUserInfo>
{
  public int isAllowed = 0;
  public int isInterested = 0;
  public String mPinying;
  public String nick;
  @unique
  public String uin;
  
  public int compareTo(QQStoryUserInfo paramQQStoryUserInfo)
  {
    if (paramQQStoryUserInfo == null) {
      return 0;
    }
    if ((this.mPinying == null) && (paramQQStoryUserInfo.mPinying == null)) {
      return 0;
    }
    if ((this.mPinying != null) && (paramQQStoryUserInfo.mPinying == null)) {
      return 1;
    }
    String str = this.mPinying;
    if (str == null) {
      return -1;
    }
    return str.compareTo(paramQQStoryUserInfo.mPinying);
  }
  
  public boolean equals(Object paramObject)
  {
    QQStoryUserInfo localQQStoryUserInfo;
    if ((paramObject instanceof QQStoryUserInfo)) {
      localQQStoryUserInfo = (QQStoryUserInfo)paramObject;
    } else {
      localQQStoryUserInfo = null;
    }
    if (paramObject != this)
    {
      paramObject = this.uin;
      if ((paramObject == null) || (localQQStoryUserInfo == null) || (!paramObject.equals(localQQStoryUserInfo.uin))) {
        return false;
      }
    }
    return true;
  }
  
  public void setNick(String paramString)
  {
    this.nick = paramString;
    if (paramString != null)
    {
      this.mPinying = ChnToSpell.b(paramString, 1);
      return;
    }
    this.mPinying = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryUserInfo
 * JD-Core Version:    0.7.0.1
 */