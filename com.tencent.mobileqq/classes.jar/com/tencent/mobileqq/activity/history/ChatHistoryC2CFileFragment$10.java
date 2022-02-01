package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.filemanager.multioperate.IQFileMultiOperate;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryC2CFileFragment$10
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryC2CFileFragment$10(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new ArrayList();
    paramView.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CFileFragment.a);
    ChatHistoryC2CFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CFileFragment).a(paramView, 3, new ChatHistoryC2CFileFragment.10.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CFileFragment.h();
    ChatHistoryC2CFileFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CFileFragment, false);
    ChatHistoryC2CFileFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CFileFragment);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.10
 * JD-Core Version:    0.7.0.1
 */