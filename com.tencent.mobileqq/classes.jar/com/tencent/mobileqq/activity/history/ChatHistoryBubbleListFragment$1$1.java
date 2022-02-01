package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryBubbleListFragment$1$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$1$1(ChatHistoryBubbleListFragment.1 param1, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20) {}
    for (boolean bool = true;; bool = false)
    {
      localChatHistoryBubbleListAdapter.a(localList, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.b = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.1.1
 * JD-Core Version:    0.7.0.1
 */