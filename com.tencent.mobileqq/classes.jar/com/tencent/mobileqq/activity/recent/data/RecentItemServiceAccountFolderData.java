package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import arph;
import bbbq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import uot;
import usu;

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
    boolean bool = usu.a;
    label35:
    uot localuot;
    if (bool)
    {
      this.mMenuFlag |= 0x1;
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.getCurrentUin() + ", canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag);
      }
      localuot = uot.a();
      this.mTitleName = uot.a(paramQQAppInterface);
      this.mDisplayTime = localuot.a(paramQQAppInterface);
      this.mUnreadNum = localuot.b();
      Manager localManager = paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if ((localManager instanceof bbbq))
      {
        int i = ((bbbq)localManager).a("104000.104001", 100);
        if (i > 0) {
          this.mUnreadNum += i;
        }
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.getCurrentUin() + "getSubscribeAccountRedDotNum  numRedNumByAppIdAndMsgType:" + i + "   mUnreadNum: " + this.mUnreadNum);
      }
      if (this.mUnreadNum > 0) {
        break label666;
      }
      if ((!localuot.a()) || (this.mDisplayTime <= localuot.b())) {
        break label658;
      }
      this.mUnreadFlag = 2;
      this.mUnreadNum = 1;
      label254:
      if (this.mDisplayTime == 0L) {
        break label674;
      }
      this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
      label281:
      this.mReportKeyBytesOacMsgxtend = localuot.b();
      this.mLastMsg = localuot.a(paramQQAppInterface);
      if (!localuot.b()) {
        break label687;
      }
      this.mStatus = 4;
      label313:
      if ((this.mUnreadNum <= 0) || (this.mUnreadFlag != 1)) {
        break label695;
      }
      this.mMsgExtroInfo = localuot.c();
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
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
      arph.c(paramQQAppInterface, paramQQAppInterface.getCurrentUin());
      tryResetServiceAccountFolderDeleteFlag += 1;
      break label35;
      label658:
      this.mUnreadFlag = 0;
      break label254;
      label666:
      this.mUnreadFlag = 1;
      break label254;
      label674:
      this.mShowTime = localuot.b(paramQQAppInterface);
      break label281;
      label687:
      this.mStatus = 0;
      break label313;
      label695:
      this.mMsgExtroInfo = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData
 * JD-Core Version:    0.7.0.1
 */