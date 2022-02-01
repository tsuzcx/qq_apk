package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentItemQCallData
  extends AbsRecentUserBusinessBaseData
{
  public RecentItemQCallData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
    this.mDisplayTime = this.mUser.lastmsgtime;
    a(paramQQAppInterface, paramContext, this.msgSummary);
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.d)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.mTitleName);
      paramQQAppInterface.append(",");
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
          paramQQAppInterface.append("条未读,");
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
      paramQQAppInterface.append(",");
      paramQQAppInterface.append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemQCallData
 * JD-Core Version:    0.7.0.1
 */