package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatAVHelper$13
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$13(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.VideoCheckFlag localVideoCheckFlag = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag;
    localVideoCheckFlag.d = false;
    localVideoCheckFlag.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, localVideoCheckFlag);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.13
 * JD-Core Version:    0.7.0.1
 */