package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SystemMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((AppConstants.QQBROADCAST_MSG_UIN.equals(paramMessage.senderuin)) && (paramMessage.msgtype == -2011)) {
      paramAppRuntime = null;
    } else {
      paramAppRuntime = SystemMsg.decode((QQAppInterface)paramAppRuntime, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
    }
    if (paramMessage.isFromLS) {
      ((BaseMessageManager)paramIMessageManager).c(paramMessage);
    } else {
      ((BaseMessageManager)paramIMessageManager).b(paramMessage);
    }
    if (paramAppRuntime != null)
    {
      paramMessage.msg = paramAppRuntime.message;
      if (QLog.isDevelopLevel())
      {
        paramIMessageManager = new StringBuilder();
        paramIMessageManager.append("addFrindSystemMsg decode end");
        paramIMessageManager.append(paramMessage.msg);
        QLog.d("Q.msg.BaseMessageManager", 4, paramIMessageManager.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.SystemMsgDecoder
 * JD-Core Version:    0.7.0.1
 */