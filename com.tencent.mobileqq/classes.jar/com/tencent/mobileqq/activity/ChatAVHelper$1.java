package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;

final class ChatAVHelper$1
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$1(ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener.a();
    }
    DataReport.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    DataReport.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.1
 * JD-Core Version:    0.7.0.1
 */