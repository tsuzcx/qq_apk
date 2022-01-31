package com.tencent.mobileqq.activity.recent.data;

import ahpj;
import akbn;
import android.content.Context;
import atza;
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
    akbn localakbn = (akbn)paramQQAppInterface.getManager(34);
    atza localatza = localakbn.a();
    this.mTitleName = paramContext.getString(this.mTilteId);
    if (localatza == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemNewFriendMsgData", 2, "isFirstShow = " + this.isFirstShow);
      }
      this.mLastMsg = "";
      this.mUnreadNum = 0;
      this.mMsgExtroInfo = "";
      this.mDisplayTime = 0L;
      this.mShowTime = "";
      if (AppSetting.d)
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
      if (localatza.a(paramQQAppInterface) != null) {}
      for (paramQQAppInterface = localatza.a(paramQQAppInterface);; paramQQAppInterface = this.mLastMsg)
      {
        this.mLastMsg = paramQQAppInterface;
        this.mUnreadNum = localakbn.d();
        if (this.mDisplayTime < localatza.a) {
          this.mDisplayTime = localatza.a;
        }
        this.mShowTime = ahpj.a().a(a(), this.mDisplayTime);
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