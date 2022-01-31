package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.ChnToSpell;

public class QQStoryUserInfo
  extends Entity
  implements Comparable
{
  public int isAllowed;
  public int isInterested;
  public String mPinying;
  public String nick;
  @unique
  public String uin;
  
  public int compareTo(QQStoryUserInfo paramQQStoryUserInfo)
  {
    if (paramQQStoryUserInfo == null) {}
    while ((this.mPinying == null) && (paramQQStoryUserInfo.mPinying == null)) {
      return 0;
    }
    if ((this.mPinying != null) && (paramQQStoryUserInfo.mPinying == null)) {
      return 1;
    }
    if (this.mPinying == null) {
      return -1;
    }
    return this.mPinying.compareTo(paramQQStoryUserInfo.mPinying);
  }
  
  public boolean equals(Object paramObject)
  {
    QQStoryUserInfo localQQStoryUserInfo = null;
    if ((paramObject instanceof QQStoryUserInfo)) {
      localQQStoryUserInfo = (QQStoryUserInfo)paramObject;
    }
    return (paramObject == this) || ((this.uin != null) && (localQQStoryUserInfo != null) && (this.uin.equals(localQQStoryUserInfo.uin)));
  }
  
  public void setNick(String paramString)
  {
    this.nick = paramString;
    if (paramString != null)
    {
      this.mPinying = ChnToSpell.a(paramString, 1);
      return;
    }
    this.mPinying = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryUserInfo
 * JD-Core Version:    0.7.0.1
 */