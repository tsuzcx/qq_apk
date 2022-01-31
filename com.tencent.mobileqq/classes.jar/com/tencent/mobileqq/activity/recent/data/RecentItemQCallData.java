package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import bbcz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemQCallData
  extends RecentUserBaseData
{
  public RecentItemQCallData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mTitleName = bbcz.b(paramQQAppInterface, this.mUser.uin, true);
    this.mDisplayTime = this.mUser.lastmsgtime;
    a(paramQQAppInterface, paramContext, this.msgSummary);
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.d)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.mTitleName).append(",");
      if (this.mUnreadNum != 0) {
        break label142;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      label142:
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemQCallData
 * JD-Core Version:    0.7.0.1
 */