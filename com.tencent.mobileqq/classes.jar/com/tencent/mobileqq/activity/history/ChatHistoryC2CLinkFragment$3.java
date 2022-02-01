package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class ChatHistoryC2CLinkFragment$3
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryC2CLinkFragment$3(ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryC2CLinkFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment);
    if (paramView.size() > 0)
    {
      ThreadManager.post(new ChatHistoryC2CLinkFragment.3.1(this, paramView), 8, null, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.h();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkFragment.b, "dc00898", "", "", "0X800A0B5", "0X800A0B5", 4, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.3
 * JD-Core Version:    0.7.0.1
 */