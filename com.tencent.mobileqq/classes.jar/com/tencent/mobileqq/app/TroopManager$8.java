package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import awgf;
import awgg;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.ArrayList;

class TroopManager$8
  implements Runnable
{
  TroopManager$8(TroopManager paramTroopManager, TroopMemberInfo paramTroopMemberInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.getStatus() == 1000) {
      ((awgf)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
    for (;;)
    {
      ((awgf)localObject).a();
      localObject = this.this$0.c(this.jdField_a_of_type_JavaLangString);
      new Handler(Looper.getMainLooper()).post(new TroopManager.8.1(this, (ArrayList)localObject));
      return;
      ((awgf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.8
 * JD-Core Version:    0.7.0.1
 */