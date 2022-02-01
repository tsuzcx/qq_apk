package com.tencent.mobileqq.app.automator.step;

import amwl;
import angd;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private amwl a;
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMsgHandler().a(3, true);
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Amwl == null)
    {
      this.jdField_a_of_type_Amwl = new angd(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addDefaultObservers(this.jdField_a_of_type_Amwl);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amwl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Amwl);
      this.jdField_a_of_type_Amwl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */