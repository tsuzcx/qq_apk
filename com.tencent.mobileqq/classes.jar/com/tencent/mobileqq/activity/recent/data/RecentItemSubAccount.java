package com.tencent.mobileqq.activity.recent.data;

import ajed;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import axam;
import babh;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public RecentItemSubAccount(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label172:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      MsgSummary localMsgSummary = a();
      if (!ajed.x.equals(this.mUser.uin)) {
        break;
      }
      this.mTitleName = paramContext.getString(2131653928);
      this.mUnreadNum = 0;
      axam.a(paramQQAppInterface, paramContext, this, localMsgSummary);
      if (!TextUtils.isEmpty(localMsgSummary.strContent)) {
        localMsgSummary.mEmojiFlag = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentItemSubAccount.update mUser.uin=" + this.mUser.uin + " mUser.type=" + this.mUser.getType() + " mUnreadNum=" + this.mUnreadNum + " mUnreadFlag=" + this.mUnreadFlag);
      }
      if (TextUtils.isEmpty(this.mMsgExtroInfo)) {
        break label377;
      }
      this.mExtraInfoColor = paramContext.getResources().getColor(2131101360);
      this.mShowTime = "";
      this.mDisplayTime = a();
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, localMsgSummary);
    } while (!AppSetting.c);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.mTitleName).append(",");
    if (this.mUnreadNum == 0) {}
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      this.mTitleName = babh.c(paramQQAppInterface, this.mUser.uin, true);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = this.mUser.uin;
      }
      this.mTitleName = (paramContext.getString(2131653961) + "（" + this.mTitleName + "）");
      break;
      label377:
      this.mMsgExtroInfo = "";
      this.mExtraInfoColor = 0;
      break label172;
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount
 * JD-Core Version:    0.7.0.1
 */