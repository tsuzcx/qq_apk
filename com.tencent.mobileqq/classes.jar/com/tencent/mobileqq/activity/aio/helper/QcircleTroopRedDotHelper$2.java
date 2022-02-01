package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import java.util.Iterator;
import java.util.List;

class QcircleTroopRedDotHelper$2
  implements Runnable
{
  QcircleTroopRedDotHelper$2(QcircleTroopRedDotHelper paramQcircleTroopRedDotHelper, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotFlag(false);
      localChatMessage.getChatMsgRedDotInfo().setQzoneRedDotFlag(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.2
 * JD-Core Version:    0.7.0.1
 */