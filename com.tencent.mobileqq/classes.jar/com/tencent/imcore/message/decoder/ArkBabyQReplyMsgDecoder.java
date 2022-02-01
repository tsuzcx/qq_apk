package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import mqq.app.AppRuntime;

public class ArkBabyQReplyMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -5016) && (paramMessage.msgData != null))
    {
      paramIMessageManager = new MessageForArkBabyqReply();
      paramIMessageManager.fromBytes(paramMessage.msgData);
      paramMessage.msg = paramIMessageManager.getSummery();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.ArkBabyQReplyMsgDecoder
 * JD-Core Version:    0.7.0.1
 */