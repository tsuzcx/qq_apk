package com.tencent.mobileqq.activity;

import afxa;
import bdpd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class BaseChatPie$26$1
  implements Runnable
{
  BaseChatPie$26$1(BaseChatPie.26 param26) {}
  
  public void run()
  {
    if (bdpd.a().c()) {}
    do
    {
      return;
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_Boolean = false;
    } while (!afxa.a(this.a.this$0.jdField_a_of_type_AndroidContentContext, this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa));
    this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.26.1
 * JD-Core Version:    0.7.0.1
 */