package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AIORevokeMsgHelper$5
  implements ActionSheet.OnButtonClickListener
{
  AIORevokeMsgHelper$5(AIORevokeMsgHelper paramAIORevokeMsgHelper, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper, (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      ReportController.b(AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper), "dc00899", "Grp_chatRecord", "", "remove_file", "tips_det", 0, 0, AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper).a, "", "", "");
      continue;
      ReportController.b(AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper), "dc00899", "Grp_chatRecord", "", "remove_file", "Clk_cel", 0, 0, AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper).a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.5
 * JD-Core Version:    0.7.0.1
 */