package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import agce;
import agdj;
import agdq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.activateFriend.biz.entity.ReminderEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReminderDataManager$4
  implements Runnable
{
  public ReminderDataManager$4(agdj paramagdj, agdq paramagdq) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    agdj.a(this.this$0);
    Object localObject = agdj.a(this.this$0, NetConnInfoCenter.getServerTimeMillis());
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, "async from db, msg list is null");
      }
    }
    while (!agdj.a(this.this$0).get())
    {
      localObject = localArrayList.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          AcsMsg localAcsMsg = (AcsMsg)((Iterator)localObject).next();
          agdj.a(this.this$0, localAcsMsg, 1);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ReminderDataManagerNew", 1, new Object[] { "async from db, msg count: ", Integer.valueOf(((List)localObject).size()) });
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((ReminderEntity)((Iterator)localObject).next()).getAcsMsg());
          }
          break;
        }
      }
      agdj.a(this.this$0).set(true);
      agdj.a(this.this$0).edit().putString("sp_key_cache_list_time", agce.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
    }
    this.a.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.4
 * JD-Core Version:    0.7.0.1
 */