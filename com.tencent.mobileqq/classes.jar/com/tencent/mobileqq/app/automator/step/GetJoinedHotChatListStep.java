package com.tencent.mobileqq.app.automator.step;

import ajyg;
import ajyr;
import aklz;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private ajyr a;
  
  public int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app)) {
      return 7;
    }
    ajyg localajyg = (ajyg)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(35);
    this.jdField_a_of_type_Ajyr = new aklz(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajyr);
    localajyg.a();
    return 2;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajyr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajyr);
      this.jdField_a_of_type_Ajyr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */