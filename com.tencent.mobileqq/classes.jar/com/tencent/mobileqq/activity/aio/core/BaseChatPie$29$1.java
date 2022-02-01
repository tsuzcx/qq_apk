package com.tencent.mobileqq.activity.aio.core;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import mqq.os.MqqHandler;

class BaseChatPie$29$1
  implements Runnable
{
  BaseChatPie$29$1(BaseChatPie.29 param29) {}
  
  public void run()
  {
    CharSequence localCharSequence = this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a(this.a.jdField_a_of_type_AndroidContentIntent, this.a.jdField_a_of_type_ComTencentImcoreMessageMessage);
    this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(95, localCharSequence).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.29.1
 * JD-Core Version:    0.7.0.1
 */