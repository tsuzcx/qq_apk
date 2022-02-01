package com.tencent.biz.pubaccount.troopbarassit;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopBarAssistantManager$3
  implements Runnable
{
  TroopBarAssistantManager$3(TroopBarAssistantManager paramTroopBarAssistantManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ConversationFacade localConversationFacade = this.a.getConversationFacade();
    Object localObject1 = this.a.getMessageFacade();
    if ((localConversationFacade != null) && (localObject1 != null)) {
      synchronized (this.this$0.o)
      {
        if (this.this$0.l != null)
        {
          Iterator localIterator = this.this$0.l.iterator();
          while (localIterator.hasNext())
          {
            TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
            MessageRecord localMessageRecord = localTroopBarData.mLatestMessage;
            localObject1 = localMessageRecord;
            if (localMessageRecord == null) {
              localObject1 = this.a.getMessageFacade().r(localTroopBarData.mUin, 1008);
            }
            if ((localObject1 != null) && (localConversationFacade.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop) > 0))
            {
              int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.a, ((MessageRecord)localObject1).frienduin);
              RecentUtil.b(this.a, ((MessageRecord)localObject1).frienduin, i);
              localConversationFacade.a(((MessageRecord)localObject1).frienduin, i, true);
            }
          }
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopBarAssistantManager", 2, "clearAllSubscriptionUnreadMsgLite getConversationFacade fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.3
 * JD-Core Version:    0.7.0.1
 */