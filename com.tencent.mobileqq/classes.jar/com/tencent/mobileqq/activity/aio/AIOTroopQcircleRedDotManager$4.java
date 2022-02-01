package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.Iterator;
import java.util.List;

class AIOTroopQcircleRedDotManager$4
  implements Runnable
{
  AIOTroopQcircleRedDotManager$4(AIOTroopQcircleRedDotManager paramAIOTroopQcircleRedDotManager, List paramList, ArrayMap paramArrayMap, boolean paramBoolean, TroopChatPie paramTroopChatPie) {}
  
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
        if (this.c) {
          localChatMessage.getChatMsgRedDotInfo().setQzoneRedDotPulledFlag(true);
        }
      }
    }
    this.d.V.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.4
 * JD-Core Version:    0.7.0.1
 */