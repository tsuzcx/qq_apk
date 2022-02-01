package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private ConfigObserver a;
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new CheckAuthCode.CheckAuthCodeObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
    if (((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */