package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.text.QQText;
import mqq.app.AppRuntime;

public class MixMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -1035)
    {
      paramIMessageManager = new MessageForMixedMsg();
      paramIMessageManager.frienduin = paramMessage.frienduin;
      paramIMessageManager.msgData = paramMessage.msgData;
      paramIMessageManager.extStr = paramMessage.extStr;
      paramIMessageManager.extLong |= 0x1;
      paramIMessageManager.parse();
      paramMessage.msg = paramIMessageManager.msg;
      paramMessage.msg2 = paramIMessageManager.msg2;
      if ((paramMessage.msg2 != null) && (!"".equals(paramMessage.msg2)))
      {
        paramMessage.emoRecentMsg = new QQText(paramMessage.msg2, 3, 16);
        return;
      }
      if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
        paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.MixMsgDecoder
 * JD-Core Version:    0.7.0.1
 */