package com.tencent.mobileqq.app.automator.step;

import alqf;
import alqh;
import amhk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private alqh a;
  
  public int a()
  {
    if (this.jdField_a_of_type_Alqh == null)
    {
      this.jdField_a_of_type_Alqh = new amhk(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Alqh);
    }
    if (((alqf)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Alqh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Alqh);
      this.jdField_a_of_type_Alqh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */