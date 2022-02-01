package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class SendBlessRecentItemData
  extends AbsRecentUserBusinessBaseData
{
  public SendBlessRecentItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    BlessManager localBlessManager = (BlessManager)paramQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
    Object localObject = localBlessManager.a();
    if (!localBlessManager.h())
    {
      this.mTitleName = paramContext.getResources().getString(2131690683);
      if (localObject != null) {
        this.mTitleName = ((BlessTask)localObject).starWord;
      }
      this.mLastMsg = localBlessManager.b();
      this.mMsgExtroInfo = "";
      if (QLog.isColorLevel()) {
        QLog.d("SendBlessRecentItemData", 2, "not isVideoNeedToPlay");
      }
    }
    else if (localObject != null)
    {
      this.mTitleName = ((BlessTask)localObject).starWord;
      this.mLastMsg = ((BlessTask)localObject).starBless;
      this.mMsgExtroInfo = ((BlessTask)localObject).ex2;
      boolean bool;
      if (((BlessTask)localObject).ex3 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("useHint: ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("SendBlessRecentItemData", 2, ((StringBuilder)localObject).toString());
      }
      if ((bool) && (!TextUtils.isEmpty(localBlessManager.b())))
      {
        this.mLastMsg = localBlessManager.b();
        this.mMsgExtroInfo = "";
      }
      else if (!TextUtils.isEmpty(this.mMsgExtroInfo))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.mMsgExtroInfo);
        ((StringBuilder)localObject).append("] ");
        this.mMsgExtroInfo = ((StringBuilder)localObject).toString();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800632B", "0X800632B", 0, 0, "", "", "", "");
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800618A", "0X800618A", 0, 0, "", "", "", "");
    if (localBlessManager.a() >= 0)
    {
      int i;
      if (localBlessManager.a() == 0) {
        i = 2;
      } else {
        i = 1;
      }
      this.mUnreadFlag = i;
      this.mUnreadNum = 1;
    }
    else
    {
      this.mUnreadNum = 0;
    }
    this.mDisplayTime = this.mUser.lastmsgtime;
    if (this.mDisplayTime > 0L) {
      this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
    }
    localBlessManager.f();
    if (AppSetting.d)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.mTitleName);
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData
 * JD-Core Version:    0.7.0.1
 */