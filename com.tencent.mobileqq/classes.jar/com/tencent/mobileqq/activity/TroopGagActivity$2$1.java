package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.ArrayList;

class TroopGagActivity$2$1
  implements Runnable
{
  TroopGagActivity$2$1(TroopGagActivity.2 param2, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2.a.a, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopGagActivity.2.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1
 * JD-Core Version:    0.7.0.1
 */