package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListForTroopFragment$5
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$5(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment, int paramInt) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_JavaLangString, 1, this.this$0.jdField_a_of_type_Long, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListForTroopFragment.5.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.5
 * JD-Core Version:    0.7.0.1
 */