package com.tencent.mobileqq.activity.recent.data;

import ajgs;
import altc;
import android.content.Context;
import avqe;
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
    altc localaltc = (altc)paramQQAppInterface.getManager(34);
    avqe localavqe = localaltc.a();
    this.mTitleName = paramContext.getString(this.mTilteId);
    if (localavqe == null)
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
      if (localavqe.a(paramQQAppInterface) != null) {}
      for (paramQQAppInterface = localavqe.a(paramQQAppInterface);; paramQQAppInterface = this.mLastMsg)
      {
        this.mLastMsg = paramQQAppInterface;
        this.mUnreadNum = localaltc.d();
        if (this.mDisplayTime < localavqe.a) {
          this.mDisplayTime = localavqe.a;
        }
        this.mShowTime = ajgs.a().a(a(), this.mDisplayTime);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData
 * JD-Core Version:    0.7.0.1
 */