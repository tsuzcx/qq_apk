package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

final class RecentUtil$4
  implements Runnable
{
  RecentUtil$4(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = TroopBarAssistantManager.a().h(this.a);
    int j = 0;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    while (j < i)
    {
      Object localObject = (TroopBarData)localList.get(j);
      if (localObject != null)
      {
        localObject = this.a.getMessageFacade().getLastMessage(((TroopBarData)localObject).mUin, 1008);
        if (localObject != null) {
          TroopBarAssistantManager.a().a(this.a, ((Message)localObject).time);
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.4
 * JD-Core Version:    0.7.0.1
 */