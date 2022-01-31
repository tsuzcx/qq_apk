package com.tencent.mobileqq.app.automator.step;

import akmm;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.observer.AccountObserver;

public class RegisterPush
  extends AsyncStep
{
  private AccountObserver a;
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().e();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.p();
    return 2;
  }
  
  public void a()
  {
    if (this.b == 13) {}
    for (this.c = 0;; this.c = 10)
    {
      this.jdField_a_of_type_MqqObserverAccountObserver = new akmm(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqObserverAccountObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.jdField_a_of_type_MqqObserverAccountObserver = null;
    }
    if ((this.b == 12) && (this.jdField_a_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush
 * JD-Core Version:    0.7.0.1
 */