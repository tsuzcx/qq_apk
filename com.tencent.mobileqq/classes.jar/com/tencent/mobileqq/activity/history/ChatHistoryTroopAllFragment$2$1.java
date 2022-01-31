package com.tencent.mobileqq.activity.history;

import agzc;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryTroopAllFragment$2$1
  implements Runnable
{
  ChatHistoryTroopAllFragment$2$1(ChatHistoryTroopAllFragment.2 param2, List paramList) {}
  
  public void run()
  {
    agzc localagzc = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20) {}
    for (boolean bool = true;; bool = false)
    {
      localagzc.a(localList, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.getItem(0)).shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.b = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.getCount() - 1)).shmsgseq;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$2.this$0.jdField_a_of_type_Agzc.getCount() - 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.2.1
 * JD-Core Version:    0.7.0.1
 */