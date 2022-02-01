package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryBubbleListFragment$3$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$3$1(ChatHistoryBubbleListFragment.3 param3, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.a != this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadingContext changed, ignored result local=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.a);
        ((StringBuilder)localObject).append(", global=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_b_of_type_Int);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    List localList = this.jdField_a_of_type_JavaUtilList;
    int j = localList.size();
    int i = 1;
    int k = 0;
    boolean bool;
    if (j < 20) {
      bool = true;
    } else {
      bool = false;
    }
    int m = ((ChatHistoryBubbleListAdapter)localObject).b(localList, bool);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(0)).shmsgseq;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_b_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() - 1)).shmsgseq;
    }
    if ((m == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0)) {
      i = 0;
    }
    if (i != 0)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
    }
    else
    {
      j = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701838));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$3.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(j + m, k);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update position pos=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", offset=");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(", top=");
        ((StringBuilder)localObject).append(k);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.3.1
 * JD-Core Version:    0.7.0.1
 */