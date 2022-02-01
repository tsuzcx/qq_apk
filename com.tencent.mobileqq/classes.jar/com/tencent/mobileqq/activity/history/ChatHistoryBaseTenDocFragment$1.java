package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class ChatHistoryBaseTenDocFragment$1
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryBaseTenDocFragment$1(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryBaseTenDocFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseTenDocFragment);
    if (paramView.size() > 0)
    {
      ThreadManager.post(new ChatHistoryBaseTenDocFragment.1.1(this, paramView), 8, null, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseTenDocFragment.h();
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.1
 * JD-Core Version:    0.7.0.1
 */