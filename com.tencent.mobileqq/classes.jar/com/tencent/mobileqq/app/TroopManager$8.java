package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;

class TroopManager$8
  implements Runnable
{
  TroopManager$8(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.getStatus() == 1000) {
      ((EntityManager)localObject).persistOrReplace(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      localObject = this.this$0.c(this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).post(new TroopManager.8.1(this, (ArrayList)localObject));
      return;
      ((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.8
 * JD-Core Version:    0.7.0.1
 */