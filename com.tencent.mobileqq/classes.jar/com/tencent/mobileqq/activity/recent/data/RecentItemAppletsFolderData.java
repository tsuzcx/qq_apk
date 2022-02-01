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
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = localStringBuilder1.append("mTitleName:").append(this.mTitleName).append(", mDisplayTime:").append(this.mDisplayTime).append(", mUnreadNum:").append(this.mUnreadNum).append(", mUnreadFlag:").append(this.mUnreadFlag).append(", mShowTime:").append(this.mShowTime).append(", mStatus:").append(this.mStatus).append(", mMsgExtroInfo:").append(this.mMsgExtroInfo).append(", mExtraInfoColor:").append(this.mExtraInfoColor).append(", mLastMsg:").append(this.mLastMsg).append(", iconUrl:");
      if (this.iconUrl == null) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      localStringBuilder2.append(bool);
      QLog.d("RecentItemAppletsFolderData", 2, localStringBuilder1.toString());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = ContactUtils.j(paramQQAppInterface, this.mUser.uin);
    }
    Message localMessage = null;
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());
    }
    localObject1 = (AppletsFolderManager)paramQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
    if (RecentParcelUtil.a(paramQQAppInterface)) {}
    try
    {
      ((AppletsFolderManager)localObject1).a();
      label97:
      Object localObject2 = ((AppletsFolderManager)localObject1).a(this.mUser.uin);
      if (localObject2 != null)
      {
        QLog.d("RecentItemAppletsFolderData", 2, "account not null nick:" + ((AppletsAccountInfo)localObject2).nick);
        this.mTitleName = ((AppletsAccountInfo)localObject2).nick;
        this.iconUrl = ((AppletsAccountInfo)localObject2).faceUrl;
        this.iconUrlSimple = ((AppletsAccountInfo)localObject2).faceUrlSimple;
        if (localMessage == null) {
          break label321;
        }
        localObject2 = paramQQAppInterface.getConversationFacade();
        if (localObject2 == null) {
          break label305;
        }
        this.mUnreadNum = ((ConversationFacade)localObject2).a(localMessage.frienduin, this.mUser.getType());
        label207:
        if (((AppletsFolderManager)localObject1).a(localMessage, this.mUser) != 2) {
          break label313;
        }
        this.mUnreadFlag = 1;
        label226:
        this.mDisplayTime = getLastMsgTime();
      }
      for (;;)
      {
        localObject1 = getMsgSummaryTemp();
        a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject1);
        this.mShowTime = TimeManager.a().a(this.mUser.uin, this.mUser.lastmsgtime);
        this.mLastMsg = ((MsgSummary)localObject1).strContent;
        a();
        return;
        QLog.d("RecentItemAppletsFolderData", 2, "account is null");
        break;
        label305:
        this.mUnreadNum = 0;
        break label207;
        label313:
        this.mUnreadFlag = 2;
        break label226;
        label321:
        this.mDisplayTime = 0L;
        this.mUnreadNum = 0;
      }
    }
    catch (Throwable localThrowable)
    {
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData
 * JD-Core Version:    0.7.0.1
 */