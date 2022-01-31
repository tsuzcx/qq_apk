package com.tencent.mobileqq.activity.main;

import aiez;
import axap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$15
  implements Runnable
{
  public MainAssistObserver$15(aiez paramaiez, QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    int i = axap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b();
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "updateTab = " + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new MainAssistObserver.15.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.15
 * JD-Core Version:    0.7.0.1
 */