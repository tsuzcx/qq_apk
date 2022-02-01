package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.Iterator;
import java.util.List;

class AIOTroopQcircleRedDotManager$3
  implements Runnable
{
  AIOTroopQcircleRedDotManager$3(AIOTroopQcircleRedDotManager paramAIOTroopQcircleRedDotManager, List paramList, ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (this.b.containsKey(localChatMessage.senderuin))
      {
        localChatMessage.getChatMsgRedDotInfo().setQzoneRedDotFlag(((QzoneRedDotEntity)this.b.get(localChatMessage.senderuin)).isShowRedDot);
        localChatMessage.getChatMsgRedDotInfo().setQzoneRedDotJumpSchema(((QzoneRedDotEntity)this.b.get(localChatMessage.senderuin)).jumpSchema);
        localChatMessage.getChatMsgRedDotInfo().setQzoneJumpIconUrl(((QzoneRedDotEntity)this.b.get(localChatMessage.senderuin)).iconUrl);
      }
      else if (this.c.containsKey(localChatMessage.senderuin))
      {
        localChatMessage.getChatMsgRedDotInfo().setQzoneRedDotPulledFlag(true);
      }
    }
    this.d.V.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.3
 * JD-Core Version:    0.7.0.1
 */