package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistoryTroopAllFragment$6
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryTroopAllFragment$6(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ThreadManager.post(new ChatHistoryTroopAllFragment.6.1(this), 5, null, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.getCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(ChatHistoryTroopAllFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.6
 * JD-Core Version:    0.7.0.1
 */