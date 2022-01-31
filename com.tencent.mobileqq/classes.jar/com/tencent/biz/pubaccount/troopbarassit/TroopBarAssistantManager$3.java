package com.tencent.biz.pubaccount.troopbarassit;

import ahpf;
import akpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import sdf;
import sgj;

public class TroopBarAssistantManager$3
  implements Runnable
{
  public TroopBarAssistantManager$3(sdf paramsdf, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    akpc localakpc = this.a.a();
    Object localObject1 = this.a.a();
    if ((localakpc == null) || (localObject1 == null))
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
            localObject1 = this.a.a().b(localTroopBarData.mUin, 1008);
            if ((localObject1 == null) || (localakpc.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop) <= 0)) {
              continue;
            }
            int i = sgj.b(this.a, ((MessageRecord)localObject1).frienduin);
            ahpf.b(this.a, ((MessageRecord)localObject1).frienduin, i);
            localakpc.a(((MessageRecord)localObject1).frienduin, i, true);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */