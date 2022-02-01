package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting.OnGetNickNameOfMaskDisc;

final class ChatActivityUtils$13
  implements QAVHrMeeting.OnGetNickNameOfMaskDisc
{
  ChatActivityUtils$13(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("MeetingStasks", paramInt);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.13
 * JD-Core Version:    0.7.0.1
 */