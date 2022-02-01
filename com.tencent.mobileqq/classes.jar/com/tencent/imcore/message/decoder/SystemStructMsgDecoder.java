package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class SystemStructMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -2018) || (paramMessage.msgtype == -2050)) {}
    try
    {
      paramIMessageManager = new structmsg.StructMsg();
      paramIMessageManager.mergeFrom(paramMessage.msgData);
      paramMessage.msg = MessageForSystemMsg.getSysMsgDesc(paramAppRuntime.getApp().getResources(), paramIMessageManager);
      return;
    }
    catch (Exception paramMessage)
    {
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.SystemStructMsgDecoder
 * JD-Core Version:    0.7.0.1
 */