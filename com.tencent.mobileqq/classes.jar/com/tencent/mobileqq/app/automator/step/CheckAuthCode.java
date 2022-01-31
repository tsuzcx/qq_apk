package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import zmt;

public class CheckAuthCode
  extends AsyncStep
{
  private ConfigObserver a;
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new zmt(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
    if (((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(4)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */