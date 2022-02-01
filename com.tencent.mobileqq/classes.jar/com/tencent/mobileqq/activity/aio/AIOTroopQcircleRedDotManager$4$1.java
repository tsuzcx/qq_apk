package com.tencent.mobileqq.activity.aio;

import afol;
import afqz;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import java.util.Iterator;
import java.util.List;

public class AIOTroopQcircleRedDotManager$4$1
  implements Runnable
{
  public AIOTroopQcircleRedDotManager$4$1(afol paramafol) {}
  
  public void run()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (this.a.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.containsKey(localChatMessage.senderuin))
      {
        localChatMessage.setQcircleRedDotFlag(((QcircleRedDotEntity)this.a.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.get(localChatMessage.senderuin)).isShowRedDot);
        localChatMessage.setQcircleRedDotJumpSchema(((QcircleRedDotEntity)this.a.jdField_a_of_type_ComTencentMttSupportuiUtilsStructArrayMap.get(localChatMessage.senderuin)).jumpSchema);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.listAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.4.1
 * JD-Core Version:    0.7.0.1
 */