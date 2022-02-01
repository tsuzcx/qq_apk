package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentSayHelloBoxItem
  extends RecentMsgBoxItem
{
  private static final int MAX_UNREADER_MSG_ICON = 6;
  public Object lock = new Object();
  public boolean mHasFlowerMsg = false;
  public List<MessageRecord> mUnreadMRList = new ArrayList(6);
  
  public RecentSayHelloBoxItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  private void a(QQAppInterface arg1)
  {
    Object localObject2 = ???.getMessageProxy(getRecentUserType()).b(getRecentUserUin(), getRecentUserType());
    ConversationFacade localConversationFacade = ???.getConversationFacade();
    int i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((List)localObject2).size();
    }
    synchronized (this.lock)
    {
      this.mUnreadMRList.clear();
      this.mUnreadNum = localConversationFacade.a(getRecentUserUin(), getRecentUserType());
      if (i > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localConversationFacade.a(localMessageRecord.senderuin, localMessageRecord.istroop) > 0) && (this.mUnreadMRList.size() < 6)) {
            this.mUnreadMRList.add(localMessageRecord);
          }
        } while (this.mUnreadMRList.size() < 6);
      }
      if ((this.mUnreadNum == 0) && (!this.mUnreadMRList.isEmpty())) {
        this.mUnreadMRList.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void b()
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(24);
      localStringBuilder1.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          localStringBuilder1.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          localStringBuilder1.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          localStringBuilder1.append("有");
          localStringBuilder1.append(this.mUnreadNum);
          localStringBuilder1.append("条未读");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.mMsgExtroInfo);
        localStringBuilder2.append(",");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(this.mLastMsg);
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.mShowTime);
      this.mContentDesc = localStringBuilder1.toString();
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.getConversationFacade();
    this.mUnreadFlag = 3;
    this.mLastMsg = "";
    this.mExtraInfoColor = 0;
    this.mMsgExtroInfo = "";
    Object localObject2 = paramQQAppInterface.getMessageFacade();
    if (localObject2 != null) {
      localObject2 = ((QQMessageFacade)localObject2).getLastMessage(getRecentUserUin(), getRecentUserType());
    } else {
      localObject2 = null;
    }
    if (DatingUtil.a(paramQQAppInterface, getRecentUserUin(), 1001))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131890709);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
      localObject2 = getMsgSummaryTemp();
      ((MsgSummary)localObject2).strContent = ((ConversationFacade)localObject1).b(getRecentUserUin(), 1001, paramContext.getResources().getString(2131890708), 0);
      a(paramQQAppInterface, (MsgSummary)localObject2);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("boxUin");
        paramQQAppInterface.append(getRecentUserUin());
        paramQQAppInterface.append(",boxType");
        paramQQAppInterface.append(getRecentUserType());
        paramQQAppInterface.append(",HasUnreadRedPacketMsg");
        QLog.d("Q.msg_box", 2, paramQQAppInterface.toString());
      }
    }
    else if (DatingUtil.b(paramQQAppInterface, getRecentUserUin(), 1001))
    {
      this.mHasFlowerMsg = true;
      this.mUnreadFlag = 1;
      this.mMsgExtroInfo = paramContext.getResources().getString(2131891939);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
      this.mLastMsg = "";
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("boxUin");
        paramQQAppInterface.append(getRecentUserUin());
        paramQQAppInterface.append(",boxType");
        paramQQAppInterface.append(getRecentUserType());
        paramQQAppInterface.append(",HasUnreadGiftMsg");
        QLog.d("Q.msg_box", 2, paramQQAppInterface.toString());
      }
    }
    else if (this.mUnreadNum > 0)
    {
      this.mLastMsg = "";
    }
    else
    {
      if (localObject2 != null)
      {
        localObject3 = ContactUtils.h(paramQQAppInterface, ((Message)localObject2).senderuin);
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = ContactUtils.a(paramQQAppInterface, ((Message)localObject2).senderuin, false);
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = "";
        }
      }
      else
      {
        localObject1 = null;
      }
      Object localObject3 = getMsgSummaryTemp();
      MsgUtils.a(paramContext, paramQQAppInterface, (Message)localObject2, getRecentUserType(), (MsgSummary)localObject3, (String)localObject1, false, false);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      extraUpdate(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("boxUin");
      paramQQAppInterface.append(getRecentUserUin());
      paramQQAppInterface.append(",boxType");
      paramQQAppInterface.append(getRecentUserType());
      paramQQAppInterface.append(",unreadNum:");
      paramQQAppInterface.append(this.mUnreadNum);
      QLog.d("Q.msg_box", 2, paramQQAppInterface.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      a(paramQQAppInterface);
      b(paramQQAppInterface, paramContext);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem
 * JD-Core Version:    0.7.0.1
 */