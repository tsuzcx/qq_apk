package com.tencent.mobileqq.activity;

import aael;
import android.content.Context;
import android.content.res.Resources;
import anmf;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$63
  implements Runnable
{
  BaseChatPie$63(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    aael.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    try
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846017);
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846018);
      this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837708);
      anmf.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.63
 * JD-Core Version:    0.7.0.1
 */