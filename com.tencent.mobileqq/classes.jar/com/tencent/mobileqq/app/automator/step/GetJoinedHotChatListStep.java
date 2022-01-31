package com.tencent.mobileqq.app.automator.step;

import aluj;
import aluu;
import amie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private aluu a;
  
  public int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app)) {
      return 7;
    }
    aluj localaluj = (aluj)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(35);
    this.jdField_a_of_type_Aluu = new amie(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Aluu);
    localaluj.a();
    return 2;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aluu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aluu);
      this.jdField_a_of_type_Aluu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */