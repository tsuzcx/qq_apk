package com.tencent.mobileqq.activity.recent.data;

import ahjz;
import ahop;
import ahpl;
import akpc;
import android.content.Context;
import android.text.TextUtils;
import bbcl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemAppletsFolderData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemAppletsFolderData";
  public String iconUrl;
  public String iconUrlSimple;
  
  public RecentItemAppletsFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
  }
  
  private void f()
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
      this.mTitleName = bbcl.j(paramQQAppInterface, this.mUser.uin);
    }
    QQMessageFacade.Message localMessage = null;
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());
    }
    localObject1 = (ahjz)paramQQAppInterface.getManager(315);
    if (ahop.a(paramQQAppInterface)) {}
    try
    {
      ((ahjz)localObject1).a();
      label97:
      Object localObject2 = ((ahjz)localObject1).a(this.mUser.uin);
      if (localObject2 != null)
      {
        QLog.d("RecentItemAppletsFolderData", 2, "account not null nick:" + ((AppletsAccountInfo)localObject2).nick);
        this.mTitleName = ((AppletsAccountInfo)localObject2).nick;
        this.iconUrl = ((AppletsAccountInfo)localObject2).faceUrl;
        this.iconUrlSimple = ((AppletsAccountInfo)localObject2).faceUrlSimple;
        if (localMessage == null) {
          break label321;
        }
        localObject2 = paramQQAppInterface.a();
        if (localObject2 == null) {
          break label305;
        }
        this.mUnreadNum = ((akpc)localObject2).a(localMessage.frienduin, this.mUser.getType());
        label207:
        if (((ahjz)localObject1).a(localMessage, this.mUser) != 2) {
          break label313;
        }
        this.mUnreadFlag = 1;
        label226:
        this.mDisplayTime = a();
      }
      for (;;)
      {
        localObject1 = a();
        a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject1);
        this.mShowTime = ahpl.a().a(this.mUser.uin, this.mUser.lastmsgtime);
        this.mLastMsg = ((MsgSummary)localObject1).strContent;
        f();
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
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramMessage, paramInt, paramQQAppInterface, paramContext, paramMsgSummary);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData
 * JD-Core Version:    0.7.0.1
 */