package com.tencent.mobileqq.app.automator.step;

import anwd;
import anwo;
import aoio;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private anwo a;
  
  public int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app)) {
      return 7;
    }
    anwd localanwd = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
    this.jdField_a_of_type_Anwo = new aoio(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anwo);
    localanwd.a();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anwo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Anwo);
      this.jdField_a_of_type_Anwo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */