package com.tencent.mobileqq.activity.aio;

import afok;
import afqz;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.Iterator;
import java.util.List;

public class AIOTroopQcircleRedDotManager$2
  implements Runnable
{
  public AIOTroopQcircleRedDotManager$2(afok paramafok, List paramList, ArrayMap paramArrayMap, boolean paramBoolean, TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.containsKey(localChatMessage.senderuin))
      {
        localChatMessage.setQcircleRedDotFlag(((QcircleRedDotEntity)this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.get(localChatMessage.senderuin)).isShowRedDot);
        localChatMessage.setQcircleRedDotJumpSchema(((QcircleRedDotEntity)this.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.get(localChatMessage.senderuin)).jumpSchema);
        if (this.jdField_a_of_type_Boolean) {
          localChatMessage.setQcircleRedDotPulledFlag(true);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.listAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.2
 * JD-Core Version:    0.7.0.1
 */