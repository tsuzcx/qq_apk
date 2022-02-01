package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ChatMsgRedDotInfo;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.Iterator;
import java.util.List;

class AIOTroopQcircleRedDotManager$2
  implements Runnable
{
  AIOTroopQcircleRedDotManager$2(AIOTroopQcircleRedDotManager paramAIOTroopQcircleRedDotManager, List paramList, ArrayMap paramArrayMap, boolean paramBoolean, TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.containsKey(localChatMessage.senderuin))
      {
        localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotFlag(((QcircleRedDotEntity)this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.get(localChatMessage.senderuin)).isShowRedDot);
        localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotJumpSchema(((QcircleRedDotEntity)this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.get(localChatMessage.senderuin)).jumpSchema);
        localChatMessage.getChatMsgRedDotInfo().setQcircleJumpIconUrl(AIOTroopQcircleRedDotManager.a(this.this$0));
        if (this.jdField_a_of_type_Boolean) {
          localChatMessage.getChatMsgRedDotInfo().setQcircleRedDotPulledFlag(true);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.2
 * JD-Core Version:    0.7.0.1
 */