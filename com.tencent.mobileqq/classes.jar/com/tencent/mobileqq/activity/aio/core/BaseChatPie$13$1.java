package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import mqq.os.MqqHandler;

class BaseChatPie$13$1
  implements Runnable
{
  BaseChatPie$13$1(BaseChatPie.13 param13) {}
  
  public void run()
  {
    if (AIOMusicSkin.a().n_()) {
      return;
    }
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_Boolean = false;
    if (ChatBackground.a(this.a.this$0.jdField_a_of_type_AndroidContentContext, this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.13.1
 * JD-Core Version:    0.7.0.1
 */