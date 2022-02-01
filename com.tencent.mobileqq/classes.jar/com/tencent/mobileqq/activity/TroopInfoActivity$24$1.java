package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

class TroopInfoActivity$24$1
  implements Runnable
{
  TroopInfoActivity$24$1(TroopInfoActivity.24 param24, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity$24.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.24.1
 * JD-Core Version:    0.7.0.1
 */