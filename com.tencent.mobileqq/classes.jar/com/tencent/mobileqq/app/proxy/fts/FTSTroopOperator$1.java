package com.tencent.mobileqq.app.proxy.fts;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import aone;
import aonm;
import aonn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FTSTroopOperator$1
  implements Runnable
{
  public FTSTroopOperator$1(aonn paramaonn) {}
  
  public void run()
  {
    if (!aonn.a(this.this$0))
    {
      aonn.a(this.this$0);
      if (aonn.b(this.this$0) >= 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp failed");
        }
        return;
      }
      this.this$0.jdField_a_of_type_Aonm.postDelayed(this, 5000L);
      return;
    }
    this.this$0.b();
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ArrayList localArrayList = aonn.a(this.this$0).a();
    List localList = ((EntityManager)localObject).query(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, null, null, null, null, null, null);
    ((EntityManager)localObject).close();
    aonn.a(this.this$0, localArrayList, localList);
    aonn.a(this.this$0).f();
    localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int i = ((SharedPreferences)localObject).getInt("is_first_upgrade_to_500", 0);
    if (i == 0)
    {
      ((SharedPreferences)localObject).edit().putInt("is_first_upgrade_to_500", 1).commit();
      if (aonn.a(this.this$0) == null) {
        aonn.a(this.this$0, new FTSTroopOperator.1.1(this));
      }
      this.this$0.jdField_a_of_type_Aonm.postDelayed(aonn.a(this.this$0), 86400000L);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_Aonm.obtainMessage(1, this.this$0).sendToTarget();
      this.this$0.jdField_a_of_type_Aonm.obtainMessage(1, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4)).sendToTarget();
      return;
      if (i == 1) {
        ((SharedPreferences)localObject).edit().putInt("is_first_upgrade_to_500", 2).commit();
      }
      if (aonn.a(this.this$0) != null)
      {
        this.this$0.jdField_a_of_type_Aonm.removeCallbacks(aonn.a(this.this$0));
        aonn.a(this.this$0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator.1
 * JD-Core Version:    0.7.0.1
 */