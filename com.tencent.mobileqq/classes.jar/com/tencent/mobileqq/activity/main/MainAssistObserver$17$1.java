package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class MainAssistObserver$17$1
  implements Runnable
{
  MainAssistObserver$17$1(MainAssistObserver.17 param17, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver$17.this$0.a(32, 16, Integer.valueOf(this.jdField_a_of_type_Int));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver$17.a.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.17.1
 * JD-Core Version:    0.7.0.1
 */