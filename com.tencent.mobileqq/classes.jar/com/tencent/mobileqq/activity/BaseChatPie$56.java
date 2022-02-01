package com.tencent.mobileqq.activity;

import adrm;
import android.content.Context;
import android.content.res.Resources;
import ascv;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$56
  implements Runnable
{
  BaseChatPie$56(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    adrm.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    try
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847098);
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847099);
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838009);
      ascv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "emo qvip_emoji_aio_face_new_default_fail, e=" + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(this.this$0.jdField_a_of_type_JavaLangString, 1, "emo qvip_emoji_aio_face oom, e= " + localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.56
 * JD-Core Version:    0.7.0.1
 */