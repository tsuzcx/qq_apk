package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class RecentItemServiceAccountFolderData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemServiceAccountFolderData";
  private static int tryResetServiceAccountFolderDeleteFlag = 0;
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
    boolean bool = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete();
    label45:
    ServiceAccountFolderManager localServiceAccountFolderManager;
    if (bool)
    {
      this.mMenuFlag |= 0x1;
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.getCurrentUin() + ", canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag);
      }
      localServiceAccountFolderManager = ServiceAccountFolderManager.a();
      this.mTitleName = ServiceAccountFolderManager.a(paramQQAppInterface);
      this.mDisplayTime = localServiceAccountFolderManager.a(paramQQAppInterface);
      this.mUnreadNum = localServiceAccountFolderManager.b();
      Manager localManager = paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if ((localManager instanceof RedTouchManager))
      {
        int i = ((RedTouchManager)localManager).a("104000.104001", 100);
        if (i > 0) {
          this.mUnreadNum += i;
        }
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.getCurrentUin() + "getSubscribeAccountRedDotNum  numRedNumByAppIdAndMsgType:" + i + "   mUnreadNum: " + this.mUnreadNum);
      }
      if (this.mUnreadNum > 0) {
        break label676;
      }
      if ((!localServiceAccountFolderManager.a()) || (this.mDisplayTime <= localServiceAccountFolderManager.b())) {
        break label668;
      }
      this.mUnreadFlag = 2;
      this.mUnreadNum = 1;
      label264:
      if (this.mDisplayTime == 0L) {
        break label684;
      }
      this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
      label291:
      this.mReportKeyBytesOacMsgxtend = localServiceAccountFolderManager.b();
      this.mLastMsg = localServiceAccountFolderManager.a(paramQQAppInterface);
      if (!localServiceAccountFolderManager.b()) {
        break label697;
      }
      this.mStatus = 4;
      label323:
      if ((this.mUnreadNum <= 0) || (this.mUnreadFlag != 1)) {
        break label705;
      }
      this.mMsgExtroInfo = localServiceAccountFolderManager.c();
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
    }
    for (;;)
    {
      if (AppSetting.d)
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
        break label45;
      }
      QLog.d("RecentItemServiceAccountFolderData", 1, "canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag + " tryResetServiceAccountFolderDeleteFlag = " + tryResetServiceAccountFolderDeleteFlag);
      ConfigServlet.c(paramQQAppInterface, paramQQAppInterface.getCurrentUin());
      tryResetServiceAccountFolderDeleteFlag += 1;
      break label45;
      label668:
      this.mUnreadFlag = 0;
      break label264;
      label676:
      this.mUnreadFlag = 1;
      break label264;
      label684:
      this.mShowTime = localServiceAccountFolderManager.b(paramQQAppInterface);
      break label291;
      label697:
      this.mStatus = 0;
      break label323;
      label705:
      this.mMsgExtroInfo = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData
 * JD-Core Version:    0.7.0.1
 */