package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class RecentHotChatCenterItem
  extends AbsRecentUserBusinessBaseData
{
  public RecentHotChatCenterItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  protected void a(Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true);
    MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (MsgProxyUtils.g(paramMessage.msgtype))) {
      paramMsgSummary.strPrefix = str;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    HotChatItemData localHotChatItemData = ((HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
    if (localHotChatItemData != null)
    {
      if (TextUtils.isEmpty(localHotChatItemData.mTroopUin)) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface == null) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(localHotChatItemData.mTroopUin, 1);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        this.mStatus = 4;
        return;
      }
      this.mStatus = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131693223);
      }
      HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
      HotChatItemData localHotChatItemData = localHotChatCenterManager.a();
      Object localObject = paramQQAppInterface.getMessageFacade();
      if ((localObject != null) && (localHotChatItemData != null)) {
        localObject = ((QQMessageFacade)localObject).getLastMessage(localHotChatItemData.mTroopUin, 1);
      } else {
        localObject = null;
      }
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      if (localObject != null)
      {
        this.mUnreadNum = localHotChatCenterManager.a();
        this.mDisplayTime = ((Message)localObject).time;
        a((Message)localObject, 1, paramQQAppInterface, paramContext, localMsgSummary);
        if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
          this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
        }
      }
      else
      {
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
      }
      if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localMsgSummary.strPrefix = null;
        if ((localHotChatItemData != null) && (localHotChatItemData.mState == 1)) {
          localMsgSummary.strContent = HardCodeUtil.a(2131713086);
        }
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      b(paramQQAppInterface, paramContext);
      if (AppSetting.d)
      {
        if (this.mUnreadNum > 0)
        {
          this.mContentDesc = String.format(HardCodeUtil.a(2131713087), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
          return;
        }
        this.mContentDesc = String.format(HardCodeUtil.a(2131713085), new Object[] { this.mLastMsg, this.mShowTime });
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    paramQQAppInterface = ((HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
    if (paramQQAppInterface != null)
    {
      if ((!paramQQAppInterface.mIsRead4Folder) && (!TextUtils.isEmpty(paramQQAppInterface.mADsContent)))
      {
        paramContext = new StringBuilder();
        paramContext.append(" ");
        paramContext.append(paramQQAppInterface.mADsContent);
        this.mLastMsg = paramContext.toString();
        return;
      }
      if (paramQQAppInterface.mState == 1)
      {
        this.mLastMsg = HardCodeUtil.a(2131713089);
        return;
      }
      if (this.mUnreadNum > 0) {
        this.mLastMsg = "";
      }
    }
    else if (this.mUnreadNum > 0)
    {
      this.mLastMsg = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject2 = paramQQAppInterface.getMessageFacade();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ((HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(((HotChatItemData)localObject1).mTroopUin)) {
        return;
      }
      if (this.mDisplayTime >= ((HotChatItemData)localObject1).mDraftSec) {
        return;
      }
      localObject2 = ((QQMessageFacade)localObject2).getDraftSummaryInfo(((HotChatItemData)localObject1).mTroopUin, 1);
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary())) {
          return;
        }
        this.mDisplayTime = ((DraftSummaryInfo)localObject2).getTime();
        paramMsgSummary.bShowDraft = true;
        localObject2 = ((DraftSummaryInfo)localObject2).getSummary();
        paramQQAppInterface = ContactUtils.a(paramQQAppInterface, ((HotChatItemData)localObject1).mTroopUin, true);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramQQAppInterface);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append((String)localObject2);
        paramMsgSummary.mDraft = new QQText(((StringBuilder)localObject1).toString(), 3, 16);
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    ((HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a();
    this.mMsgExtroInfo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem
 * JD-Core Version:    0.7.0.1
 */