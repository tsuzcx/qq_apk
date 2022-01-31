package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import zxi;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private HotChatObserver a;
  
  protected int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b)) {
      return 7;
    }
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(35);
    localHotChatHandler.c();
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new zxi(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    localHotChatHandler.b();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */