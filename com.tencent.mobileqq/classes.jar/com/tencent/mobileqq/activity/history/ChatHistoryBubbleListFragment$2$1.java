package com.tencent.mobileqq.activity.history;

import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryBubbleListFragment$2$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$2$1(ChatHistoryBubbleListFragment.2 param2, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool;
    if (localList.size() < 21) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryBubbleListAdapter.b(localList, bool);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.b = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701849));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.2.1
 * JD-Core Version:    0.7.0.1
 */