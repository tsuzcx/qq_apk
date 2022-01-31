package com.tencent.mobileqq.activity.history;

import ahdr;
import android.view.View;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryBubbleListFragment$4$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$4$1(ChatHistoryBubbleListFragment.4 param4, List paramList) {}
  
  public void run()
  {
    int j = 1;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.a != this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_b_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "loadingContext changed, ignored result local=" + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.a + ", global=" + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_b_of_type_Int);
      }
      return;
    }
    ahdr localahdr = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr;
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool;
    label115:
    int i1;
    label237:
    int m;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20)
    {
      bool = true;
      i1 = localahdr.a(localList, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.getItem(0)).shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_b_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.getCount() - 1)).shmsgseq;
      }
      if ((i1 == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0)) {
        break label458;
      }
      if (j == 0) {
        break label463;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
      k = m;
      i = n;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() < 0) {
        i = n - this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
      }
    }
    label458:
    label463:
    for (int k = m;; k = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_Ahdr.notifyDataSetChanged();
      if (j == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(k + i1, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("chatHistory.troop.msgList", 2, "update position pos=" + k + ", offset=" + i1 + ", top=" + i);
      return;
      bool = false;
      break label115;
      j = 0;
      break label237;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.4.1
 * JD-Core Version:    0.7.0.1
 */