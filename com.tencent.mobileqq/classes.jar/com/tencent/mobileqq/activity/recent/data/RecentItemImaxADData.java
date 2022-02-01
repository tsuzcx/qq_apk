package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemImaxADData
  extends RecentItemChatMsgData
{
  private static final String TAG = "RecentItemImaxADData";
  public String mHeaderUrl = null;
  
  public RecentItemImaxADData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
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
          paramContext = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_name");
          if (!TextUtils.isEmpty(paramContext)) {
            this.mTitleName = paramContext;
          }
          paramQQAppInterface = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_uin_head_url");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            this.mHeaderUrl = paramQQAppInterface;
          }
        }
      }
      if (this.mUnreadNum > 0) {
        this.mUnreadNum = 1;
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
        QLog.d("RecentItemImaxADData", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData
 * JD-Core Version:    0.7.0.1
 */