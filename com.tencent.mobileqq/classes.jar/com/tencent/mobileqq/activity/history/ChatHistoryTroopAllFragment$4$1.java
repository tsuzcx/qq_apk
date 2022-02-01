package com.tencent.mobileqq.activity.history;

import ajbn;
import android.view.View;
import android.widget.TextView;
import anzj;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryTroopAllFragment$4$1
  implements Runnable
{
  ChatHistoryTroopAllFragment$4$1(ChatHistoryTroopAllFragment.4 param4, List paramList) {}
  
  public void run()
  {
    int i = 1;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "loadingContext changed, ignored result local=" + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.jdField_a_of_type_Int + ", global=" + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Int);
      }
      return;
    }
    ajbn localajbn = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn;
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool;
    label115:
    int m;
    label237:
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() < 20)
    {
      bool = true;
      m = localajbn.b(localList, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.getItem(0)).shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.b = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.getCount() - 1)).shmsgseq;
      }
      if ((m == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0)) {
        break label458;
      }
      if (i == 0) {
        break label463;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700519));
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.c);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.getCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(ChatHistoryTroopAllFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_Ajbn.notifyDataSetChanged();
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment$4.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(j + m, k);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("chatHistory.troop.msgList", 2, "update position pos=" + j + ", offset=" + m + ", top=" + k);
      return;
      bool = false;
      break label115;
      label458:
      i = 0;
      break label237;
      label463:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.4.1
 * JD-Core Version:    0.7.0.1
 */