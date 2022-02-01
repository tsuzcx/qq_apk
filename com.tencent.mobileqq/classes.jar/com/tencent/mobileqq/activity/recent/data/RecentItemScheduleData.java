package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemScheduleData
  extends AbsRecentUserBusinessBaseData
{
  public long time;
  
  public RecentItemScheduleData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.e)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          paramQQAppInterface.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          paramQQAppInterface.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          paramQQAppInterface.append("有");
          paramQQAppInterface.append(this.mUnreadNum);
          paramQQAppInterface.append("条未读");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        paramContext = new StringBuilder();
        paramContext.append(this.mMsgExtroInfo);
        paramContext.append(",");
        paramQQAppInterface.append(paramContext.toString());
      }
      paramQQAppInterface.append(this.mLastMsg);
      paramQQAppInterface.append(' ');
      paramQQAppInterface.append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemScheduleData
 * JD-Core Version:    0.7.0.1
 */