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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReminderDataManager$5
  implements Runnable
{
  public ReminderDataManager$5(agdj paramagdj, boolean paramBoolean, List paramList, agdq paramagdq) {}
  
  public void run()
  {
    agdj.a(this.this$0);
    Object localObject1;
    if ((agdj.a(this.this$0) != null) && (agdj.a(this.this$0).get()) && (!this.jdField_a_of_type_Boolean))
    {
      localObject1 = new ArrayList(agdj.a(this.this$0).values());
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "async from cache, msg count: ", Integer.valueOf(((List)localObject1).size()) });
      }
      localObject1 = ((List)localObject1).iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ReminderEntity)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilList.add(((ReminderEntity)localObject2).getAcsMsg());
      continue;
      localObject1 = agdj.a(this.this$0, NetConnInfoCenter.getServerTimeMillis());
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderDataManagerNew", 1, "async from db, msg list is null");
        }
      }
      while ((!agdj.a(this.this$0).get()) || (this.jdField_a_of_type_Boolean))
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AcsMsg)((Iterator)localObject1).next();
            agdj.a(this.this$0, (AcsMsg)localObject2, 1);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("ReminderDataManagerNew", 1, new Object[] { "async from db, msg count: ", Integer.valueOf(((List)localObject1).size()) });
            }
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ReminderEntity)((Iterator)localObject1).next();
              this.jdField_a_of_type_JavaUtilList.add(((ReminderEntity)localObject2).getAcsMsg());
            }
            break;
          }
        }
        agdj.a(this.this$0).set(true);
        agdj.a(this.this$0).edit().putString("sp_key_cache_list_time", agce.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd")).apply();
      }
    }
    this.jdField_a_of_type_Agdq.a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.5
 * JD-Core Version:    0.7.0.1
 */