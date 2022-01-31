package com.tencent.mobileqq.app.proxy.fts;

import amnu;
import amof;
import amog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import asiu;
import awgf;
import awgg;
import ayzl;
import ayzq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FTSTroopOperator$1
  implements Runnable
{
  public FTSTroopOperator$1(amog paramamog) {}
  
  public void run()
  {
    if (!amog.a(this.this$0))
    {
      amog.a(this.this$0);
      if (amog.b(this.this$0) >= 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp failed");
        }
        return;
      }
      this.this$0.jdField_a_of_type_Amof.postDelayed(this, 5000L);
      return;
    }
    this.this$0.b();
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = amog.a(this.this$0).a();
    Object localObject3 = ((awgf)localObject1).a(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, null, null, null, null, null, null);
    ((awgf)localObject1).a();
    if (localObject2 != null)
    {
      localObject1 = new HashMap();
      localObject2 = ((List)localObject2).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (TroopInfo)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(((TroopInfo)localObject4).troopuin, localObject4);
      }
      localObject2 = new ArrayList();
      Object localObject5;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          FTSTroopTime localFTSTroopTime = (FTSTroopTime)((Iterator)localObject3).next();
          localObject4 = localFTSTroopTime.mTroopUin;
          if (((HashMap)localObject1).containsKey(localObject4))
          {
            localObject5 = (TroopInfo)((HashMap)localObject1).get(localObject4);
            if ((((TroopInfo)localObject5).wMemberNum == 0) || (((TroopInfo)localObject5).mMemberNumSeq == 0L))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp troop ignore troopuin:" + (String)localObject4 + " wMemberNum:" + ((TroopInfo)localObject5).wMemberNum + " mMemberNumSeq:" + ((TroopInfo)localObject5).mMemberNumSeq);
              }
              ((HashMap)localObject1).remove(localObject4);
            }
            else
            {
              if (localFTSTroopTime.mTimeStamp < ((TroopInfo)localObject5).mMemberNumSeq) {}
              try
              {
                ((ArrayList)localObject2).add(new FTSTroopSync(5, Long.parseLong(((TroopInfo)localObject5).troopuin)));
                if (QLog.isColorLevel()) {
                  QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp add troop:" + ((TroopInfo)localObject5).troopname + " mMemberNumSeq:" + ((TroopInfo)localObject5).mMemberNumSeq + " troopTime:" + localFTSTroopTime.toString());
                }
                ((HashMap)localObject1).remove(localObject4);
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.fts.troop.operator", 2, "checkTroopTimeStamp e:" + localException3.toString());
                  }
                }
              }
            }
          }
          else
          {
            try
            {
              ((ArrayList)localObject2).add(new FTSTroopSync(4, Long.parseLong((String)localObject4)));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp delete troop=" + (String)localObject4);
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel()) {
              QLog.e("Q.fts.troop.operator", 2, "checkTroopTimeStamp e:" + localException2.toString());
            }
          }
        }
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (ayzl.a != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (ayzl.a.a != null)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (ayzl.a.a.size() > 0)
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            localObject3 = ayzl.a.a.entrySet().iterator();
            if (((Iterator)localObject3).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
              String str = (String)localEntry.getKey();
              i = 0;
              while (i < ((ArrayList)localEntry.getValue()).size()) {
                try
                {
                  localObject5 = (String)((ArrayList)localEntry.getValue()).get(i);
                  ((ArrayList)localObject2).add(new FTSTroopSync(3, Long.parseLong(str), Long.parseLong((String)localObject5)));
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.fts.troop.operator", 2, "checkTroopMemberCache modify troop=" + str + " member=" + (String)localObject5);
                  }
                  i += 1;
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("Q.fts.troop.operator", 2, "checkTroopMemberCache e:" + localException4.toString());
                    }
                  }
                }
              }
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            ayzl.a.a.clear();
          }
        }
      }
      i = asiu.b(this.this$0.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "FTSDatabaseHelper.queryItemCount = " + i);
      }
      if (i > 0)
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext()) {
          try
          {
            ((ArrayList)localObject2).add(new FTSTroopSync(5, Long.parseLong((String)((Map.Entry)((Iterator)localObject1).next()).getKey())));
          }
          catch (Exception localException1)
          {
            i += 1;
          }
        }
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.e("Q.fts.troop.operator", 2, "checkTroopTimeStamp add syncData fail " + i);
        }
      }
      this.this$0.b((ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp optList.size:" + ((ArrayList)localObject2).size());
      }
    }
    amog.a(this.this$0).f();
    localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int i = ((SharedPreferences)localObject1).getInt("is_first_upgrade_to_500", 0);
    if (i == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("is_first_upgrade_to_500", 1).commit();
      if (amog.a(this.this$0) == null) {
        amog.a(this.this$0, new FTSTroopOperator.1.1(this));
      }
      this.this$0.jdField_a_of_type_Amof.postDelayed(amog.a(this.this$0), 86400000L);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_Amof.obtainMessage(1, this.this$0).sendToTarget();
      this.this$0.jdField_a_of_type_Amof.obtainMessage(1, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4)).sendToTarget();
      return;
      if (i == 1) {
        ((SharedPreferences)localObject1).edit().putInt("is_first_upgrade_to_500", 2).commit();
      }
      if (amog.a(this.this$0) != null)
      {
        this.this$0.jdField_a_of_type_Amof.removeCallbacks(amog.a(this.this$0));
        amog.a(this.this$0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator.1
 * JD-Core Version:    0.7.0.1
 */