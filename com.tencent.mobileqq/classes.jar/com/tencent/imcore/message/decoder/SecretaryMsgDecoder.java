package com.tencent.imcore.message.decoder;

import ActionMsg.MsgBody;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import mqq.app.AppRuntime;

public class SecretaryMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && ((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002))) {}
    try
    {
      paramMessage.msg = ActionMsgUtil.a(paramMessage.msg).msg;
      return;
    }
    catch (Exception paramMessage)
    {
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.SecretaryMsgDecoder
 * JD-Core Version:    0.7.0.1
 */