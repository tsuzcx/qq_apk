package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TroopManager$SaveTroopMemberTask
  implements Runnable
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  boolean jdField_a_of_type_Boolean;
  volatile boolean b = false;
  
  TroopManager$SaveTroopMemberTask(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    this.b = true;
    EntityManager localEntityManager = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.getStatus() == 1000) {
      localEntityManager.persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
    for (;;)
    {
      localEntityManager.close();
      new Handler(Looper.getMainLooper()).post(new TroopManager.SaveTroopMemberTask.1(this));
      if (this.jdField_a_of_type_Boolean) {
        TroopNameHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin);
      }
      this.b = false;
      this.this$0.b.remove(this);
      this.this$0.c();
      return;
      localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.SaveTroopMemberTask
 * JD-Core Version:    0.7.0.1
 */