package com.tencent.mobileqq.activity.main;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$17
  implements Runnable
{
  MainAssistObserver$17(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    int i = QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b() + i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTab = ");
      localStringBuilder.append(i);
      QLog.d("MainAssistObserver", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new MainAssistObserver.17.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.17
 * JD-Core Version:    0.7.0.1
 */