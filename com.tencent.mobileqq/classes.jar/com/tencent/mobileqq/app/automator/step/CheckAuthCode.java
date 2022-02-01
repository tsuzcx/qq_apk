package com.tencent.mobileqq.app.automator.step;

import ansg;
import ansi;
import aoht;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private ansi a;
  
  public int a()
  {
    if (this.jdField_a_of_type_Ansi == null)
    {
      this.jdField_a_of_type_Ansi = new aoht(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addDefaultObservers(this.jdField_a_of_type_Ansi);
    }
    if (((ansg)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ansi != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ansi);
      this.jdField_a_of_type_Ansi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */