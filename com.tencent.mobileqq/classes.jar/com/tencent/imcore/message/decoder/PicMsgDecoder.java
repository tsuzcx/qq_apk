package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForPic;
import mqq.app.AppRuntime;

public class PicMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2000)
    {
      paramIMessageManager = new MessageForPic();
      paramIMessageManager.msgData = paramMessage.msgData;
      paramIMessageManager.istroop = paramMessage.istroop;
      paramIMessageManager.parse();
      paramMessage.msg = paramIMessageManager.getSummaryMsg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.PicMsgDecoder
 * JD-Core Version:    0.7.0.1
 */