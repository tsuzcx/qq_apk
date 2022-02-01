package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$11
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$11(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, int paramInt, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.a)
    {
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt == 2) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
      } else if ((paramInt == 3) || (paramInt == 4)) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.11
 * JD-Core Version:    0.7.0.1
 */