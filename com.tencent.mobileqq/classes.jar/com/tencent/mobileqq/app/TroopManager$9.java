package com.tencent.mobileqq.app;

import android.os.Handler;
import aukn;
import auko;
import com.tencent.mobileqq.data.TroopMemberInfo;

class TroopManager$9
  implements Runnable
{
  TroopManager$9(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, Handler paramHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.getStatus() == 1000) {
      localaukn.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
    for (;;)
    {
      localaukn.a();
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopManager.9.1(this));
      return;
      localaukn.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.9
 * JD-Core Version:    0.7.0.1
 */