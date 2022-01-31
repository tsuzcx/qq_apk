package com.tencent.mobileqq.activity.recent.data;

import ajum;
import akpb;
import akpf;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import apug;
import aykk;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemPcDataLine
  extends RecentUserBaseData
{
  CharSequence MsgDescreption;
  int dev_type;
  String mTitle;
  
  public RecentItemPcDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
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
      this.mTitle = paramContext.getString(2131693965);
      this.MsgDescreption = paramContext.getString(2131693949);
      this.dev_type = 0;
      QQMessageFacade.Message localMessage = null;
      Object localObject = paramQQAppInterface.a();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).a(this.mUser.uin, this.mUser.getType());
      }
      if (localMessage == null) {
        break label334;
      }
      this.mDisplayTime = localMessage.time;
      localObject = paramQQAppInterface.a();
      if (localObject == null) {
        break label326;
      }
      this.mUnreadNum = ((akpb)localObject).a(localMessage.frienduin, localMessage.istroop);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = this.mTitle;
      }
      localObject = a();
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject);
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject);
    } while (!AppSetting.d);
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
      this.mTitle = paramContext.getString(2131693966);
      this.MsgDescreption = paramContext.getString(2131693948);
      this.dev_type = 1;
      break;
      label326:
      this.mUnreadNum = 0;
      break label126;
      label334:
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
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    boolean bool3 = false;
    paramContext = (ajum)paramQQAppInterface.a(8);
    if ((paramContext != null) && (paramContext.a(this.dev_type)))
    {
      this.mDisplayTime = paramContext.a(this.dev_type);
      paramMsgSummary.strContent = this.MsgDescreption;
      return;
    }
    boolean bool1;
    boolean bool2;
    if ((paramMessage != null) && (paramMessage.msg != null))
    {
      paramContext = paramQQAppInterface.a().a(this.dev_type).a(paramMessage.msgId);
      if (paramContext == null)
      {
        bool1 = false;
        if (paramContext != null) {
          break label230;
        }
        bool2 = false;
        label101:
        if ((!bool1) || (paramMessage.isSend())) {
          break label492;
        }
        bool1 = bool3;
      }
    }
    label230:
    label492:
    for (;;)
    {
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
          if ((paramContext.hasFailed()) && (!paramContext.hasSendingOrRecving()) && (!paramContext.hasWaiting()))
          {
            bool1 = true;
            break;
          }
          bool1 = false;
          break;
          if ((paramContext.isSendFromLocal()) && (paramContext.hasSendingOrRecving()))
          {
            bool2 = true;
            break label101;
          }
          bool2 = false;
        }
        break;
      case -1000: 
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface != null)
        {
          if (bool1) {
            paramMessage = "F " + paramQQAppInterface;
          }
          for (;;)
          {
            paramMsgSummary.strContent = a(null, bool1, bool2, new aykk(paramMessage, 1, 16), paramMsgSummary);
            return;
            paramMessage = paramQQAppInterface;
            if (bool2) {
              paramMessage = "S " + paramQQAppInterface;
            }
          }
        }
        paramContext = new StringBuffer();
        if (bool1)
        {
          paramContext.append("F ");
          if (paramQQAppInterface == null) {
            break label444;
          }
        }
        for (paramMessage = paramQQAppInterface.toString().trim();; paramMessage = "")
        {
          paramContext.append(paramMessage);
          try
          {
            paramMsgSummary.strContent = a(null, bool1, bool2, new aykk(paramContext, 1, 16), paramMsgSummary);
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          if (!bool2) {
            break;
          }
          paramContext.append("S ");
          break;
        }
        paramMsgSummary.strContent = a(apug.a(paramQQAppInterface, paramContext.getFirstItem()), bool1, bool2, null, paramMsgSummary);
        return;
      case -2015: 
        paramMsgSummary.strContent = "";
        return;
        paramMsgSummary.strContent = "";
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine
 * JD-Core Version:    0.7.0.1
 */