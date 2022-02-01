package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FuDaiMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -2072) && (paramMessage.msgData != null)) {
      try
      {
        paramIMessageManager = new MessageForFuDai();
        paramIMessageManager.msgData = paramMessage.msgData;
        paramIMessageManager.parse();
        paramMessage.msg = paramIMessageManager.getSummaryMsg();
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("Q.msg.BaseMessageManager", 1, paramMessage, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.FuDaiMsgDecoder
 * JD-Core Version:    0.7.0.1
 */