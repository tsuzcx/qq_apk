package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopMemberListActivity$49
  implements Runnable
{
  TroopMemberListActivity$49(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    try
    {
      localObject4 = this.this$0.app.getEntityManagerFactory().createEntityManager();
      if (localObject4 == null) {
        break label177;
      }
      localObject1 = ((EntityManager)localObject4).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.mTroopUin }, null, null, null, null);
      ((EntityManager)localObject4).close();
    }
    finally
    {
      for (;;)
      {
        Object localObject4;
        Object localObject1;
        for (;;)
        {
          throw localObject2;
        }
        label177:
        Object localObject3 = null;
      }
    }
    if (localObject1 != null)
    {
      localObject4 = new ArrayList(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject4).add(((TroopMemberInfo)((Iterator)localObject1).next()).memberuin);
      }
      localObject1 = this.this$0.mHandler.obtainMessage();
      ((Message)localObject1).what = 8;
      ((Message)localObject1).obj = new Object[] { Boolean.valueOf(this.this$0.mIsTroopAdmin), localObject4 };
      this.this$0.mHandler.sendMessage((Message)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.49
 * JD-Core Version:    0.7.0.1
 */