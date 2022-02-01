package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatActivityUtils$9
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$9(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean1, ChatActivityUtils.StartVideoListener paramStartVideoListener, Bundle paramBundle, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    paramDialogInterface = ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 1)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDialogInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    if (!this.b) {
      bool = true;
    }
    ChatActivityUtils.a(paramDialogInterface, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.9
 * JD-Core Version:    0.7.0.1
 */