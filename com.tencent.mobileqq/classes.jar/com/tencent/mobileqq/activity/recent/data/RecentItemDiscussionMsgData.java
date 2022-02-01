package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemDiscussionMsgData
  extends AbsRecentUserBusinessBaseData
{
  private static final String TAG = "RecentItemDiscussionMsgData";
  
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a()
  {
    if (AppSetting.e)
    {
      Object localObject;
      if (this.mTitleName != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mTitleName);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131910663));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = HardCodeUtil.a(2131910663);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",");
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          localStringBuilder.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          localStringBuilder.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          localStringBuilder.append("有");
          localStringBuilder.append(this.mUnreadNum);
          localStringBuilder.append("条未读,");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mMsgExtroInfo);
        ((StringBuilder)localObject).append(",");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString()));
      localStringBuilder.append(",");
      localStringBuilder.append(this.mShowTime);
      this.mContentDesc = localStringBuilder.toString();
    }
  }
  
  private void a(Context paramContext)
  {
    if (e().msg == null)
    {
      this.mContentDesc = "";
      return;
    }
    boolean bool = e().msg instanceof AbstructRecentUserMsg;
    int i = 0;
    if (bool)
    {
      AbstructRecentUserMsg localAbstructRecentUserMsg = (AbstructRecentUserMsg)e().msg;
      this.mMsgExtroInfo = localAbstructRecentUserMsg.c;
      this.mContentDesc = localAbstructRecentUserMsg.d;
      if ((e().msg instanceof TroopAtAllMsg)) {
        this.mContentDesc = String.format(HardCodeUtil.a(2131910662), new Object[] { this.mTitleName });
      }
      i = 2131168153;
    }
    if ((!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (i > 0)) {
      this.mExtraInfoColor = paramContext.getResources().getColor(i);
    }
  }
  
  private void a(Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -2025) && (this.mUnreadNum > 0) && (!paramMsgSummary.bShowDraft))
    {
      paramMessage = paramContext.getString(2131890709);
      if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(paramMessage)))
      {
        if (this.mExtraInfoColor == 0) {
          this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
        }
        if (android.text.TextUtils.isEmpty(this.mMsgExtroInfo))
        {
          paramContext = paramMessage;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mMsgExtroInfo);
          paramContext.append(paramMessage);
          paramContext = paramContext.toString();
        }
        this.mMsgExtroInfo = paramContext;
        this.mLastMsg = this.mLastMsg.toString().replace(paramMessage, "");
      }
    }
  }
  
  private void a(Context paramContext, MsgSummary paramMsgSummary)
  {
    if (!paramMsgSummary.bShowDraft)
    {
      a(paramContext);
      return;
    }
    if ((e().msg instanceof AbstructRecentUserMsg)) {
      this.mMsgExtroInfo = ((AbstructRecentUserMsg)e().msg).c;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if ((paramMessage.istroop == 3000) && (paramMessage.msg == null) && (paramMessage.time == 0L)) {
        this.mDisplayTime = this.mUser.lastmsgtime;
      } else {
        this.mDisplayTime = paramMessage.time;
      }
      ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
      if (localConversationFacade != null) {
        this.mUnreadNum = localConversationFacade.a(paramMessage.frienduin, paramMessage.istroop);
      } else {
        this.mUnreadNum = 0;
      }
      paramQQAppInterface = QCallFacade.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0)
      {
        this.mMsgExtroInfo = paramQQAppInterface.b();
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
      }
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramMessage != null) && (!android.text.TextUtils.isEmpty(paramMessage.senderuin)))
    {
      if (paramMessage.senderuin.equals(paramMessage.frienduin))
      {
        paramMessage.nickName = "";
        return;
      }
      if (!android.text.TextUtils.isEmpty(paramMessage.frienduin)) {
        paramMessage.nickName = ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin, paramMessage);
      }
      if (android.text.TextUtils.isEmpty(paramMessage.nickName)) {
        paramMessage.nickName = ContactUtils.a(paramQQAppInterface, paramMessage.senderuin, true);
      }
      if (android.text.TextUtils.isEmpty(paramMessage.nickName)) {
        paramMessage.nickName = paramMessage.senderuin;
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.mUnreadNum > 0) && (DiscussionManager.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())))
    {
      this.mUnreadFlag = 3;
      return;
    }
    this.mUnreadFlag = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      Object localObject1 = paramQQAppInterface.getMessageFacade();
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((QQMessageFacade)localObject1).getLastMessage(this.mUser.uin, this.mUser.getType());
      } else {
        localObject1 = null;
      }
      a(paramQQAppInterface, paramContext, (Message)localObject1);
      b(paramQQAppInterface);
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localDiscussionManager != null) {
        localObject2 = localDiscussionManager.d(this.mUser.uin);
      }
      if ((localObject2 == null) && (!TimeManager.a().b(this.mUser.uin)))
      {
        try
        {
          long l = Long.parseLong(this.mUser.uin);
          ((DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(l);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("discussion", 2, localNumberFormatException.toString());
          }
        }
        TimeManager.a().a(this.mUser.uin, true);
      }
      a(paramQQAppInterface, (Message)localObject1);
      this.mTitleName = ContactUtils.b(paramQQAppInterface, this.mUser.uin);
      if (android.text.TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = ContactUtils.a(paramContext, (DiscussionInfo)localObject2);
      }
      if (!android.text.TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleNameCs = new QQText(this.mTitleName, 1);
      }
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      a((Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
      if (localDiscussionManager != null)
      {
        int i = localDiscussionManager.c(this.mUser.uin);
        if (i > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(")");
          localObject2 = ((StringBuilder)localObject2).toString();
          break label346;
        }
      }
      localObject2 = "";
      label346:
      this.mExtraInfo = ((CharSequence)localObject2);
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      if (((e().msg instanceof TroopReceiptMsg)) && (this.mUnreadNum > 0))
      {
        localMsgSummary.suffix = "";
        localMsgSummary.strPrefix = "";
      }
      a(paramQQAppInterface, paramContext, localMsgSummary);
      a(paramContext, localMsgSummary);
      a(paramContext, (Message)localObject1, localMsgSummary);
      paramQQAppInterface = e();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
        paramQQAppInterface.reParse();
      }
      a();
      d();
    }
  }
  
  protected boolean b()
  {
    return this.mUser.getType() == 3000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */