package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import mqq.app.AppRuntime;

public class StructMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2011)
    {
      paramIMessageManager = StructMsgFactory.a(paramMessage.msgData);
      if (paramIMessageManager != null) {
        paramIMessageManager = paramIMessageManager.mMsgBrief;
      } else {
        paramIMessageManager = "";
      }
      paramMessage.msg = paramIMessageManager;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.StructMsgDecoder
 * JD-Core Version:    0.7.0.1
 */