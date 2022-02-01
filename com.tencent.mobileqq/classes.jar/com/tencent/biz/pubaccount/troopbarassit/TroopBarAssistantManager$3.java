package com.tencent.biz.pubaccount.troopbarassit;

import abwp;
import akms;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import uda;
import ugf;

public class TroopBarAssistantManager$3
  implements Runnable
{
  public TroopBarAssistantManager$3(uda paramuda, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    abwp localabwp = this.a.getConversationFacade();
    Object localObject1 = this.a.getMessageFacade();
    if ((localabwp == null) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopBarAssistantManager", 2, "clearAllSubscriptionUnreadMsgLite getConversationFacade fail");
      }
      return;
    }
    label192:
    for (;;)
    {
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
            localObject1 = localTroopBarData.mLatestMessage;
            if (localObject1 != null) {
              break label192;
            }
            localObject1 = this.a.getMessageFacade().getLastMsgForMsgTab(localTroopBarData.mUin, 1008);
            if ((localObject1 == null) || (localabwp.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop) <= 0)) {
              continue;
            }
            int i = ugf.b(this.a, ((MessageRecord)localObject1).frienduin);
            akms.b(this.a, ((MessageRecord)localObject1).frienduin, i);
            localabwp.a(((MessageRecord)localObject1).frienduin, i, true);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */