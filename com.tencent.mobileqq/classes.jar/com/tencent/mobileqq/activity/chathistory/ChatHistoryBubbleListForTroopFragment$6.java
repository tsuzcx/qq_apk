package com.tencent.mobileqq.activity.chathistory;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistoryBubbleListForTroopFragment$6
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryBubbleListForTroopFragment$6(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.6.1(this), 5, null, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.6
 * JD-Core Version:    0.7.0.1
 */