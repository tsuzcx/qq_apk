package com.tencent.biz.qqcircle.fragments.chat;

import adab;
import adak;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import begp;
import bhlg;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class QCircleRecentChatListData
  extends RecentBaseData
{
  private QQCirclePrivateMsgShow.UserPMGiftInfo mGiftInfo;
  private MessageRecord mMessageRecord;
  
  public QCircleRecentChatListData(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("QCircleRecentChatListData data is null");
    }
    this.mMessageRecord = paramMessageRecord;
  }
  
  public QQCirclePrivateMsgShow.UserPMGiftInfo a()
  {
    return this.mGiftInfo;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject1 = paramQQAppInterface.a();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(getRecentUserUin(), getRecentUserType());; localObject1 = null)
    {
      this.mExtraInfoColor = 0;
      this.mMsgExtroInfo = null;
      if (localObject1 != null)
      {
        this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
        if (localObject2 != null)
        {
          this.mUnreadNum = ((adab)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if (adak.d((MessageRecord)localObject1)) {
            this.mUnreadFlag = 3;
          }
          label89:
          localObject2 = super.getMsgSummaryTemp();
          super.buildMessageBody((IMCoreMessageStub)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          this.mTitleName = bhlg.b(paramQQAppInterface, getRecentUserUin(), true);
          this.mAuthenIconId = 0;
          super.dealStatus(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject2);
          super.extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          if (!AppSetting.c) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.mTitleName);
          if (this.mUnreadNum != 0) {
            break label263;
          }
        }
      }
      for (;;)
      {
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
        return;
        this.mUnreadNum = 0;
        break;
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        break label89;
        label263:
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131698163));
        } else if (this.mUnreadNum == 2) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131698164));
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131698162, new Object[] { Integer.valueOf(this.mUnreadNum) }));
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.mDisplayTime > l);
    this.mDisplayTime = l;
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new begp(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public void a(QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo)
  {
    this.mGiftInfo = paramUserPMGiftInfo;
  }
  
  public void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramMsgSummary);
    }
  }
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    return this.mMessageRecord.time;
  }
  
  public int getRecentUserType()
  {
    return this.mMessageRecord.istroop;
  }
  
  public String getRecentUserUin()
  {
    return this.mMessageRecord.senderuin;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData
 * JD-Core Version:    0.7.0.1
 */