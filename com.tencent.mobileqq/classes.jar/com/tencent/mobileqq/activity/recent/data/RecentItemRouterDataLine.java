package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class RecentItemRouterDataLine
  extends AbsRecentUserBusinessBaseData
{
  public RecentItemRouterDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private Message a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.getLastMessage(this.mUser.uin, this.mUser.getType());
      if (localMessage != null)
      {
        paramQQAppInterface = localMessage;
        if (localMessage.msgtype != 0) {}
      }
      else
      {
        return null;
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
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
      paramCharSequence = new SpannableStringBuilder(paramCharSequence.toString());
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
    paramMessage = new StringBuffer();
    if (paramBoolean1) {
      paramMessage.append("F ");
    } else if (paramBoolean2) {
      paramMessage.append("S ");
    }
    paramMessage.append("");
    try
    {
      paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new QQText(paramMessage, 1, 16), paramMsgSummary);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  protected void a(Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null)
    {
      paramInt = paramMessage.extInt;
      boolean bool1;
      if (paramInt == 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramInt == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (paramMessage.msgtype == -1000) {
        a(paramMessage, paramMsgSummary, bool1, bool2);
      } else if (paramMessage.msgtype == -2000) {
        paramMsgSummary.strContent = a(paramContext.getString(2131718406), bool1, bool2, null, paramMsgSummary);
      } else if (paramMessage.msgtype == -2005) {
        paramMsgSummary.strContent = a(paramContext.getString(2131692262), bool1, bool2, null, paramMsgSummary);
      } else if (paramMessage.msgtype == -2009) {
        paramMsgSummary.strContent = a(paramContext.getString(2131720194), bool1, bool2, null, paramMsgSummary);
      } else if (paramMessage.msgtype == -2335) {
        paramMsgSummary.strContent = a(paramContext.getString(2131692262), bool1, bool2, null, paramMsgSummary);
      } else if (paramMessage.msgtype == -2015) {
        paramMsgSummary.strContent = "";
      } else if ((paramMessage.msgtype == -2060) || (paramMessage.msgtype == -2062) || (paramMessage.msgtype == -2066) || (paramMessage.msgtype == -4023) || (paramMessage.msgtype == -4024) || (paramMessage.msgtype == -4025) || (paramMessage.msgtype == -4026) || (paramMessage.msgtype == -4027) || (paramMessage.msgtype == -7010) || (paramMessage.msgtype == -7009) || (paramMessage.msgtype == -7011) || (paramMessage.msgtype == -7012) || (paramMessage.msgtype == -7013) || (paramMessage.msgtype == -7015)) {
        paramMsgSummary.strContent = "";
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("msg info: ");
      paramQQAppInterface.append(paramMessage.extInt);
      paramQQAppInterface.append(":");
      paramQQAppInterface.append(paramMessage.msgtype);
      paramQQAppInterface.append("msgSummary.strContent:");
      paramQQAppInterface.append(paramMsgSummary.strContent);
      QLog.d("RecentItemRouterDataLine", 2, paramQQAppInterface.toString());
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
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      RouterHandler localRouterHandler = (RouterHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER);
      Object localObject1 = a(paramQQAppInterface);
      if (localObject1 == null)
      {
        QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
        String str = UinTypeUtil.a(this.mUser.uin, 6002);
        localObject2 = localRouterHandler.a(this.mUser.uin);
        if (localObject2 == null)
        {
          localObject1 = new Message();
          ((Message)localObject1).extInt = 0;
          ((Message)localObject1).time = MessageCache.a();
          ((Message)localObject1).msgtype = 0;
        }
        else
        {
          if (localQQMessageFacade == null) {
            return;
          }
          localObject1 = localObject2;
          if (localQQMessageFacade.a.containsKey(str))
          {
            localQQMessageFacade.a.remove(str);
            localObject1 = localObject2;
          }
        }
        localQQMessageFacade.a.put(str, localObject1);
      }
      this.mTitleName = localRouterHandler.a(Long.parseLong(this.mUser.uin));
      this.mDisplayTime = ((Message)localObject1).time;
      Object localObject2 = getMsgSummaryTemp();
      a((Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (AppSetting.d)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(HardCodeUtil.a(2131713098));
        paramQQAppInterface.append(this.mUnreadNum);
        paramQQAppInterface.append(HardCodeUtil.a(2131713101));
        paramQQAppInterface.append(" ");
        paramQQAppInterface.append(((MsgSummary)localObject2).strContent);
        paramQQAppInterface.append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine
 * JD-Core Version:    0.7.0.1
 */