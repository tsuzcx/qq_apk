package com.tencent.mobileqq.activity.recent;

import acnh;
import android.content.Context;
import android.text.TextUtils;
import anvx;
import anwa;
import bhfj;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentHotChatCenterItem
  extends AbsRecentUserBusinessBaseData
{
  public RecentHotChatCenterItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = ContactUtils.getTroopName(paramQQAppInterface, paramMessage.frienduin, true);
    bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (acnh.m(paramMessage.msgtype))) {
      paramMsgSummary.strPrefix = str;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    HotChatItemData localHotChatItemData = ((anwa)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
    if ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(localHotChatItemData.mTroopUin, 1);
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
      this.mTitleName = paramContext.getString(2131693123);
    }
    MsgSummary localMsgSummary = null;
    anwa localanwa = (anwa)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    HotChatItemData localHotChatItemData = localanwa.a();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    Object localObject = localMsgSummary;
    if (localQQMessageFacade != null)
    {
      localObject = localMsgSummary;
      if (localHotChatItemData != null) {
        localObject = localQQMessageFacade.getLastMessage(localHotChatItemData.mTroopUin, 1);
      }
    }
    localMsgSummary = getMsgSummaryTemp();
    if (localObject != null)
    {
      this.mUnreadNum = localanwa.a();
      this.mDisplayTime = ((QQMessageFacade.Message)localObject).time;
      a((QQMessageFacade.Message)localObject, 1, paramQQAppInterface, paramContext, localMsgSummary);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localMsgSummary.strPrefix = null;
        if ((localHotChatItemData != null) && (localHotChatItemData.mState == 1)) {
          localMsgSummary.strContent = anvx.a(2131712615);
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
      this.mContentDesc = String.format(anvx.a(2131712616), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      return;
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    label304:
    this.mContentDesc = String.format(anvx.a(2131712614), new Object[] { this.mLastMsg, this.mShowTime });
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    paramQQAppInterface = ((anwa)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
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
          this.mLastMsg = anvx.a(2131712618);
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
    Object localObject = paramQQAppInterface.getMessageFacade();
    if (localObject == null) {}
    HotChatItemData localHotChatItemData;
    do
    {
      do
      {
        return;
        localHotChatItemData = ((anwa)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
      } while ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin)) || (this.mDisplayTime >= localHotChatItemData.mDraftSec));
      localObject = ((QQMessageFacade)localObject).getDraftSummaryInfo(localHotChatItemData.mTroopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.bShowDraft = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = ContactUtils.getTroopName(paramQQAppInterface, localHotChatItemData.mTroopUin, true);
    paramMsgSummary.mDraft = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    ((anwa)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
    this.mMsgExtroInfo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem
 * JD-Core Version:    0.7.0.1
 */