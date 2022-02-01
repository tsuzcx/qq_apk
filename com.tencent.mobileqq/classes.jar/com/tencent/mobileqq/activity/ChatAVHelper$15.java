package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

final class ChatAVHelper$15
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$15(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = UITools.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_a_of_type_Int);
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_a_of_type_JavaUtilMap != null) && (i == 1))
    {
      str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.jdField_a_of_type_JavaUtilMap.get("MultiAVType");
      if (str == null) {}
    }
    for (paramInt = Integer.valueOf(str).intValue();; paramInt = 0)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.d = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.e = false;
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.15
 * JD-Core Version:    0.7.0.1
 */