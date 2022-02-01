package com.tencent.mobileqq.app.automator.step;

import anca;
import andd;
import android.content.SharedPreferences;
import android.os.SystemClock;
import angr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateTroop
  extends AsyncStep
{
  private andd a;
  
  private void a()
  {
    if (this.jdField_a_of_type_Andd == null)
    {
      this.jdField_a_of_type_Andd = new angr(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Andd);
    }
    ((anca)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(20)).b();
  }
  
  public int a()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.b == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isTrooplistok", false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getEntityManagerFactory();
      if (((localObject instanceof QQEntityManagerFactory)) && (((QQEntityManagerFactory)localObject).isUpdated())) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean = false;
      }
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(52);
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCheckTroopList:Done");
        }
        long l2 = SystemClock.uptimeMillis();
        anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(20);
        l2 = SystemClock.uptimeMillis() - l2;
        ((TroopManager)localObject).b();
        localanca.notifyUI(2, true, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(2));
        l1 = SystemClock.uptimeMillis() - l1 - l2;
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("UpdateTroop_withoutHandlerCost", Long.valueOf(l1));
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "troopHandler creation cost: " + l2 + ", total cost without troopHandler: " + l1);
        }
        return 7;
      }
      ((TroopManager)localObject).b();
      a();
    }
    for (;;)
    {
      return 2;
      a();
    }
  }
  
  public void b()
  {
    this.c = 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Andd != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Andd);
      this.jdField_a_of_type_Andd = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop
 * JD-Core Version:    0.7.0.1
 */