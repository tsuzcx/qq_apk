package com.tencent.mobileqq.app.automator.step;

import ajud;
import ajuf;
import aklf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private ajuf a;
  
  public int a()
  {
    if (this.jdField_a_of_type_Ajuf == null)
    {
      this.jdField_a_of_type_Ajuf = new aklf(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Ajuf);
    }
    if (((ajud)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajuf != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajuf);
      this.jdField_a_of_type_Ajuf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */