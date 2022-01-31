package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import bbkp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemVoteData
  extends RecentUserBaseData
{
  public long time;
  
  public RecentItemVoteData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.d)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        break label102;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      label102:
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.mTitleName = paramString;
    this.time = paramLong;
    this.mShowTime = bbkp.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemVoteData
 * JD-Core Version:    0.7.0.1
 */