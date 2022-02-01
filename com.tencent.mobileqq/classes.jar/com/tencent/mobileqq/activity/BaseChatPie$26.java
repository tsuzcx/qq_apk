package com.tencent.mobileqq.activity;

import aggu;
import android.view.ViewGroup;
import behz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;
import mqq.os.MqqHandler;

class BaseChatPie$26
  implements Runnable
{
  BaseChatPie$26(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (behz.a().c()) {}
    do
    {
      return;
      if ((aggu.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 3, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu)) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a != this.this$0.d.getBackground())) {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu.a));
      }
    } while (!ChatBackgroundManager.b(new File(aggu.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    ThreadManager.getSubThreadHandler().postDelayed(new BaseChatPie.26.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.26
 * JD-Core Version:    0.7.0.1
 */