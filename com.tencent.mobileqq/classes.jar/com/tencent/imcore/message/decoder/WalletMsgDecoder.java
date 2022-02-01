package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class WalletMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -2025) && (paramMessage.msgData != null)) {
      try
      {
        paramIMessageManager = new MessageForQQWalletMsg();
        paramIMessageManager.msgData = paramMessage.msgData;
        paramIMessageManager.parse();
        paramMessage.msg = paramIMessageManager.getMsgSummary();
        return;
      }
      catch (Exception paramMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageManager", 2, paramMessage.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.WalletMsgDecoder
 * JD-Core Version:    0.7.0.1
 */