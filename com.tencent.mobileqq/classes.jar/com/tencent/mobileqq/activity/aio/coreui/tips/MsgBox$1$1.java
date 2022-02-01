package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.MessageTips;
import mqq.os.MqqHandler;

class MsgBox$1$1
  implements Runnable
{
  MsgBox$1$1(MsgBox.1 param1) {}
  
  public void run()
  {
    CharSequence localCharSequence = MsgBox.a(this.a.this$0).a(this.a.jdField_a_of_type_AndroidContentIntent, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.a.jdField_a_of_type_ComTencentImcoreMessageMessage);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().obtainMessage(95, localCharSequence).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox.1.1
 * JD-Core Version:    0.7.0.1
 */