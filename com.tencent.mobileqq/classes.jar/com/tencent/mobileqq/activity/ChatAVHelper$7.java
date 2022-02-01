package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$7
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$7(QQAppInterface paramQQAppInterface, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    ChatActivityUtils.VideoCheckFlag localVideoCheckFlag = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag;
    localVideoCheckFlag.b = false;
    localVideoCheckFlag.jdField_c_of_type_Boolean = true;
    localVideoCheckFlag.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, localVideoCheckFlag);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.7
 * JD-Core Version:    0.7.0.1
 */