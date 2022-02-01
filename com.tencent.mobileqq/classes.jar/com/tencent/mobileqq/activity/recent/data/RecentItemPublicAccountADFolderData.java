package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class RecentItemPublicAccountADFolderData
  extends RecentItemPublicAccountChatMsgData
{
  private static final String TAG = "RecentItemPublicAccountADFolderData";
  public String trueUin = "";
  
  public RecentItemPublicAccountADFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
    this.trueUin = AdvertisementRecentUserManager.a().c(paramRecentUser.uin);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getLastMessage(this.mUser.uin, this.mUser.getType());
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_uin");
          paramQQAppInterface = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_name");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            this.mTitleName = paramQQAppInterface;
          }
        }
      }
      if (this.mUnreadNum > 0) {
        this.mUnreadNum = 1;
      }
      if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedspots()) {
        this.mMenuFlag |= 0x1;
      } else {
        this.mMenuFlag &= 0xFFFFFFFE;
      }
      if (AppSetting.e)
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
        QLog.d("RecentItemPublicAccountADFolderData", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData
 * JD-Core Version:    0.7.0.1
 */