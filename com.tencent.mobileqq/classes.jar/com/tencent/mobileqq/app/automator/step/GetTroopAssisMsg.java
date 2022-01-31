package com.tencent.mobileqq.app.automator.step;

import alwx;
import amij;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private alwx a;
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(3, true);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Alwx == null)
    {
      this.jdField_a_of_type_Alwx = new amij(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Alwx);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Alwx != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Alwx);
      this.jdField_a_of_type_Alwx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */