package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemMayKnowFriendVerticalListData
  extends RecentUserBaseData
{
  public int age = -1;
  public int gender = -1;
  
  public RecentItemMayKnowFriendVerticalListData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mTitleName = paramRecentUser.displayName;
    if ((paramRecentUser.extraInfo instanceof MayKnowRecommend))
    {
      paramRecentUser = (MayKnowRecommend)paramRecentUser.extraInfo;
      this.mLastMsg = paramRecentUser.recommendReason;
      this.gender = paramRecentUser.gender;
      this.age = paramRecentUser.age;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    paramQQAppInterface = a();
    if (paramQQAppInterface.uin.equals("sp_uin_for_title")) {}
    for (this.mMenuFlag = 0;; this.mMenuFlag = 1)
    {
      if ((paramQQAppInterface.extraInfo instanceof MayKnowRecommend))
      {
        paramQQAppInterface = (MayKnowRecommend)paramQQAppInterface.extraInfo;
        this.mLastMsg = paramQQAppInterface.recommendReason;
        this.gender = paramQQAppInterface.gender;
        this.age = paramQQAppInterface.age;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData
 * JD-Core Version:    0.7.0.1
 */