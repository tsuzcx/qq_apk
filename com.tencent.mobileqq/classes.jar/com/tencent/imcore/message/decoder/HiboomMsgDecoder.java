package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.HiBoomMessage;
import mqq.app.AppRuntime;

public class HiboomMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -5014) && (paramMessage.msgData != null)) {
      paramMessage.msg = ((HiBoomMessage)MessagePkgUtils.a(paramMessage.msgData)).text;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.HiboomMsgDecoder
 * JD-Core Version:    0.7.0.1
 */