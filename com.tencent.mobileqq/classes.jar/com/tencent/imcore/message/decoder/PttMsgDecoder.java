package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class PttMsgDecoder
  implements IMessageDecoder
{
  private boolean a(Message paramMessage)
  {
    return (paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031);
  }
  
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (a(paramMessage))
    {
      paramMessage.msg = paramAppRuntime.getApp().getString(2131888237);
      try
      {
        paramIMessageManager = (MessageForPtt)((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if (paramIMessageManager != null)
        {
          paramMessage.pttUrl = paramIMessageManager.url;
          paramMessage.msg = paramIMessageManager.getSummaryMsg();
          return;
        }
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.PttMsgDecoder
 * JD-Core Version:    0.7.0.1
 */