package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.Iterator;
import java.util.List;

class AIOTroopQcircleRedDotManager$7$1
  implements Runnable
{
  AIOTroopQcircleRedDotManager$7$1(AIOTroopQcircleRedDotManager.7 param7) {}
  
  public void run()
  {
    Iterator localIterator = this.a.d.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (this.a.a.containsKey(localChatMessage.senderuin))
      {
        localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotFlag(((QcircleRedDotEntity)this.a.a.get(localChatMessage.senderuin)).isShowRedDot);
        localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotJumpSchema(((QcircleRedDotEntity)this.a.a.get(localChatMessage.senderuin)).jumpSchema);
        localChatMessage.getChatMsgRedDotInfo().setQcircleJumpIconUrl(AIOTroopQcircleRedDotManager.a(this.a.e));
      }
    }
    this.a.c.V.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.7.1
 * JD-Core Version:    0.7.0.1
 */