package com.tencent.mobileqq.activity.recent.data;

import acvy;
import acwh;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import arkw;
import bdnt;
import bglf;
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
import com.tencent.qphone.base.util.QLog;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  public MessageRecord mData;
  public int mFromFlag;
  public boolean mHasFlowerMsg;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.mData = paramMessageRecord;
  }
  
  public String a()
  {
    return this.mData.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    Object localObject3;
    label273:
    do
    {
      return;
      localObject1 = null;
      Object localObject2 = paramQQAppInterface.a();
      acvy localacvy = paramQQAppInterface.a();
      if (localObject2 != null)
      {
        localObject2 = ((QQMessageFacade)localObject2).a(getRecentUserUin(), getRecentUserType());
        localObject3 = paramQQAppInterface.a().a(((QQMessageFacade.Message)localObject2).senderuin, ((QQMessageFacade.Message)localObject2).istroop, ((QQMessageFacade.Message)localObject2).uniseq);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          this.mData = ((MessageRecord)localObject3);
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null) {
        break label513;
      }
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      if (localacvy == null) {
        break;
      }
      this.mUnreadNum = localacvy.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      if ((localObject1 != null) && (acwh.d((MessageRecord)localObject1))) {
        this.mUnreadFlag = 3;
      }
      localObject3 = getMsgSummaryTemp();
      this.mHasFlowerMsg = false;
      if (localObject1 != null)
      {
        if (!arkw.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, ((QQMessageFacade.Message)localObject1).istroop)) {
          break label526;
        }
        this.mMsgExtroInfo = paramContext.getResources().getString(2131692875);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
        if (localacvy != null) {
          ((MsgSummary)localObject3).strContent = localacvy.a(getRecentUserUin(), 1001, paramContext.getResources().getString(2131692874), 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_boxitem", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadRedPacketMsg");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_boxitem", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",unreadNum:" + this.mUnreadNum);
      }
      localObject2 = bglf.q(paramQQAppInterface, getRecentUserUin());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = bglf.b(paramQQAppInterface, getRecentUserUin(), false);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = getRecentUserUin();
      }
      this.mTitleName = ((String)localObject2);
      this.mAuthenIconId = 0;
      dealStatus(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
    } while (!AppSetting.c);
    paramQQAppInterface = new StringBuilder(24);
    paramQQAppInterface.append(this.mTitleName);
    if (this.mUnreadNum == 0) {}
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
      label513:
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      break;
      label526:
      if (arkw.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, ((QQMessageFacade.Message)localObject1).istroop))
      {
        this.mHasFlowerMsg = true;
        this.mMsgExtroInfo = paramContext.getResources().getString(2131693827);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
        if (!QLog.isColorLevel()) {
          break label273;
        }
        QLog.d("Q.msg_boxitem", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadGiftMsg");
        break label273;
      }
      this.mMsgExtroInfo = "";
      buildMessageBody((IMCoreMessageStub)localObject1, getRecentUserType(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break label273;
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.bShowDraft = false;
          paramMsgSummary.mDraft = null;
          paramQQAppInterface = paramQQAppInterface.a();
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.mDisplayTime > l);
    this.mDisplayTime = l;
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new bdnt(paramQQAppInterface.getSummary(), 3, 16);
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
    return this.mData.time;
  }
  
  public int getRecentUserType()
  {
    return this.mData.istroop;
  }
  
  public String getRecentUserUin()
  {
    return this.mData.senderuin;
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)paramIMCoreAppRuntime, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */