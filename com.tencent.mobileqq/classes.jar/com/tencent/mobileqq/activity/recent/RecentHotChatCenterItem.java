package com.tencent.mobileqq.activity.recent;

import ahpj;
import ajya;
import ajyd;
import akpx;
import android.content.Context;
import android.text.TextUtils;
import aykk;
import bbcz;
import bbfh;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    HotChatItemData localHotChatItemData = ((ajyd)paramQQAppInterface.getManager(255)).a();
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
      this.mTitleName = paramContext.getString(2131693351);
    }
    MsgSummary localMsgSummary = null;
    ajyd localajyd = (ajyd)paramQQAppInterface.getManager(255);
    HotChatItemData localHotChatItemData = localajyd.a();
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
      this.mUnreadNum = localajyd.a();
      this.mDisplayTime = ((QQMessageFacade.Message)localObject).time;
      a((QQMessageFacade.Message)localObject, 1, paramQQAppInterface, paramContext, localMsgSummary);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = ahpj.a().a(a(), this.mDisplayTime);
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localMsgSummary.strPrefix = null;
        if ((localHotChatItemData != null) && (localHotChatItemData.mState == 1)) {
          localMsgSummary.strContent = ajya.a(2131713164);
        }
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      b(paramQQAppInterface, paramContext);
      if (!AppSetting.d) {
        break;
      }
      if (this.mUnreadNum <= 0) {
        break label304;
      }
      this.mContentDesc = String.format(ajya.a(2131713165), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      return;
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
    label304:
    this.mContentDesc = String.format(ajya.a(2131713163), new Object[] { this.mLastMsg, this.mShowTime });
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    paramQQAppInterface = ((ajyd)paramQQAppInterface.getManager(255)).a();
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
          this.mLastMsg = ajya.a(2131713167);
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
        localHotChatItemData = ((ajyd)paramQQAppInterface.getManager(255)).a();
      } while ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin)) || (this.mDisplayTime >= localHotChatItemData.mDraftSec));
      localObject = ((QQMessageFacade)localObject).a(localHotChatItemData.mTroopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.bShowDraft = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = bbcz.a(paramQQAppInterface, localHotChatItemData.mTroopUin, true);
    paramMsgSummary.mDraft = new aykk(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = bbcz.a(paramQQAppInterface, paramMessage.frienduin, true);
    bbfh.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (akpx.l(paramMessage.msgtype))) {
      paramMsgSummary.strPrefix = str;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    ((ajyd)paramQQAppInterface.getManager(255)).a();
    this.mMsgExtroInfo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem
 * JD-Core Version:    0.7.0.1
 */