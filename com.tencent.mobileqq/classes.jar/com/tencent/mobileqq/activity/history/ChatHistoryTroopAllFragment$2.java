package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryTroopAllFragment$2
  implements Runnable
{
  ChatHistoryTroopAllFragment$2(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_b_of_type_JavaLangString, 1, 9223372036854775807L, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopAllFragment.2.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.2
 * JD-Core Version:    0.7.0.1
 */