package com.tencent.imcore.message.decoder;

import ActionMsg.MsgBody;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import mqq.app.AppRuntime;

public class MixedMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((ActionMsgUtil.a(paramMessage.msgtype)) || (paramMessage.msgtype == -3001) || (paramMessage.msgtype == -30002) || (paramMessage.msgtype == -30003)) {}
    try
    {
      paramIMessageManager = ActionMsgUtil.a(paramMessage.msg);
      paramMessage.msg = paramIMessageManager.msg;
      paramMessage.action = paramIMessageManager.action;
      paramMessage.shareAppID = paramIMessageManager.shareAppID;
      paramMessage.actMsgContentValue = paramIMessageManager.actMsgContentValue;
      return;
    }
    catch (Exception paramMessage)
    {
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.MixedMsgDecoder
 * JD-Core Version:    0.7.0.1
 */