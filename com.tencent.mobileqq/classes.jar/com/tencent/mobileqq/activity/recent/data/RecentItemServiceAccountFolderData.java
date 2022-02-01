package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;

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
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      boolean bool = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceFolderRedDelete();
      if (bool)
      {
        this.mMenuFlag |= 0x1;
      }
      else
      {
        this.mMenuFlag &= 0xFFFFFFFE;
        if (tryResetServiceAccountFolderDeleteFlag < 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("canDelete:");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(", mMenuFlag:");
          ((StringBuilder)localObject).append(this.mMenuFlag);
          ((StringBuilder)localObject).append(" tryResetServiceAccountFolderDeleteFlag = ");
          ((StringBuilder)localObject).append(tryResetServiceAccountFolderDeleteFlag);
          QLog.d("RecentItemServiceAccountFolderData", 1, ((StringBuilder)localObject).toString());
          ConfigServlet.b(paramQQAppInterface, paramQQAppInterface.getCurrentUin());
          tryResetServiceAccountFolderDeleteFlag += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uin:");
        ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
        ((StringBuilder)localObject).append(", canDelete:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", mMenuFlag:");
        ((StringBuilder)localObject).append(this.mMenuFlag);
        QLog.d("RecentItemServiceAccountFolderData", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = ServiceAccountFolderManager.a();
      this.mTitleName = ServiceAccountFolderManager.a(paramQQAppInterface);
      this.mDisplayTime = ((ServiceAccountFolderManager)localObject).a(paramQQAppInterface);
      this.mUnreadNum = ((ServiceAccountFolderManager)localObject).b();
      int i = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getNumRedNumByPath("104000.104001", 100);
      if (i > 0) {
        this.mUnreadNum += i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin:");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      localStringBuilder.append("getSubscribeAccountRedDotNum  numRedNumByAppIdAndMsgType:");
      localStringBuilder.append(i);
      localStringBuilder.append("   mUnreadNum: ");
      localStringBuilder.append(this.mUnreadNum);
      QLog.d("RecentItemServiceAccountFolderData", 2, localStringBuilder.toString());
      if (this.mUnreadNum <= 0)
      {
        if ((((ServiceAccountFolderManager)localObject).a()) && (this.mDisplayTime > ((ServiceAccountFolderManager)localObject).b()))
        {
          this.mUnreadFlag = 2;
          this.mUnreadNum = 1;
        }
        else
        {
          this.mUnreadFlag = 0;
        }
      }
      else {
        this.mUnreadFlag = 1;
      }
      if (this.mDisplayTime != 0L) {
        this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
      } else {
        this.mShowTime = ((ServiceAccountFolderManager)localObject).b(paramQQAppInterface);
      }
      this.mReportKeyBytesOacMsgxtend = ((ServiceAccountFolderManager)localObject).b();
      this.mLastMsg = ((ServiceAccountFolderManager)localObject).a(paramQQAppInterface);
      if (((ServiceAccountFolderManager)localObject).b()) {
        this.mStatus = 4;
      } else {
        this.mStatus = 0;
      }
      if ((this.mUnreadNum > 0) && (this.mUnreadFlag == 1))
      {
        this.mMsgExtroInfo = ((ServiceAccountFolderManager)localObject).c();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      }
      else
      {
        this.mMsgExtroInfo = "";
      }
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName);
        paramQQAppInterface.append(",");
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
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("mTitleName:");
        paramQQAppInterface.append(this.mTitleName);
        paramQQAppInterface.append(", mDisplayTime:");
        paramQQAppInterface.append(this.mDisplayTime);
        paramQQAppInterface.append(", mUnreadNum:");
        paramQQAppInterface.append(this.mUnreadNum);
        paramQQAppInterface.append(", mUnreadFlag:");
        paramQQAppInterface.append(this.mUnreadFlag);
        paramQQAppInterface.append(", mShowTime:");
        paramQQAppInterface.append(this.mShowTime);
        paramQQAppInterface.append(", mStatus:");
        paramQQAppInterface.append(this.mStatus);
        paramQQAppInterface.append(", mMsgExtroInfo:");
        paramQQAppInterface.append(this.mMsgExtroInfo);
        paramQQAppInterface.append(", mExtraInfoColor:");
        paramQQAppInterface.append(this.mExtraInfoColor);
        paramQQAppInterface.append(", mLastMsg:");
        paramQQAppInterface.append(this.mLastMsg);
        QLog.d("RecentItemServiceAccountFolderData", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData
 * JD-Core Version:    0.7.0.1
 */