package com.tencent.mobileqq.activity.aio.core;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import java.io.File;
import mqq.os.MqqHandler;

class BaseChatPie$24
  implements Runnable
{
  BaseChatPie$24(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (AIOMusicSkin.a().m_()) {}
    do
    {
      return;
      if ((ChatBackground.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 3, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != this.this$0.d.getBackground())) {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a));
      }
    } while (!ChatBackgroundManager.b(new File(ChatBackground.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    ThreadManager.getSubThreadHandler().postDelayed(new BaseChatPie.24.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.24
 * JD-Core Version:    0.7.0.1
 */