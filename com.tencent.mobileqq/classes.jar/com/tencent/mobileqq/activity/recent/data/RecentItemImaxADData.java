package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemImaxADData
  extends RecentItemChatMsgData
{
  private static final String TAG = "RecentItemImaxADData";
  public String mHeaderUrl;
  
  public RecentItemImaxADData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(this.mUser.uin, this.mUser.getType());
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
    } while (!QLog.isColorLevel());
    QLog.d("RecentItemImaxADData", 2, "mTitleName:" + this.mTitleName + ", mDisplayTime:" + this.mDisplayTime + ", mUnreadNum:" + this.mUnreadNum + ", mUnreadFlag:" + this.mUnreadFlag + ", mShowTime:" + this.mShowTime + ", mStatus:" + this.mStatus + ", mMsgExtroInfo:" + this.mMsgExtroInfo + ", mExtraInfoColor:" + this.mExtraInfoColor + ", mLastMsg:" + this.mLastMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData
 * JD-Core Version:    0.7.0.1
 */