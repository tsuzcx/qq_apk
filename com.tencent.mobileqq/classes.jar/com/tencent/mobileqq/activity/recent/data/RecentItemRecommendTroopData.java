package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemRecommendTroopData
  extends RecentUserBaseData
{
  public RecentItemRecommendTroopData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    if (a().uin.equals("sp_uin_for_title"))
    {
      this.mMenuFlag = 0;
      return;
    }
    this.mMenuFlag = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData
 * JD-Core Version:    0.7.0.1
 */