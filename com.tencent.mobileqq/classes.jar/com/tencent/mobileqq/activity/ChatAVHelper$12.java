package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$12
  implements DialogInterface.OnCancelListener
{
  ChatAVHelper$12(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, int paramInt, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.12
 * JD-Core Version:    0.7.0.1
 */