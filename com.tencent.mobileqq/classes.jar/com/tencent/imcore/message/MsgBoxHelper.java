package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MsgBoxHelper
{
  static void a(QQAppInterface paramQQAppInterface, BaseMessageManager paramBaseMessageManager, IMessageFacade paramIMessageFacade, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt2 = ConfessMsgUtil.a(paramInt2, paramInt3);
    paramQQAppInterface.getMessageProxy(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2);
    paramString3 = paramIMessageFacade.getLastMessage(paramString1, paramInt1);
    if ((paramString3.senderuin != null) && (paramString3.senderuin.equals(paramString2)) && ((paramInt2 == 0) || ((paramInt2 != 0) && (paramInt2 == paramString3.getExtraKey()))))
    {
      paramString2 = paramQQAppInterface.getMessageProxy(paramInt1).c(paramString1, paramInt1);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        MessageRecord.copyMessageRecordBaseField(paramString3, (MessageRecord)paramString2.get(paramString2.size() - 1));
        paramString3.frienduin = paramString1;
        paramString3.emoRecentMsg = null;
        try
        {
          paramBaseMessageManager.a(paramString3);
          return;
        }
        catch (Throwable paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramQQAppInterface);
      }
      else
      {
        paramString3.emoRecentMsg = null;
        paramString3.msg = null;
        ConfessMsgUtil.d(paramString3);
        if (paramBoolean)
        {
          paramQQAppInterface = paramQQAppInterface.getProxyManager().g().b(paramString1, paramInt1);
          if (paramQQAppInterface != null) {
            paramIMessageFacade.removeRecentUser(paramQQAppInterface);
          }
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseMessageManager paramBaseMessageManager, IMessageFacade paramIMessageFacade, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramQQAppInterface.getMessageProxy(paramInt).a(paramString1, paramInt, paramString2, paramString3, 0);
    String str;
    if (paramInt == 1010) {
      str = AppConstants.DATE_UIN;
    }
    for (;;)
    {
      break;
      if ((paramInt != 1001) && (paramInt != 10002)) {
        str = "";
      } else {
        str = AppConstants.LBS_HELLO_UIN;
      }
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Message localMessage = paramIMessageFacade.getLastMessage(paramString1, paramInt);
    if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString2)))
    {
      paramQQAppInterface.getMessageProxy(paramInt).a(str, paramInt, paramString1, paramString3, 0);
      paramString2 = paramQQAppInterface.getMessageProxy(paramInt).c(paramString1, paramInt);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        paramString2 = (MessageRecord)paramString2.get(paramString2.size() - 1);
        paramString3 = MessageRecordFactory.a(paramString2.msgtype);
        MessageRecord.copyMessageRecordBaseField(paramString3, paramString2);
        paramString3.frienduin = str;
        paramString3.senderuin = paramString1;
        if (!MsgProxyUtils.b(paramString2.msgtype)) {
          paramBaseMessageManager.a(paramString3, null, false, true, 1);
        }
        MessageRecord.copyMessageRecordBaseField(localMessage, paramString2);
        localMessage.frienduin = paramString1;
        localMessage.emoRecentMsg = null;
        try
        {
          paramBaseMessageManager.a(localMessage);
        }
        catch (Throwable paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox decode msgInLBSBox ERROR", paramString2);
          }
        }
      }
      paramString2 = paramIMessageFacade.getLastMessage(str, paramInt);
      if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1)))
      {
        paramString1 = paramQQAppInterface.getMessageProxy(paramInt).c(str, paramInt);
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          MessageRecord.copyMessageRecordBaseField(paramString2, (MessageRecord)paramString1.get(paramString1.size() - 1));
          paramString2.frienduin = str;
          paramString2.emoRecentMsg = null;
          try
          {
            paramBaseMessageManager.a(paramString2);
            return;
          }
          catch (Throwable paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramQQAppInterface);
        }
        else
        {
          paramString2.emoRecentMsg = null;
          paramString2.msg = null;
          if (paramBoolean)
          {
            paramQQAppInterface = paramQQAppInterface.getProxyManager().g().b(str, paramInt);
            if (paramQQAppInterface != null) {
              paramIMessageFacade.removeRecentUser(paramQQAppInterface);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgBoxHelper
 * JD-Core Version:    0.7.0.1
 */