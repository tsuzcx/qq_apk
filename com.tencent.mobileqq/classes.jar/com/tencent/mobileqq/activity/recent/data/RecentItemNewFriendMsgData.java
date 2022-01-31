package com.tencent.mobileqq.activity.recent.data;

import ahcw;
import ajnf;
import android.content.Context;
import atcu;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNewFriendMsgData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemNewFriendMsgData";
  private boolean isFirstShow = true;
  int mTilteId = 0;
  
  public RecentItemNewFriendMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "RecentItemNewFriendMsgData update");
    }
    super.a(paramQQAppInterface, paramContext);
    ajnf localajnf = (ajnf)paramQQAppInterface.getManager(34);
    atcu localatcu = localajnf.a();
    this.mTitleName = paramContext.getString(this.mTilteId);
    if (localatcu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemNewFriendMsgData", 2, "isFirstShow = " + this.isFirstShow);
      }
      this.mLastMsg = "";
      this.mUnreadNum = 0;
      this.mMsgExtroInfo = "";
      this.mDisplayTime = 0L;
      this.mShowTime = "";
      if (AppSetting.c)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName).append(",");
        if (this.mUnreadNum != 0) {
          break label300;
        }
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
      this.mMsgExtroInfo = "";
      if (localatcu.a(paramQQAppInterface) != null) {}
      for (paramQQAppInterface = localatcu.a(paramQQAppInterface);; paramQQAppInterface = this.mLastMsg)
      {
        this.mLastMsg = paramQQAppInterface;
        this.mUnreadNum = localajnf.d();
        if (this.mDisplayTime < localatcu.a) {
          this.mDisplayTime = localatcu.a;
        }
        this.mShowTime = ahcw.a().a(a(), this.mDisplayTime);
        break;
      }
      label300:
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData
 * JD-Core Version:    0.7.0.1
 */