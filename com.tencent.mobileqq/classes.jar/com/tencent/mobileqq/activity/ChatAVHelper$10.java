package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

final class ChatAVHelper$10
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$10(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, int paramInt, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.a)
    {
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt == 2) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "1", "", "", "");
      } else if ((paramInt == 3) || (paramInt == 4)) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "1", "", "", "");
      }
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag;
    paramDialogInterface.b = false;
    paramDialogInterface.c = false;
    paramDialogInterface.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, paramDialogInterface);
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("");
      paramDialogInterface.append(System.currentTimeMillis() - l);
      QLog.d("chenlong", 2, paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.10
 * JD-Core Version:    0.7.0.1
 */