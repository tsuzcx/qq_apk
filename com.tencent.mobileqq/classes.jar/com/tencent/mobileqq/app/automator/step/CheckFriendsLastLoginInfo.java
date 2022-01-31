package com.tencent.mobileqq.app.automator.step;

import ajjh;
import ajwy;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckFriendsLastLoginInfo
  extends AsyncStep
{
  private ajjh a;
  
  public int a()
  {
    if (((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1)).e())
    {
      if (this.jdField_a_of_type_Ajjh == null)
      {
        this.jdField_a_of_type_Ajjh = new ajwy(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajjh);
      }
      return 2;
    }
    return 7;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajjh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_Ajjh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */