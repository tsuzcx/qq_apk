package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManagerUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  public MessageRecord mData;
  public int mFromFlag;
  public boolean mHasFlowerMsg = false;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      this.mData = paramMessageRecord;
      return;
    }
    throw new NullPointerException("RecentDatingBoxItem data is null");
  }
  
  private String a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    String str;
    if ((paramMessage != null) && (paramMessage.istroop == 1001) && (MiniCardManagerUtils.a(getRecentUserUin()))) {
      str = MiniCardManagerUtils.a(getRecentUserUin()).nick.get();
    } else {
      str = ContactUtils.g(paramQQAppInterface, getRecentUserUin());
    }
    paramMessage = str;
    if (TextUtils.isEmpty(str)) {
      paramMessage = ContactUtils.a(paramQQAppInterface, getRecentUserUin(), false);
    }
    paramQQAppInterface = paramMessage;
    if (TextUtils.isEmpty(paramMessage)) {
      paramQQAppInterface = getRecentUserUin();
    }
    return paramQQAppInterface;
  }
  
  public String a()
  {
    return this.mData.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject1 = null;
      Object localObject2 = paramQQAppInterface.getMessageFacade();
      Object localObject3 = paramQQAppInterface.getConversationFacade();
      if (localObject2 != null)
      {
        localObject2 = ((QQMessageFacade)localObject2).getLastMessage(getRecentUserUin(), getRecentUserType());
        MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().a(((Message)localObject2).senderuin, ((Message)localObject2).istroop, ((Message)localObject2).uniseq);
        localObject1 = localObject2;
        if (localMessageRecord != null)
        {
          this.mData = localMessageRecord;
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null)
      {
        this.mDisplayTime = localObject1.time;
        if (localObject3 != null) {
          this.mUnreadNum = ((ConversationFacade)localObject3).a(localObject1.frienduin, localObject1.istroop);
        } else {
          this.mUnreadNum = 0;
        }
      }
      else
      {
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
      }
      if ((localObject1 != null) && (UinTypeUtil.a(localObject1))) {
        this.mUnreadFlag = 3;
      }
      localObject2 = getMsgSummaryTemp();
      this.mHasFlowerMsg = false;
      if (localObject1 != null) {
        if (DatingUtil.a(paramQQAppInterface, localObject1.senderuin, localObject1.istroop))
        {
          this.mMsgExtroInfo = paramContext.getResources().getString(2131693169);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
          if (localObject3 != null) {
            ((MsgSummary)localObject2).strContent = ((ConversationFacade)localObject3).a(getRecentUserUin(), 1001, paramContext.getResources().getString(2131693168), 0);
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("boxUin");
            ((StringBuilder)localObject3).append(getRecentUserUin());
            ((StringBuilder)localObject3).append(",boxType");
            ((StringBuilder)localObject3).append(getRecentUserType());
            ((StringBuilder)localObject3).append(",HasUnreadRedPacketMsg");
            QLog.d("Q.msg_boxitem", 2, ((StringBuilder)localObject3).toString());
          }
        }
        else if (DatingUtil.b(paramQQAppInterface, localObject1.senderuin, localObject1.istroop))
        {
          this.mHasFlowerMsg = true;
          this.mMsgExtroInfo = paramContext.getResources().getString(2131694301);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("boxUin");
            ((StringBuilder)localObject3).append(getRecentUserUin());
            ((StringBuilder)localObject3).append(",boxType");
            ((StringBuilder)localObject3).append(getRecentUserType());
            ((StringBuilder)localObject3).append(",HasUnreadGiftMsg");
            QLog.d("Q.msg_boxitem", 2, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          this.mMsgExtroInfo = "";
          buildMessageBody(localObject1, getRecentUserType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("boxUin");
        ((StringBuilder)localObject3).append(getRecentUserUin());
        ((StringBuilder)localObject3).append(",boxType");
        ((StringBuilder)localObject3).append(getRecentUserType());
        ((StringBuilder)localObject3).append(",unreadNum:");
        ((StringBuilder)localObject3).append(this.mUnreadNum);
        QLog.d("Q.msg_boxitem", 2, ((StringBuilder)localObject3).toString());
      }
      this.mTitleName = a(paramQQAppInterface, localObject1);
      this.mAuthenIconId = 0;
      dealStatus(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject2);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.mTitleName);
        if (this.mUnreadNum != 0) {
          if (this.mUnreadNum == 1)
          {
            paramQQAppInterface.append("有一条未读");
          }
          else if (this.mUnreadNum == 2)
          {
            paramQQAppInterface.append("有两条未读");
          }
          else if (this.mUnreadNum > 0)
          {
            paramQQAppInterface.append("有");
            paramQQAppInterface.append(this.mUnreadNum);
            paramQQAppInterface.append("条未读");
          }
        }
        if (this.mMsgExtroInfo != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mMsgExtroInfo);
          paramContext.append(",");
          paramQQAppInterface.append(paramContext.toString());
        }
        paramQQAppInterface.append(this.mLastMsg);
        paramQQAppInterface.append(' ');
        paramQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.bShowDraft = false;
    paramMsgSummary.mDraft = null;
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramQQAppInterface.getSummary())) {
        return;
      }
      long l = paramQQAppInterface.getTime();
      if (this.mDisplayTime > l) {
        return;
      }
      this.mDisplayTime = l;
      paramMsgSummary.bShowDraft = true;
      paramMsgSummary.mDraft = new QQText(paramQQAppInterface.getSummary(), 3, 16);
    }
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramMsgSummary);
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
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */