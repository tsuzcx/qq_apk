package com.tencent.mobileqq.activity;

import aemb;
import android.view.ViewGroup;
import bajq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;
import mqq.os.MqqHandler;

class BaseChatPie$27
  implements Runnable
{
  BaseChatPie$27(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (bajq.a().c()) {}
    do
    {
      return;
      if ((aemb.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 3, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb)) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.a != this.this$0.d.getBackground())) {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.a));
      }
    } while (!ChatBackgroundManager.b(new File(aemb.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    ThreadManager.getSubThreadHandler().postDelayed(new BaseChatPie.27.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.27
 * JD-Core Version:    0.7.0.1
 */