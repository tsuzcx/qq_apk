package com.tencent.mobileqq.activity.recent;

import abot;
import ajgs;
import alpo;
import alpr;
import android.content.Context;
import android.text.TextUtils;
import baig;
import bdbt;
import bdec;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.RecentUser;

public class RecentHotChatCenterItem
  extends RecentUserBaseData
{
  public RecentHotChatCenterItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = bdbt.a(paramQQAppInterface, paramMessage.frienduin, true);
    bdec.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (abot.m(paramMessage.msgtype))) {
      paramMsgSummary.strPrefix = str;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    HotChatItemData localHotChatItemData = ((alpr)paramQQAppInterface.getManager(255)).a();
    if ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localHotChatItemData.mTroopUin, 1);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.mStatus = 4;
      return;
    }
    this.mStatus = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = paramContext.getString(2131693452);
    }
    MsgSummary localMsgSummary = null;
    alpr localalpr = (alpr)paramQQAppInterface.getManager(255);
    HotChatItemData localHotChatItemData = localalpr.a();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    Object localObject = localMsgSummary;
    if (localQQMessageFacade != null)
    {
      localObject = localMsgSummary;
      if (localHotChatItemData != null) {
        localObject = localQQMessageFacade.a(localHotChatItemData.mTroopUin, 1);
      }
    }
    localMsgSummary = a();
    if (localObject != null)
    {
      this.mUnreadNum = localalpr.a();
      this.mDisplayTime = ((QQMessageFacade.Message)localObject).time;
      a((QQMessageFacade.Message)localObject, 1, paramQQAppInterface, paramContext, localMsgSummary);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = ajgs.a().a(a(), this.mDisplayTime);
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localMsgSummary.strPrefix = null;
        if ((localHotChatItemData != null) && (localHotChatItemData.mState == 1)) {
          localMsgSummary.strContent = alpo.a(2131713536);
        }
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      b(paramQQAppInterface, paramContext);
      if (!AppSetting.c) {
        break;
      }
      if (this.mUnreadNum <= 0) {
        break label304;
      }
      this.mContentDesc = String.format(alpo.a(2131713537), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      return;
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    label304:
    this.mContentDesc = String.format(alpo.a(2131713535), new Object[] { this.mLastMsg, this.mShowTime });
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    paramQQAppInterface = ((alpr)paramQQAppInterface.getManager(255)).a();
    if (paramQQAppInterface != null) {
      if ((!paramQQAppInterface.mIsRead4Folder) && (!TextUtils.isEmpty(paramQQAppInterface.mADsContent))) {
        this.mLastMsg = (" " + paramQQAppInterface.mADsContent);
      }
    }
    while (this.mUnreadNum <= 0)
    {
      do
      {
        return;
        if (paramQQAppInterface.mState == 1)
        {
          this.mLastMsg = alpo.a(2131713539);
          return;
        }
      } while (this.mUnreadNum <= 0);
      this.mLastMsg = "";
      return;
    }
    this.mLastMsg = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    HotChatItemData localHotChatItemData;
    do
    {
      do
      {
        return;
        localHotChatItemData = ((alpr)paramQQAppInterface.getManager(255)).a();
      } while ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin)) || (this.mDisplayTime >= localHotChatItemData.mDraftSec));
      localObject = ((QQMessageFacade)localObject).a(localHotChatItemData.mTroopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.bShowDraft = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = bdbt.a(paramQQAppInterface, localHotChatItemData.mTroopUin, true);
    paramMsgSummary.mDraft = new baig(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    ((alpr)paramQQAppInterface.getManager(255)).a();
    this.mMsgExtroInfo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem
 * JD-Core Version:    0.7.0.1
 */