package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class ChatHistory$11
  implements TextWatcher
{
  ChatHistory$11(ChatHistory paramChatHistory) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {}
    try
    {
      paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
    }
    catch (Exception localException1)
    {
      label29:
      break label29;
    }
    paramInt1 = this.a.c;
    if ((paramCharSequence.length() > 1) && (paramCharSequence.charAt(0) == '0')) {}
    for (paramCharSequence = String.valueOf(paramInt1);; paramCharSequence = String.valueOf(paramInt1))
    {
      for (;;)
      {
        paramInt2 = 1;
        break label71;
        paramInt2 = 0;
        label71:
        if ((paramInt1 < 1) || (paramInt1 > this.a.c) || (paramInt2 != 0)) {}
        try
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(Math.max(0, paramCharSequence.length() - 1));
        }
        catch (Exception localException2)
        {
          label119:
          StringBuilder localStringBuilder;
          break label119;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("current s:");
        localStringBuilder.append(paramCharSequence);
        QLog.e("ChatHistory", 1, localStringBuilder.toString());
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence.toString());
        paramCharSequence = this.a;
        if (paramInt1 >= paramCharSequence.c) {
          paramInt1 = this.a.c;
        }
        paramCharSequence.d = paramInt1;
        if (this.a.d >= this.a.c)
        {
          this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849919);
        }
        else
        {
          this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
          this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839081);
        }
        if (this.a.d <= 1)
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840566);
          break label381;
        }
        this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839080);
        break label381;
        paramCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length() - 1).toString();
        try
        {
          paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
        }
        catch (Exception paramCharSequence)
        {
          label365:
          break label365;
        }
      }
      paramInt1 = this.a.c;
    }
    label381:
    paramCharSequence = this.a;
    paramCharSequence.e = ((paramCharSequence.d - 1) * 8);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.11
 * JD-Core Version:    0.7.0.1
 */