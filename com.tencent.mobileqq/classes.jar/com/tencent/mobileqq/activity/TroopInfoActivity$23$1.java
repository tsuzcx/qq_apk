package com.tencent.mobileqq.activity;

import afdd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopInfoActivity$23$1
  implements Runnable
{
  public TroopInfoActivity$23$1(afdd paramafdd, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    ((TroopManager)this.jdField_a_of_type_Afdd.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.23.1
 * JD-Core Version:    0.7.0.1
 */