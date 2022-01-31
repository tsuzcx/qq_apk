package com.tencent.mobileqq.app.automator.step;

import ajuf;
import ajuh;
import aklg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private ajuh a;
  
  public int a()
  {
    if (this.jdField_a_of_type_Ajuh == null)
    {
      this.jdField_a_of_type_Ajuh = new aklg(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Ajuh);
    }
    if (((ajuf)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajuh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajuh);
      this.jdField_a_of_type_Ajuh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */