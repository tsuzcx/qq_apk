package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
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
  
  private void a(Message paramMessage, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    CharSequence localCharSequence = paramMessage.getMessageText();
    if (localCharSequence != null)
    {
      if (paramBoolean1)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("F ");
        paramMessage.append(localCharSequence);
        paramMessage = paramMessage.toString();
      }
      else
      {
        paramMessage = localCharSequence;
        if (paramBoolean2)
        {
          paramMessage = new StringBuilder();
          paramMessage.append("S ");
          paramMessage.append(localCharSequence);
          paramMessage = paramMessage.toString();
        }
      }
      paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new QQText(paramMessage, 1, 16), paramMsgSummary);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean1) {
      localStringBuffer.append("F ");
    } else if (paramBoolean2) {
      localStringBuffer.append("S ");
    }
    if (localCharSequence != null) {
      paramMessage = localCharSequence.toString().trim();
    } else {
      paramMessage = "";
    }
    localStringBuffer.append(paramMessage);
    try
    {
      paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new QQText(localStringBuffer, 1, 16), paramMsgSummary);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool2 = false;
    if (paramDataLineMsgSet == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      bool1 = bool2;
      if (paramDataLineMsgSet.hasSendingOrRecving()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool2 = false;
    if (paramDataLineMsgSet == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramDataLineMsgSet.hasFailed())
    {
      bool1 = bool2;
      if (!paramDataLineMsgSet.hasSendingOrRecving())
      {
        bool1 = bool2;
        if (!paramDataLineMsgSet.hasWaiting()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1) {
        paramCharSequence.append("F ");
      } else if (paramBoolean2) {
        paramCharSequence.append("S ");
      }
      paramCharSequence.append(paramString);
      paramMsgSummary.mEmojiFlag = 0;
    }
    else
    {
      paramMsgSummary.mEmojiFlag = 1;
    }
    if (paramBoolean1)
    {
      paramMsgSummary.nState = 2;
      return paramCharSequence;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.nState = 1;
      return paramCharSequence;
    }
    paramMsgSummary.nState = 0;
    return paramCharSequence;
  }
  
  protected void a(Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    paramContext = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if ((paramContext != null) && (paramContext.a(this.devType)))
    {
      this.mDisplayTime = paramContext.a(this.devType);
      paramMsgSummary.strContent = this.msgDescreption;
      return;
    }
    if ((paramMessage != null) && (paramMessage.msg != null))
    {
      paramContext = paramQQAppInterface.getMessageFacade().a(this.devType).a(paramMessage.msgId);
      boolean bool1 = b(paramContext);
      boolean bool2 = a(paramContext);
      if ((bool1) && (!paramMessage.isSend())) {
        bool1 = false;
      }
      paramInt = paramMessage.msgtype;
      if (paramInt != -2335) {
        if (paramInt != -2015)
        {
          if ((paramInt != -2009) && (paramInt != -2005) && (paramInt != -2000))
          {
            if (paramInt != -1000) {
              return;
            }
            a(paramMessage, paramMsgSummary, bool1, bool2);
          }
        }
        else
        {
          paramMsgSummary.strContent = "";
          return;
        }
      }
      if (paramContext == null)
      {
        paramMsgSummary.strContent = "";
        return;
      }
      paramMsgSummary.strContent = a(FileManagerUtil.a(paramQQAppInterface, paramContext.getFirstItem()), bool1, bool2, null, paramMsgSummary);
      return;
    }
    paramMsgSummary.strContent = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      if (this.mUser.getType() == 6000)
      {
        this.mTitle = paramContext.getString(2131693779);
        this.msgDescreption = paramContext.getString(2131693763);
        this.devType = 0;
      }
      else if (this.mUser.getType() == 6003)
      {
        this.mTitle = paramContext.getString(2131693780);
        this.msgDescreption = paramContext.getString(2131693762);
        this.devType = 1;
      }
      Message localMessage = null;
      Object localObject = paramQQAppInterface.getMessageFacade();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).getLastMessage(this.mUser.uin, this.mUser.getType());
      }
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        localObject = paramQQAppInterface.getConversationFacade();
        if (localObject != null) {
          this.mUnreadNum = ((ConversationFacade)localObject).a(localMessage.frienduin, localMessage.istroop);
        } else {
          this.mUnreadNum = 0;
        }
      }
      else
      {
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
      }
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = this.mTitle;
      }
      localObject = getMsgSummaryTemp();
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject);
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject);
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName);
        paramQQAppInterface.append(",");
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
            paramQQAppInterface.append("条未读,");
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
        paramQQAppInterface.append(",");
        paramQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine
 * JD-Core Version:    0.7.0.1
 */