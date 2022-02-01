package com.tencent.mobileqq.activity.main;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$21
  implements Runnable
{
  MainAssistObserver$21(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    int i = QCallFacade.a(this.a);
    i = this.b.w() + i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTab = ");
      localStringBuilder.append(i);
      QLog.d("MainAssistObserver", 2, localStringBuilder.toString());
    }
    this.a.runOnUiThread(new MainAssistObserver.21.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.21
 * JD-Core Version:    0.7.0.1
 */