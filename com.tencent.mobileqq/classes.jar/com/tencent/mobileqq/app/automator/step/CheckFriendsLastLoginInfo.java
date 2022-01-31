package com.tencent.mobileqq.app.automator.step;

import ajxj;
import aklh;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckFriendsLastLoginInfo
  extends AsyncStep
{
  private ajxj a;
  
  public int a()
  {
    if (((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1)).e())
    {
      if (this.jdField_a_of_type_Ajxj == null)
      {
        this.jdField_a_of_type_Ajxj = new aklh(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajxj);
      }
      return 2;
    }
    return 7;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajxj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_Ajxj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */