package com.tencent.mobileqq.activity.recent.data;

import afax;
import ahpj;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import axqy;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class SendBlessRecentItemData
  extends RecentUserBaseData
{
  public SendBlessRecentItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    afax localafax = (afax)paramQQAppInterface.getManager(138);
    BlessTask localBlessTask = localafax.a();
    int i;
    if (!localafax.h())
    {
      this.mTitleName = paramContext.getResources().getString(2131690531);
      if (localBlessTask != null) {
        this.mTitleName = localBlessTask.starWord;
      }
      this.mLastMsg = localafax.b();
      this.mMsgExtroInfo = "";
      if (QLog.isColorLevel()) {
        QLog.d("SendBlessRecentItemData", 2, "not isVideoNeedToPlay");
      }
      axqy.b(paramQQAppInterface, "CliOper", "", "", "0X800618A", "0X800618A", 0, 0, "", "", "", "");
      if (localafax.a() < 0) {
        break label490;
      }
      if (localafax.a() != 0) {
        break label485;
      }
      i = 2;
      label131:
      this.mUnreadFlag = i;
    }
    label332:
    label485:
    label490:
    for (this.mUnreadNum = 1;; this.mUnreadNum = 0)
    {
      this.mDisplayTime = this.mUser.lastmsgtime;
      if (this.mDisplayTime > 0L) {
        this.mShowTime = ahpj.a().a(a(), this.mDisplayTime);
      }
      localafax.f();
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.mTitleName);
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append("有一条未读");
        }
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
      return;
      if (localBlessTask == null) {
        break;
      }
      this.mTitleName = localBlessTask.starWord;
      this.mLastMsg = localBlessTask.starBless;
      this.mMsgExtroInfo = localBlessTask.ex2;
      boolean bool;
      if (localBlessTask.ex3 == 1)
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("SendBlessRecentItemData", 2, "useHint: " + bool);
        }
        if ((!bool) || (TextUtils.isEmpty(localafax.b()))) {
          break label428;
        }
        this.mLastMsg = localafax.b();
        this.mMsgExtroInfo = "";
      }
      for (;;)
      {
        axqy.b(paramQQAppInterface, "CliOper", "", "", "0X800632B", "0X800632B", 0, 0, "", "", "", "");
        break;
        bool = false;
        break label332;
        if (!TextUtils.isEmpty(this.mMsgExtroInfo))
        {
          this.mMsgExtroInfo = ("[" + this.mMsgExtroInfo + "] ");
          this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
        }
      }
      i = 1;
      break label131;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData
 * JD-Core Version:    0.7.0.1
 */