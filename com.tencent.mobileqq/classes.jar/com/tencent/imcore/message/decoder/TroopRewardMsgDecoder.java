package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForTroopReward;
import mqq.app.AppRuntime;

public class TroopRewardMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2048)
    {
      paramIMessageManager = new MessageForTroopReward();
      paramIMessageManager.msgData = paramMessage.msgData;
      paramIMessageManager.parse();
      paramMessage.msg = paramIMessageManager.getSummaryMsg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.TroopRewardMsgDecoder
 * JD-Core Version:    0.7.0.1
 */