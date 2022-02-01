package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.vas.ColorNickManager;

class ChatSettingForTroop$ListAdapter$1$1
  implements Runnable
{
  ChatSettingForTroop$ListAdapter$1$1(ChatSettingForTroop.ListAdapter.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter$1.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter.a.c) {}
    while (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter$1.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$ViewHolder.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter$1.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SpannableString localSpannableString = new ColorNickText(this.jdField_a_of_type_JavaLangString, 12).a();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter$1.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter$1.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$ListAdapter$1.jdField_a_of_type_AndroidWidgetTextView, localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.ListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */