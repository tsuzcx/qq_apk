package com.tencent.mobileqq.activity.main;

import ajvr;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class MainAssistObserver$16$1
  implements Runnable
{
  MainAssistObserver$16$1(MainAssistObserver.16 param16, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver$16.this$0.a(32, 16, Integer.valueOf(this.jdField_a_of_type_Int));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver$16.a.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.16.1
 * JD-Core Version:    0.7.0.1
 */