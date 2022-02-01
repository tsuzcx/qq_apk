package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.text.QQText;
import mqq.app.AppRuntime;

public class GrayTipsMsgDecoder
  implements IMessageDecoder
{
  private boolean a(Message paramMessage)
  {
    return (paramMessage.msgtype == -5000) || (paramMessage.msgtype == -5001);
  }
  
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (a(paramMessage))
    {
      paramIMessageManager = new MessageForNewGrayTips();
      paramIMessageManager.msgData = paramMessage.msgData;
      paramIMessageManager.parse();
      paramMessage.msg = paramIMessageManager.msg;
      if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
        paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.GrayTipsMsgDecoder
 * JD-Core Version:    0.7.0.1
 */