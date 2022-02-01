package com.tencent.mobileqq.activity.chathistory;

import aiqw;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryBubbleListForTroopFragment$3$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$3$1(ChatHistoryBubbleListForTroopFragment.3 param3, List paramList) {}
  
  public void run()
  {
    aiqw localaiqw = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (this.jdField_a_of_type_JavaUtilList.size() < 21) {}
    for (boolean bool = true;; bool = false)
    {
      localaiqw.b(localList, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.getItem(0)).shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.b = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.getCount() - 1)).shmsgseq;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.b = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701147));
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.b, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment$3.this$0.jdField_a_of_type_Aiqw.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.3.1
 * JD-Core Version:    0.7.0.1
 */