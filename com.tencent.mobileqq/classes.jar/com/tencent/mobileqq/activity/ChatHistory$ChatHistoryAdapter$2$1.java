package com.tencent.mobileqq.activity;

import acms;
import acmt;
import acnd;
import android.view.View;
import android.widget.Toast;

public class ChatHistory$ChatHistoryAdapter$2$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$2$1(acmt paramacmt, Object paramObject, View paramView) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Acmt.jdField_a_of_type_Int == 0) && ((this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a == null) || (!this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.a(0, this.jdField_a_of_type_JavaLangObject))))
    {
      Toast.makeText(this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131719560), 0).show();
      return;
    }
    if (this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a == null) {
      this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a = new acnd(this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
    }
    this.jdField_a_of_type_Acmt.jdField_a_of_type_Acms.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.a(0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Acmt.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */