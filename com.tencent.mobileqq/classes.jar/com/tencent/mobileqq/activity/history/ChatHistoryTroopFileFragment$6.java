package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileShowAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryTroopFileFragment$6
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryTroopFileFragment$6(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a();
    if ((paramView == null) || (paramView.isEmpty())) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramView);
      ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a(localArrayList, 3, new ChatHistoryTroopFileFragment.6.1(this));
      ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment.h();
    } while (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.6
 * JD-Core Version:    0.7.0.1
 */