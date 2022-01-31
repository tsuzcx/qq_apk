package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import znx;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private MessageObserver a;
  
  protected int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a(3, true);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new znx(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */