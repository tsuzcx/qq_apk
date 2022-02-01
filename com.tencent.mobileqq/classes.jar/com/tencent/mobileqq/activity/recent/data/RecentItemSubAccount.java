package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public String showSubUin;
  
  public RecentItemSubAccount(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.update(paramBaseQQAppInterface, paramContext);
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      StringBuilder localStringBuilder;
      if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(this.mUser.uin))
      {
        this.mTitleName = paramContext.getString(2131916834);
      }
      else
      {
        this.mTitleName = ((IContactUtils)QRoute.api(IContactUtils.class)).getBuddyNickName(paramBaseQQAppInterface, this.mUser.uin, true);
        if (TextUtils.isEmpty(this.mTitleName)) {
          this.mTitleName = this.mUser.uin;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getString(2131916856));
        localStringBuilder.append("（");
        localStringBuilder.append(this.mTitleName);
        localStringBuilder.append("）");
        this.mTitleName = localStringBuilder.toString();
      }
      this.mUnreadNum = 0;
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setRecentItemSubAccountContentAndUnread(paramBaseQQAppInterface, paramContext, this, localMsgSummary);
      if (!TextUtils.isEmpty(localMsgSummary.strContent)) {
        localMsgSummary.mEmojiFlag = 1;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("RecentItemSubAccount.update mUser.uin=");
        localStringBuilder.append(this.mUser.uin);
        localStringBuilder.append(" mUser.type=");
        localStringBuilder.append(this.mUser.getType());
        localStringBuilder.append(" mUnreadNum=");
        localStringBuilder.append(this.mUnreadNum);
        localStringBuilder.append(" mUnreadFlag=");
        localStringBuilder.append(this.mUnreadFlag);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(this.mMsgExtroInfo))
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
      }
      else
      {
        this.mMsgExtroInfo = "";
        this.mExtraInfoColor = 0;
      }
      this.mShowTime = "";
      this.mDisplayTime = getLastMsgTime();
      dealStatus(paramBaseQQAppInterface);
      extraUpdate(paramBaseQQAppInterface, paramContext, localMsgSummary);
      if (AppSetting.e)
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append(this.mTitleName);
        paramBaseQQAppInterface.append(",");
        if (this.mUnreadNum != 0) {
          if (this.mUnreadNum == 1)
          {
            paramBaseQQAppInterface.append("有一条未读");
          }
          else if (this.mUnreadNum == 2)
          {
            paramBaseQQAppInterface.append("有两条未读");
          }
          else if (this.mUnreadNum > 0)
          {
            paramBaseQQAppInterface.append("有");
            paramBaseQQAppInterface.append(this.mUnreadNum);
            paramBaseQQAppInterface.append("条未读,");
          }
        }
        if (this.mMsgExtroInfo != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mMsgExtroInfo);
          paramContext.append(",");
          paramBaseQQAppInterface.append(paramContext.toString());
        }
        paramBaseQQAppInterface.append(this.mLastMsg);
        paramBaseQQAppInterface.append(",");
        paramBaseQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramBaseQQAppInterface.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount
 * JD-Core Version:    0.7.0.1
 */