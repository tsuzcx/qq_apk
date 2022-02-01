package com.tencent.mobileqq.app.automator.step;

import anzp;
import aoaa;
import aomm;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private aoaa a;
  
  public int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app)) {
      return 7;
    }
    anzp localanzp = (anzp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(35);
    this.jdField_a_of_type_Aoaa = new aomm(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Aoaa);
    localanzp.a();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aoaa != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aoaa);
      this.jdField_a_of_type_Aoaa = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */