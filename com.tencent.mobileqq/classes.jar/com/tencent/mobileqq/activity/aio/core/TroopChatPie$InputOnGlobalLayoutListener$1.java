package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class TroopChatPie$InputOnGlobalLayoutListener$1
  implements Runnable
{
  TroopChatPie$InputOnGlobalLayoutListener$1(TroopChatPie.InputOnGlobalLayoutListener paramInputOnGlobalLayoutListener) {}
  
  public void run()
  {
    String str = this.a.a.ah.b;
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((ITroopBatchAddFriendService)this.a.a.d.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    Object localObject1 = localTroopBatchAddFriendMgr.f(str);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (this.a.a.e((String)localObject2)) {
          localArrayList.add(localObject2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.a.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CheckNewMemberDataWhenEnterAIO visibleUins size = ");
      ((StringBuilder)localObject2).append(localArrayList.size());
      ((StringBuilder)localObject2).append(",visibleUins = ");
      ((StringBuilder)localObject2).append(localArrayList);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (localArrayList.size() > 0) {
      localTroopBatchAddFriendMgr.a(str, localArrayList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.InputOnGlobalLayoutListener.1
 * JD-Core Version:    0.7.0.1
 */