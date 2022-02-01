package com.tencent.mobileqq.activity.recent.data;

import acmw;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import ansr;
import aont;
import auea;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;

public class RecentItemPcDataLine
  extends AbsRecentUserBusinessBaseData
{
  int devType;
  String mTitle;
  CharSequence msgDescreption;
  
  public RecentItemPcDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    CharSequence localCharSequence = paramMessage.getMessageText();
    if (localCharSequence != null)
    {
      if (paramBoolean1) {
        paramMessage = "F " + localCharSequence;
      }
      for (;;)
      {
        paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new QQText(paramMessage, 1, 16), paramMsgSummary);
        return;
        paramMessage = localCharSequence;
        if (paramBoolean2) {
          paramMessage = "S " + localCharSequence;
        }
      }
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean1)
    {
      localStringBuffer.append("F ");
      if (localCharSequence == null) {
        break label185;
      }
    }
    label185:
    for (paramMessage = localCharSequence.toString().trim();; paramMessage = "")
    {
      localStringBuffer.append(paramMessage);
      try
      {
        paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new QQText(localStringBuffer, 1, 16), paramMsgSummary);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      if (!paramBoolean2) {
        break;
      }
      localStringBuffer.append("S ");
      break;
    }
  }
  
  private boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {}
    while ((!paramDataLineMsgSet.isSendFromLocal()) || (!paramDataLineMsgSet.hasSendingOrRecving())) {
      return false;
    }
    return true;
  }
  
  private boolean b(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {}
    while ((!paramDataLineMsgSet.hasFailed()) || (paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) {
      return false;
    }
    return true;
  }
  
  protected CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
      }
    }
    for (paramMsgSummary.mEmojiFlag = 0;; paramMsgSummary.mEmojiFlag = 1)
    {
      if (!paramBoolean1) {
        break label76;
      }
      paramMsgSummary.nState = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label76:
    if (paramBoolean2)
    {
      paramMsgSummary.nState = 1;
      return paramCharSequence;
    }
    paramMsgSummary.nState = 0;
    return paramCharSequence;
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    paramContext = (ansr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if ((paramContext != null) && (paramContext.a(this.devType)))
    {
      this.mDisplayTime = paramContext.a(this.devType);
      paramMsgSummary.strContent = this.msgDescreption;
      return;
    }
    if ((paramMessage != null) && (paramMessage.msg != null))
    {
      paramContext = paramQQAppInterface.getMessageFacade().getDatalineMessageManager(this.devType).a(paramMessage.msgId);
      boolean bool2 = b(paramContext);
      boolean bool3 = a(paramContext);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!paramMessage.isSend()) {
          bool1 = false;
        }
      }
      switch (paramMessage.msgtype)
      {
      default: 
        return;
      case -2335: 
      case -2009: 
      case -2005: 
      case -2000: 
        if (paramContext == null)
        {
          paramMsgSummary.strContent = "";
          return;
        }
      case -1000: 
        a(paramMessage, paramMsgSummary, bool1, bool3);
        return;
        paramMsgSummary.strContent = a(auea.a(paramQQAppInterface, paramContext.getFirstItem()), bool1, bool3, null, paramMsgSummary);
        return;
      }
      paramMsgSummary.strContent = "";
      return;
    }
    paramMsgSummary.strContent = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label126:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (this.mUser.getType() != 6000) {
        break;
      }
      this.mTitle = paramContext.getString(2131693667);
      this.msgDescreption = paramContext.getString(2131693651);
      this.devType = 0;
      QQMessageFacade.Message localMessage = null;
      Object localObject = paramQQAppInterface.getMessageFacade();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).getLastMessage(this.mUser.uin, this.mUser.getType());
      }
      if (localMessage == null) {
        break label339;
      }
      this.mDisplayTime = localMessage.time;
      localObject = paramQQAppInterface.getConversationFacade();
      if (localObject == null) {
        break label331;
      }
      this.mUnreadNum = ((acmw)localObject).a(localMessage.frienduin, localMessage.istroop);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = this.mTitle;
      }
      localObject = getMsgSummaryTemp();
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject);
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject);
    } while (!AppSetting.c);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.mTitleName).append(",");
    if (this.mUnreadNum == 0) {}
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      if (this.mUser.getType() != 6003) {
        break;
      }
      this.mTitle = paramContext.getString(2131693668);
      this.msgDescreption = paramContext.getString(2131693650);
      this.devType = 1;
      break;
      label331:
      this.mUnreadNum = 0;
      break label126;
      label339:
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      break label126;
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine
 * JD-Core Version:    0.7.0.1
 */