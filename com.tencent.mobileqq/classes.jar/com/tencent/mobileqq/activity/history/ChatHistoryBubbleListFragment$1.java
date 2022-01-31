package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$1(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Int == 1) {}
    for (Object localObject = this.this$0.b;; localObject = this.this$0.jdField_a_of_type_JavaLangString)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.this$0.jdField_a_of_type_Int, 9223372036854775807L, 20);
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.1.1(this, (List)localObject));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.1
 * JD-Core Version:    0.7.0.1
 */