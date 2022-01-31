package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import aukp;
import aukq;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TroopManager$SaveTroopMemberTask
  implements Runnable
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  boolean jdField_a_of_type_Boolean;
  volatile boolean b = false;
  
  TroopManager$SaveTroopMemberTask(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    this.b = true;
    aukp localaukp = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.getStatus() == 1000) {
      localaukp.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
    for (;;)
    {
      localaukp.a();
      new Handler(Looper.getMainLooper()).post(new TroopManager.SaveTroopMemberTask.1(this));
      if (this.jdField_a_of_type_Boolean) {
        TroopNameHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin);
      }
      this.b = false;
      this.this$0.b.remove(this);
      this.this$0.c();
      return;
      localaukp.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.SaveTroopMemberTask
 * JD-Core Version:    0.7.0.1
 */