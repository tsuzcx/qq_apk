package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private HotChatObserver a;
  
  public int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a)) {
      return 7;
    }
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new GetJoinedHotChatListStep.GetJoindedHotChatListObserver(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    localHotChatHandler.a();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */