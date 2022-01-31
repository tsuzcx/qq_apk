package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemMayKnowFriendData
  extends RecentUserBaseData
{
  public String curUin;
  
  public RecentItemMayKnowFriendData(RecentUser paramRecentUser, String paramString)
  {
    super(paramRecentUser);
    this.curUin = paramString;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    this.mMenuFlag = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData
 * JD-Core Version:    0.7.0.1
 */