package com.tencent.mobileqq.activity.recent.data;

import acmw;
import acnf;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import arxx;
import bhfj;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentSayHelloBoxItem
  extends RecentMsgBoxItem
{
  private static final int MAX_UNREADER_MSG_ICON = 6;
  public Object lock = new Object();
  public boolean mHasFlowerMsg;
  public List<MessageRecord> mUnreadMRList = new ArrayList(6);
  
  public RecentSayHelloBoxItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  private void a()
  {
    StringBuilder localStringBuilder;
    if (AppSetting.c)
    {
      localStringBuilder = new StringBuilder(24);
      localStringBuilder.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        break label96;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(this.mLastMsg).append(' ').append(this.mShowTime);
      this.mContentDesc = localStringBuilder.toString();
      return;
      label96:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
  
  private void a(QQAppInterface arg1)
  {
    Object localObject2 = ???.getMessageProxy(getRecentUserType()).a(getRecentUserUin(), getRecentUserType());
    acmw localacmw = ???.getConversationFacade();
    int i;
    if (localObject2 == null) {
      i = 0;
    }
    synchronized (this.lock)
    {
      this.mUnreadMRList.clear();
      this.mUnreadNum = localacmw.a(getRecentUserUin(), getRecentUserType());
      if (i > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localacmw.a(localMessageRecord.senderuin, localMessageRecord.istroop) > 0) && (this.mUnreadMRList.size() < 6)) {
            this.mUnreadMRList.add(localMessageRecord);
          }
        } while (this.mUnreadMRList.size() < 6);
      }
      if ((this.mUnreadNum == 0) && (!this.mUnreadMRList.isEmpty())) {
        this.mUnreadMRList.clear();
      }
      return;
      i = ((List)localObject2).size();
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.getConversationFacade();
    this.mUnreadFlag = 3;
    this.mLastMsg = "";
    this.mExtraInfoColor = 0;
    this.mMsgExtroInfo = "";
    Object localObject2 = null;
    Object localObject3 = paramQQAppInterface.getMessageFacade();
    if (localObject3 != null) {
      localObject2 = ((QQMessageFacade)localObject3).getLastMessage(getRecentUserUin(), getRecentUserType());
    }
    if (arxx.a(paramQQAppInterface, getRecentUserUin(), 1001))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131693069);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
      localObject2 = getMsgSummaryTemp();
      ((MsgSummary)localObject2).strContent = ((acmw)localObject1).a(getRecentUserUin(), 1001, paramContext.getResources().getString(2131693068), 0);
      a(paramQQAppInterface, (MsgSummary)localObject2);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadRedPacketMsg");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",unreadNum:" + this.mUnreadNum);
      }
      return;
      if (arxx.b(paramQQAppInterface, getRecentUserUin(), 1001))
      {
        this.mHasFlowerMsg = true;
        this.mUnreadFlag = 1;
        this.mMsgExtroInfo = paramContext.getResources().getString(2131694134);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
        this.mLastMsg = "";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadGiftMsg");
        }
      }
      else
      {
        if (this.mUnreadNum <= 0) {
          break;
        }
        this.mLastMsg = "";
      }
    }
    localObject1 = null;
    if (localObject2 != null)
    {
      localObject3 = ContactUtils.getDateNickName(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin);
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = ContactUtils.getBuddyName(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, false);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label469;
      }
      localObject1 = "";
    }
    label469:
    for (;;)
    {
      localObject3 = getMsgSummaryTemp();
      bhfj.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, getRecentUserType(), (MsgSummary)localObject3, (String)localObject1, false, false);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    a(paramQQAppInterface);
    b(paramQQAppInterface, paramContext);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem
 * JD-Core Version:    0.7.0.1
 */