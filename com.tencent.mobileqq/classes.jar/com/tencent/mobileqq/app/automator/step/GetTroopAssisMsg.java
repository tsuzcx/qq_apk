package com.tencent.mobileqq.app.automator.step;

import aocj;
import aomr;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private aocj a;
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(3, true);
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aocj == null)
    {
      this.jdField_a_of_type_Aocj = new aomr(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Aocj);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aocj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aocj);
      this.jdField_a_of_type_Aocj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */