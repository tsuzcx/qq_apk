package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import zrv;

public class UpdateTroop
  extends AsyncStep
{
  private TroopObserver a;
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new zrv(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(20)).b();
  }
  
  protected int a()
  {
    if (this.b == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isTrooplistok", false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getEntityManagerFactory();
      if (((localObject instanceof QQEntityManagerFactory)) && (((QQEntityManagerFactory)localObject).isUpdated())) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean = false;
      }
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(51);
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCheckTroopList:Done");
        }
        TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(20);
        ((TroopManager)localObject).b();
        localTroopHandler.a(2, true, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(3, true, Integer.valueOf(2));
        return 7;
      }
      ((TroopManager)localObject).b();
      b();
    }
    for (;;)
    {
      return 2;
      b();
    }
  }
  
  public void a()
  {
    this.c = 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop
 * JD-Core Version:    0.7.0.1
 */