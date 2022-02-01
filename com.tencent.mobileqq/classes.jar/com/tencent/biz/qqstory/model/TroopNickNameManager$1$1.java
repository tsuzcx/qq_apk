package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopNickNameManager$1$1
  implements Runnable
{
  TroopNickNameManager$1$1(TroopNickNameManager.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str1 = ((TroopMemberCardInfo)this.a.get(0)).troopuin;
    ArrayList localArrayList = new ArrayList(this.a.size());
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)((Iterator)localObject).next();
      String str2 = TroopNickNameManager.b(str1, localTroopMemberCardInfo.memberuin);
      if ((this.b.a.b.remove(str2) == null) && (QLog.isColorLevel()))
      {
        QLog.d("TroopNickNameManager", 2, "loading not match, return");
        return;
      }
      localArrayList.add(localTroopMemberCardInfo.memberuin);
    }
    if (localArrayList.size() > 0)
    {
      localObject = new TroopNickNameManager.TroopNickNameUpdateEvent();
      ((TroopNickNameManager.TroopNickNameUpdateEvent)localObject).a = localArrayList;
      ((TroopNickNameManager.TroopNickNameUpdateEvent)localObject).b = str1;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.1.1
 * JD-Core Version:    0.7.0.1
 */