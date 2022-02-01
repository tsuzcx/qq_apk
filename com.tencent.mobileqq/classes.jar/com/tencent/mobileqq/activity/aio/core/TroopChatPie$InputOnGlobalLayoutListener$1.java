package com.tencent.mobileqq.activity.aio.core;

import agbs;
import aoep;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopChatPie$InputOnGlobalLayoutListener$1
  implements Runnable
{
  public TroopChatPie$InputOnGlobalLayoutListener$1(agbs paramagbs) {}
  
  public void run()
  {
    String str1 = this.a.a.sessionInfo.curFriendUin;
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((aoep)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
    Object localObject = localTroopBatchAddFriendMgr.a(str1);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if (this.a.a.a(str2)) {
          localArrayList.add(str2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a.tag, 2, "CheckNewMemberDataWhenEnterAIO visibleUins size = " + localArrayList.size() + ",visibleUins = " + localArrayList);
    }
    if (localArrayList.size() > 0) {
      localTroopBatchAddFriendMgr.a(str1, localArrayList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.InputOnGlobalLayoutListener.1
 * JD-Core Version:    0.7.0.1
 */