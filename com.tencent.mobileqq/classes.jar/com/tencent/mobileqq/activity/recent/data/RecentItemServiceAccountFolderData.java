package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import arry;
import bbav;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import tug;
import tyi;

public class RecentItemServiceAccountFolderData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemServiceAccountFolderData";
  private static int tryResetServiceAccountFolderDeleteFlag;
  public String mReportKeyBytesOacMsgxtend;
  
  public RecentItemServiceAccountFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    boolean bool = tyi.a;
    label35:
    tug localtug;
    if (bool)
    {
      this.mMenuFlag |= 0x1;
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.c() + ", canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag);
      }
      localtug = tug.a();
      this.mTitleName = tug.a(paramQQAppInterface);
      this.mDisplayTime = localtug.a(paramQQAppInterface);
      this.mUnreadNum = localtug.b();
      Manager localManager = paramQQAppInterface.getManager(36);
      if ((localManager instanceof bbav))
      {
        int i = ((bbav)localManager).a("104000.104001", 100);
        if (i > 0) {
          this.mUnreadNum += i;
        }
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.c() + "getSubscribeAccountRedDotNum  numRedNumByAppIdAndMsgType:" + i + "   mUnreadNum: " + this.mUnreadNum);
      }
      if (this.mUnreadNum > 0) {
        break label665;
      }
      if ((!localtug.a()) || (this.mDisplayTime <= localtug.b())) {
        break label657;
      }
      this.mUnreadFlag = 2;
      this.mUnreadNum = 1;
      label253:
      if (this.mDisplayTime == 0L) {
        break label673;
      }
      this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
      label280:
      this.mReportKeyBytesOacMsgxtend = localtug.b();
      this.mLastMsg = localtug.a(paramQQAppInterface);
      if (!localtug.b()) {
        break label686;
      }
      this.mStatus = 4;
      label312:
      if ((this.mUnreadNum <= 0) || (this.mUnreadFlag != 1)) {
        break label694;
      }
      this.mMsgExtroInfo = localtug.c();
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167102);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName).append(",");
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemServiceAccountFolderData", 2, "mTitleName:" + this.mTitleName + ", mDisplayTime:" + this.mDisplayTime + ", mUnreadNum:" + this.mUnreadNum + ", mUnreadFlag:" + this.mUnreadFlag + ", mShowTime:" + this.mShowTime + ", mStatus:" + this.mStatus + ", mMsgExtroInfo:" + this.mMsgExtroInfo + ", mExtraInfoColor:" + this.mExtraInfoColor + ", mLastMsg:" + this.mLastMsg);
      return;
      this.mMenuFlag &= 0xFFFFFFFE;
      if (tryResetServiceAccountFolderDeleteFlag >= 3) {
        break label35;
      }
      QLog.d("RecentItemServiceAccountFolderData", 1, "canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag + " tryResetServiceAccountFolderDeleteFlag = " + tryResetServiceAccountFolderDeleteFlag);
      arry.c(paramQQAppInterface, paramQQAppInterface.c());
      tryResetServiceAccountFolderDeleteFlag += 1;
      break label35;
      label657:
      this.mUnreadFlag = 0;
      break label253;
      label665:
      this.mUnreadFlag = 1;
      break label253;
      label673:
      this.mShowTime = localtug.b(paramQQAppInterface);
      break label280;
      label686:
      this.mStatus = 0;
      break label312;
      label694:
      this.mMsgExtroInfo = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData
 * JD-Core Version:    0.7.0.1
 */