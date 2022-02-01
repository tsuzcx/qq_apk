package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import mqq.app.AppRuntime;

public class ArkSdkShareMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -5017) && (paramMessage.msgData != null))
    {
      paramIMessageManager = new ArkAppMessage();
      paramIMessageManager.fromBytes(paramMessage.msgData);
      paramMessage.msg = paramIMessageManager.getSummery();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.ArkSdkShareMsgDecoder
 * JD-Core Version:    0.7.0.1
 */