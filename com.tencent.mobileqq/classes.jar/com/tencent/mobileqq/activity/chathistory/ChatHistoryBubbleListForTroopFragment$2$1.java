package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryBubbleListForTroopFragment$2$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$2$1(ChatHistoryBubbleListForTroopFragment.2 param2, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20) {}
    for (boolean bool = true;; bool = false)
    {
      localChatHistoryBubbleListAdapter.a(localList, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.b = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.2.1
 * JD-Core Version:    0.7.0.1
 */