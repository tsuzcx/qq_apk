package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class BaseChatPie$48$1
  implements Runnable
{
  BaseChatPie$48$1(BaseChatPie.48 param48) {}
  
  public void run()
  {
    CharSequence localCharSequence = this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.a(this.a.jdField_a_of_type_AndroidContentIntent, this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$Message);
    this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(95, localCharSequence).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.48.1
 * JD-Core Version:    0.7.0.1
 */