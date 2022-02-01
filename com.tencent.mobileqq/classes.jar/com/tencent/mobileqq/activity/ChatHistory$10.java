package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$10
  implements View.OnClickListener
{
  ChatHistory$10(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d < this.a.c)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839226);
      ChatHistory localChatHistory = this.a;
      localChatHistory.d += 1;
      if (this.a.d >= this.a.c)
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849993);
      }
      this.a.e = ((this.a.d - 1) * 8);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.e);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.a.d));
      this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      this.a.t();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.10
 * JD-Core Version:    0.7.0.1
 */