package com.tencent.mobileqq.app.automator.step;

import ajtg;
import ajuc;
import ajyj;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class UpdateTroop
  extends AsyncStep
{
  private ajuc a;
  
  private void b()
  {
    if (this.jdField_a_of_type_Ajuc == null)
    {
      this.jdField_a_of_type_Ajuc = new ajyj(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajuc);
    }
    ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(20)).b();
  }
  
  public int a()
  {
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
        ajtg localajtg = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(20);
        ((TroopManager)localObject).b();
        localajtg.notifyUI(2, true, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(2));
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
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajuc != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajuc);
      this.jdField_a_of_type_Ajuc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop
 * JD-Core Version:    0.7.0.1
 */