package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemAppletsFolderData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemAppletsFolderData";
  public String iconUrl;
  public String iconUrlSimple;
  
  public RecentItemAppletsFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mTitleName:");
      localStringBuilder.append(this.mTitleName);
      localStringBuilder.append(", mDisplayTime:");
      localStringBuilder.append(this.mDisplayTime);
      localStringBuilder.append(", mUnreadNum:");
      localStringBuilder.append(this.mUnreadNum);
      localStringBuilder.append(", mUnreadFlag:");
      localStringBuilder.append(this.mUnreadFlag);
      localStringBuilder.append(", mShowTime:");
      localStringBuilder.append(this.mShowTime);
      localStringBuilder.append(", mStatus:");
      localStringBuilder.append(this.mStatus);
      localStringBuilder.append(", mMsgExtroInfo:");
      localStringBuilder.append(this.mMsgExtroInfo);
      localStringBuilder.append(", mExtraInfoColor:");
      localStringBuilder.append(this.mExtraInfoColor);
      localStringBuilder.append(", mLastMsg:");
      localStringBuilder.append(this.mLastMsg);
      localStringBuilder.append(", iconUrl:");
      boolean bool;
      if (this.iconUrl != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("RecentItemAppletsFolderData", 2, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Message localMessage;
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = ContactUtils.d(paramQQAppInterface, this.mUser.uin);
      }
      localMessage = null;
      localObject1 = paramQQAppInterface.getMessageFacade();
      if (localObject1 != null) {
        localMessage = ((QQMessageFacade)localObject1).getLastMessage(this.mUser.uin, this.mUser.getType());
      }
      localObject1 = (AppletsFolderManager)paramQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
      if (!RecentParcelUtil.a(paramQQAppInterface)) {}
    }
    try
    {
      ((AppletsFolderManager)localObject1).a();
    }
    catch (Throwable localThrowable)
    {
      label100:
      Object localObject2;
      StringBuilder localStringBuilder;
      break label100;
    }
    localObject2 = ((AppletsFolderManager)localObject1).a(this.mUser.uin);
    if (localObject2 != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("account not null nick:");
      localStringBuilder.append(((AppletsAccountInfo)localObject2).nick);
      QLog.d("RecentItemAppletsFolderData", 2, localStringBuilder.toString());
      this.mTitleName = ((AppletsAccountInfo)localObject2).nick;
      this.iconUrl = ((AppletsAccountInfo)localObject2).faceUrl;
      this.iconUrlSimple = ((AppletsAccountInfo)localObject2).faceUrlSimple;
    }
    else
    {
      QLog.d("RecentItemAppletsFolderData", 2, "account is null");
    }
    if (localMessage != null)
    {
      localObject2 = paramQQAppInterface.getConversationFacade();
      if (localObject2 != null) {
        this.mUnreadNum = ((ConversationFacade)localObject2).a(localMessage.frienduin, this.mUser.getType());
      } else {
        this.mUnreadNum = 0;
      }
      if (((AppletsFolderManager)localObject1).a(localMessage, this.mUser) == 2) {
        this.mUnreadFlag = 1;
      } else {
        this.mUnreadFlag = 2;
      }
      this.mDisplayTime = getLastMsgTime();
    }
    else
    {
      this.mDisplayTime = 0L;
      this.mUnreadNum = 0;
    }
    Object localObject1 = getMsgSummaryTemp();
    a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject1);
    this.mShowTime = TimeManager.a().a(this.mUser.uin, this.mUser.lastmsgtime);
    this.mLastMsg = ((MsgSummary)localObject1).strContent;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData
 * JD-Core Version:    0.7.0.1
 */